package com.lulan.shincolle.init;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Particle type registration for ShinColle.
 * All custom particle types are registered via DeferredRegister.
 * The alwaysShow parameter is set to true so particles render at any distance.
 */
public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister
            .create(ForgeRegistries.PARTICLE_TYPES, Reference.MOD_ID);

    // ========== Custom Particle Types ==========

    /**
     * Laser beam particle for ship cannon attacks
     */
    public static final RegistryObject<SimpleParticleType> LASER = PARTICLES.register("laser",
            () -> new SimpleParticleType(true));

    /**
     * Water spray particle for ship movement and impacts
     */
    public static final RegistryObject<SimpleParticleType> SPRAY = PARTICLES.register("spray",
            () -> new SimpleParticleType(true));

    /**
     * Chi/energy particle for special attacks
     */
    public static final RegistryObject<SimpleParticleType> CHI = PARTICLES.register("chi",
            () -> new SimpleParticleType(true));

    /**
     * Lightning effect particle for electric attacks
     */
    public static final RegistryObject<SimpleParticleType> LIGHTNING = PARTICLES.register("lightning",
            () -> new SimpleParticleType(true));

    /**
     * Emotion indicator particle (hearts, anger, etc.)
     */
    public static final RegistryObject<SimpleParticleType> EMOTION = PARTICLES.register("emotion",
            () -> new SimpleParticleType(true));

    /**
     * Sparkle/glitter effect particle
     */
    public static final RegistryObject<SimpleParticleType> SPARKLE = PARTICLES.register("sparkle",
            () -> new SimpleParticleType(true));

    /**
     * Weapon sweep arc particle
     */
    public static final RegistryObject<SimpleParticleType> SWEEP = PARTICLES.register("sweep",
            () -> new SimpleParticleType(true));

    /**
     * Cube-shaped particle for block-related effects
     */
    public static final RegistryObject<SimpleParticleType> CUBE = PARTICLES.register("cube",
            () -> new SimpleParticleType(true));

    /**
     * Gradient color transition particle
     */
    public static final RegistryObject<SimpleParticleType> GRADIENT = PARTICLES.register("gradient",
            () -> new SimpleParticleType(true));

    /**
     * Spherical light/glow particle
     */
    public static final RegistryObject<SimpleParticleType> SPHERE_LIGHT = PARTICLES.register("sphere_light",
            () -> new SimpleParticleType(true));

    /**
     * "MISS" text particle displayed on failed attacks
     */
    public static final RegistryObject<SimpleParticleType> MISS_TEXT = PARTICLES.register("miss_text",
            () -> new SimpleParticleType(true));

    /**
     * Team indicator circle particle
     */
    public static final RegistryObject<SimpleParticleType> TEAM_CIRCLE = PARTICLES.register("team_circle",
            () -> new SimpleParticleType(true));

    /**
     * Line/trail particle for projectile paths
     */
    public static final RegistryObject<SimpleParticleType> LINE = PARTICLES.register("line",
            () -> new SimpleParticleType(true));

    /**
     * AP fist impact particle for melee attacks
     */
    public static final RegistryObject<SimpleParticleType> AP_FIST = PARTICLES.register("ap_fist",
            () -> new SimpleParticleType(true));

    /**
     * Crane construction particle effect
     */
    public static final RegistryObject<SimpleParticleType> CRANING = PARTICLES.register("craning",
            () -> new SimpleParticleType(true));

    /**
     * Custom smoke particle with configurable color/size
     */
    public static final RegistryObject<SimpleParticleType> SMOKE_CUSTOM = PARTICLES.register("smoke_custom",
            () -> new SimpleParticleType(true));
}
