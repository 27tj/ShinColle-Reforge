# TargetHelper.Selector — 擬似ユニットテストケース

この文書は `TargetHelper.Selector.test(Entity target)` の主要判定を個別に検証するための擬似テストケース群です。実際のユニットテスト実装では、モックエンティティ／モックホストを用いて各条件を再現してください。

ケース一覧（入力条件 → 期待結果）

1. プレイヤー無敵
   - 入力: `target` が `Player`、`player.getAbilities().invulnerable == true`
   - 期待: `false`（攻撃対象外）

2. AntiAir フラグと航空機
   - 入力: `host` の `isAA == true`、`target instanceof BasicEntityAirplane`、`TeamHelper.checkIsBanned(host,target) == true`
   - 期待: `true`（優先攻撃）

3. AntiAir フラグ無しで航空機
   - 入力: `isAA == false`、`target instanceof BasicEntityAirplane`
   - 期待: `false`（除外）

4. 不可視ターゲットだがフレア無し
   - 入力: `target.isInvisible() == true`、`canDetectInvisible(host) == false`
   - 期待: `false`（検出不能で除外）

5. 不可視ターゲットだが検出装備あり
   - 入力: `target.isInvisible() == true`、`canDetectInvisible(host) == true`
   - 期待: 続行判定へ（他の条件に依存）

6. PVPFirst フラグで味方艦をターゲット
   - 入力: `isPVP == true`、`target instanceof BasicEntityShip`、`TeamHelper.checkIsBanned(host,target) == true`
   - 期待: `true`

7. モンスター判定
   - 入力: `target instanceof Monster` または `target instanceof Slime`
   - 期待: `true`

8. カスタムターゲットリスト登録
   - 入力: `checkAttackTargetList(host,target) == true`
   - 期待: `true`（ただし所有者チェックで除外される場合あり）

9. 同一所有者（味方）
   - 入力: `checkSameOwner(host,target) == true`
   - 期待: `false`（味方は攻撃しない）

10. isEntityInvulnerable の例外
    - 入力: `target instanceof Projectile` 等
    - 期待: `false`

テスト実装メモ:
- 各ケースはホストを `BasicEntityShip` としてフラグをセットするケースと、ホストを `Mob`（host が船ではない）にするケースを作る。
- `TeamHelper` 系関数はモック可能なら stub で true/false を返すようにする。
- `canDetectInvisible` の検証は `BasicEntityShip.getStateMinor(ID.M.LevelFlare/LevelSearchlight)` を切り替えて行う。
- 結果は `Selector.test(target)` の戻り値 boolean を検査する。

これらの擬似ケースをもとに、実際の JUnit テストクラス（`src/test/java/...`）を作りたい場合は作成手順を提示します。