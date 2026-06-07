package com.lulan.shincolle.entity.destroyer;

import com.lulan.shincolle.ai.ShipPickItemGoal;
import com.lulan.shincolle.ai.ShipRangeAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShipSmall;
import com.lulan.shincolle.entity.IShipRiderType;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * Destroyer Akatsuki entity.
 * model state: 0:cannon, 1:head, 2:weapon, 3:armor
 */
public class EntityDestroyerAkatsuki extends BasicEntityShipSmall implements IShipRiderType {

    private int riderType;

    public EntityDestroyerAkatsuki(EntityType<? extends EntityDestroyerAkatsuki> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.DESTROYER);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.DDAkatsuki);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.DESTROYER);
        this.setStateMinor(ID.M.NumState, 4);
        this.setGrudgeConsumption(ConfigHandler.consumeGrudgeShip[ID.ShipConsume.DD]);
        this.setAmmoConsumption(ConfigHandler.consumeAmmoShip[ID.ShipConsume.DD]);
        this.ModelPos = new float[]{0F, 25F, 0F, 45F};

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
                // marriage aura: speed boost to owner
                java.util.UUID ownerUUID = this.getOwnerUUID();
                Player player = ownerUUID != null ? this.level().getPlayerByUUID(ownerUUID) : null;
                if (player != null && getStateFlag(ID.F.IsMarried) && getStateFlag(ID.F.UseRingEffect) &&
                        getStateMinor(ID.M.NumGrudge) > 0 &&
                        this.distanceToSqr(player) < 256.0D) {
                    int level = getStateMinor(ID.M.ShipLevel) / 35 + 1;
                    player.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                            net.minecraft.world.effect.MobEffects.MOVEMENT_SPEED,
                            80 + getStateMinor(ID.M.ShipLevel), level, false, false));
                }
            }
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        if (this.isOrderedToSit()) {
            if (getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                return this.getBbHeight() * -0.04F;
            } else {
                return this.getBbHeight() * 0.16F;
            }
        } else {
            return this.getBbHeight() * 0.67F;
        }
    }
}
