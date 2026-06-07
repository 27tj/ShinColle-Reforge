package com.lulan.shincolle.entity.battleship;

import com.lulan.shincolle.ai.ShipPickItemGoal;
import com.lulan.shincolle.ai.ShipRangeAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipSummonAttack;
import com.lulan.shincolle.reference.ID;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.UUID;

/**
 * Battleship Ta-class entity (full-size base, summon attack).
 * model state: 0:rensouhou type, 1:cape, 2:armor
 */
public class EntityBattleshipTa extends BasicEntityShip implements IShipSummonAttack {

    public int numRensouhou;

    public EntityBattleshipTa(EntityType<? extends EntityBattleshipTa> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.BATTLESHIP);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.BBTA);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.BATTLESHIP);
        this.setStateMinor(ID.M.NumState, 3);
        this.setGrudgeConsumption(1);
        this.setAmmoConsumption(1);
        this.ModelPos = new float[]{0F, 25F, 0F, 40F};
        this.numRensouhou = 0;

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
    public int getNumServant() {
        return this.numRensouhou;
    }

    @Override
    public void setNumServant(int num) {
        this.numRensouhou = num;
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
        // bonus stats: +0.1 CRI, +0.1 MISS
        if (this.shipAttrs != null) {
            this.shipAttrs.setAttrsRaw(ID.Attrs.CRI, this.shipAttrs.getAttrsRaw(ID.Attrs.CRI) + 0.1F);
            this.shipAttrs.setAttrsRaw(ID.Attrs.MISS, this.shipAttrs.getAttrsRaw(ID.Attrs.MISS) + 0.1F);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            if (this.tickCount % 128 == 0) {
                // regenerate rensouhou
                if (this.numRensouhou < 6) {
                    this.numRensouhou++;
                }

                // marriage ring aura: movement speed to nearby same-owner ships
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
                            s.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, dur, amp, false, false));
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
                return this.getBbHeight() * 0.47D;
            }
        } else {
            return this.getBbHeight() * 0.76D;
        }
    }
}
