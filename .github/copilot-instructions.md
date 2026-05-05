# GitHub Copilot Instructions — Minecraft Mod Porting (1.10.2 → 1.20.1)

## プロジェクト概要

このプロジェクトは Minecraft Forge Mod を **1.10.2 から 1.20.1 へ移植**する作業です。
旧バージョンのソースコードは `original_source/` ディレクトリに配置されています。

---

## ディレクトリ構成の前提

| パス | 内容 |
|---|---|
| `original_source/` | 移植元となる 1.10.2 時代のオリジナルソース（読み取り専用参照用） |
| `src/` | 移植先となる 1.20.1 用の新しいソース（実装作業対象） |

---

## Copilot への基本方針

### 1. 旧実装の確認（`original_source/` の参照）

- `original_source/` 内のコードは **参照専用** です。直接編集しないでください。
- 旧実装の挙動・ロジックを説明する際は、対象ファイルのパスとクラス名・メソッド名を明示してください。
- 旧バージョン固有の API（例：`IBlockState`, `net.minecraftforge.fml.common.registry.GameRegistry` など）については、**廃止された旨を明記**したうえで、1.20.1 での対応する代替 API を提示してください。

### 2. 1.20.1 の API・実装調査

- Minecraft 1.20.1 / Forge 47.x のAPIを前提に回答してください。
- `net.minecraft.*` および `net.minecraftforge.*` のクラス・インターフェースは **1.20.1 時点の正しい名前空間とシグネチャ** で提示してください。
- Mixin（Fabric）ではなく **Forge の仕組み**（`@Mod`, `IForgeRegistry`, `DeferredRegister` 等）を基本とします。
- レジストリは旧来の `GameRegistry` ではなく `DeferredRegister<T>` を使う方針で回答してください。

### 3. 実装方法の提案

- 実装案を提示する際は、以下の順序で説明してください：
  1. **旧実装でのアプローチ**（`original_source/` のどのクラスに相当するか）
  2. **1.20.1 での変更点・廃止事項**
  3. **新実装のサンプルコード**（コメント付き）
- コードは Java 17 構文を使用してください（`var`, `record`, sealed class なども可）。
- 副作用が大きいリファクタは提案するにとどめ、**自動適用はしない**でください。

---

## バージョン間の主要な変更点（ヒント集）

> Copilot はこのセクションを参考に回答の精度を高めてください。

| 1.10.2 の書き方 | 1.20.1 での対応 |
|---|---|
| `IBlockState` | `BlockState` |
| `BlockPos.MutableBlockPos` | 同名・一部メソッド変更あり |
| `GameRegistry.registerBlock()` | `DeferredRegister<Block>` |
| `GameRegistry.registerItem()` | `DeferredRegister<Item>` |
| `@EventHandler` (FMLPreInitializationEvent 等) | `@Mod.EventBusSubscriber` + `FMLCommonSetupEvent` 等 |
| `World` (server/client 共通) | `Level` (server: `ServerLevel`, client: `ClientLevel`) |
| `EntityPlayer` | `Player` (`ServerPlayer` / `LocalPlayer`) |
| `IInventory` | `Container` / `SimpleContainer` |
| `TileEntity` | `BlockEntity` |
| `@SideOnly(Side.CLIENT)` | `@OnlyIn(Dist.CLIENT)` |
| `NetworkRegistry` / `SimpleNetworkWrapper` | `SimpleChannel` (NetworkDirection ベース) |
| `IRecipe` | `Recipe<C>` + JSON レシピファイル |

---

## 回答スタイルの指示

- **日本語で回答**してください。コード・識別子は英語のまま維持してください。
- 「このメソッドは 1.12 で廃止、1.16 で削除」のように**バージョン経緯**が分かる場合は補足してください。
- 不明な点や Forge のバージョン差異が不確実な場合は、**推測である旨を明示**してから回答してください。
- Minecraft の公式 Javadoc や Forge の GitHub (MinecraftForge/MinecraftForge) を根拠にできる場合はそれを示してください。

---

## Ask モードでの典型的な質問パターン

以下のような質問を想定しています。適切なコンテキストを踏まえて回答してください。

- `original_source/` の〇〇クラスは何をしているのか説明して
- 1.10.2 の `XXX` に相当する 1.20.1 の API は何か
- 1.20.1 でカスタムブロックエンティティを登録する方法を教えて
- このメソッドのシグネチャが変わっているが、新バージョンではどう呼べばいいか
- 旧実装のネットワークパケット処理を 1.20.1 に移植したい