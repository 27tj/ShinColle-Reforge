# GitHub Copilot Agent Instructions
# Minecraft Forge Mod 移植プロジェクト（1.10.2 → 1.20.1）

---

## プロジェクト概要

このプロジェクトは **Minecraft Forge 1.10.2 で作成された Mod を 1.20.1 へ移植する作業** です。
バージョン間のギャップは約 10 バージョン分に及び、Forge・Minecraft 双方で多数の破壊的変更が存在します。
また、このプロジェクトは **進行途中であり、既存コードには未完成・不整合・暫定実装が含まれています。**

コンパイルが通っても **実際のゲーム内動作が移植元と一致しない** ケースが存在するため、
静的なコードレビューに加えて **動作等価性の検証** を必ず行ってください。

Copilot はコードを補完・生成・編集する際、以下のルールを **必ず** 遵守してください。

---

## 1. 進行中プロジェクトの不完全コードへの対応（最優先）

### 1-1. 作業前の必須確認

ファイルを編集する前に、以下を確認し問題があれば報告してください：

- `// TODO`・`// FIXME`・`// HACK`・`// PORT`・`// PORT?` コメントが残っていないか
- メソッドが `throw new UnsupportedOperationException()` や `return null` で仮実装されていないか
- 1.10.2 時代の旧 API（セクション 3）がまだ残存していないか
- コンパイルエラーになる可能性のある未解決の import や型参照がないか
- 空実装のままのインターフェース実装メソッドがないか
- 旧 API と新 API が同一ファイルに混在していないか

### 1-2. 不完全コードの発見時の行動

不完全な箇所を発見した場合は、**実装を続ける前に**以下の形式で報告してください：

```
⚠️ 未完成箇所を検出しました：
- ファイル: <ファイルパス>
- 箇所: <クラス名#メソッド名>
- 問題: <何が未完成か>
- 対応案: <どう実装すべきか>
```

その上で、修正してよいか確認を求めるか、`// FIXME` コメントを残して先へ進んでください。

### 1-3. 暫定コードへのマーキング

自分が生成したコードが暫定実装である場合、必ず以下のコメントを付与してください：

```java
// TODO(Copilot): 暫定実装。<理由や確認が必要な点>
```

---

## 2. 動作等価性の検証（コンパイル成功だけでは不十分）

**コンパイルが通っても動作が変わっているケースが多数あります。**
以下に代表的なパターンを示します。実装後は必ずこれらの観点で確認してください。

### 2-1. よくある「コンパイルは通るが動作が違う」パターン

#### 引数の順序・意味の変化

| 箇所 | 変化内容 |
|------|----------|
| `BlockPos` コンストラクタ | 順序変更なし。ただし Y 座標の扱い（ビルドハイト上限）が変わっている |
| `Level#setBlock(pos, state, flags)` | `flags` の意味が拡張された（`3` がデフォルト相当だが意図を要確認） |
| `AABB`（旧 `AxisAlignedBB`）| コンストラクタ引数の min/max 順序は変わらないが内部不変条件が厳格化 |
| `Entity#hurt(DamageSource, float)` | `DamageSource` の生成方法が 1.20 で大幅変更（後述） |

#### DamageSource の変更（1.20〜）

```java
// ❌ 1.10.2 〜 1.19
DamageSource.GENERIC
entity.attackEntityFrom(DamageSource.MAGIC, 5.0f);

// ✅ 1.20.1（DamageSource はレジストリ管理に変更）
entity.hurt(level.damageSources().magic(), 5.0f);
// カスタムダメージは DamageType をレジストリに登録して使う
```

#### イベントのキャンセル可否・発火タイミングの変化

| イベント | 変化内容 |
|----------|----------|
| `PlayerInteractEvent` | `LEFT_CLICK`・`RIGHT_CLICK` のサブイベント構成が変更 |
| `LivingDeathEvent` | キャンセル後の挙動（ドロップ・経験値）が変わった |
| `ChunkEvent.Load` | 発火タイミングが非同期処理の影響を受けるようになった |
| `TickEvent.WorldTickEvent` | → `TickEvent.LevelTickEvent` に変更（`world` → `level` フィールド）|

#### サイレントな失敗・型の厳格化

- **NBT の型不一致**: 1.20.1 では `getInt()` でキーが存在しない場合 `0` を返す（例外は出ない）。
  型が違う場合は `0`/`false`/`""` が返るため、移植元の挙動を確認すること
- **`ItemStack.EMPTY` の判定**: `stack == null` は常に禁止。必ず `stack.isEmpty()` を使うこと
- **`CompoundTag` の `contains(key, type)`**: 型 ID を第 2 引数に渡す厳格チェックを使うこと

