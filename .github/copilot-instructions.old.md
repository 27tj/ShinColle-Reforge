# GitHub Copilot Agent Instructions
# Minecraft Forge Mod 移植プロジェクト（1.10.2 → 1.20.1）

---

## プロジェクト概要

このプロジェクトは **Minecraft Forge 1.10.2 で作成された Mod を 1.20.1 へ移植する作業** です。
バージョン間のギャップは約 10 バージョン分に及び、Forge・Minecraft 双方で多数の破壊的変更が存在します。
また、このプロジェクトは **進行途中であり、既存コードには未完成・不整合・暫定実装が含まれています。**

### 移植の最重要原則

> **「コンパイルが通ること」「旧 API が残っていないこと」は移植完了の条件ではない。**
> **移植元（1.10.2）と同一の挙動が再現できていることが唯一のゴールである。**
>
> **「問題なし」と報告するには、問題がないことの根拠を必ず示さなければならない。**
> **根拠を示せない項目は「未確認」として報告する。確認できていないことを隠蔽しない。**

---

## 0. 使用する MCP と使用タイミング（必須）

以下の MCP を積極的に活用してください。
**各 PHASE で指定された MCP を使わずに作業を進めることを禁止します。**

### MCP 一覧と用途

| MCP | 主な用途 | 使用タイミング |
|-----|---------|--------------|
| **Serena** | コードベース全体のシンボル検索・参照元追跡・クラス構造把握 | PHASE 1・2・スキャン全般 |
| **Sequential Thinking** | 複雑な移植判断・APIの変化の影響分析・設計判断の整理 | 判断に迷ったとき・複雑な変更の前 |
| **Context7** | Forge/Minecraft 1.20.1 の公式ドキュメント・API 仕様の確認 | API の正しい使い方を確認するとき |
| **github-mcp-server** | 移植元（1.10.2）コードの参照・ブランチ間の差分確認 | PHASE 1（移植元挙動確認）・常時 |
| **Fetch** | Forge Javadoc・公式サイト・Migration Guide の取得 | API 変更の詳細確認・PHASE 1 補完 |
| **Files** | ファイル走査・アセット（JSON モデル・テクスチャ）の存在確認 | PHASE 2 スキャン・アセット検証 |
| **Markitdown** | `docs/visual_checklist.md`・`docs/repro_issues.md` の更新 | PHASE 4 レポート後・`[RENDER?]` 発見時 |

### MCP の使用を義務付けるシーン

```
【Serena を必ず使う場面】
  - クラス・メソッドの参照元を調べるとき（自分の記憶だけで判断しない）
  - あるシンボルがプロジェクト全体でどう使われているか確認するとき
  - 未実装かどうか判断できないとき（Serena でシンボルの実装状況を確認する）

【Sequential Thinking を必ず使う場面】
  - 「この API 変更が他のクラスに与える影響」を分析するとき
  - 移植方針に複数の選択肢があり判断が必要なとき
  - 再現度レポートで ❌ や ❓ が出たとき（原因の段階的分析）

【Context7 を必ず使う場面】
  - 1.20.1 の API を使用する前（正しいシグネチャ・動作を確認する）
  - Forge のイベント・レジストリ・ネットワーク API を使用する前
  - 「たぶんこうだろう」と思って実装しようとしているとき

【github-mcp-server を必ず使う場面】
  - PHASE 1 で移植元（1.10.2）コードを参照するとき（必須）
  - 移植元と移植先の差分を確認するとき
  - 移植元に存在したコードが移植先で見当たらないとき

【Fetch を必ず使う場面】
  - Forge Migration Guide を参照するとき
  - Forge Javadoc で API の詳細を確認するとき
  - Context7 で情報が不十分なとき

【Files を必ず使う場面】
  - PHASE 2 のアセットスキャン（JSON モデル・テクスチャパス検証）
  - `blockstates/`・`models/`・`textures/` の整合性確認
  - アセットファイルが存在するか確認するとき

【Markitdown を必ず使う場面】
  - PHASE 4 の再現度レポートを `docs/repro_issues.md` に記録するとき
  - `[RENDER?]` コメントを付与したとき（`docs/visual_checklist.md` に転記）
  - `[REPRO?]` コメントを付与したとき（`docs/repro_issues.md` に転記）
```

