package com.lulan.shincolle.init;

import com.lulan.shincolle.block.CustomRenderedBlockItem;
import com.lulan.shincolle.block.ItemBlockGrudgeHeavy;
import com.lulan.shincolle.block.ItemBlockResourceBlock;
import com.lulan.shincolle.item.*;
import com.lulan.shincolle.reference.Reference;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Reference.MOD_ID);

    // ========== Material Items ==========
    public static final RegistryObject<Item> GRUDGE = ITEMS.register("grudge", Grudge::new);
    public static final RegistryObject<Item> GRUDGE_1 = ITEMS.register("grudge_1", Grudge::new);
    public static final RegistryObject<Item> ABYSS_METAL = ITEMS.register("abyss_metal", AbyssMetal::new);
    public static final RegistryObject<Item> ABYSS_NUGGET = ITEMS.register("abyss_nugget", AbyssNugget::new);
    public static final RegistryObject<Item> ABYSS_NUGGET_1 = ITEMS.register("abyss_nugget_1", AbyssNugget::new);
    public static final RegistryObject<Item> POLYMETAL_NODULE = ITEMS.register("polymetal_nodule",
            PolymetalNodule::new);
    public static final RegistryObject<Item> AMMO = ITEMS.register("ammo", Ammo::new);
    public static final RegistryObject<Item> AMMO_1 = ITEMS.register("ammo_1", () -> new Ammo(1));
    public static final RegistryObject<Item> AMMO_2 = ITEMS.register("ammo_2", () -> new Ammo(2));
    public static final RegistryObject<Item> AMMO_3 = ITEMS.register("ammo_3", () -> new Ammo(3));

    // ========== Food/Consumable Items ==========
    public static final RegistryObject<Item> COMBAT_RATION = ITEMS.register("combat_ration", CombatRation::new);
    public static final RegistryObject<Item> COMBAT_RATION_1 = ITEMS.register("combat_ration_1",
            () -> new CombatRation(1));
    public static final RegistryObject<Item> COMBAT_RATION_2 = ITEMS.register("combat_ration_2",
            () -> new CombatRation(2));
    public static final RegistryObject<Item> COMBAT_RATION_3 = ITEMS.register("combat_ration_3",
            () -> new CombatRation(3));
    public static final RegistryObject<Item> COMBAT_RATION_4 = ITEMS.register("combat_ration_4",
            () -> new CombatRation(4));
    public static final RegistryObject<Item> COMBAT_RATION_5 = ITEMS.register("combat_ration_5",
            () -> new CombatRation(5));
    public static final RegistryObject<Item> TOY_AIRPLANE = ITEMS.register("toy_airplane", ToyAirplane::new);
    public static final RegistryObject<Item> TRAINING_BOOK = ITEMS.register("training_book", TrainingBook::new);
    public static final RegistryObject<Item> MODERN_KIT = ITEMS.register("modern_kit", ModernKit::new);
    public static final RegistryObject<Item> BUCKET_REPAIR = ITEMS.register("bucket_repair", BucketRepair::new);
    public static final RegistryObject<Item> REPAIR_GODDESS = ITEMS.register("repair_goddess", RepairGoddess::new);

    // ========== Special Items ==========
    public static final RegistryObject<Item> SHIP_SPAWN_EGG = ITEMS.register("ship_spawn_egg", ShipSpawnEgg::new);
    public static final RegistryObject<Item> OWNER_PAPER = ITEMS.register("owner_paper", OwnerPaper::new);
    public static final RegistryObject<Item> MARRIAGE_RING = ITEMS.register("marriage_ring", MarriageRing::new);
    public static final RegistryObject<Item> RECIPE_PAPER = ITEMS.register("recipe_paper", RecipePaper::new);
    public static final RegistryObject<Item> INSTANT_CON_MAT = ITEMS.register("instant_con_mat",
            InstantConMat::new);

    // ========== Tool Items ==========
    public static final RegistryObject<Item> KAITAI_HAMMER = ITEMS.register("kaitai_hammer", KaitaiHammer::new);
    public static final RegistryObject<Item> TARGET_WRENCH = ITEMS.register("target_wrench", TargetWrench::new);
    public static final RegistryObject<Item> OP_TOOL = ITEMS.register("op_tool", OPTool::new);

    // ========== GUI Items ==========
    public static final RegistryObject<Item> DESK_ITEM_BOOK = ITEMS.register("desk_item_book", DeskItemBook::new);
    public static final RegistryObject<Item> DESK_ITEM_RADAR = ITEMS.register("desk_item_radar",
            DeskItemRadar::new);
    public static final RegistryObject<Item> SHIP_TANK = ITEMS.register("ship_tank", ShipTank::new);
    public static final RegistryObject<Item> SHIP_TANK_1 = ITEMS.register("ship_tank_1", () -> new ShipTank(1));
    public static final RegistryObject<Item> SHIP_TANK_2 = ITEMS.register("ship_tank_2", () -> new ShipTank(2));
    public static final RegistryObject<Item> SHIP_TANK_3 = ITEMS.register("ship_tank_3", () -> new ShipTank(3));
    public static final RegistryObject<Item> POINTER = ITEMS.register("pointer", PointerItem::new);

    // ========== Equipment Items ==========
    public static final RegistryObject<Item> EQUIP_CANNON = ITEMS.register("equip_cannon", EquipCannon::new);
    public static final RegistryObject<Item> EQUIP_MACHINEGUN = ITEMS.register("equip_machinegun",
            EquipMachinegun::new);
    public static final RegistryObject<Item> EQUIP_TORPEDO = ITEMS.register("equip_torpedo", EquipTorpedo::new);
    public static final RegistryObject<Item> EQUIP_AMMO = ITEMS.register("equip_ammo", EquipAmmo::new);
    public static final RegistryObject<Item> EQUIP_AIRPLANE = ITEMS.register("equip_airplane", EquipAirplane::new);
    public static final RegistryObject<Item> EQUIP_ARMOR = ITEMS.register("equip_armor", EquipArmor::new);
    public static final RegistryObject<Item> EQUIP_RADAR = ITEMS.register("equip_radar", EquipRadar::new);
    public static final RegistryObject<Item> EQUIP_COMPASS = ITEMS.register("equip_compass", EquipCompass::new);
    public static final RegistryObject<Item> EQUIP_SEARCHLIGHT = ITEMS.register("equip_searchlight",
            EquipSearchlight::new);
    public static final RegistryObject<Item> EQUIP_FLARE = ITEMS.register("equip_flare", EquipFlare::new);
    public static final RegistryObject<Item> EQUIP_DRUM = ITEMS.register("equip_drum", EquipDrum::new);
    public static final RegistryObject<Item> EQUIP_TURBINE = ITEMS.register("equip_turbine", EquipTurbine::new);
    public static final RegistryObject<Item> EQUIP_CATAPULT = ITEMS.register("equip_catapult", EquipCatapult::new);

    // ========== BlockItems ==========
    public static final RegistryObject<Item> ABYSSIUM_BLOCK_ITEM = ITEMS.register("abyssium",
            () -> new ItemBlockResourceBlock(ModBlocks.ABYSSIUM.get(), new Item.Properties(),
                    new int[]{0, 9, 0, 0}));
    public static final RegistryObject<Item> GRUDGE_BLOCK_ITEM = ITEMS.register("grudge_block",
            () -> new ItemBlockResourceBlock(ModBlocks.GRUDGE.get(), new Item.Properties(),
                    new int[]{9, 0, 0, 0}));
    public static final RegistryObject<Item> GRUDGE_HEAVY_DECO_BLOCK_ITEM = ITEMS.register("grudge_heavy_deco",
            () -> new ItemBlockResourceBlock(ModBlocks.GRUDGE_HEAVY_DECO.get(), new Item.Properties(),
                    new int[]{81, 0, 0, 0}));
    public static final RegistryObject<Item> GRUDGE_XP_BLOCK_ITEM = ITEMS.register("grudge_xp",
            () -> new BlockItem(ModBlocks.GRUDGE_XP.get(), new Item.Properties()));
    public static final RegistryObject<Item> VOL_BLOCK_BLOCK_ITEM = ITEMS.register("vol_block",
            () -> new BlockItem(ModBlocks.VOL_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> FRAME_BLOCK_ITEM = ITEMS.register("frame",
            () -> new BlockItem(ModBlocks.FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> POLYMETAL_ORE_BLOCK_ITEM = ITEMS.register("polymetal_ore",
            () -> new BlockItem(ModBlocks.POLYMETAL_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> POLYMETAL_GRAVEL_BLOCK_ITEM = ITEMS.register("polymetal_gravel",
            () -> new ItemBlockResourceBlock(ModBlocks.POLYMETAL_GRAVEL.get(), new Item.Properties(),
                    new int[]{0, 0, 0, 4}));
    public static final RegistryObject<Item> CRANE_BLOCK_ITEM = ITEMS.register("crane",
            () -> new BlockItem(ModBlocks.CRANE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DESK_BLOCK_ITEM = ITEMS.register("desk",
            () -> new CustomRenderedBlockItem(ModBlocks.DESK.get(), new Item.Properties()));
    public static final RegistryObject<Item> SMALL_SHIPYARD_BLOCK_ITEM = ITEMS.register("small_shipyard",
            () -> new CustomRenderedBlockItem(ModBlocks.SMALL_SHIPYARD.get(), new Item.Properties()));
    public static final RegistryObject<Item> VOL_CORE_BLOCK_ITEM = ITEMS.register("vol_core",
            () -> new BlockItem(ModBlocks.VOL_CORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> WAYPOINT_BLOCK_ITEM = ITEMS.register("waypoint",
            () -> new BlockItem(ModBlocks.WAYPOINT.get(), new Item.Properties()));
    public static final RegistryObject<Item> GRUDGE_HEAVY_BLOCK_ITEM = ITEMS.register("grudge_heavy",
            () -> new ItemBlockGrudgeHeavy(ModBlocks.GRUDGE_HEAVY.get(), new Item.Properties()));
    public static final RegistryObject<Item> POLYMETAL_BLOCK_ITEM = ITEMS.register("polymetal",
            () -> new ItemBlockResourceBlock(ModBlocks.POLYMETAL.get(), new Item.Properties(),
                    new int[]{0, 0, 0, 9}));
    public static final RegistryObject<Item> LIGHT_AIR_BLOCK_ITEM = ITEMS.register("light_air",
            () -> new BlockItem(ModBlocks.LIGHT_AIR.get(), new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_LIQUID_BLOCK_ITEM = ITEMS.register("light_liquid",
            () -> new BlockItem(ModBlocks.LIGHT_LIQUID.get(), new Item.Properties()));
}
