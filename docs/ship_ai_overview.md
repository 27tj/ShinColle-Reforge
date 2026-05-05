# Ship AI 概要ドキュメント

この文書は旧実装（1.10.2 系）の Ship（艦娘）AI を読みやすく整理したものです。実装の参照箇所はソース内の AI クラスとユーティリティです。移植や理解の起点にしてください。

**主な目的**
- Ship の動作構成（タスク登録 → 実行 → 継続判定）を理解する
- 主要 AI の役割と条件を把握する
- パス探索／移動補助の仕組みを把握する
- ターゲティングの選定基準を参照できるようにする

---

## 全体フロー（要点）
- 各艦種のコンストラクタや `postInit()` の後に `setAIList()` と `setAITargetList()` が呼ばれて、`tasks` と `targetTasks` に AI を登録します（登録順と `setMutexBits()` により同時実行が制御される）。参照: [original_source/src/main/java/com/lulan/shincolle/entity/BasicEntityShip.java](original_source/src/main/java/com/lulan/shincolle/entity/BasicEntityShip.java)
- 毎 tick の更新で `onLivingUpdate()` 等を経て個々の AI が `shouldExecute()` → `startExecuting()` → `updateTask()` → `continueExecuting()` の流れで実行されます。
- ターゲットは `EntityAIShipRangeTarget` や `EntityAIShipRevengeTarget` 等の targetTasks で決定され、`host.setEntityTarget(...)` によりホストへ設定されます。詳しくは [docs/target_selection.md](docs/target_selection.md) を参照してください。

---

## 主要 AI と役割（抜粋）
- `EntityAIShipSit` — 着席／停止状態。優先度高。
- `EntityAIShipFlee` — 一定条件で回避行動。
- `EntityAIShipGuarding` — 指定地点またはエンティティの守衛行動。
- `EntityAIShipFollowOwner` — 主人（プレイヤー）を追従。遠距離ではテレポート機能あり。([original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipFollowOwner.java](original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipFollowOwner.java))
- `EntityAIShipOpenDoor` — 扉を開ける処理。
- 近接: `EntityAIShipAttackOnCollide` — 近接攻撃（追尾して殴る）。([original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipAttackOnCollide.java](original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipAttackOnCollide.java))
- 射撃: `EntityAIShipRangeAttack` — 軽/重弾の選択・照準・発射を扱う。弾薬判定や aimTime、視認判定を備える。([original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipRangeAttack.java](original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipRangeAttack.java))
- `EntityAIShipRangeTarget` — 範囲内ターゲット選定（AntiAir/AntiSS/PVPFirst 等の優先を実装）。詳細は [docs/target_selection.md](docs/target_selection.md)。
- 巡回/アイドル: `EntityAIShipWander`, `EntityAIShipFloating`, `EntityAIShipWatchClosest`, `EntityAIShipLookIdle`。

---

## パス探索と移動補助
- `ShipPathNavigate`:
  - 水中／空中も考慮した独自のパス探索（`ShipPathFinder` を使用）。Y 軸起点や最大探索範囲が `canFly()` 等で決まる。
  - 経路短縮（高低差の節約）やスタック検出（所定時間移動できない場合の回避）を行う。([original_source/src/main/java/com/lulan/shincolle/ai/path/ShipPathNavigate.java](original_source/src/main/java/com/lulan/shincolle/ai/path/ShipPathNavigate.java))
- `ShipMoveHelper`:
  - `setMoveTo(x,y,z,speed)` で MOVE_TO 状態へ。`onUpdateMoveHelper()` が Y 軸の補正（浮上／降下）や速度調整を直接 `motionY` 等へ適用する。
  - フォーメーション時の速度補正も行う。([original_source/src/main/java/com/lulan/shincolle/ai/path/ShipMoveHelper.java](original_source/src/main/java/com/lulan/shincolle/ai/path/ShipMoveHelper.java))

---

## ターゲティング（まとめ）
- 優先順序（概略）: AntiAir → AntiSS → PVPFirst → 通常ターゲット
- フィルタ条件: 無敵プレイヤー、特殊投射物、サーバの unattackable リスト、不可視（フレア/サーチライトで捕捉可否）、チーム/オーナー判定
- 選択: 距離ソート（`TargetHelper.Sorter`）の最短を基本、候補多数の場合は上位3からランダム選択。詳細: [docs/target_selection.md](docs/target_selection.md)

---

## 内部ステートとフラグ
- `StateFlag`, `StateMinor`, `StateTimer`, `StateEmotion` といった配列が Ship の状態を管理する。多くの AI はこれらの値に依存して実行可否を判定する（例: `CanFollow`, `UseAmmoLight`, `NoFuel` など）。
- 属性（攻撃力・移動速度など）は `AttrsAdv`（shipAttrs）で管理され、AI の攻撃間隔や射程はこの値に依存する。

---

## 同期・永続化
- NBT 保存／読み込みで `CapaShipSavedValues` と `CapaShipInventory` を使って内部ステート・インベントリを保持する。AI 関連のフラグも NBT で同期されるため、移植時は NBT のキー互換に留意する必要がある。

---

## デバッグとテストのヒント
- ターゲットの可視化: `EntityHelper` / `CommonProxy.channelP` でパーティクル表示が使われている箇所を利用して、追従先や目標位置を可視化できる。
- AI の頻度制御: 多くの AI は tick ごとに周期チェック（例: %8, %32）を行うため、この周期を変えてテストを早めに行うと挙動確認が容易。

---

## 移植時の注意点（簡易）
- 1.10.2 と 1.20.1 では Entity / World / Pathfinding API が変わっている。特に PathNavigate 系と BlockState / Material の扱いに差異があるため、`ShipPathNavigate` の移植は慎重に行ってください。
- レジストリ・イベント周り（`@EventHandler` 等）やネットワーク（SimpleChannel 等）も API 変更があるため、AI 周りの同期ロジックやパケット呼び出し箇所に注意。

---

## 参考ファイル
- 基本: [original_source/src/main/java/com/lulan/shincolle/entity/BasicEntityShip.java](original_source/src/main/java/com/lulan/shincolle/entity/BasicEntityShip.java)
- パス/移動: [original_source/src/main/java/com/lulan/shincolle/ai/path/ShipPathNavigate.java](original_source/src/main/java/com/lulan/shincolle/ai/path/ShipPathNavigate.java), [original_source/src/main/java/com/lulan/shincolle/ai/path/ShipMoveHelper.java](original_source/src/main/java/com/lulan/shincolle/ai/path/ShipMoveHelper.java)
- 主要 AI:
  - [original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipRangeAttack.java](original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipRangeAttack.java)
  - [original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipAttackOnCollide.java](original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipAttackOnCollide.java)
  - [original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipFollowOwner.java](original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipFollowOwner.java)
  - [original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipFloating.java](original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipFloating.java)
- ターゲティング詳細: [docs/target_selection.md](docs/target_selection.md)

---

必要なら次の作業を行います:
- 各 AI のフローチャート（Mermaid/SVG）を個別に作成
- `TargetHelper` の全判定に行番号を付した注釈版ドキュメント作成
- 移植チェックリスト（API 差分）を生成

どれを優先しますか？