---

## 1. 作業フロー（すべての編集作業で必ず従う）

### PHASE 1: 移植元の挙動を確認する（編集前・必須）

**使用 MCP: `github-mcp-server`（移植元コード取得）・`Fetch`（Migration Guide）・`Context7`（1.20.1 API 確認）**

対象ファイルを編集する前に、移植元（1.10.2）の対応コードを `github-mcp-server` で取得し、以下を文書化してください。
移植元コードを取得できなかった場合は、その旨を報告して作業を止めてください。

```
📖 移植元の挙動確認: <クラス名#メソッド名>
  取得元: <github-mcp-server で参照したブランチ/コミット>

  何をするメソッド/クラスか:
  入力（引数・前提条件）:
  出力・副作用（戻り値・状態変化・イベント発火・NBT 操作など）:
  呼び出し元・呼び出し条件:
  特記事項（エッジケース・null 条件・サイド依存など）:
```

### PHASE 2: ファイルスキャン（編集前・必須）

**使用 MCP: `Serena`（シンボル検索・参照追跡）・`Files`（アセット存在確認）**

`Serena` を使ってシンボルの実装状況を確認し、`Files` でアセットを走査してください。
**自分の目視だけでスキャンを完了したと判断することを禁止します。**

#### 2-A: 未実装スキャン（Serena で実施）

```
Serena で以下を検索し、発見件数と該当箇所を列挙すること:
  // TODO  // FIXME  // HACK  // PORT?  // BEHAVIOR?  // RENDER?  // REPRO?  // TODO(Copilot)
  UnsupportedOperationException
  インターフェース実装メソッドで本体が {} のみのもの
  abstract メソッドの override で super 呼び出しのみのもの
  戻り値が非 null 必須なメソッドで return null しているもの
```

#### 2-B: 旧 API 残存スキャン（Serena で実施）

```
【描画系 旧API（発見したら即時報告・修正対象）】
  GL11.  GL13.  GL14.  GL20.
  GlStateManager.enableAlpha    GlStateManager.disableAlpha
  GlStateManager.enableLighting GlStateManager.disableLighting
  GlStateManager.color(         GlStateManager.translate(
  TileEntitySpecialRenderer     WorldRenderer（旧）
  RenderHelper.

【ロジック系 旧API（発見したら即時報告・修正対象）】
  world.isRemote        GameRegistry.register
  NBTTagCompound        NBTTagList        IBlockState
  EnumFacing            EntityPlayer      TileEntity       ITickable
  TextComponentString   TextComponentTranslation
  NetworkRegistry.INSTANCE.newSimpleChannel
  DamageSource.GENERIC  DamageSource.MAGIC  （静的フィールド参照）
  entity.attackEntityFrom(    entity.remove()    world.spawnEntity(
  new Configuration(
```

#### 2-C: アセットスキャン（Files で実施）

```
Files で以下を確認すること:
  - blockstates/*.json に記載されたモデルパスが models/block/ に存在するか
  - models/block/*.json・models/item/*.json に記載されたテクスチャパスが textures/ に存在するか
  - lang/ に en_us.json（.lang ファイルではないか）が存在するか
  - sounds.json に記載されたサウンドファイルが存在するか
```

#### 2-D: クライアント/サーバー混在スキャン（Serena で実施）

```
Serena で以下を検索すること:
  @OnlyIn なしで Minecraft.getInstance() が呼ばれていないか
  @OnlyIn なしで RenderSystem.・Screen.・Font.・GuiGraphics. が使われていないか
  DistExecutor で適切に分岐されているか
```

#### スキャン結果の報告フォーマット

