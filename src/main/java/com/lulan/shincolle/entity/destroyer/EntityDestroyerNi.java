package com.lulan.shincolle.entity.destroyer;

import com.lulan.shincolle.ai.ShipPickItemGoal;
import com.lulan.shincolle.ai.ShipRangeAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShipSmall;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * Destroyer Ni-Class entity.
 * model state: 0:head
 */
public class EntityDestroyerNi extends BasicEntityShipSmall {

    public EntityDestroyerNi(EntityType<? extends EntityDestroyerNi> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.DESTROYER);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.DDNI);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.DESTROYER);
        this.setStateMinor(ID.M.NumState, 1);
        this.setGrudgeConsumption(1);
        this.setAmmoConsumption(1);
        this.ModelPos = new float[]{0F, 0F, 0F, 25F};
        this.setMaxUpStep(2.0F);

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
                // marriage aura: strength boost to owner
                java.util.UUID ownerUUID = this.getOwnerUUID();
                Player player = ownerUUID != null ? this.level().getPlayerByUUID(ownerUUID) : null;
                if (player != null && getStateFlag(ID.F.IsMarried) && getStateFlag(ID.F.UseRingEffect) &&
                        getStateMinor(ID.M.NumGrudge) > 0 &&
                        this.distanceToSqr(player) < 256.0D) {
                    int level = getStateMinor(ID.M.ShipLevel) / 35 + 1;
                    player.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                            net.minecraft.world.effect.MobEffects.DAMAGE_BOOST,
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
                return this.getBbHeight() * 0.12F;
            }
        } else {
            return this.getBbHeight() * 0.77F;
        }
    }
}
