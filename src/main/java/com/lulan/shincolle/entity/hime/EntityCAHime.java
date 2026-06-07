package com.lulan.shincolle.entity.hime;

import com.lulan.shincolle.ai.ShipRangeAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShipSmall;
import com.lulan.shincolle.entity.IShipRiderType;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * CA (Heavy Cruiser) Hime entity - cruiser type with night combat bonuses.
 * Provides MOVEMENT_SPEED and JUMP to nearby player at night.
 * Gains CRI and THIT bonuses at night.
 */
public class EntityCAHime extends BasicEntityShipSmall implements IShipRiderType {

    private int riderType;

    public EntityCAHime(EntityType<? extends EntityCAHime> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.HIME);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.CAHime);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.CRUISER);
        this.setStateMinor(ID.M.NumState, 5);
        this.setGrudgeConsumption(1);
        this.setAmmoConsumption(1);
        this.ModelPos = new float[]{0F, 10F, 0F, 45F};

        // cannon only
        this.StateFlag[ID.F.AtkType_AirLight] = false;
        this.StateFlag[ID.F.AtkType_AirHeavy] = false;

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
    public void setAIList() {
        super.setAIList();
        this.goalSelector.addGoal(11, new ShipRangeAttackGoal(this));
    }

    @Override
    public void calcShipAttributesAddRaw() {
        super.calcShipAttributesAddRaw();

        // Night bonus: +0.1 CRI and +0.2 THIT
        if (!this.level().isDay()) {
            this.shipAttrs.setAttrsBuffed(ID.Attrs.CRI,
                    this.shipAttrs.getAttrsBuffed(ID.Attrs.CRI) + 0.1F);
            this.shipAttrs.setAttrsBuffed(ID.Attrs.THIT,
                    this.shipAttrs.getAttrsBuffed(ID.Attrs.THIT) + 0.2F);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            if (this.tickCount % 128 == 0) {
                // Ring effect: MOVEMENT_SPEED + JUMP at night to nearby player
                if (this.level().isNight()) {
                    java.util.UUID ownerUUID = this.getOwnerUUID();
                    Player player = ownerUUID != null ? this.level().getPlayerByUUID(ownerUUID) : null;
                    if (player != null && getStateFlag(ID.F.IsMarried) && getStateFlag(ID.F.UseRingEffect) &&
                            getStateMinor(ID.M.NumGrudge) > 0 &&
                            this.distanceToSqr(player) < 256.0D) {
                        int level = getStateMinor(ID.M.ShipLevel) / 35 + 1;
                        int duration = 80 + getStateMinor(ID.M.ShipLevel);
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, duration, level, false, false));
                        player.addEffect(new MobEffectInstance(MobEffects.JUMP, duration, level, false, false));
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
