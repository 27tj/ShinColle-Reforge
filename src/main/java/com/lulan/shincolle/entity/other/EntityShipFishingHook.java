package com.lulan.shincolle.entity.other;

import com.lulan.shincolle.handler.ConfigHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

import java.util.List;

/**
 * Ship fishing hook entity (for ship fishing mechanic).
 * Implements basic fishing behavior: launched into water, waits for a catch,
 * then returns with loot to the hosting ship.
 * <p>
 * States:
 * 0: flying (just thrown)
 * 1: in water, waiting for fish
 * 2: fish hooked, bobbing
 * 3: retracting (returning to host)
 */
public class EntityShipFishingHook extends Entity {

    private LivingEntity host;

    /**
     * Current fishing state
     */
    private int fishState = 0;

    /**
     * Timer for waiting for a catch
     */
    private int waitTimer = 0;

    /**
     * Max wait time before a fish bites (config-based)
     */
    private int maxWaitTime = 400;

    /**
     * Timer for bobbing animation when fish is hooked
     */
    private int hookTimer = 0;

    /**
     * Whether the hook is in water
     */
    private boolean inWater = false;

    public EntityShipFishingHook(EntityType<? extends EntityShipFishingHook> type, Level level) {
        super(type, level);
        this.noCulling = true;
    }

    /**
     * Initialize the fishing hook with a host and launch direction.
     *
     * @param host the ship entity casting the line
     * @param velX launch velocity X
     * @param velY launch velocity Y
     * @param velZ launch velocity Z
     */
    public void initHook(LivingEntity host, double velX, double velY, double velZ) {
        this.host = host;
        this.setPos(host.getX(), host.getEyeY(), host.getZ());
        this.setDeltaMovement(velX, velY, velZ);
        this.fishState = 0;

        // set wait time from config: base + random
        this.maxWaitTime = ConfigHandler.tickFishing[0]
                + this.random.nextInt(Math.max(1, ConfigHandler.tickFishing[1]));
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.fixed(0.25F, 0.25F);
    }

    @Override
    protected void defineSynchedData() {
        // empty
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        // fishing hook is transient - don't persist
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        // fishing hook is transient - don't persist
    }

    @Override
    public void tick() {
        super.tick();

        // discard if host is gone
        if (this.host == null || !this.host.isAlive()) {
            this.discard();
            return;
        }

        // discard if too far from host (64 blocks)
        if (this.distanceToSqr(this.host) > 4096D) {
            this.discard();
            return;
        }

        // max lifetime 2400 ticks (2 minutes)
        if (this.tickCount > 2400) {
            this.discard();
            return;
        }

        // check water status
        BlockPos blockPos = BlockPos.containing(this.getX(), this.getY(), this.getZ());
        FluidState fluidState = this.level().getFluidState(blockPos);
        this.inWater = fluidState.is(Fluids.WATER) || fluidState.is(Fluids.FLOWING_WATER);

        switch (this.fishState) {
            case 0: // flying - apply gravity until hitting water or ground
                handleFlying();
                break;
            case 1: // in water, waiting for bite
                handleWaiting();
                break;
            case 2: // fish hooked, bobbing
                handleHooked();
                break;
            case 3: // retracting back to host
                handleRetracting();
                break;
        }
    }

    /**
     * State 0: Flying through air with gravity
     */
    private void handleFlying() {
        Vec3 motion = this.getDeltaMovement();

        // apply gravity
        this.setDeltaMovement(motion.x * 0.98, motion.y - 0.04, motion.z * 0.98);
        this.move(MoverType.SELF, this.getDeltaMovement());

        // hit water -> transition to waiting
        if (this.inWater) {
            this.setDeltaMovement(0, -0.05, 0);
            this.fishState = 1;
            this.waitTimer = 0;
        }

        // hit ground -> discard after a few ticks
        if (this.onGround() && this.tickCount > 5) {
            this.discard();
        }
    }

