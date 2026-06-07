package com.lulan.shincolle.init;

import com.lulan.shincolle.reference.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.HashMap;

/**
 * Sound registration for ShinColle mod (1.20.1 port).
 * <p>
 * All 53 base SoundEvents are registered via DeferredRegister. Custom per-ship
 * sounds are also registered and stored in a HashMap for lookup at runtime.
 * <p>
 * Custom sound lookup: key = shipClass * 100 + soundType
 * soundType: 0=idle, 1=hit, 2=hurt, 3=dead, 4=marry, 5=knockback, 6=item,
 * 7=feed
 * soundType 10~33: time keeping sounds (10 + hour)
 */
public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
            Reference.MOD_ID);

    // ========== Helper ==========
    public static final RegistryObject<SoundEvent> SHIP_IDLE = registerSound("ship_idle");

    // ========== Core Sounds (11) ==========
    public static final RegistryObject<SoundEvent> SHIP_HURT = registerSound("ship_hurt");
    public static final RegistryObject<SoundEvent> SHIP_DEATH = registerSound("ship_death");
    public static final RegistryObject<SoundEvent> SHIP_FIRELIGHT = registerSound("ship_firelight");
    public static final RegistryObject<SoundEvent> SHIP_EXPLODE = registerSound("ship_explode");
    public static final RegistryObject<SoundEvent> SHIP_FIREHEAVY = registerSound("ship_fireheavy");
    public static final RegistryObject<SoundEvent> SHIP_HIT = registerSound("ship_hit");
    public static final RegistryObject<SoundEvent> SHIP_AIRCRAFT = registerSound("ship_aircraft");
    public static final RegistryObject<SoundEvent> SHIP_MACHINEGUN = registerSound("ship_machinegun");
    public static final RegistryObject<SoundEvent> SHIP_LASER = registerSound("ship_laser");
    public static final RegistryObject<SoundEvent> SHIP_MARRY = registerSound("ship_marry");
    public static final RegistryObject<SoundEvent> SHIP_TIME0 = registerSound("ship_time0");

    // ========== Time Keeping Sounds (24) ==========
    public static final RegistryObject<SoundEvent> SHIP_TIME1 = registerSound("ship_time1");
    public static final RegistryObject<SoundEvent> SHIP_TIME2 = registerSound("ship_time2");
    public static final RegistryObject<SoundEvent> SHIP_TIME3 = registerSound("ship_time3");
    public static final RegistryObject<SoundEvent> SHIP_TIME4 = registerSound("ship_time4");
    public static final RegistryObject<SoundEvent> SHIP_TIME5 = registerSound("ship_time5");
    public static final RegistryObject<SoundEvent> SHIP_TIME6 = registerSound("ship_time6");
    public static final RegistryObject<SoundEvent> SHIP_TIME7 = registerSound("ship_time7");
    public static final RegistryObject<SoundEvent> SHIP_TIME8 = registerSound("ship_time8");
    public static final RegistryObject<SoundEvent> SHIP_TIME9 = registerSound("ship_time9");
    public static final RegistryObject<SoundEvent> SHIP_TIME10 = registerSound("ship_time10");
    public static final RegistryObject<SoundEvent> SHIP_TIME11 = registerSound("ship_time11");
    public static final RegistryObject<SoundEvent> SHIP_TIME12 = registerSound("ship_time12");
    public static final RegistryObject<SoundEvent> SHIP_TIME13 = registerSound("ship_time13");
    public static final RegistryObject<SoundEvent> SHIP_TIME14 = registerSound("ship_time14");
    public static final RegistryObject<SoundEvent> SHIP_TIME15 = registerSound("ship_time15");
    public static final RegistryObject<SoundEvent> SHIP_TIME16 = registerSound("ship_time16");
    public static final RegistryObject<SoundEvent> SHIP_TIME17 = registerSound("ship_time17");
    public static final RegistryObject<SoundEvent> SHIP_TIME18 = registerSound("ship_time18");
    public static final RegistryObject<SoundEvent> SHIP_TIME19 = registerSound("ship_time19");
    public static final RegistryObject<SoundEvent> SHIP_TIME20 = registerSound("ship_time20");
    public static final RegistryObject<SoundEvent> SHIP_TIME21 = registerSound("ship_time21");
    public static final RegistryObject<SoundEvent> SHIP_TIME22 = registerSound("ship_time22");
    public static final RegistryObject<SoundEvent> SHIP_TIME23 = registerSound("ship_time23");
    public static final RegistryObject<SoundEvent> SHIP_KAITAI = registerSound("ship_kaitai");

    // ========== Special/Boss Sounds (4) ==========
    public static final RegistryObject<SoundEvent> SHIP_AP_P1 = registerSound("ship_ap_phase1");
    public static final RegistryObject<SoundEvent> SHIP_AP_P2 = registerSound("ship_ap_phase2");
    public static final RegistryObject<SoundEvent> SHIP_AP_ATTACK = registerSound("ship_ap_attack");
    public static final RegistryObject<SoundEvent> SHIP_WAKA_ATTACK = registerSound("ship_waka_attack");

    // ========== Wakamoto Entity Sounds (4) ==========
    public static final RegistryObject<SoundEvent> SHIP_WAKA_HURT = registerSound("ship_waka_hurt");
    public static final RegistryObject<SoundEvent> SHIP_WAKA_IDLE = registerSound("ship_waka_idle");
    public static final RegistryObject<SoundEvent> SHIP_WAKA_DEATH = registerSound("ship_waka_death");
    public static final RegistryObject<SoundEvent> SHIP_GARURU = registerSound("ship_garuru");

    // ========== Additional Sounds (10) ==========
    public static final RegistryObject<SoundEvent> SHIP_YAMATO_READY = registerSound("ship_yamato_ready");
    public static final RegistryObject<SoundEvent> SHIP_YAMATO_SHOT = registerSound("ship_yamato_shot");
    public static final RegistryObject<SoundEvent> SHIP_KNOCKBACK = registerSound("ship_knockback");
    public static final RegistryObject<SoundEvent> SHIP_ITEM = registerSound("ship_item");
    public static final RegistryObject<SoundEvent> SHIP_LEVEL = registerSound("ship_levelup");
    public static final RegistryObject<SoundEvent> SHIP_FEED = registerSound("ship_feed");
    public static final RegistryObject<SoundEvent> SHIP_BELL = registerSound("ship_bell");
    public static final RegistryObject<SoundEvent> SHIP_JET = registerSound("ship_jet");
    public static final RegistryObject<SoundEvent> SHIP_HITMETAL = registerSound("ship_hitmetal");
    // Ship class 54 custom sounds
    private static final RegistryObject<SoundEvent> SHIP_IDLE_54 = registerSound("ship_idle_54");

    // ========== Custom Per-Ship Sounds ==========
    // These are custom voice sounds for specific ship classes, previously
    // registered dynamically from config. In 1.20.1 they must be registered
    // statically via DeferredRegister.
    private static final RegistryObject<SoundEvent> SHIP_HURT_54 = registerSound("ship_hurt_54");
    private static final RegistryObject<SoundEvent> SHIP_MARRY_54 = registerSound("ship_marry_54");
    private static final RegistryObject<SoundEvent> SHIP_ITEM_54 = registerSound("ship_item_54");
    // Ship class 56 custom sounds
    private static final RegistryObject<SoundEvent> SHIP_IDLE_56 = registerSound("ship_idle_56");
    private static final RegistryObject<SoundEvent> SHIP_HIT_56 = registerSound("ship_hit_56");
    private static final RegistryObject<SoundEvent> SHIP_HURT_56 = registerSound("ship_hurt_56");
    private static final RegistryObject<SoundEvent> SHIP_DEATH_56 = registerSound("ship_death_56");
    private static final RegistryObject<SoundEvent> SHIP_ITEM_56 = registerSound("ship_item_56");
    // Ship class 60 custom sounds
    private static final RegistryObject<SoundEvent> SHIP_IDLE_60 = registerSound("ship_idle_60");
    private static final RegistryObject<SoundEvent> SHIP_HIT_60 = registerSound("ship_hit_60");
    // Ship class 62 custom sounds
    private static final RegistryObject<SoundEvent> SHIP_HIT_62 = registerSound("ship_hit_62");
    /**
     * Custom sound map: key = shipClass * 100 + soundType
     * soundType: 0=idle, 1=hit, 2=hurt, 3=dead, 4=marry, 5=knockback, 6=item,
     * 7=feed
     * soundType 10~33: time keeping sounds (10 + hour)
     */
    private static final HashMap<Integer, RegistryObject<SoundEvent>> CUSTOM_SOUNDS = new HashMap<>();

    // ========== Custom Sound Lookup ==========

    static {
        // Ship class 54
        CUSTOM_SOUNDS.put(54 * 100, SHIP_IDLE_54); // idle
        CUSTOM_SOUNDS.put(54 * 100 + 2, SHIP_HURT_54); // hurt
        CUSTOM_SOUNDS.put(54 * 100 + 4, SHIP_MARRY_54); // marry
        CUSTOM_SOUNDS.put(54 * 100 + 6, SHIP_ITEM_54); // item

        // Ship class 56
        CUSTOM_SOUNDS.put(56 * 100, SHIP_IDLE_56); // idle
        CUSTOM_SOUNDS.put(56 * 100 + 1, SHIP_HIT_56); // hit
        CUSTOM_SOUNDS.put(56 * 100 + 2, SHIP_HURT_56); // hurt
        CUSTOM_SOUNDS.put(56 * 100 + 3, SHIP_DEATH_56); // death
        CUSTOM_SOUNDS.put(56 * 100 + 6, SHIP_ITEM_56); // item

        // Ship class 60
        CUSTOM_SOUNDS.put(60 * 100, SHIP_IDLE_60); // idle
        CUSTOM_SOUNDS.put(60 * 100 + 1, SHIP_HIT_60); // hit

        // Ship class 62
        CUSTOM_SOUNDS.put(62 * 100 + 1, SHIP_HIT_62); // hit
    }

    private static RegistryObject<SoundEvent> registerSound(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(
                new ResourceLocation(Reference.MOD_ID, name)));
    }

    /**
     * Get custom sound for a specific ship class and sound type.
     * Falls back to default sound if no custom sound is registered.
     *
     * @param type      sound type (0=idle, 1=hit, 2=hurt, 3=dead, 4=marry,
     *                  5=knockback, 6=item, 7=feed)
     * @param shipClass the ship class ID
     * @return the SoundEvent, or null if no default exists for the type
     */
    public static @Nullable SoundEvent getCustomSound(int type, int shipClass) {
        int key = shipClass * 100 + type;
        RegistryObject<SoundEvent> obj = CUSTOM_SOUNDS.get(key);
        return obj != null ? obj.get() : getDefaultSound(type);
    }

    /**
     * Get the default (generic) sound for a given sound type.
     *
     * @param type sound type (0=idle, 1=hit, 2=hurt, 3=dead, 4=marry, 5=knockback,
     *             6=item, 7=feed)
     * @return the default SoundEvent, or null if the type is unknown
     */
    private static @Nullable SoundEvent getDefaultSound(int type) {
        return switch (type) {
            case 0 -> SHIP_IDLE.get();
            case 1 -> SHIP_HIT.get();
            case 2 -> SHIP_HURT.get();
            case 3 -> SHIP_DEATH.get();
            case 4 -> SHIP_MARRY.get();
            case 5 -> SHIP_KNOCKBACK.get();
            case 6 -> SHIP_ITEM.get();
            case 7 -> SHIP_FEED.get();
            default -> {
                // Types 10-33: timekeeping sounds (type = hour + 10)
                if (type >= 10 && type <= 33) {
                    yield getTimekeepingSound(type - 10);
                }
                yield null;
            }
        };
    }

    /**
     * Get the timekeeping sound for a given hour (0-23).
     *
     * @param hour the in-game hour (0-23)
     * @return the timekeeping SoundEvent, or null if the hour is out of range
     */
    public static @Nullable SoundEvent getTimekeepingSound(int hour) {
        return switch (hour) {
            case 0 -> SHIP_TIME0.get();
            case 1 -> SHIP_TIME1.get();
            case 2 -> SHIP_TIME2.get();
            case 3 -> SHIP_TIME3.get();
            case 4 -> SHIP_TIME4.get();
            case 5 -> SHIP_TIME5.get();
            case 6 -> SHIP_TIME6.get();
            case 7 -> SHIP_TIME7.get();
            case 8 -> SHIP_TIME8.get();
            case 9 -> SHIP_TIME9.get();
            case 10 -> SHIP_TIME10.get();
            case 11 -> SHIP_TIME11.get();
            case 12 -> SHIP_TIME12.get();
            case 13 -> SHIP_TIME13.get();
            case 14 -> SHIP_TIME14.get();
            case 15 -> SHIP_TIME15.get();
            case 16 -> SHIP_TIME16.get();
            case 17 -> SHIP_TIME17.get();
            case 18 -> SHIP_TIME18.get();
            case 19 -> SHIP_TIME19.get();
            case 20 -> SHIP_TIME20.get();
            case 21 -> SHIP_TIME21.get();
            case 22 -> SHIP_TIME22.get();
            case 23 -> SHIP_TIME23.get();
            default -> null;
        };
    }
}