```
📋 スキャン結果: <ファイルパス>
  使用 MCP: Serena（シンボル検索）/ Files（アセット走査）

  【未実装】<件数>件
    🔴 高優先度: <クラス名#メソッド名> — <問題内容>
    🟡 中優先度: <クラス名#メソッド名> — <問題内容>
    🟢 低優先度: <クラス名#メソッド名> — <問題内容>

  【旧API残存】<件数>件
    🎨 描画系: <行番号> <旧API> → <推奨代替>
    ⚙️  ロジック系: <行番号> <旧API> → <推奨代替>

  【アセット不整合】<件数>件
    <ファイルパス>: <何が存在しないか>

  【クライアント/サーバー混在】<件数>件
    <行番号>: <問題内容>

  ※「問題なし」と報告する場合は、各カテゴリについて
    「Serena / Files で <検索クエリ> を実行し、該当なし」と根拠を明示すること。
```

> ⚠️ **「問題なし」の報告ルール**
> 「問題なし」と報告する場合、**各カテゴリに対して使用した MCP・検索クエリ・結果を必ず明示**してください。
> 根拠を示せないカテゴリは「未確認」として報告してください。

### PHASE 3: 実装する

**使用 MCP: `Context7`（API 仕様確認）・`Sequential Thinking`（判断が複雑な場合）**

- 移植元の挙動確認（PHASE 1）を参照しながら実装する
- API を使用する前に必ず `Context7` で正しいシグネチャ・動作を確認する
- 移植方針に複数の選択肢がある場合は `Sequential Thinking` で段階的に分析する
- 移植元との差異が生じる場合は `// [PORT]` コメントで理由を明記する

### PHASE 4: 再現度を自己評価する（実装後・必須）

**使用 MCP: `Markitdown`（レポートを docs/ に記録）・`Sequential Thinking`（❌・❓ の原因分析）**

実装完了後、以下のフォーマットで再現度を評価して報告し、`Markitdown` で `docs/repro_issues.md` に記録してください。

```
📊 再現度レポート: <クラス名 / 機能名>

  【確認方法】
    移植元コード参照: <github-mcp-server で参照したブランチ/コミット>
    API 仕様確認: <Context7 または Fetch で確認したドキュメント URL>

  【挙動の再現状況】
    ✅ 再現確認済み  : <具体的な挙動> — 確認根拠: <どう確認したか>
    ⚠️  要検証      : <何が確認できていないか> — 確認方法: <どう確認すべきか>
    ❌ 再現できていない: <何が違うか> — 原因: <Sequential Thinking による分析結果>
    ❓ 移植元挙動不明 : <何がわからないか> — 試みた調査: <何を調べたか>

  【再現度スコア】（確認済み項目 / 全項目）
    ロジック:    ___ / ___
    副作用:      ___ / ___
    エッジケース: ___ / ___
    描画:        ___ / ___（該当する場合）

  【未解決の問題】
    - <問題>: <推奨アクション>
```

- スコアが低い・未確認項目がある箇所には `// [REPRO?]` コメントを付与する
- `[REPRO?]` を付与した箇所は `Markitdown` で `docs/repro_issues.md` に転記する
- `[RENDER?]` を付与した箇所は `Markitdown` で `docs/visual_checklist.md` に転記する

---

## 2. 未実装検出の優先度判定基準

### 🔴 高優先度（作業着手前に必ず解決）

- `UnsupportedOperationException` が投げられる可能性のある実装
- ネットワークパケットのハンドラが空実装
- `BlockEntity#saveAdditional` / `load` が未実装（セーブデータ破損につながる）
- `@SubscribeEvent` が付いているがロジックが空

### 🟡 中優先度（同一セッション中に対処）

- 計算・判定ロジックが `return 0` / `return false` で仮実装
- `// PORT?` や `// BEHAVIOR?` でマークされた動作不明箇所
- Capability の `invalidateCaps()` が未 override
- `// REPRO?` でマークされた再現未確認箇所

### 🟢 低優先度（次回以降で対処可）

- Javadoc・コメントが未記入
- テストが未作成
- `// TODO` で記録されているが動作に影響しない改善点

---

## 3. 描画問題の検出

### 3-1. 描画コードの禁止パターン

