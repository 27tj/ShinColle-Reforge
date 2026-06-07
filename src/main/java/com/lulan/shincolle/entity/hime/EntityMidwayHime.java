package com.lulan.shincolle.entity.hime;

import com.lulan.shincolle.ai.ShipCarrierAttackGoal;
import com.lulan.shincolle.ai.ShipRangeAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShipCV;
import com.lulan.shincolle.entity.IShipRiderType;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * Midway Hime entity - powerful CV type with highest self-healing.
 * Provides ABSORPTION to both nearby allied ships and owner player.
 */
public class EntityMidwayHime extends BasicEntityShipCV implements IShipRiderType {

    private int riderType;

    public EntityMidwayHime(EntityType<? extends EntityMidwayHime> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.HIME);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.MidwayHime);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.AVIATION);
        this.setStateMinor(ID.M.NumState, 2);
        this.setGrudgeConsumption(1);
        this.setAmmoConsumption(1);
        this.ModelPos = new float[]{0F, 25F, 0F, 45F};

        // hybrid attacker: cannon + aircraft
        this.StateFlag[ID.F.AtkType_Light] = true;
        this.StateFlag[ID.F.AtkType_Heavy] = true;
        this.StateFlag[ID.F.AtkType_AirLight] = true;
        this.StateFlag[ID.F.AtkType_AirHeavy] = true;

        // initialize aircraft counts
        this.setNumAircraftLight(6);
        this.setNumAircraftHeavy(3);

        this.postInit();
    }

    public int getEquipType() {
        return 2;
    }

    @Override
    public int getRiderType() {
        return this.riderType;
    }

    @Override
    public void setRiderType(int type) {
        this.riderType = type;
    }

    @Override
    public void setAIList() {
        super.setAIList();
        this.goalSelector.addGoal(11, new ShipCarrierAttackGoal(this));
        this.goalSelector.addGoal(12, new ShipRangeAttackGoal(this));
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            if (this.tickCount % 128 == 0) {
                // Self-heal: 9% max HP (highest self-heal)
                if (this.getHealth() < this.getMaxHealth()) {
                    this.heal(this.getMaxHealth() * 0.09F);
                }

                // Ring effect: ABSORPTION to nearby ships AND player
                if (getStateFlag(ID.F.IsMarried) && getStateFlag(ID.F.UseRingEffect) &&
                        getStateMinor(ID.M.NumGrudge) > 0) {
                    int level = getStateMinor(ID.M.ShipLevel) / 35 + 1;
                    int duration = 80 + getStateMinor(ID.M.ShipLevel);

                    // Buff nearby ships
                    java.util.UUID ownerUUID = this.getOwnerUUID();
                    java.util.List<net.minecraft.world.entity.LivingEntity> nearby = this.level().getEntitiesOfClass(
                            net.minecraft.world.entity.LivingEntity.class,
                            this.getBoundingBox().inflate(12D),
                            e -> e != this && e instanceof com.lulan.shincolle.entity.BasicEntityShip ship
                                    && ownerUUID != null && ownerUUID.equals(ship.getOwnerUUID()));
                    int maxTargets = getStateMinor(ID.M.ShipLevel) / 50 + 1;
                    int count = 0;
                    for (net.minecraft.world.entity.LivingEntity target : nearby) {
                        if (count >= maxTargets)
                            break;
                        target.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, duration, level, false, false));
                        count++;
                    }

                    // Buff owner player
                    Player player = ownerUUID != null ? this.level().getPlayerByUUID(ownerUUID) : null;
                    if (player != null && this.distanceToSqr(player) < 256.0D) {
                        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, duration, level, false, false));
                    }
                }
            }
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        if (this.isOrderedToSit()) {
            return this.getBbHeight() * 0.16F;
        } else {
            return this.getBbHeight() * 0.67F;
        }
    }
}
