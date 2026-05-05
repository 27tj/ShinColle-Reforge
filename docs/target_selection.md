# ターゲット選定ロジック（詳細）

この文書は旧実装のターゲット選定ロジックを詳細に分解し、意思決定フローをフローチャート（Mermaid）で示したものです。実装参照元は `EntityAIShipRangeTarget` とそれに依存する `TargetHelper` 系です。

参照実装:
- [original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipRangeTarget.java](original_source/src/main/java/com/lulan/shincolle/ai/EntityAIShipRangeTarget.java)
- [original_source/src/main/java/com/lulan/shincolle/entity/BasicEntityShip.java](original_source/src/main/java/com/lulan/shincolle/entity/BasicEntityShip.java)

---

## 要約（決定木の主要ノード）
1. 前提チェック: ホストが有効で、実行タイミング（例: 8 tick 毎）か、`getIsSitting()` 等のブロック条件を満たしていないことを確認。
2. 攻撃タイプ優先チェック（艦種固有フラグによる枝分かれ）
   - `AntiAir` フラグが立っていれば、空中／飛行ユニット（`IShipFlyable`, `EntityFlying`）を最優先で検索。
   - それが見つからなければ `AntiSS`（対潜）フラグで潜行／インビジブル系（`IShipInvisible`）を検索。
   - 更に見つからなければ `PVPFirst` フラグで味方艦（`BasicEntityShip`）を優先的に検索。
3. 汎用検索: 指定された `targetClass`（`Entity` など）で範囲内検索を行う。
4. フィルタリング: `TargetHelper.Selector` 系で味方・無敵プレイヤー・不可視状態などを除外。
5. ソート & 選択: `TargetHelper.Sorter`（距離ソート）で昇順に並べ、最接近を選択、候補が多ければ上位3つからランダム選択する場合あり。
6. ターゲット設定: `host.setEntityTarget(target)` を呼び出す。
7. 継続判定: ターゲットが死亡または射程外であれば解除。プレイヤーの無敵状態（creative / spectator）も解除条件に含む。

---

## 詳細フロー（ステップ毎の判定仕様）

- 前提チェック
  - `host != null`
  - `host.getIsSitting() == false`
  - `host.getStateMinor(ID.M.CraneState) == 0`
  - `host.getTickExisted() % 8 == 0`（実装では周期的チェック）

- 範囲計算
  - `range = max( 2, (int) host.getAttrs().getAttackRange(), host.getStateMinor(FollowMax)+2 )`
  - 検索 AABB は `host.getEntityBoundingBox().expand(range, range * 0.75D, range)`

- 優先検索（実装順）
  1. AntiAir:
     - 条件: `host.getStateFlag(ID.F.AntiAir)` が true
     - 検索対象: `IShipFlyable.class` と `EntityFlying.class` の結果を union
  2. AntiSS:
     - 条件: `host.getStateFlag(ID.F.AntiSS)` が true
     - 検索対象: `IShipInvisible.class`
  3. PVPFirst:
     - 条件: `host.getStateFlag(ID.F.PVPFirst)` が true
     - 検索対象: `BasicEntityShip.class`
  4. 通常検索:
     - 検索対象: コンストラクタで渡された `targetClass`

- フィルタ: 各 `EntityHelper.getEntitiesWithinAABB(..., selector)` 呼び出しで `TargetHelper.Selector`（あるいは `SelectorForHostile`）を利用して次を除外
  - 味方（オーナー/チーム）
  - 無効なターゲット（死亡/消滅）
  - プレイヤーで且つ `capabilities.disableDamage == true`（無敵）

- ソート & 選択
  - `Collections.sort(list, targetSorter)` により距離昇順
  - 最短の要素をターゲットにする
  - `list.size() > 2` の場合は最初の3つからランダムに1つ選ぶ

- ターゲット設定
  - `host.setEntityTarget(targetEntity)` を呼ぶ（`startExecuting()`）

- 継続条件（`continueExecuting()`）
  - `target != null && target.isEntityAlive()`
  - 距離が `range^2` を超えていない
  - プレイヤーの場合は `capabilities.disableDamage` を再確認

---

## 関連フラグと挙動まとめ
- `ID.F.AntiAir` : 飛行ユニット優先
- `ID.F.AntiSS` : 潜行/ステルス系優先
- `ID.F.PVPFirst` : 他艦（`BasicEntityShip`）優先
- `ID.F.PassiveAI` : passive 時は targetTasks に `RevengeTarget` のみ登録する（BasicEntityShip の `setAITargetList()` を参照）