```java
// ❌ 使用禁止（旧 OpenGL 直接呼び出し）
GL11.glBegin(GL11.GL_QUADS);
GL11.glColor4f(r, g, b, a);
GlStateManager.color(r, g, b, a);
GlStateManager.enableAlpha();
GlStateManager.translate(x, y, z);   // float 引数版

// ✅ 1.20.1 の正しい描画方式
poseStack.pushPose();
try {
    poseStack.translate(x, y, z);
    poseStack.mulPose(Axis.YP.rotationDegrees(angle));
    VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityCutout(texture));
    // 描画処理
} finally {
    poseStack.popPose();  // 対称性を try-finally で保証
}
```

### 3-2. 描画クラスの移植対応表

| 1.10.2 | 1.20.1 |
|--------|--------|
| `TileEntitySpecialRenderer<T>` | `BlockEntityRenderer<T>` |
| `Render<T extends Entity>` | `EntityRenderer<T>` |
| `ModelBase` / `ModelRenderer` | `Model` / `ModelPart` |
| `GlStateManager.bindTexture` | `RenderSystem.setShaderTexture` |
| `RenderGameOverlayEvent` | `RenderGuiOverlayEvent`（1.19.4〜）|
| `Gui.drawTexturedModalRect` | `GuiGraphics#blit` |
| `FontRenderer` | `Font` / `GuiGraphics#drawString` |

### 3-3. 描画の目視検証（`docs/visual_checklist.md`）

描画は GameTest で自動検証できません。`[RENDER?]` コメントを付与したら `Markitdown` で即座に転記してください。

```markdown
## 目視検証チェックリスト

### [RENDER?] 未検証項目（Copilot が転記）
  - [ ] <クラス名>: <何を確認すべきか> — 追加日: <日付>

### ブロック描画
  - [ ] <ブロック名>: テクスチャが正しく表示される
  - [ ] <ブロック名>: BlockEntity アニメーションが移植元と一致する

### エンティティ描画
  - [ ] <エンティティ名>: モデルの形状・サイズが移植元と一致する
  - [ ] <エンティティ名>: アニメーションが移植元と一致する

### GUI
  - [ ] <GUI名>: レイアウトが移植元と一致する
  - [ ] <GUI名>: ボタン・スロットが正しく動作する
```

---

## 4. 動作等価性の検証

### 4-1. コンパイルは通るが動作が違う主要パターン

#### DamageSource の変更（1.20〜）

```java
// ❌ entity.attackEntityFrom(DamageSource.MAGIC, 5.0f);
// ✅
entity.hurt(level.damageSources().magic(), 5.0f);
```

#### NBT のサイレント失敗

```java
// 型不一致で例外なく 0 / false / "" が返る
// ✅ 型を指定した安全な確認
if (nbt.contains("myKey", Tag.TAG_INT)) {
    int val = nbt.getInt("myKey");
}
```

#### イベントの変化

| イベント | 変化内容 |
|----------|---------|
| `LivingDeathEvent` | キャンセル後のドロップ・経験値挙動が変わった |
| `PlayerInteractEvent` | LEFT/RIGHT サブイベント構成が変更 |
| `TickEvent.LevelTickEvent` | 旧 `WorldTickEvent`。`world` → `level` フィールド |

#### その他

```java
stack == null          // ❌ → stack.isEmpty() ✅
entity.remove()        // ❌ → entity.discard() ✅
world.spawnEntity()    // ❌ → level.addFreshEntity() ✅
if (!world.isRemote)   // ❌ → if (!level.isClientSide()) ✅
```

### 4-2. 動作不一致チェックリスト

```
□ 同じ入力に対して同じ戻り値を返すか
□ 副作用（状態変化・NBT 書き込み・イベント発火）のタイミングと内容が一致するか
□ NBT のキー名・型が移植元と一致するか
□ 数値（ダメージ・速度・確率など）の定数が一致するか
□ エッジケース（空スタック・null エンティティ）の処理が一致するか
□ イベントのキャンセルが正しく機能するか
□ サーバー/クライアント両サイドで正しく動作するか
```

---

## 5. バージョン間差分の吸収（1.10.2 → 1.20.1）

