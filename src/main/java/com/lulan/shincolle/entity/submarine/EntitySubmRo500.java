package com.lulan.shincolle.entity.submarine;

import com.lulan.shincolle.ai.ShipPickItemGoal;
import com.lulan.shincolle.ai.ShipRangeAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShipSmall;
import com.lulan.shincolle.entity.IShipInvisible;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * Submarine Ro-500 entity.
 * model state: 0:hat, 1:hair, 2:swimsuit
 */
public class EntitySubmRo500 extends BasicEntityShipSmall implements IShipInvisible {

    private float invisibleLevel = 0.35F;

    public EntitySubmRo500(EntityType<? extends EntitySubmRo500> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.SUBMARINE);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.SSRo500);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.SUBMARINE);
        this.setStateMinor(ID.M.NumState, 3);
        this.setGrudgeConsumption(ConfigHandler.consumeGrudgeShip[ID.ShipConsume.SS]);
        this.setAmmoConsumption(ConfigHandler.consumeAmmoShip[ID.ShipConsume.SS]);
        this.ModelPos = new float[]{0F, 20F, 0F, 45F};
        this.ShipFloatingDepth = 1.1D;

        // set attack type: submarine has no air attacks
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
                // ring effect: INVISIBILITY on owner
                java.util.UUID ownerUUID = this.getOwnerUUID();
                Player player = ownerUUID != null ? this.level().getPlayerByUUID(ownerUUID) : null;
                if (player != null && getStateFlag(ID.F.IsMarried) && getStateFlag(ID.F.UseRingEffect) &&
                        getStateMinor(ID.M.NumGrudge) > 0 &&
                        this.distanceToSqr(player) < 256.0D) {
                    int level = getStateMinor(ID.M.ShipLevel);
                    int duration = 40 + level;

                    player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, duration, 0, false, false));

                    // self invisibility when married + ring
                    this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, duration, 0, false, false));
                }
            }
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        if (this.isOrderedToSit()) {
            if (getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                return this.getBbHeight() * 0.05F;
            } else {
                return this.getBbHeight() * 0.14F;
            }
        } else {
            return this.getBbHeight() * 0.6F;
        }
    }
}