---

## 実装上の注意（移植観点）
- 検索対象インターフェース／クラス（`IShipFlyable` 等）は旧実装内部で定義されているため、1.20.1 側でも同等の判定手段を用意する必要があります。
- 検索に用いる AABB の拡張倍率（Y 軸で *0.75）や range の最小値ルールは、移植後も同じ挙動を保つために明示的に保持してください。
- `TargetHelper.Selector` はチーム判定や不可視判定、種別除外を行う重要なクラスなので、Selector のフィルタ条件も合わせて検証してください。

---

## フローチャート（Mermaid）
以下は上記の意思決定を表す Mermaid フローチャートです。Mermaid 対応のビューア／Markdown レンダラで確認してください。

```mermaid
flowchart TD
  Start([開始])
  A[前提チェック: host 有効か, not sitting, crane=0, tick %8==0]
  B{範囲内にターゲットを検索}
  A -->|fail| EndFail([終了: 実行しない])
  A -->|ok| CheckFlags

  CheckFlags -->|AntiAir=true| SearchAA
  CheckFlags -->|else| CheckAntiSS

  SearchAA[検索: IShipFlyable + EntityFlying within range]
  SearchAA -->|found| Select
  SearchAA -->|not found| CheckAntiSS

  CheckAntiSS -->|AntiSS=true| SearchSS
  CheckAntiSS -->|else| CheckPVP

  SearchSS[検索: IShipInvisible within range]
  SearchSS -->|found| Select
  SearchSS -->|not found| CheckPVP

  CheckPVP -->|PVPFirst=true| SearchPVP
  CheckPVP -->|else| SearchGeneric

  SearchPVP[検索: BasicEntityShip within range]
  SearchPVP -->|found| Select
  SearchPVP -->|not found| SearchGeneric

  SearchGeneric[検索: targetClass within range]
  SearchGeneric -->|found| Select
  SearchGeneric -->|not found| EndNoTarget([終了: ターゲット無し])

  Select[フィルタ(Selector) -> ソート(Sorter) -> 最短 or 上位3からランダム]
  Select --> SetTarget
  SetTarget[host.setEntityTarget(target)]
  SetTarget --> ContinueCheck

  ContinueCheck{継続判定}
  ContinueCheck -->|ターゲット死亡 or 距離超過 or 無敵| ClearTarget([setEntityTarget(null)]) --> End
  ContinueCheck -->|継続条件満たす| EndRunning([実行継続])

  End([終了])
  EndFail --> End
  EndNoTarget --> End

``` 

---

## `TargetHelper.Selector` の条件分解（詳細）

以下は `TargetHelper.Selector.apply(Entity target2)` の条件を上から順に詳しく分解したものです（参照: `original_source/src/main/java/com/lulan/shincolle/utility/TargetHelper.java`）。

1) 初期フラグ更新（ホストが `BasicEntityShip` である場合）
  - `isPVP = host.getStateFlag(ID.F.PVPFirst)`
  - `isAA  = host.getStateFlag(ID.F.AntiAir)`
  - `isASM = host.getStateFlag(ID.F.AntiSS)`

2) 基本的な除外条件（ここで false を返す）
  - `target2 == null`
  - `!target2.isEntityAlive()`
  - `host == null`
  - `host.equals(target2)`（自己）

3) プレイヤー特有チェック（`target2 instanceof EntityPlayer`）
  - 無敵判定: `((EntityPlayer)target2).capabilities.disableDamage` -> 排除（false）
  - `ConfigHandler.shipAttackPlayer` による種類別許可：
    - 0: 自動攻撃しない
    - 1: 敵対プレイヤーのみ攻撃 -> `TeamHelper.checkIsBanned(host, target2)` が true の場合 true
    - 2: 敵対+中立プレイヤーを攻撃 -> `!TeamHelper.checkIsAlly(host, target2)` が true の場合 true
    - 3: 所有者以外のすべてのプレイヤーを攻撃 -> `!TeamHelper.checkSameOwner(host, target2)` が true の場合 true

  （上記いずれかでターゲット許可が出た場合、apply は true を返す）

4) 即時除外対象（`isEntityInvulnerable(target2)` が true の場合 false）
  - 投射物・ロケット・釣り針等、`isEntityInvulnerable` で列挙される特殊エンティティ
  - サーバー側で `unattackable target class list` に登録されているクラス