### 5-1. 命名規則の大変更（MCP → Mojmap、1.17〜）

| 1.10.2 (MCP) | 1.20.1 (Mojmap) |
|--------------|-----------------|
| `World` | `Level` |
| `WorldServer` | `ServerLevel` |
| `WorldClient` | `ClientLevel` |
| `EntityPlayer` | `Player` |
| `EntityPlayerSP` | `LocalPlayer` |
| `EntityPlayerMP` | `ServerPlayer` |
| `TileEntity` | `BlockEntity` |
| `IBlockState` | `BlockState` |
| `Block.getStateFromMeta` | 削除（`BlockState` + `Property<T>` で管理）|
| `NBTTagCompound` | `CompoundTag` |
| `NBTTagList` | `ListTag` |
| `Vec3d` | `Vec3` |
| `AxisAlignedBB` | `AABB` |
| `EnumFacing` | `Direction` |
| `EnumHand` | `InteractionHand` |
| `EnumActionResult` | `InteractionResult` |
| `TextFormatting` | `ChatFormatting` |
| `ITextComponent` | `Component` |
| `TextComponentString` | `Component.literal()` |
| `TextComponentTranslation` | `Component.translatable()` |

### 5-2. レジストリ（1.14〜）

```java
// ❌ GameRegistry.registerItem(item, "name");
// ✅
public static final DeferredRegister<Item> ITEMS =
    DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
public static final RegistryObject<Item> MY_ITEM =
    ITEMS.register("my_item", () -> new Item(new Item.Properties()));
```

### 5-3. TileEntity → BlockEntity（1.17〜）

```java
public class MyBE extends BlockEntity {
    public MyBE(BlockPos pos, BlockState state) {
        super(MY_BE_TYPE.get(), pos, state);
    }
    @Override public void load(CompoundTag nbt) { super.load(nbt); }
    @Override protected void saveAdditional(CompoundTag nbt) { super.saveAdditional(nbt); }
}
```

### 5-4. ネットワーク（SimpleImpl → SimpleChannel）

```java
// ❌ NetworkRegistry.INSTANCE.newSimpleChannel(MODID)
// ✅
public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
    new ResourceLocation(MODID, "main"),
    () -> "1.0", "1.0"::equals, "1.0"::equals
);
// handler 内では必ず ctx.get().enqueueWork(() -> { ... }) を使う
```

### 5-5. イベントバスの分離（1.14〜）

| イベント種別 | 登録先 |
|-------------|--------|
| `FMLCommonSetupEvent` など Mod ロード系 | MOD バス（`getModEventBus()`）|
| `PlayerEvent`・`BlockEvent` などゲーム系 | FORGE バス（`MinecraftForge.EVENT_BUS`）|

### 5-6. 設定ファイル（1.13〜）

```java
// ❌ new Configuration(...)
// ✅
public static final ForgeConfigSpec.IntValue MY_VALUE =
    BUILDER.comment("説明").defineInRange("myValue", 10, 0, 100);
```

### 5-7. リソースパック・アセット（1.13〜）

- モデルパスに `block/`・`item/` プレフィックスが必須
- 言語ファイル: `en_us.lang` → `en_us.json`
- `blockstates/` の JSON 形式が変更（`variants` / `multipart` 構造）

---

## 6. テスト戦略

### 6-1. テストの使い分け

| テスト種別 | 用途 | 使用場面 |
|-----------|------|----------|
| **JUnit 5** | ゲームコンテキスト不要なロジック | 計算・変換・NBT 構造 |
| **Forge GameTest** | ゲーム内サーバーサイド動作検証 | ブロック・エンティティ・イベント |
| **目視チェックリスト** | クライアントサイド・描画の検証 | レンダリング・GUI・モデル |

### 6-2. Forge GameTest

```groovy
minecraft {
    runs {
        gameTestServer {
            workingDirectory project.file('run')
            property 'forge.enabledGameTestNamespaces', project.mod_id
        }
    }
}
```