```java
// ✅ 型を指定した安全な存在確認
if (nbt.contains("myKey", Tag.TAG_INT)) {
    int val = nbt.getInt("myKey");
}
```

#### エンティティ・ライフサイクルの変化

- `Entity#remove()` → `Entity#discard()` に変更（1.17〜）
- `Entity` の tick 処理は `baseTick()` と `tick()` の呼び出し順が変更されている
- エンティティの登録は `EntityType.Builder` + `DeferredRegister` で行うこと

#### スポーン・ディメンション関連

- `World#spawnEntity(entity)` → `Level#addFreshEntity(entity)`
- ディメンション識別子が `DimensionType`（enum）から `ResourceKey<Level>` に変更
  - 例: `Level.OVERWORLD`・`Level.NETHER`・`Level.END`

### 2-2. 動作不一致を疑うべきチェックリスト

実装後に以下を確認し、問題があれば `// [BEHAVIOR?]` コメントを付与してください：

```
□ メソッドの戻り値の意味が変わっていないか
□ イベントのキャンセルが正しく機能しているか
□ サーバー/クライアント両サイドで正しく動作するか
□ NBT の読み書きがサイレントに失敗していないか
□ エンティティのスポーン・削除が正しく行われているか
□ ダメージ・治癒の数値が移植元と一致しているか
□ ブロックのインタラクション（右クリック・左クリック）が正しく発火しているか
□ tick 処理の呼び出し頻度・タイミングが変わっていないか
```

---

## 3. バージョン間差分の吸収（1.10.2 → 1.20.1）

### 3-1. 命名規則の大変更（MCP → Mojmap、1.17〜）

| 1.10.2 (MCP)                  | 1.20.1 (Mojmap)                              |
|-------------------------------|----------------------------------------------|
| `World`                       | `Level`                                      |
| `WorldServer`                 | `ServerLevel`                                |
| `WorldClient`                 | `ClientLevel`                                |
| `EntityPlayer`                | `Player`                                     |
| `EntityPlayerSP`              | `LocalPlayer`                                |
| `EntityPlayerMP`              | `ServerPlayer`                               |
| `TileEntity`                  | `BlockEntity`                                |
| `IBlockState`                 | `BlockState`                                 |
| `Block.getStateFromMeta`      | 削除（`BlockState` + `Property<T>` で管理）  |
| `ItemStack.stackTagCompound`  | `ItemStack#getTag()`                         |
| `NBTTagCompound`              | `CompoundTag`                                |
| `NBTTagList`                  | `ListTag`                                    |
| `NBTTagString`                | `StringTag`                                  |
| `NBTTagInt` など              | `IntTag` など                                |
| `Vec3d`                       | `Vec3`                                       |
| `AxisAlignedBB`               | `AABB`                                       |
| `EnumFacing`                  | `Direction`                                  |
| `EnumHand`                    | `InteractionHand`                            |
| `EnumActionResult`            | `InteractionResult`                          |
| `RayTraceResult`              | `HitResult` / `BlockHitResult` / `EntityHitResult` |
| `TextFormatting`              | `ChatFormatting`                             |
| `ITextComponent`              | `Component`                                  |
| `TextComponentString`         | `Component.literal()`                        |
| `TextComponentTranslation`    | `Component.translatable()`                   |
| `Entity#remove()`             | `Entity#discard()`                           |
| `World#spawnEntity()`         | `Level#addFreshEntity()`                     |

### 3-2. レジストリの変更（1.14〜）

```java
// ❌ 使用禁止
GameRegistry.registerItem(item, "name");

// ✅ DeferredRegister を使用
public static final DeferredRegister<Item> ITEMS =
    DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
public static final RegistryObject<Item> MY_ITEM =
    ITEMS.register("my_item", () -> new Item(new Item.Properties()));
```

### 3-3. ブロック状態管理（1.13〜）

- `getStateFromMeta` / `getMetaFromState` → 削除
- アイテムのサブタイプ（damage 値）→ 削除（バリアントは個別 Item として登録）
- ブロック状態は `BooleanProperty`・`IntegerProperty`・`EnumProperty` で管理

### 3-4. TileEntity → BlockEntity（1.17〜）

```java
// ✅ 1.20.1
public class MyBE extends BlockEntity {
    public MyBE(BlockPos pos, BlockState state) {
        super(MY_BE_TYPE.get(), pos, state);
    }
    @Override public void load(CompoundTag nbt) { super.load(nbt); }
    @Override protected void saveAdditional(CompoundTag nbt) { super.saveAdditional(nbt); }
}
```

- `ITickable` → `BlockEntityTicker<T>` に変更
- `getTileEntity(pos)` → `getBlockEntity(pos)` に変更