5) インビジビリティ（`target2.isInvisible()`）
  - ホストが `BasicEntityShip` の場合、ホスト（艦）が `LevelFlare` または `LevelSearchlight` を持っていなければ除外（false）
  - ホストがサモン（`IShipOwner`）でそのホストが `BasicEntityShip` の場合、上記ホストのフレア/サーチライトで同様判定

6) 視認チェック（OnSightChase）
  - ホストが `BasicEntityShip` でフラグ `OnSightChase` が立っている場合、`host.getEntitySenses().canSee(target2)` が false なら除外
  - それ以外の `EntityLiving` ホストでも `getEntitySenses().canSee(target2)` を必須とする

7) AntiAir / AntiSS の即時判定
  - `target2 instanceof BasicEntityAirplane || target2 instanceof EntityAbyssMissile`
    - `isAA` が true かつ `TeamHelper.checkIsBanned(host, target2)` が true なら true、さもなくば false
  - `target2 instanceof IShipInvisible`
    - `isASM` が true かつ `TeamHelper.checkIsBanned(host, target2)` が true なら true、さもなくば false

8) PVP 優先判定
  - `isPVP` が true かつ `target2 instanceof BasicEntityShip || target2 instanceof BasicEntityMount`
    - `TeamHelper.checkIsBanned(host, target2)` が true なら true

9) モブ判定
  - `target2 instanceof EntityMob || target2 instanceof EntitySlime` -> true

10) カスタムターゲットリスト（プレイヤー定義）
  - `checkAttackTargetList(host, target2)` が true なら true（プレイヤーがサーバへ登録したターゲットクラス）

11) 最終デフォルト -> false

---

## RevengeSelector の条件分解（要点）
- 共通: 上記の基本的な null/死亡/自己判定、無敵プレイヤー排除、isEntityInvulnerable チェック、不可視時のフレア判定は同じ。
- 追加: `IShipOwner`（サモンや所有権を持つエンティティ）に対しては味方であれば攻撃しない。それ以外は所有者が異なれば true を返す。

## SelectorForHostile / RevengeSelectorForHostile の要点
- Hostile 用はより単純: プレイヤーは `ConfigHandler.mobAttackPlayer` に従い許可するか判定。
- `BasicEntityShipHostile` は同種を攻撃しないガードがある。
- 非不可視かつ `BasicEntityShip` / `BasicEntityMount` / `IShipOwner`（所有者が異なる場合）を攻撃する。

---

## 補助関数の説明
- `isEntityInvulnerable(Entity)`:
  - 投射物・花火ロケット・釣り針・掛けられたエンティティ・エリア効果クラウドは常に true（攻撃対象外）。
  - サーバ側リストに登録されたクラスも true（攻撃不可）。
- `checkAttackTargetList(host, target)`:
  - サーバのプレイヤー毎設定リストを参照。該当クラス名が登録されていれば true（tameable の場合は所有者チェックも行う）。

---

この条件分解を Markdown に追記しました。次は各判定の細かい例（具体的なコード行番号と実行順）を抜き出して注釈付きで示しますか？

---

## 図 (SVG)

フローチャートを PNG/SVG で確認したい場合はリポジトリに SVG を作成済みです。以下のファイルを開いてください。

- [docs/target_selection.svg](docs/target_selection.svg)

この SVG は簡易的なフローチャート図です。PNG 変換や高解像度化、細かいレイアウト調整をご希望なら指示ください。

---

## 具体的なコード参照（抜粋と注釈）
以下は `TargetHelper.java` の主要な判定箇所を抜粋し、それぞれ何をしているかを注釈したものです。該当コードは `original_source/src/main/java/com/lulan/shincolle/utility/TargetHelper.java` にあります。

- Selector クラス冒頭（フラグ更新、基本除外）

```java
public static class Selector implements Predicate<Entity>
{
  protected Entity host;
  protected boolean isPVP;
  protected boolean isAA;
  protected boolean isASM;
  public Selector(Entity host) { this.host = host; }
  @Override
  public boolean apply(Entity target2) {
    // フラグ更新: host が BasicEntityShip ならフラグを取得
    if (host instanceof BasicEntityShip) {
      this.isPVP = ((BasicEntityShip) host).getStateFlag(ID.F.PVPFirst);
      this.isAA  = ((BasicEntityShip) host).getStateFlag(ID.F.AntiAir);
      this.isASM = ((BasicEntityShip) host).getStateFlag(ID.F.AntiSS);
    }
    // null / self / 死亡 などの早期除外
    if (target2 == null || !target2.isEntityAlive() || this.host == null || host.equals(target2)) {
      return false;
    }
    ...
  }
}
```

