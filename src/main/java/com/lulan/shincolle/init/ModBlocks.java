package com.lulan.shincolle.init;

import com.lulan.shincolle.block.*;
import com.lulan.shincolle.reference.Reference;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);

    // ========== Simple Blocks ==========
    public static final RegistryObject<Block> ABYSSIUM = BLOCKS.register("abyssium", BlockAbyssium::new);
    public static final RegistryObject<Block> GRUDGE = BLOCKS.register("grudge_block", BlockGrudge::new);
    public static final RegistryObject<Block> GRUDGE_HEAVY_DECO = BLOCKS.register("grudge_heavy_deco", BlockGrudgeHeavyDeco::new);
    public static final RegistryObject<Block> GRUDGE_XP = BLOCKS.register("grudge_xp", BlockGrudgeXP::new);
    public static final RegistryObject<Block> VOL_BLOCK = BLOCKS.register("vol_block", BlockVolBlock::new);
    public static final RegistryObject<Block> FRAME = BLOCKS.register("frame", BlockFrame::new);

    // ========== Ore/World Blocks ==========
    public static final RegistryObject<Block> POLYMETAL_ORE = BLOCKS.register("polymetal_ore", BlockPolymetalOre::new);
    public static final RegistryObject<Block> POLYMETAL_GRAVEL = BLOCKS.register("polymetal_gravel", BlockPolymetalGravel::new);

    // ========== Container Blocks ==========
    public static final RegistryObject<Block> CRANE = BLOCKS.register("crane", BlockCrane::new);
    public static final RegistryObject<Block> DESK = BLOCKS.register("desk", BlockDesk::new);
    public static final RegistryObject<Block> SMALL_SHIPYARD = BLOCKS.register("small_shipyard", BlockSmallShipyard::new);
    public static final RegistryObject<Block> VOL_CORE = BLOCKS.register("vol_core", BlockVolCore::new);
    public static final RegistryObject<Block> WAYPOINT = BLOCKS.register("waypoint", BlockWaypoint::new);

    // ========== Multi-Block ==========
    public static final RegistryObject<Block> GRUDGE_HEAVY = BLOCKS.register("grudge_heavy", BlockGrudgeHeavy::new);
    public static final RegistryObject<Block> POLYMETAL = BLOCKS.register("polymetal", BlockPolymetal::new);

    // ========== Special Blocks ==========
    public static final RegistryObject<Block> LIGHT_AIR = BLOCKS.register("light_air", BlockLightAir::new);
    public static final RegistryObject<Block> LIGHT_LIQUID = BLOCKS.register("light_liquid", BlockLightLiquid::new);
}
