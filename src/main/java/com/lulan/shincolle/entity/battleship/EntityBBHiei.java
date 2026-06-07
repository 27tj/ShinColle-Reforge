package com.lulan.shincolle.entity.battleship;

import com.lulan.shincolle.ai.ShipPickItemGoal;
import com.lulan.shincolle.ai.ShipRangeAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipSmall;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.reference.ID;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.UUID;

/**
 * Battleship Hiei entity.
 * model state: 0:equip, 1:head
 */
public class EntityBBHiei extends BasicEntityShipSmall {

    public EntityBBHiei(EntityType<? extends EntityBBHiei> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.BATTLESHIP);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.BBHiei);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.BATTLESHIP);
        this.setStateMinor(ID.M.NumState, 2);
        this.setGrudgeConsumption(ConfigHandler.consumeGrudgeShip[ID.ShipConsume.BB]);
        this.setAmmoConsumption(ConfigHandler.consumeAmmoShip[ID.ShipConsume.BB]);
        this.ModelPos = new float[]{0F, 25F, 0F, 40F};

        // set attack type
        this.StateFlag[ID.F.AtkType_AirLight] = false;
        this.StateFlag[ID.F.AtkType_AirHeavy] = false;
        this.StateFlag[ID.F.CanPickItem] = true;

        this.postInit();
    }

    /**
     * Equip type: 1=cannon+misc
     */
    @Override
    public int getEquipType() {
        return 1;
    }

    @Override
    public void setAIList() {
        super.setAIList();

        // range attack
        this.goalSelector.addGoal(11, new ShipRangeAttackGoal(this));

        // pick item
        this.goalSelector.addGoal(20, new ShipPickItemGoal(this, 4.0F));
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            if (this.tickCount % 128 == 0) {
                // marriage ring aura: saturation to nearby same-owner ships
                UUID ownerUUID = this.getOwnerUUID();
                if (ownerUUID != null && getStateFlag(ID.F.IsMarried) && getStateFlag(ID.F.UseRingEffect) &&
                        getStateMinor(ID.M.NumGrudge) > 0) {
                    int shipLevel = getStateMinor(ID.M.ShipLevel);
                    int amp = shipLevel / 80;
                    int dur = 50 + shipLevel;

                    List<BasicEntityShip> nearby = this.level().getEntitiesOfClass(
                            BasicEntityShip.class, this.getBoundingBox().inflate(16D, 16D, 16D));
                    for (BasicEntityShip s : nearby) {
                        UUID sOwner = s.getOwnerUUID();
                        if (sOwner != null && sOwner.equals(ownerUUID) && this.distanceToSqr(s) < 256.0D) {
                            s.addEffect(new MobEffectInstance(MobEffects.SATURATION, dur, amp, false, false));
                        }
                    }
                }
            }
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        if (this.isOrderedToSit()) {
            if (getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                return 0D;
            } else {
                return this.getBbHeight() * 0.35D;
            }
        } else {
            return this.getBbHeight() * 0.75D;
        }
    }
}