注: このブロックで `isPVP/isAA/isASM` が決まり、以降の分岐で利用されます。

- プレイヤーチェックと `ConfigHandler.shipAttackPlayer` の条件

```java
if (target2 instanceof EntityPlayer) {
  if (((EntityPlayer) target2).capabilities.disableDamage) return false; // 無敵は除外
  switch (ConfigHandler.shipAttackPlayer) {
    case 0: break; // 自動攻撃しない
    case 1: if (TeamHelper.checkIsBanned(host, target2)) return true; break;
    case 2: if (!TeamHelper.checkIsAlly(host, target2)) return true; break;
    case 3: if (!TeamHelper.checkSameOwner(host, target2)) return true; break;
  }
}
```

- 即時除外: `isEntityInvulnerable(target2)` と不可視処理

```java
if (isEntityInvulnerable(target2)) return false;
if (target2.isInvisible()) {
  if (host instanceof BasicEntityShip) {
    if (((BasicEntityShip) host).getStateMinor(ID.M.LevelFlare) < 1 &&
      ((BasicEntityShip) host).getStateMinor(ID.M.LevelSearchlight) < 1) {
      return false;
    }
  }
  // Summon の場合はそのホスト艦のフレア/サーチライトを参照
}
```

- AntiAir / AntiSS の優先判定

```java
if (target2 instanceof BasicEntityAirplane || target2 instanceof EntityAbyssMissile) {
  if (isAA && TeamHelper.checkIsBanned(host, target2)) return true;
  else return false;
}
if (target2 instanceof IShipInvisible) {
  if (isASM && TeamHelper.checkIsBanned(host, target2)) return true;
  else return false;
}
```

- PVP 優先とモブ判定・カスタムリスト

```java
if (this.isPVP && (target2 instanceof BasicEntityShip || target2 instanceof BasicEntityMount)) {
  if (TeamHelper.checkIsBanned(host, target2)) return true;
}
if (target2 instanceof EntityMob || target2 instanceof EntitySlime) return true;
if (checkAttackTargetList(host, target2)) return true; // プレイヤー設定のカスタムターゲット

return false; // デフォルトでは攻撃対象外
```

---

この抜粋により、`Selector` 内の実際の処理順序と判定意図が分かるはずです。次の作業案:
- 各判定に対するユニットテスト用の擬似ケースを作る（挙動確認用）
- 実際のソース上の正確な行番号を付加してドキュメントを更新する（必要なら行番号を抽出して追記します）
---

### 現バージョン（リポジトリ内ソースの解析結果）

以下はワークスペース内の現行ソース（1.20.1 ブランチ）の主要 AI クラスと、本解析で抽出した要点です。

