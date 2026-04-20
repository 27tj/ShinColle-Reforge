package com.lulan.shincolle.utility;

import com.lulan.shincolle.client.particle.ParticleChi;
import com.lulan.shincolle.client.particle.ParticleCraning;
import com.lulan.shincolle.client.particle.ParticleCube;
import com.lulan.shincolle.client.particle.ParticleEmotion;
import com.lulan.shincolle.client.particle.ParticleGradient;
import com.lulan.shincolle.client.particle.ParticleLaser;
import com.lulan.shincolle.client.particle.ParticleLightning;
import com.lulan.shincolle.client.particle.ParticleLine;
import com.lulan.shincolle.client.particle.ParticleSparkle;
import com.lulan.shincolle.client.particle.ParticleSphereLight;
import com.lulan.shincolle.client.particle.ParticleSpray;
import com.lulan.shincolle.client.particle.ParticleStickyLightning;
import com.lulan.shincolle.client.particle.ParticleSweep;
import com.lulan.shincolle.client.particle.ParticleTeam;
import com.lulan.shincolle.client.particle.ParticleTexts;
import com.lulan.shincolle.network.ModNetworking;
import com.lulan.shincolle.network.S2CSpawnParticlePacket;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Particle spawning utility class for ShinColle.
 * Provides helper methods for spawning attack, emotion, and effect particles.
 *
 * The original mod (1.10.2) used numeric particle type IDs:
 * Types 1-49: Position-based particles (explosions, flames, etc.)
 * Types 50+: Entity-attached particles (emotions, status effects, etc.)
 *
 * Sprite-based particles (Spray, Smoke) are spawned via level.addParticle()
 * through the registered provider system.
 * Custom-rendered particles (Laser, Lightning, etc.) are spawned directly via
 * Minecraft.getInstance().particleEngine.add() since they need complex
 * constructor parameters (Entity references, type IDs, float arrays) that
 * can't pass through the standard ParticleProvider interface.
 */
public class ParticleHelper {

    private static final float TEAM_CIRCLE_ENTITY_SCALE = 0.35F;

    /**
     * Spawn attack particles at a position. Type IDs match the original mod's
     * particle system.
     * Types 1-49 are position-based particles, types 50+ are entity-attached.
     *
     * @param level the world/level instance
     * @param x     X position
     * @param y     Y position
     * @param z     Z position
     * @param lookX look vector X (used for directional particles)
     * @param lookY look vector Y
     * @param lookZ look vector Z
     * @param type  particle type ID from the original mod's system
     */
    public static void spawnAttackParticleAt(Level level, double x, double y, double z,
            double lookX, double lookY, double lookZ, int type) {
        if (level.isClientSide()) {
            switch (type) {
                // Basic attack/effect particles (types 1-9)
                case 1 -> level.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 0, 0);
                case 2 -> level.addParticle(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 0, 0, 0);
                case 3 -> level.addParticle(ParticleTypes.HEART, x, y, z, 0, 0, 0);
                case 4 -> level.addParticle(ParticleTypes.SMOKE, x, y, z, 0, 0, 0);
                case 5 -> level.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, 0);
                case 6 -> level.addParticle(ParticleTypes.CRIT, x, y, z, lookX, lookY, lookZ);
                  case 25 -> {
                      int teamId = (int) lookY;
                      spawnTeamCircleAtClient((net.minecraft.client.multiplayer.ClientLevel) level, x, y, z, teamId);
                  }
                case 7 -> level.addParticle(ParticleTypes.ENCHANTED_HIT, x, y, z, lookX, lookY, lookZ);
                case 8 -> level.addParticle(ParticleTypes.LARGE_SMOKE, x, y, z, 0, 0, 0);
                case 9 -> level.addParticle(ParticleTypes.BUBBLE, x, y, z, 0, 0.1, 0);

                // Text/indicator particles (types 10-14) - use custom ParticleTexts
                case 10 -> spawnTextParticleClient((ClientLevel) level, x, y + 1, z, 1.0f, 0); // miss
                case 11 -> spawnTextParticleClient((ClientLevel) level, x, y + 1, z, 1.0f, 1); // critical
                case 12 -> spawnTextParticleClient((ClientLevel) level, x, y + 1, z, 1.0f, 2); // double hit
                case 13 -> spawnTextParticleClient((ClientLevel) level, x, y + 1, z, 1.0f, 3); // triple hit
                case 14 -> spawnTextParticleClient((ClientLevel) level, x, y + 1, z, 1.0f, 4); // dodge

                // Weapon effect particles (types 15-20)
                case 15 -> level.addParticle(ParticleTypes.SPLASH, x, y, z, lookX, lookY, lookZ);
                case 16 -> {
                    // multi-explosion (heavy cannon)
                    for (int i = 0; i < 3; i++) {
                        double ox = (level.random.nextDouble() - 0.5) * 1.5;
                        double oz = (level.random.nextDouble() - 0.5) * 1.5;
                        level.addParticle(ParticleTypes.EXPLOSION, x + ox, y, z + oz, 0, 0, 0);
                    }
                }
                case 17 -> {
                    // flame burst (incendiary)
                    for (int i = 0; i < 5; i++) {
                        double ox = (level.random.nextDouble() - 0.5) * 0.5;
                        double oy = level.random.nextDouble() * 0.5;
                        double oz = (level.random.nextDouble() - 0.5) * 0.5;
                        level.addParticle(ParticleTypes.FLAME, x + ox, y + oy, z + oz, 0, 0.05, 0);
                    }
                }
                case 18 -> level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 0, 0.15, 0);
                case 19 -> level.addParticle(ParticleTypes.SONIC_BOOM, x, y, z, 0, 0, 0);
                case 20 -> {
                    // electric spark (laser)
                    for (int i = 0; i < 4; i++) {
                        double ox = (level.random.nextDouble() - 0.5) * 0.3;
                        double oy = (level.random.nextDouble() - 0.5) * 0.3;
                        double oz = (level.random.nextDouble() - 0.5) * 0.3;
                        level.addParticle(ParticleTypes.ELECTRIC_SPARK, x + ox, y + oy, z + oz, 0, 0, 0);
                    }
                }

