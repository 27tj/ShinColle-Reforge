## 再現度レポート（2026-04-22）

### 対象
- BlockHelper / ClientRuntimeHelper のクライアント参照経路の安全化

### 確認方法
- 移植元コード参照: PinkaLulan/ShinColle `mc-1.10.2` の `utility/BlockHelper.java`
- 仕様参照: Forge公式 sides.md（physical side / `net.minecraft.client` 参照回避の推奨）
- 検証: `gradlew compileJava` 成功、`gradlew runGameTestServer` 37/37 pass

### 挙動再現状況
- ✅ 再現確認済み: Block ray trace 系ロジック（camera entity -> player fallback -> mount host置換）を維持
- ✅ 再現確認済み: partial tick 参照を維持（`getClientFrameTime` 経由）
- ⚠️ 要検証: クライアント実機で pointer/mount 視点時の ray trace 体感確認
- ❓ 移植元挙動不明: なし（対象機能は移植元コードで比較可能）

### 再現度スコア
- ロジック: 2 / 2
- 副作用: 1 / 1
- エッジケース: 1 / 2
- 描画: 0 / 0

### [REPRO?] 未解決項目（2026-04-22 スキャン転記）
- [ ] ModelMidwayHime: 水上待機揺れの実機比較未完了
- [ ] ModelMountAfH: 水上待機揺れの実機比較未完了
- [ ] ModelMountBaH: 水上待機揺れの実機比較未完了
- [ ] ModelMountCaH: 水上待機揺れの実機比較未完了
- [ ] ModelMountHbH: 水上待機揺れの実機比較未完了
- [ ] ModelMountIsH: 水上待機揺れの実機比較未完了
- [ ] ModelMountMiH: 水上待機揺れの実機比較未完了
- [ ] ModelMountSuH: 水上待機揺れの実機比較未完了
- [ ] ModelSSNH: 水上待機揺れの実機比較未完了
- [ ] ModelSubmHime: 水上待機揺れの実機比較未完了
- [ ] ShipModelBaseAdv: NoFuel時の接地見え方の横断比較未完了

### 未解決の問題
- 視覚再現度の確認がGameTest対象外のため、Client実機の目視比較が必要。
