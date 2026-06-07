package com.lulan.shincolle.entity.battleship;

import com.lulan.shincolle.ai.ShipPickItemGoal;
import com.lulan.shincolle.ai.ShipRangeAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Battleship Ru-class entity (full-size base).
 * model state: 0:weapon, 1:armor, 2:glove, 3:eye effect
 */
public class EntityBattleshipRu extends BasicEntityShip {

    public EntityBattleshipRu(EntityType<? extends EntityBattleshipRu> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.BATTLESHIP);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.BBRU);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.BATTLESHIP);
        this.setStateMinor(ID.M.NumState, 4);
        this.setGrudgeConsumption(1);
        this.setAmmoConsumption(1);
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
    public void calcShipAttributesAddRaw() {
        // bonus stats: +0.05 CRI, +0.05 DHIT, +0.05 THIT
        if (this.shipAttrs != null) {
            this.shipAttrs.setAttrsRaw(ID.Attrs.CRI, this.shipAttrs.getAttrsRaw(ID.Attrs.CRI) + 0.05F);
            this.shipAttrs.setAttrsRaw(ID.Attrs.DHIT, this.shipAttrs.getAttrsRaw(ID.Attrs.DHIT) + 0.05F);
            this.shipAttrs.setAttrsRaw(ID.Attrs.THIT, this.shipAttrs.getAttrsRaw(ID.Attrs.THIT) + 0.05F);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            if (this.tickCount % 128 == 0) {
                // marriage ring aura: luck self-buff during daytime
                if (getStateFlag(ID.F.IsMarried) && getStateFlag(ID.F.UseRingEffect) &&
                        getStateMinor(ID.M.NumGrudge) > 0 && this.level().isDay()) {
                    int shipLevel = getStateMinor(ID.M.ShipLevel);
                    int amp = shipLevel / 80;
                    int dur = 50 + shipLevel;
                    this.addEffect(new MobEffectInstance(MobEffects.LUCK, dur, amp, false, false));
                }
            }
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        if (this.isOrderedToSit()) {
            return this.getBbHeight() * 0.45D;
        } else {
            return this.getBbHeight() * 0.72D;
        }
    }
}