    /**
     * State 1: In water, waiting for a fish to bite
     */
    private void handleWaiting() {
        // slight bobbing motion in water
        double bobMotion = Math.sin(this.tickCount * 0.1) * 0.01;
        this.setDeltaMovement(0, bobMotion, 0);
        this.move(MoverType.SELF, this.getDeltaMovement());

        // if displaced from water, discard
        if (!this.inWater) {
            this.fishState = 0;
            return;
        }

        this.waitTimer++;

        // fish bites
        if (this.waitTimer >= this.maxWaitTime) {
            this.fishState = 2;
            this.hookTimer = 0;

            // splash particles to indicate a bite
            if (this.level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(
                        net.minecraft.core.particles.ParticleTypes.SPLASH,
                        this.getX(), this.getY(), this.getZ(),
                        8, 0.3D, 0.1D, 0.3D, 0.1D);
            }
        }
    }

    /**
     * State 2: Fish hooked, bobbing animation, auto-retract after delay
     */
    private void handleHooked() {
        // stronger bobbing to indicate catch
        double bobMotion = Math.sin(this.tickCount * 0.3) * 0.03;
        this.setDeltaMovement(0, bobMotion, 0);
        this.move(MoverType.SELF, this.getDeltaMovement());

        this.hookTimer++;

        // auto-retract after 40 ticks (2 seconds)
        if (this.hookTimer >= 40) {
            this.fishState = 3;

            // generate loot and drop it
            if (!this.level().isClientSide()) {
                spawnFishingLoot();
            }
        }
    }

    /**
     * State 3: Retracting back toward host
     */
    private void handleRetracting() {
        double dx = this.host.getX() - this.getX();
        double dy = (this.host.getY() + this.host.getBbHeight() * 0.5) - this.getY();
        double dz = this.host.getZ() - this.getZ();
        double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);

        if (dist < 1.5) {
            // reached host, discard
            this.discard();
            return;
        }

        // move toward host
        double speed = 0.3;
        this.setDeltaMovement(dx / dist * speed, dy / dist * speed, dz / dist * speed);
        this.move(MoverType.SELF, this.getDeltaMovement());
    }

    /**
     * Spawn fishing loot near the hook position using the vanilla fishing loot table.
     */
    private void spawnFishingLoot() {
        if (!(this.level() instanceof ServerLevel serverLevel)) return;

        try {
            LootTable lootTable = serverLevel.getServer().getLootData()
                    .getLootTable(BuiltInLootTables.FISHING);

            LootParams.Builder builder = new LootParams.Builder(serverLevel)
                    .withParameter(LootContextParams.ORIGIN, this.position())
                    .withParameter(LootContextParams.THIS_ENTITY, this)
                    .withParameter(LootContextParams.TOOL, new ItemStack(Items.FISHING_ROD));

            List<ItemStack> loot = lootTable.getRandomItems(builder.create(LootContextParamSets.FISHING));

            for (ItemStack stack : loot) {
                ItemEntity itemEntity = new ItemEntity(
                        this.level(), this.getX(), this.getY(), this.getZ(), stack);
                // toss toward host
                double dx = this.host.getX() - this.getX();
                double dy = this.host.getY() - this.getY() + 0.5;
                double dz = this.host.getZ() - this.getZ();
                double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
                if (dist > 0.01) {
                    itemEntity.setDeltaMovement(dx / dist * 0.2, dy / dist * 0.2 + 0.2, dz / dist * 0.2);
                }
                this.level().addFreshEntity(itemEntity);
            }
        } catch (Exception e) {
            // fallback: drop a raw cod if loot table fails
            ItemEntity itemEntity = new ItemEntity(
                    this.level(), this.getX(), this.getY(), this.getZ(),
                    new ItemStack(Items.COD));
            this.level().addFreshEntity(itemEntity);
        }
    }

    /**
     * Manually retract the hook (called by ship when pulling the line).
     */
    public void retract() {
        if (this.fishState == 2) {
            // fish is hooked, generate loot
            if (!this.level().isClientSide()) {
                spawnFishingLoot();
            }
        }
        this.fishState = 3;
    }

    public int getFishState() {
        return this.fishState;
    }

    public boolean isInWater() {
        return this.inWater;
    }

    public LivingEntity getHost() {
        return this.host;
    }

    public void setHost(LivingEntity host) {
        this.host = host;
    }
}
