package com.lulan.shincolle.entity.hime;

import com.lulan.shincolle.ai.ShipPickItemGoal;
import com.lulan.shincolle.ai.ShipRangeAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShipSmall;
import com.lulan.shincolle.entity.IShipInvisible;
import com.lulan.shincolle.entity.IShipRiderType;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * Submarine New Hime (SSNH) entity - stealthy submarine type with invisibility.
 * Provides INVISIBILITY to owner player and maintains self-invisible state.
 */
public class EntitySSNH extends BasicEntityShipSmall implements IShipRiderType, IShipInvisible {

    private int riderType;
    private float invisibleLevel = 0.35F;

    public EntitySSNH(EntityType<? extends EntitySSNH> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.HIME);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.SSNH);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.SUBMARINE);
        this.setStateMinor(ID.M.NumState, 3);
        this.setGrudgeConsumption(1);
        this.setAmmoConsumption(1);
        this.ModelPos = new float[]{0F, 10F, 0F, 45F};

        // cannon only
        this.StateFlag[ID.F.AtkType_AirLight] = false;
        this.StateFlag[ID.F.AtkType_AirHeavy] = false;
        this.StateFlag[ID.F.CanPickItem] = true;

        this.postInit();
    }

    public int getEquipType() {
        return 1;
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
    public float getInvisibleLevel() {
        return this.invisibleLevel;
    }

    @Override
    public void setInvisibleLevel(float level) {
        this.invisibleLevel = level;
    }

    @Override
    public void setAIList() {
        super.setAIList();
        this.goalSelector.addGoal(11, new ShipRangeAttackGoal(this));
        this.goalSelector.addGoal(20, new ShipPickItemGoal(this, 4.0F));
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            if (this.tickCount % 128 == 0) {
                // Ring effect: INVISIBILITY to owner + self-invisible
                java.util.UUID ownerUUID = this.getOwnerUUID();
                Player player = ownerUUID != null ? this.level().getPlayerByUUID(ownerUUID) : null;
                if (player != null && getStateFlag(ID.F.IsMarried) && getStateFlag(ID.F.UseRingEffect) &&
                        getStateMinor(ID.M.NumGrudge) > 0 &&
                        this.distanceToSqr(player) < 256.0D) {
                    int level = getStateMinor(ID.M.ShipLevel) / 35 + 1;
                    int duration = 80 + getStateMinor(ID.M.ShipLevel);
                    player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, duration, level, false, false));
                    this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, duration, level, false, false));
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
