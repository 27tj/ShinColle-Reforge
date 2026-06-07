package com.lulan.shincolle.init;

import com.lulan.shincolle.client.gui.inventory.*;
import com.lulan.shincolle.reference.Reference;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES,
            Reference.MOD_ID);

    public static final RegistryObject<MenuType<ContainerShipInventory>> SHIP_INVENTORY =
            MENUS.register("ship_inventory", () -> IForgeMenuType.create(ContainerShipInventory::new));

    public static final RegistryObject<MenuType<ContainerSmallShipyard>> SMALL_SHIPYARD =
            MENUS.register("small_shipyard", () -> IForgeMenuType.create(ContainerSmallShipyard::new));

    public static final RegistryObject<MenuType<ContainerLargeShipyard>> LARGE_SHIPYARD =
            MENUS.register("large_shipyard", () -> IForgeMenuType.create(ContainerLargeShipyard::new));

    public static final RegistryObject<MenuType<ContainerDesk>> DESK =
            MENUS.register("desk", () -> IForgeMenuType.create(ContainerDesk::new));

    public static final RegistryObject<MenuType<ContainerFormation>> FORMATION =
            MENUS.register("formation", () -> IForgeMenuType.create(ContainerFormation::new));

    public static final RegistryObject<MenuType<ContainerCrane>> CRANE =
            MENUS.register("crane", () -> IForgeMenuType.create(ContainerCrane::new));

    public static final RegistryObject<MenuType<ContainerVolCore>> VOL_CORE =
            MENUS.register("vol_core", () -> IForgeMenuType.create(ContainerVolCore::new));

    public static final RegistryObject<MenuType<ContainerRecipePaper>> RECIPE_PAPER =
            MENUS.register("recipe_paper", () -> IForgeMenuType.create(ContainerRecipePaper::new));
}
