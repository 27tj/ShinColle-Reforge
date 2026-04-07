package com.lulan.shincolle.init;

import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.tileentity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Reference.MOD_ID);

    // ========== Container Block Entities ==========

    @SuppressWarnings("ConstantConditions")
    public static final RegistryObject<BlockEntityType<TileEntityCrane>> CRANE =
            BLOCK_ENTITIES.register("crane", () ->
                    BlockEntityType.Builder.of(TileEntityCrane::new, ModBlocks.CRANE.get()).build(null));

    @SuppressWarnings("ConstantConditions")
    public static final RegistryObject<BlockEntityType<TileEntityDesk>> DESK =
            BLOCK_ENTITIES.register("desk", () ->
                    BlockEntityType.Builder.of(TileEntityDesk::new, ModBlocks.DESK.get()).build(null));

    @SuppressWarnings("ConstantConditions")
    public static final RegistryObject<BlockEntityType<TileEntitySmallShipyard>> SMALL_SHIPYARD =
            BLOCK_ENTITIES.register("small_shipyard", () ->
                    BlockEntityType.Builder.of(TileEntitySmallShipyard::new, ModBlocks.SMALL_SHIPYARD.get()).build(null));

    @SuppressWarnings("ConstantConditions")
    public static final RegistryObject<BlockEntityType<TileEntityVolCore>> VOL_CORE =
            BLOCK_ENTITIES.register("vol_core", () ->
                    BlockEntityType.Builder.of(TileEntityVolCore::new, ModBlocks.VOL_CORE.get()).build(null));

    @SuppressWarnings("ConstantConditions")
    public static final RegistryObject<BlockEntityType<TileEntityWaypoint>> WAYPOINT =
            BLOCK_ENTITIES.register("waypoint", () ->
                    BlockEntityType.Builder.of(TileEntityWaypoint::new, ModBlocks.WAYPOINT.get()).build(null));

    // ========== Special Block Entities ==========

    @SuppressWarnings("ConstantConditions")
    public static final RegistryObject<BlockEntityType<TileEntityLightBlock>> LIGHT_BLOCK =
            BLOCK_ENTITIES.register("light_block", () ->
                    BlockEntityType.Builder.of(TileEntityLightBlock::new,
                            ModBlocks.LIGHT_AIR.get(), ModBlocks.LIGHT_LIQUID.get()).build(null));

    // ========== Multi-Block Entities ==========

    @SuppressWarnings("ConstantConditions")
    public static final RegistryObject<BlockEntityType<TileMultiGrudgeHeavy>> GRUDGE_HEAVY_MULTI =
            BLOCK_ENTITIES.register("grudge_heavy_multi", () ->
                    BlockEntityType.Builder.of(TileMultiGrudgeHeavy::new, ModBlocks.GRUDGE_HEAVY.get()).build(null));

    @SuppressWarnings("ConstantConditions")
    public static final RegistryObject<BlockEntityType<TileMultiPolymetal>> POLYMETAL_MULTI =
            BLOCK_ENTITIES.register("polymetal_multi", () ->
                    BlockEntityType.Builder.of(TileMultiPolymetal::new, ModBlocks.POLYMETAL.get()).build(null));
}