                // Legacy spray variants (21-39 subset)
                // 2026/04/07：GitHub Copilotによって確認済み
                case 29 -> spawnSprayParticleVariantClient((ClientLevel) level, x, y, z, lookX, lookY, lookZ, 9);

                // Death smoke particles (types 40-49)
                case 43 -> {
                    // death smoke - spawns multiple large smoke columns
                    double width = 0.6; // approximate entity width for spread
                    for (int i = 0; i < 3; i++) {
                        double dx = (level.random.nextDouble() - 0.5) * width;
                        double dz = (level.random.nextDouble() - 0.5) * width;
                        level.addParticle(ParticleTypes.LARGE_SMOKE,
                                x + dx, y + level.random.nextDouble() * 0.5, z + dz,
                                0, 0.02, 0);
                    }
                }

                default -> {
                    /* Unhandled particle type */ }
            }
        }
    }

    /**
     * Spawn attack particles with default look direction (upward).
     */
    public static void spawnAttackParticleAt(Level level, double x, double y, double z, int type) {
        spawnAttackParticleAt(level, x, y, z, 0.0, 1.0, 0.0, type);
    }

    /**
     * Spawn emotion particles on an entity using custom ParticleEmotion.
     * Emotion types correspond to the original mod's emotion system:
     * 0 = none, 1 = heart, 2 = note, 3 = angry, 4 = sweat, etc.
     *
     * @param entity      the entity to spawn particles on
     * @param emotionType the emotion type ID
     */
    public static void spawnEmotionParticle(Entity entity, int emotionType) {
        if (entity.level().isClientSide() && emotionType > 0) {
            spawnEmotionParticleClient(entity, emotionType);
        }
    }

    /**
     * Spawn a spray/splash particle effect, typically used for ship movement on
     * water. Uses custom ParticleSpray via level.addParticle().
     *
     * @param level the world/level instance
     * @param x     X position
     * @param y     Y position (water surface)
     * @param z     Z position
     * @param count number of particles to spawn
     */
    public static void spawnSprayParticle(Level level, double x, double y, double z, int count) {
        if (level.isClientSide()) {
            spawnSprayParticleClient(level, x, y, z, count);
        }
    }

    /**
     * Spawn a "MISS" text particle above an entity using custom ParticleTexts.
     *
     * @param entity the entity that was missed
     */
    public static void spawnMissParticle(Entity entity) {
        if (entity.level().isClientSide()) {
            spawnTextParticleClient((ClientLevel) entity.level(),
                    entity.getX(), entity.getY() + entity.getBbHeight() + 0.5, entity.getZ(),
                    1.0f, 0);
        }
    }

    /**
     * Spawn team circle indicator particle below an entity using custom
     * ParticleTeam.
     *
     * @param entity the entity to show the team circle for
     * @param teamId the team ID (determines color)
     */
    public static void spawnTeamCircle(Entity entity, int teamId) {
        if (entity.level().isClientSide()) {
            spawnTeamCircleClient(entity, teamId);
        }
    }

    /**
     * Spawn team circle indicator particle at a world position.
     * Used for pointer block/waypoint target visualization.
     */
    public static void spawnTeamCircleAt(Level level, double x, double y, double z, int teamId) {
        if (level.isClientSide()) {
            spawnTeamCircleAtClient((ClientLevel) level, x, y, z, teamId);
        }
    }

    public static void spawnTeamCircleAtPlayer(net.minecraft.server.level.ServerPlayer player, double x, double y, double z, int teamId) {
        if (player == null || player.connection == null) return;
        io.netty.buffer.ByteBuf rawBuf = io.netty.buffer.Unpooled.buffer(48);
        net.minecraft.network.FriendlyByteBuf buf = new net.minecraft.network.FriendlyByteBuf(rawBuf);
        try {
            buf.writeDouble(x);
            buf.writeDouble(y);
            buf.writeDouble(z);
            buf.writeDouble(0.3); // scale (lookX)
            buf.writeDouble((double) teamId); // team indicator type (lookY)
            buf.writeDouble(0.0); // unused (lookZ)
            byte[] payload = new byte[48];
            buf.getBytes(0, payload);
            com.lulan.shincolle.network.ModNetworking.sendToPlayer(
                new com.lulan.shincolle.network.S2CSpawnParticlePacket((byte) 25, -1, payload),
                player
            );
        } finally {
            buf.release();
        }
    }

    // ========== Custom particle spawn methods ==========

    /**
     * Spawn a laser beam particle from source to target position.
     *
     * @param level the world/level (must be client-side)
     * @param x     source X
     * @param y     source Y
     * @param z     source Z
     * @param tarX  target X
     * @param tarY  target Y
     * @param tarZ  target Z
     * @param scale beam scale
     * @param type  beam visual type
     */
    public static void spawnLaserParticle(Level level, double x, double y, double z,
            double tarX, double tarY, double tarZ, float scale, int type) {
        if (level.isClientSide()) {
            spawnLaserParticleClient((ClientLevel) level, x, y, z, tarX, tarY, tarZ, scale, type);
        }
    }

    /**
     * Spawn a lightning particle attached to an entity.
     *
     * @param entity the entity to electrify
     * @param scale  effect scale
     * @param type   lightning visual type
     */
    public static void spawnLightningParticle(Entity entity, float scale, int type) {
        if (entity.level().isClientSide()) {
            spawnLightningParticleClient(entity, scale, type);
        }
    }

    /**
     * Spawn a chi/energy particle attached to an entity.
     *
     * @param entity the host entity
     * @param scale  effect scale
     * @param type   chi visual type
     */
    public static void spawnChiParticle(Entity entity, float scale, int type) {
        if (entity.level().isClientSide()) {
            spawnChiParticleClient(entity, scale, type);
        }
    }

    /**
     * Spawn a cube particle effect on a living entity.
     *
     * @param entity the living entity
     * @param scale  effect scale
     * @param type   cube visual type
     */
    public static void spawnCubeParticle(LivingEntity entity, float scale, int type) {
        if (entity.level().isClientSide()) {
            spawnCubeParticleClient(entity, scale, type);
        }
    }

    /**
     * Spawn a gradient ring particle on an entity.
     *
     * @param entity the entity
     * @param type   gradient visual type
     * @param parms  additional parameters
     */
    public static void spawnGradientParticle(Entity entity, int type, float... parms) {
        if (entity.level().isClientSide()) {
            spawnGradientParticleClient(entity, type, parms);
        }
    }

    /**
     * Spawn a sphere light particle on an entity.
     *
     * @param entity the entity
     * @param type   light visual type
     * @param parms  additional parameters
     */
    public static void spawnSphereLightParticle(Entity entity, int type, float... parms) {
        if (entity.level().isClientSide()) {
            spawnSphereLightParticleClient(entity, type, parms);
        }
    }

    /**
     * Spawn sticky lightning particles attached to an entity.
     * Ported for legacy projectile beam effects.
     */
    public static void spawnStickyLightningParticle(Entity entity, float scale, int life, int type) {
        if (entity.level().isClientSide()) {
            spawnStickyLightningParticleClient(entity, scale, life, type);
        }
    }

    /**
     * Spawn a sparkle particle on an entity.
     *
     * @param entity the entity
     * @param type   sparkle visual type
     * @param parms  additional parameters
     */
    public static void spawnSparkleParticle(Entity entity, int type, float... parms) {
        if (entity.level().isClientSide()) {
            spawnSparkleParticleClient(entity, type, parms);
        }
    }

    /**
     * Spawn a line/trail particle.
     *
     * @param level the world/level
     * @param type  line visual type
     * @param parms line parameters (positions, etc.)
     */
    public static void spawnLineParticle(Level level, int type, float[] parms) {
        if (level.isClientSide()) {
            spawnLineParticleClient((ClientLevel) level, type, parms);
        }
    }

    /**
     * Spawn a sweep arc particle on an entity.
     *
     * @param entity the entity
     * @param type   sweep visual type
     * @param parms  sweep parameters
     */
    public static void spawnSweepParticle(Entity entity, int type, float... parms) {
        if (entity.level().isClientSide()) {
            spawnSweepParticleClient(entity, type, parms);
        }
    }

    /**
     * Spawn a crane construction particle.
     *
     * @param level     the world/level
     * @param x         X position
     * @param y         Y position
     * @param z         Z position
     * @param lengthMax maximum length
     * @param par1      parameter 1
     * @param scale     effect scale
     * @param type      visual type
     */
    public static void spawnCraningParticle(Level level, double x, double y, double z,
            double lengthMax, double par1, double scale, int type) {
        if (level.isClientSide()) {
            spawnCraningParticleClient((ClientLevel) level, x, y, z, lengthMax, par1, scale, type);
        }
    }

    // ========== Client-side implementation methods ==========
    // These methods use @OnlyIn(Dist.CLIENT) and directly instantiate
    // custom particle classes, adding them to the particle engine.

    @OnlyIn(Dist.CLIENT)
    private static void spawnTextParticleClient(ClientLevel level, double x, double y, double z,
            float scale, int type) {
        Minecraft.getInstance().particleEngine.add(
                new ParticleTexts(level, x, y, z, scale, type));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnEmotionParticleClient(Entity entity, int emotionType) {
        ClientLevel level = (ClientLevel) entity.level();
        Minecraft.getInstance().particleEngine.add(
                new ParticleEmotion(level, entity,
                        entity.getX(), entity.getY() + entity.getBbHeight(),
                        entity.getZ(), entity.getBbHeight(), 0, emotionType));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnSprayParticleClient(Level level, double x, double y, double z, int count) {
        ClientLevel clientLevel = (ClientLevel) level;
        for (int i = 0; i < count; i++) {
            double offsetX = (level.random.nextDouble() - 0.5) * 0.5;
            double offsetZ = (level.random.nextDouble() - 0.5) * 0.5;
            double speedY = level.random.nextDouble() * 0.2 + 0.1;
            Minecraft.getInstance().particleEngine.add(
                    new ParticleSpray(clientLevel, x + offsetX, y, z + offsetZ, 0, speedY, 0, 0));
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnSprayParticleVariantClient(ClientLevel level, double x, double y, double z,
            double motionX, double motionY, double motionZ, int sprayType) {
        Minecraft.getInstance().particleEngine.add(
                new ParticleSpray(level, x, y, z, motionX, motionY, motionZ, sprayType));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnTeamCircleClient(Entity entity, int teamId) {
        ClientLevel level = (ClientLevel) entity.level();
        Minecraft.getInstance().particleEngine.add(
                new ParticleTeam(level, entity, TEAM_CIRCLE_ENTITY_SCALE, teamId));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnTeamCircleAtClient(ClientLevel level, double x, double y, double z, int teamId) {
        Minecraft.getInstance().particleEngine.add(
                new ParticleTeam(level, TEAM_CIRCLE_ENTITY_SCALE, teamId, x, y, z));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnLaserParticleClient(ClientLevel level, double x, double y, double z,
            double tarX, double tarY, double tarZ, float scale, int type) {
        Minecraft.getInstance().particleEngine.add(
                new ParticleLaser(level, x, y, z, tarX, tarY, tarZ, scale, type));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnLightningParticleClient(Entity entity, float scale, int type) {
        ClientLevel level = (ClientLevel) entity.level();
        Minecraft.getInstance().particleEngine.add(
                new ParticleLightning(level, entity, scale, type));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnChiParticleClient(Entity entity, float scale, int type) {
        ClientLevel level = (ClientLevel) entity.level();
        Minecraft.getInstance().particleEngine.add(
                new ParticleChi(level, entity, scale, type));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnCubeParticleClient(LivingEntity entity, float scale, int type) {
        ClientLevel level = (ClientLevel) entity.level();
        Minecraft.getInstance().particleEngine.add(
                new ParticleCube(level, entity,
                        entity.getX(), entity.getY(), entity.getZ(), scale, type));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnGradientParticleClient(Entity entity, int type, float... parms) {
        ClientLevel level = (ClientLevel) entity.level();
        Minecraft.getInstance().particleEngine.add(
                new ParticleGradient(level, entity, type, parms));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnSphereLightParticleClient(Entity entity, int type, float... parms) {
        Minecraft.getInstance().particleEngine.add(
                new ParticleSphereLight(entity, type, parms));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnStickyLightningParticleClient(Entity entity, float scale, int life, int type) {
        ClientLevel level = (ClientLevel) entity.level();
        // 2026/04/07：GitHub Copilotによって確認済み
        // Keep legacy visual density: railgun beam emitted 4 sticky-lightning strips
        // per tick.
        for (int i = 0; i < 4; i++) {
            Minecraft.getInstance().particleEngine.add(
                    new ParticleStickyLightning(level, entity, scale, life, type));
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnSparkleParticleClient(Entity entity, int type, float... parms) {
        Minecraft.getInstance().particleEngine.add(
                new ParticleSparkle(entity, type, parms));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnLineParticleClient(ClientLevel level, int type, float[] parms) {
        Minecraft.getInstance().particleEngine.add(
                new ParticleLine(level, type, parms));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnSweepParticleClient(Entity entity, int type, float... parms) {
        ClientLevel level = (ClientLevel) entity.level();
        Minecraft.getInstance().particleEngine.add(
                new ParticleSweep(level, entity, type, parms));
    }

    @OnlyIn(Dist.CLIENT)
    private static void spawnCraningParticleClient(ClientLevel level, double x, double y, double z,
            double lengthMax, double par1, double scale, int type) {
        Minecraft.getInstance().particleEngine.add(
                new ParticleCraning(level, x, y, z, lengthMax, par1, scale, type));
    }

    /**
     * Spawn attack text particle (miss/crit/dhit/thit indicator).
     * Called from server side (CombatHelper). Sends a particle packet to nearby
     * clients.
     * type: 0=miss, 1=critical, 2=double hit, 3=triple hit
     */
    public static void spawnAttackTextParticle(Entity entity, int type) {
        if (entity == null || entity.level().isClientSide())
            return;
        // type offset: CombatHelper uses 0-3, spawnAttackParticleAt uses 10-13
        int particleType = 10 + type;
        S2CSpawnParticlePacket packet = new S2CSpawnParticlePacket(
                (byte) particleType, entity.getId(), null);
        ModNetworking.sendToAllTracking(packet, entity);
    }
}
