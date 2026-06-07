package com.lulan.shincolle.entity.cruiser;

import com.lulan.shincolle.ai.ShipPickItemGoal;
import com.lulan.shincolle.ai.ShipRangeAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShipSmall;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Heavy Cruiser Ne-class entity.
 * model state: none
 */
public class EntityCANe extends BasicEntityShipSmall {

    public EntityCANe(EntityType<? extends EntityCANe> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.HEAVY_CRUISER);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.CANE);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.CRUISER);
        this.setStateMinor(ID.M.NumState, 0);
        this.setGrudgeConsumption(1);
        this.setAmmoConsumption(1);
        this.ModelPos = new float[]{0F, 10F, 0F, 40F};

        // set attack type
        this.StateFlag[ID.F.AtkType_AirLight] = false;
        this.StateFlag[ID.F.AtkType_AirHeavy] = false;
        this.StateFlag[ID.F.CanPickItem] = true;

        this.postInit();
    }

    /**
     * Equip type: 1=cannon+misc, 2=cannon+airplane+misc, 3=airplane+misc
     */
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
                // ring effect: speed + jump on self at night
                if (getStateFlag(ID.F.IsMarried) && getStateFlag(ID.F.UseRingEffect) &&
                        getStateMinor(ID.M.NumGrudge) > 0 &&
                        !this.level().isDay()) {
                    int level = getStateMinor(ID.M.ShipLevel);
                    this.addEffect(new MobEffectInstance(
                            MobEffects.MOVEMENT_SPEED,
                            200, level / 70, false, false));
                    this.addEffect(new MobEffectInstance(
                            MobEffects.JUMP,
                            200, level / 60, false, false));
                }
            }
        }
    }

    // night bonus: +0.3 CRI
    @Override
    public void calcShipAttributesAddRaw() {
        super.calcShipAttributesAddRaw();

        if (!this.level().isDay()) {
            this.shipAttrs.setAttrsBuffed(ID.Attrs.CRI,
                    this.shipAttrs.getAttrsBuffed(ID.Attrs.CRI) + 0.3F);
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        if (this.isOrderedToSit()) {
            return 0;
        } else {
            return this.getBbHeight() * 0.24F;
        }
    }
}
