package com.lulan.shincolle.entity.hime;

import com.lulan.shincolle.ai.ShipCarrierAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShipCV;
import com.lulan.shincolle.entity.IShipRiderType;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Carrier Hime entity - pure aircraft carrier type.
 * Provides JUMP boost to nearby allied ships.
 */
public class EntityCarrierHime extends BasicEntityShipCV implements IShipRiderType {

    private int riderType;

    public EntityCarrierHime(EntityType<? extends EntityCarrierHime> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.HIME);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.CVHime);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.CARRIER);
        this.setStateMinor(ID.M.NumState, 3);
        this.setGrudgeConsumption(1);
        this.setAmmoConsumption(1);
        this.ModelPos = new float[]{0F, 25F, 0F, 45F};

        // aircraft only: disable cannon attacks
        this.StateFlag[ID.F.AtkType_Light] = false;
        this.StateFlag[ID.F.AtkType_Heavy] = false;
        this.StateFlag[ID.F.AtkType_AirLight] = true;
        this.StateFlag[ID.F.AtkType_AirHeavy] = true;

        // initialize aircraft counts
        this.setNumAircraftLight(6);
        this.setNumAircraftHeavy(3);

        this.postInit();
    }

    public int getEquipType() {
        return 3;
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
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            if (this.tickCount % 128 == 0) {
                // Ring effect: JUMP to nearby ships
                if (getStateFlag(ID.F.IsMarried) && getStateFlag(ID.F.UseRingEffect) &&
                        getStateMinor(ID.M.NumGrudge) > 0) {
                    java.util.UUID ownerUUID = this.getOwnerUUID();
                    java.util.List<net.minecraft.world.entity.LivingEntity> nearby = this.level().getEntitiesOfClass(
                            net.minecraft.world.entity.LivingEntity.class,
                            this.getBoundingBox().inflate(12D),
                            e -> e != this && e instanceof com.lulan.shincolle.entity.BasicEntityShip ship
                                    && ownerUUID != null && ownerUUID.equals(ship.getOwnerUUID()));
                    int maxTargets = getStateMinor(ID.M.ShipLevel) / 50 + 1;
                    int level = getStateMinor(ID.M.ShipLevel) / 35 + 1;
                    int duration = 80 + getStateMinor(ID.M.ShipLevel);
                    int count = 0;
                    for (net.minecraft.world.entity.LivingEntity target : nearby) {
                        if (count >= maxTargets)
                            break;
                        target.addEffect(new MobEffectInstance(MobEffects.JUMP, duration, level, false, false));
                        count++;
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