- **射程ターゲット取得**: [src/main/java/com/lulan/shincolle/ai/ShipRangeTargetGoal.java](src/main/java/com/lulan/shincolle/ai/ShipRangeTargetGoal.java#L1)
  - 8 tick ごとに検索を行う (`tick % 8 == 0`)。
  - 範囲 AABB は X/Z に range、Y に range * 0.75 を拡張している。
  - 優先順: `AntiAir` → `AntiSS` → `PVPFirst` → 通常検索。各ステップはインターフェース／クラスによる絞り込みを行う。
  - フィルタに `TargetHelper.Selector`（友軍／無敵プレイヤー除外等）を使用。候補を距離でソートし、上位3からランダム選択する挙動を保持。

- **リベンジターゲット反撃**: [src/main/java/com/lulan/shincolle/ai/ShipRevengeTargetGoal.java](src/main/java/com/lulan/shincolle/ai/ShipRevengeTargetGoal.java#L1)
  - `host.getEntityRevengeTime()` の更新をトリガーに、`getEntityRevengeTarget()` を現在の攻撃ターゲットに設定する。
  - Hostile 系は `SelectorForHostile` を用いる（フィルタ基準が簡略化される）。

- **射撃（砲撃）挙動**: [src/main/java/com/lulan/shincolle/ai/ShipRangeAttackGoal.java](src/main/java/com/lulan/shincolle/ai/ShipRangeAttackGoal.java#L1)
  - `host.getEntityTarget()` が有効かつ弾薬を持っていることを前提に開始。
  - 視認時間 (`onSightTime`) と照準時間 (`aimTime`) を使って発砲のタイミングを制御。
  - Light/Heavy のディレイと最大ディレイを更新し、スタック（長時間ヒット無し）した場合はリセットするガードあり。

- **スキル攻撃**: [src/main/java/com/lulan/shincolle/ai/ShipSkillAttackGoal.java](src/main/java/com/lulan/shincolle/ai/ShipSkillAttackGoal.java#L1)
  - `host.getStateEmotion(ID.S.Phase) > 0` の間、`host.updateSkillAttack(target)` を呼び出す（スキルフェーズ管理）。

- **オーナー追従（フォロー）**: [src/main/java/com/lulan/shincolle/ai/ShipFollowOwnerGoal.java](src/main/java/com/lulan/shincolle/ai/ShipFollowOwnerGoal.java#L1)
  - 距離しきい値（min/max）を計算して移動・テレポートを制御。
  - フォーメーション時は `FormationHelper` で位置を決定、移動パスはカスタムナビゲータ `ShipPathNavigate` を使用。
  - テレポート条件: 距離閾値超過 or スタック時間超過（ConfigHandler の設定に基づく）。

上記により、現行実装は旧実装の設計方針（優先フラグによる段階検索、Selector による詳細フィルタ、距離ソートとランダム性、視界/弾薬/技能フェーズによる起動制御）を踏襲していることが確認できました。

---

今後の推奨作業:

- `TargetHelper.Selector` と `SelectorForHostile` の完全な逐次分解（行番号付き）とそのテストケース化。
- `ShipRangeTargetGoal` の周期性（8tick）や AABB の比率等、微調整パラメータのドキュメント化。
- 1.20.1 側で移植上問題になりそうな外部参照（`IShipFlyable` 等のインターフェース）を抽出し、代替案（タグ/Capability/instanceof の保持）を提案します。

どれを優先しますか？

## 追加資料 / 次のステップ提案
- `TargetHelper.Selector` と `TargetHelper.Sorter` の中身を分解してフィルタ条件を明文化します（必要なら実装ファイルへの行番号付き参照を含めます）。
- 1.20.1 移植のために `IShipFlyable` 等の判定をどのように置換するか（例: Entity タグ／capability など）を検討します。

ご希望があれば、次に `TargetHelper.Selector` の詳細分解（条件リスト化）と、Mermaid を PNG に変換した図（リポジトリ内画像）を作成します。どちらを先に進めますか？

---

## 行番号付き注釈: `TargetHelper.Selector` の判定順

下記は `TargetHelper` 実装にある `Selector.test()` の主要判定箇所を行番号付きで参照した注釈です。該当ソース: [src/main/java/com/lulan/shincolle/utility/TargetHelper.java](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L1)

- クラス定義: [Selector](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L69)
- フラグ更新 (host が `BasicEntityShip` の場合): [L73-L78](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L73-L78)
- null/生存/自己チェック: [L91-L94](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L91-L94)
- プレイヤー無敵チェック & `ConfigHandler.shipAttackPlayer()`: [L96-L110](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L96-L110)
- `isEntityInvulnerable(target)` 呼び出し（即時除外）: [L112-L114](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L112-L114)
- 不可視判定と `canDetectInvisible(host)` チェック: [L116-L121](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L116-L121)
- 視認 (OnSightChase) 判定: [L123-L129](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L123-L129)
- AntiAir 即時判定 (`BasicEntityAirplane`): [L131-L134](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L131-L134)
- AntiSS 即時判定 (`IShipInvisible`): [L136-L139](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L136-L139)
- PVP 優先判定（他艦/マウント）: [L141-L145](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L141-L145)
- 敵対ホストシップ直接許可: [L147-L149](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L147-L149)
- バニラモンスター/スライム許可: [L151-L154](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L151-L154)
- カスタムターゲットリスト (`checkAttackTargetList`) の判定: [L156-L158](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L156-L158)
- デフォルトで `false` を返す箇所: [L160](src/main/java/com/lulan/shincolle/utility/TargetHelper.java#L160)

これら参照箇所のソース抜粋が必要なら、該当範囲を抜き出してドキュメント化します。次はユニットテスト用の擬似ケースを `docs/target_selector_test_cases.md` に作成します。