```java
@GameTestHolder(value = MyMod.MODID)
@PrefixGameTestTemplate(false)
public class MyBlockGameTest {

    @GameTest(template = "flat_10x10")
    public static void blockEntity_nbtRoundTrip(GameTestHelper helper) {
        BlockPos pos = new BlockPos(1, 1, 1);
        helper.setBlock(pos, MyMod.MY_BLOCK.get().defaultBlockState());
        MyBE be = (MyBE) helper.getLevel().getBlockEntity(helper.absolutePos(pos));
        assertNotNull(be);
        CompoundTag nbt = be.saveWithFullMetadata();
        be.load(nbt);
        helper.succeed();
    }
}
```

GameTest で優先的に検証すべき項目：

```
□ BlockEntity の NBT 読み書きの往復（移植元と同一のキー・型・値か）
□ ブロックのインタラクション（右クリック・左クリック）
□ エンティティのスポーン・tick・削除
□ カスタムイベントの発火・キャンセル
□ ダメージ・治癒の数値が移植元と一致するか
```

---

## 7. コーディング規約

- Java 17 以上の構文を使用すること（`record`・`sealed class`・テキストブロックなど）
- すべての `public` クラス・メソッドに Javadoc を記述すること（`@param`・`@return`・`@throws` 必須）
- `null` を返す API は避け、`Optional<T>` を使用すること
- `ItemStack` の null チェックは `stack.isEmpty()` を使うこと（`== null` は禁止）
- アクセス修飾子は常に明示すること
- マジックナンバーは `static final` 定数で定義すること
- インデント: スペース 4 つ、1 行最大 120 文字

---

## 8. コメント記法（トレーサビリティ）

| 記法 | 意味 |
|------|------|
| `// [PORT] 1.10.2 -> 1.20.1: <理由>` | 移植変更の記録 |
| `// [PORT] 1.10.2 -> 1.13 -> 1.17 -> 1.20.1: <理由>` | 中間バージョン経由の変更 |
| `// [PORT?] <不明な点>` | 移植元の挙動が不明で要確認 |
| `// [BEHAVIOR?] <差分の説明>` | コンパイルは通るが動作等価性が不明 |
| `// [RENDER?] <確認すべき内容>` | 描画の目視確認が必要（Markitdown で visual_checklist.md に転記） |
| `// [REPRO?] <再現できていない内容>` | 再現度レポートで未解決（Markitdown で repro_issues.md に転記） |
| `// TODO(Copilot): 暫定実装。<理由>` | Copilot が生成した暫定コード |

---

## 9. セキュリティ

- ネットワークパケット受信時はサーバー側で必ず入力バリデーションを行うこと
- プレイヤーから送られるデータを無条件に信頼しないこと
- `Command` 登録時は適切な `permissionLevel`（通常は 2 = OP）を設定すること
- ファイル I/O はゲームディレクトリ外へのアクセスを禁止すること

---

## 10. エージェントへの行動指針

1. **PHASE 1 で github-mcp-server を使って移植元コードを取得してから実装を始める** — 取得できなければ作業を止める
2. **PHASE 2 のスキャンは Serena と Files を使って実施する** — 目視だけでスキャンを完了したと判断しない
3. **「問題なし」と報告するときは使用した MCP・検索クエリ・結果を明示する** — 根拠のない「問題なし」は禁止
4. **API を使用する前に Context7 で正しい仕様を確認する** — 「たぶんこうだろう」で実装しない
5. **判断に迷ったとき・影響範囲が広いときは Sequential Thinking で段階的に分析する**
6. **PHASE 4 の再現度レポートを Markitdown で docs/ に記録する**
7. **`[RENDER?]` を付与したら即座に Markitdown で visual_checklist.md に転記する**
8. **`[REPRO?]` を付与したら即座に Markitdown で repro_issues.md に転記する**
9. **コンパイル成功を動作保証と混同しない** — 再現度の根拠を常に問う
10. **差分を最小化する** — 移植に直接関係しないリファクタリングを勝手に行わない
11. **NBT キー名を変更しない** — セーブデータの破壊につながるため変更前に必ず警告する
12. **GameTest はサーバーサイド検証に集中させる** — 描画検証に GameTest を使おうとしない