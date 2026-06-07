package com.lulan.shincolle.init;

import com.lulan.shincolle.item.BasicEquip;
import com.lulan.shincolle.item.ShipSpawnEgg;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SHINCOLLE_TAB = CREATIVE_TABS.register("shincolle_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab." + Reference.MOD_ID))
                    .icon(() -> new ItemStack(ModItems.GRUDGE.get()))
                    .displayItems((parameters, output) -> {
                        // 1. Spawn Eggs - all ship type variants
                        addSpawnEggVariants(output);

                        // 2. AbyssMetal
                        output.accept(ModItems.ABYSS_METAL.get());

                        // 3. AbyssNugget (all variants)
                        output.accept(ModItems.ABYSS_NUGGET.get());
                        output.accept(ModItems.ABYSS_NUGGET_1.get());

                        // 4. Ammo (all variants)
                        output.accept(ModItems.AMMO.get());
                        output.accept(ModItems.AMMO_1.get());
                        output.accept(ModItems.AMMO_2.get());
                        output.accept(ModItems.AMMO_3.get());

                        // 5. Grudge (meta 0 and meta 1)
                        output.accept(ModItems.GRUDGE.get());
                        output.accept(ModItems.GRUDGE_1.get());

                        // 6. Equipment Items - alphabetical order, custom sub-ordering where applicable
                        // Airplane: T:0,1,2,3,15 / F:4,5,6,7,8,18,16,21 / B:9,10,11,12,17,19,20 /
                        // R:13,14
                        addEquipVariants(output, ModItems.EQUIP_AIRPLANE,
                                new int[]{0, 1, 2, 3, 15, 4, 5, 6, 7, 8, 18, 16, 21, 9, 10, 11, 12, 17, 19, 20, 13,
                                        14});
                        addEquipVariants(output, ModItems.EQUIP_AMMO);
                        // Armor: 0,1,5,2,3,4,6
                        addEquipVariants(output, ModItems.EQUIP_ARMOR,
                                new int[]{0, 1, 5, 2, 3, 4, 6});
                        // Cannon: S:0,1,12 / Tw:2,3,4,13,5,6,7,8 / Tr:11,9,15,10 / Qu:14
                        addEquipVariants(output, ModItems.EQUIP_CANNON,
                                new int[]{0, 1, 12, 2, 3, 4, 13, 5, 6, 7, 8, 11, 9, 15, 10, 14});
                        addEquipVariants(output, ModItems.EQUIP_CATAPULT);
                        addEquipVariants(output, ModItems.EQUIP_COMPASS);
                        addEquipVariants(output, ModItems.EQUIP_DRUM);
                        addEquipVariants(output, ModItems.EQUIP_FLARE);
                        addEquipVariants(output, ModItems.EQUIP_MACHINEGUN);
                        // Radar: AA:0,1,5 / Surface:2,3,6 / Sonar:4,7 / Other:8
                        addEquipVariants(output, ModItems.EQUIP_RADAR,
                                new int[]{0, 1, 5, 2, 3, 6, 4, 7, 8});
                        addEquipVariants(output, ModItems.EQUIP_SEARCHLIGHT);
                        addEquipVariants(output, ModItems.EQUIP_TORPEDO);
                        addEquipVariants(output, ModItems.EQUIP_TURBINE);

                        // 7. BucketRepair
                        output.accept(ModItems.BUCKET_REPAIR.get());

                        // 8. CombatRation (all variants)
                        output.accept(ModItems.COMBAT_RATION.get());
                        output.accept(ModItems.COMBAT_RATION_1.get());
                        output.accept(ModItems.COMBAT_RATION_2.get());
                        output.accept(ModItems.COMBAT_RATION_3.get());
                        output.accept(ModItems.COMBAT_RATION_4.get());
                        output.accept(ModItems.COMBAT_RATION_5.get());

                        // 9. DeskItemBook
                        output.accept(ModItems.DESK_ITEM_BOOK.get());

                        // 10. DeskItemRadar
                        output.accept(ModItems.DESK_ITEM_RADAR.get());

                        // 11. InstantConMat
                        output.accept(ModItems.INSTANT_CON_MAT.get());

                        // 12. KaitaiHammer
                        output.accept(ModItems.KAITAI_HAMMER.get());

                        // 13. MarriageRing
                        output.accept(ModItems.MARRIAGE_RING.get());

                        // 14. ModernKit
                        output.accept(ModItems.MODERN_KIT.get());

                        // 15. OwnerPaper
                        output.accept(ModItems.OWNER_PAPER.get());

                        // 16. OPTool
                        output.accept(ModItems.OP_TOOL.get());

                        // 17. PointerItem
                        output.accept(ModItems.POINTER.get());

                        // 18. RecipePaper
                        output.accept(ModItems.RECIPE_PAPER.get());

                        // 19. RepairGoddess
                        output.accept(ModItems.REPAIR_GODDESS.get());

                        // 20. ShipTank (all variants)
                        output.accept(ModItems.SHIP_TANK.get());
                        output.accept(ModItems.SHIP_TANK_1.get());
                        output.accept(ModItems.SHIP_TANK_2.get());
                        output.accept(ModItems.SHIP_TANK_3.get());

                        // 21. TargetWrench
                        output.accept(ModItems.TARGET_WRENCH.get());

                        // 22. TrainingBook
                        output.accept(ModItems.TRAINING_BOOK.get());

                        // 23. ToyAirplane
                        output.accept(ModItems.TOY_AIRPLANE.get());

                        // Other material items not in original ordering
                        output.accept(ModItems.POLYMETAL_NODULE.get());

                        // Block Items
                        output.accept(ModItems.ABYSSIUM_BLOCK_ITEM.get());
                        output.accept(ModItems.GRUDGE_BLOCK_ITEM.get());
                        output.accept(ModItems.GRUDGE_HEAVY_DECO_BLOCK_ITEM.get());
                        output.accept(ModItems.GRUDGE_XP_BLOCK_ITEM.get());
                        output.accept(ModItems.VOL_BLOCK_BLOCK_ITEM.get());
                        output.accept(ModItems.FRAME_BLOCK_ITEM.get());
                        output.accept(ModItems.POLYMETAL_ORE_BLOCK_ITEM.get());
                        output.accept(ModItems.POLYMETAL_GRAVEL_BLOCK_ITEM.get());
                        output.accept(ModItems.CRANE_BLOCK_ITEM.get());
                        output.accept(ModItems.DESK_BLOCK_ITEM.get());
                        output.accept(ModItems.SMALL_SHIPYARD_BLOCK_ITEM.get());
                        output.accept(ModItems.VOL_CORE_BLOCK_ITEM.get());
                        output.accept(ModItems.WAYPOINT_BLOCK_ITEM.get());
                        output.accept(ModItems.GRUDGE_HEAVY_BLOCK_ITEM.get());
                        output.accept(ModItems.POLYMETAL_BLOCK_ITEM.get());
                        // [PORT] 1.10.2 -> 1.20.1: Light helper blocks are internal utility blocks and
                        // were not visible in normal tab flow.
                        // Keep them obtainable by command only to avoid creative inventory pollution.
                    })
                    .build());

    /**
     * Add all variants of an equipment item to creative tab in sequential order
     */
    private static void addEquipVariants(CreativeModeTab.Output output, RegistryObject<Item> equipItem) {
        Item item = equipItem.get();
        if (item instanceof BasicEquip equip) {
            for (int meta = 0; meta < equip.getNumVariants(); meta++) {
                output.accept(equip.createStack(meta));
            }
        } else {
            output.accept(item);
        }
    }

    /**
     * Add all variants of an equipment item to creative tab in custom order
     */
    private static void addEquipVariants(CreativeModeTab.Output output, RegistryObject<Item> equipItem, int[] order) {
        Item item = equipItem.get();
        if (item instanceof BasicEquip equip) {
            for (int meta : order) {
                output.accept(equip.createStack(meta));
            }
        } else {
            output.accept(item);
        }
    }

    /**
     * Add all spawn egg variants to creative tab using correct ShipClass values.
     * Construction template eggs use BuildType tag; individual eggs use ShipClass
     * directly.
     */
    private static void addSpawnEggVariants(CreativeModeTab.Output output) {
        Item item = ModItems.SHIP_SPAWN_EGG.get();
        if (!(item instanceof ShipSpawnEgg egg)) {
            output.accept(item);
            return;
        }

        // Construction template eggs (with BuildType NBT tag)
        output.accept(egg.createConstructionStack(0)); // small construction egg
        output.accept(egg.createConstructionStack(1)); // large construction egg

        // Abyssal ships (深海棲艦) - friendly, owner assigned on spawn, extends
        // BasicEntityShip
        output.accept(egg.createStack(0)); // DDI
        output.accept(egg.createStack(1)); // DDRO
        output.accept(egg.createStack(2)); // DDHA
        output.accept(egg.createStack(3)); // DDNI
        output.accept(egg.createStack(9)); // CARI
        output.accept(egg.createStack(10)); // CANE
        output.accept(egg.createStack(12)); // CVWO
        output.accept(egg.createStack(13)); // BBRU
        output.accept(egg.createStack(14)); // BBTA
        output.accept(egg.createStack(15)); // BBRE
        output.accept(egg.createStack(16)); // APWA
        output.accept(egg.createStack(17)); // SSKA
        output.accept(egg.createStack(18)); // SSYO
        output.accept(egg.createStack(19)); // SSSO

        // Hime/Princess types
        output.accept(egg.createStack(27)); // DDHime
        output.accept(egg.createStack(49)); // CAHime
        output.accept(egg.createStack(20)); // CVHime
        output.accept(egg.createStack(26)); // BBHime
        output.accept(egg.createStack(21)); // AirfieldHime
        output.accept(egg.createStack(28)); // HarbourHime
        output.accept(egg.createStack(29)); // IsolatedHime
        output.accept(egg.createStack(30)); // MidwayHime
        output.accept(egg.createStack(31)); // NorthernHime
        output.accept(egg.createStack(44)); // SSHime
        output.accept(egg.createStack(72)); // SSNH
        output.accept(egg.createStack(33)); // CVWD

        // Kanmusu (friendly) ships
        output.accept(egg.createStack(51)); // DDAkatsuki
        output.accept(egg.createStack(52)); // DDHibiki
        output.accept(egg.createStack(53)); // DDIkazuchi
        output.accept(egg.createStack(54)); // DDInazuma
        output.accept(egg.createStack(36)); // DDShimakaze
        output.accept(egg.createStack(56)); // CLTenryuu
        output.accept(egg.createStack(57)); // CLTatsuta
        output.accept(egg.createStack(59)); // CATakao
        output.accept(egg.createStack(58)); // CAAtago
        output.accept(egg.createStack(47)); // CVKaga
        output.accept(egg.createStack(48)); // CVAkagi
        output.accept(egg.createStack(60)); // BBKongou
        output.accept(egg.createStack(61)); // BBHiei
        output.accept(egg.createStack(62)); // BBHaruna
        output.accept(egg.createStack(63)); // BBKirishima
        output.accept(egg.createStack(37)); // BBNagato
        output.accept(egg.createStack(46)); // BBYamato
        output.accept(egg.createStack(38)); // SSU511
        output.accept(egg.createStack(39)); // SSRo500

        // Mob variants (hostile field-spawning versions, ShipClass + 2000, extends
        // BasicEntityShipHostile)
        output.accept(egg.createStack(2051)); // DDAkatsuki (Mob)
        output.accept(egg.createStack(2052)); // DDHibiki (Mob)
        output.accept(egg.createStack(2053)); // DDIkazuchi (Mob)
        output.accept(egg.createStack(2054)); // DDInazuma (Mob)
        output.accept(egg.createStack(2036)); // DDShimakaze (Mob)
        output.accept(egg.createStack(2056)); // CLTenryuu (Mob)
        output.accept(egg.createStack(2057)); // CLTatsuta (Mob)
        output.accept(egg.createStack(2059)); // CATakao (Mob)
        output.accept(egg.createStack(2058)); // CAAtago (Mob)
        output.accept(egg.createStack(2047)); // CVKaga (Mob)
        output.accept(egg.createStack(2048)); // CVAkagi (Mob)
        output.accept(egg.createStack(2060)); // BBKongou (Mob)
        output.accept(egg.createStack(2061)); // BBHiei (Mob)
        output.accept(egg.createStack(2062)); // BBHaruna (Mob)
        output.accept(egg.createStack(2063)); // BBKirishima (Mob)
        output.accept(egg.createStack(2037)); // BBNagato (Mob)
        output.accept(egg.createStack(2046)); // BBYamato (Mob)
        output.accept(egg.createStack(2038)); // SSU511 (Mob)
        output.accept(egg.createStack(2039)); // SSRo500 (Mob)
    }
}