### 3-5. サイド判定

```java
// ❌  if (!world.isRemote)
// ✅
if (!level.isClientSide()) { /* サーバー処理 */ }
```

### 3-6. ネットワーク（SimpleImpl → SimpleChannel）

```java
// ❌ 使用禁止
SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);

// ✅
public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
    new ResourceLocation(MODID, "main"),
    () -> "1.0", "1.0"::equals, "1.0"::equals
);
```

- `handler` 内では必ず `ctx.get().enqueueWork(() -> { ... })` を使うこと
- `Side` → `LogicalSide` に変更

### 3-7. イベントバスの分離（1.14〜）

| イベント種別                              | 登録先                                      |
|------------------------------------------|---------------------------------------------|
| `FMLCommonSetupEvent` など Mod ロード系  | MOD バス（`getModEventBus()`）              |
| `PlayerEvent`・`BlockEvent` などゲーム系 | FORGE バス（`MinecraftForge.EVENT_BUS`）    |

### 3-8. Capabilities

- `LazyOptional<T>` を使うこと
- `invalidateCaps()` を必ず override すること
- `@CapabilityInject` → `CapabilityManager.get(new CapabilityToken<>(){})` を使うこと

### 3-9. Rendering（1.15〜）

- `TileEntitySpecialRenderer` → `BlockEntityRenderer<T>`
- `RenderGameOverlayEvent` → `RenderGuiOverlayEvent`（1.19.4〜）
- OpenGL 直接呼び出し禁止。`PoseStack` + `MultiBufferSource` を使うこと

### 3-10. NBT の読み書き

```java
// ❌ nbt.setInteger / nbt.getInteger
// ✅
nbt.putInt("key", value);
int val = nbt.getInt("key");
```

**NBT キー名は変更しないこと**（既存セーブデータの破壊防止）

### 3-11. 設定ファイル（1.13〜）

```java
// ❌ Configuration（使用禁止）
// ✅ ForgeConfigSpec
public static final ForgeConfigSpec.IntValue MY_VALUE =
    BUILDER.comment("説明").defineInRange("myValue", 10, 0, 100);
```

### 3-12. リソースパック・アセット（1.13〜）

- モデルパスに `block/`・`item/` プレフィックスが必須
- 言語ファイル: `en_us.lang` → `en_us.json`
- `blockstates/` の JSON 形式が変更（`variants` / `multipart` 構造）

---

## 4. テスト戦略

### 4-1. テストの使い分け方針

| テスト種別              | 用途                                               | 使用場面                                  |
|-------------------------|----------------------------------------------------|-------------------------------------------|
| **JUnit 5**             | ゲームコンテキスト不要なロジックの単体テスト       | 計算・変換・ユーティリティ・NBT 構造      |
| **Forge GameTest**      | ゲーム内でのインゲーム動作検証                     | ブロック・エンティティ・インタラクション  |

### 4-2. Forge GameTest（最重要）

Forge GameTest は実際のゲームコンテキスト（`Level`・`BlockState`・`Entity` など）の中でテストを実行できます。
**移植プロジェクトにおいて動作等価性の検証に最も有効な手段** です。積極的に活用してください。

#### セットアップ

`build.gradle` に以下を追加：

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

`mods.toml` にテストモジュールを登録：

```toml
[[mods]]
modId = "your_mod_id"
```

#### テストクラスの書き方

```java
@GameTestHolder(value = MyMod.MODID)        // テストの名前空間
@PrefixGameTestTemplate(false)              // メソッド名をテスト名として使用
public class MyBlockGameTest {

    // structure: NBT 構造ファイル（src/main/resources/data/<modid>/structures/）
    @GameTest(template = "flat_10x10")
    public static void myBlock_rightClickDropsItem(GameTestHelper helper) {
        BlockPos pos = new BlockPos(1, 1, 1);
        helper.setBlock(pos, MyMod.MY_BLOCK.get().defaultBlockState());

        helper.startSequence()
            .thenExecute(() -> helper.useBlock(pos))
            .thenExecuteAfter(2, () ->
                helper.assertEntityPresent(EntityType.ITEM, pos)
            )
            .thenSucceed();
    }

    @GameTest(template = "flat_10x10")
    public static void blockEntity_nbtRoundTrip(GameTestHelper helper) {
        BlockPos pos = new BlockPos(1, 1, 1);
        helper.setBlock(pos, MyMod.MY_BLOCK.get().defaultBlockState());

        ServerLevel level = helper.getLevel();
        MyBE be = (MyBE) level.getBlockEntity(helper.absolutePos(pos));
        assertNotNull(be);

        // NBT 書き込み → 読み込みの往復検証
        CompoundTag nbt = be.saveWithFullMetadata();
        be.load(nbt);
        helper.succeed();
    }
}
```

#### GameTest で優先的に検証すべき項目

移植プロジェクトでは以下を GameTest で必ず検証してください：

```
□ ブロックの右クリック・左クリックインタラクション
□ BlockEntity の NBT 読み書きの往復（書いた値が正しく読み戻せるか）
□ エンティティのスポーン・tick・削除
□ ダメージ・治癒の数値が移植元と一致するか
□ カスタムイベントの発火・キャンセルが正しく動作するか
□ ネットワークパケット送受信後の状態変化
□ レシピ・ドロップテーブルが正しく登録されているか
□ ディメンション間の挙動差異（特にネザー・エンド）
```

#### テスト構造ファイルの配置

```
src/main/resources/data/<modid>/structures/
  flat_10x10.nbt    # 10x10 の平坦な汎用ステージ
  flat_simple.nbt   # 最小限のステージ（1x1 基盤など）
```

### 4-3. JUnit 5（ゲームコンテキスト不要なテスト）

```java
class MyCalculatorTest {
    @Test
    void damageCalculation_returnsExpectedValue() {
        assertEquals(15.0f, MyDamageCalc.calculate(10.0f, 1.5f));
    }

    @Test
    void nbtSerialization_roundTrip() {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("count", 42);
        assertEquals(42, nbt.getInt("count"));
    }
}
```

- テストは `src/test/java` に配置し、対象クラスと同じパッケージ構造にすること

### 4-4. 動作不一致コメント記法

テスト時に移植元と動作が一致しない箇所には以下のコメントを付与し、優先的に対処してください：

```java
// [BEHAVIOR?] 移植元では X だったが、現状では Y になっている。要調査。
```

---

## 5. 移植トレーサビリティ

すべての移植変更箇所に以下のコメントを付与してください：

```java
// [PORT] 1.10.2 -> 1.20.1: <変更理由>
```

複数の中間バージョンを経由した変更の場合：

```java
// [PORT] 1.10.2 -> 1.13 -> 1.17 -> 1.20.1: IBlockState廃止(1.13)、World->Level(1.17)
```

挙動確認が必要な場合：

```java
// [PORT?] 移植元の挙動要確認: <何が不明か>
```

動作不一致が疑われる場合：

```java
// [BEHAVIOR?] <移植元と現状の差分の説明>
```

---

## 6. コーディング規約

### Java

- Java 17 以上の構文を使用すること（`record`・`sealed class`・テキストブロックなど）
- すべての `public` クラス・メソッドに Javadoc を記述すること（`@param`・`@return`・`@throws` 必須）
- `null` を返す API は避け、`Optional<T>` を使用すること
- `ItemStack` の null チェックは `stack.isEmpty()` を使うこと（`== null` は禁止）
- アクセス修飾子は常に明示すること
- マジックナンバーは `static final` 定数で定義すること

### Kotlin（併用する場合）

- `!!` の使用は原則禁止。`?: throw` や `requireNotNull` で代替すること
- `data class`・`object`・`companion object` を積極的に活用すること

### 共通

- インデント: スペース 4 つ、1 行最大 120 文字
- 未使用の `import` は残さないこと

---

## 7. セキュリティ

- ネットワークパケット受信時はサーバー側で必ず入力バリデーションを行うこと
- プレイヤーから送られるデータを無条件に信頼しないこと
- `Command` 登録時は適切な `permissionLevel`（通常は 2 = OP）を設定すること
- ファイル I/O はゲームディレクトリ外へのアクセスを禁止すること

---

## 8. エージェントへの行動指針

1. **作業前に既存コードの完成度を確認する** — 未完成箇所を `⚠️` 形式で報告してから進む
2. **コンパイル成功を動作保証と混同しな
い** — 必ず動作等価性チェックリスト（セクション 2-2）を確認する
3. **推測で実装しない** — 移植元の挙動が不明な場合は `// [PORT?]` を残して確認を求める
4. **動作不一致を発見したら `[BEHAVIOR?]` を付ける** — 黙って修正せず、差分を明示する
5. **差分を最小化する** — 移植に直接関係しないリファクタリングを勝手に行わない
6. **一度に大量変更しない** — 機能単位で分割して段階的に適用する
7. **旧 API を混在させない** — 1.10.2 の旧 API と 1.20.1 の新 API を同一ファイルに混在させない
8. **NBT キー名を変更しない** — セーブデータの破壊につながるため、変更前に必ず警告する
9. **サイドを常に意識する** — `level.isClientSide()` を確認せずにサーバー/クライアント固有処理を書かない
10. **GameTest を積極的に書く** — インゲーム動作が必要な検証は JUnit でなく GameTest を使う
