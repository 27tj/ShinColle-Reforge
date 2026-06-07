package com.lulan.shincolle.entity.cruiser;

import com.lulan.shincolle.ai.ShipPickItemGoal;
import com.lulan.shincolle.ai.ShipRangeAttackGoal;
import com.lulan.shincolle.ai.ShipSkillAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShipSmall;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * Light Cruiser Tatsuta entity.
 * model state: 0:cannon, 1:head, 2:weapon
 */
public class EntityCLTatsuta extends BasicEntityShipSmall {

    public EntityCLTatsuta(EntityType<? extends EntityCLTatsuta> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.LIGHT_CRUISER);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.CLTatsuta);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.CRUISER);
        this.setStateMinor(ID.M.NumState, 3);
        this.setGrudgeConsumption(ConfigHandler.consumeGrudgeShip[ID.ShipConsume.CL]);
        this.setAmmoConsumption(ConfigHandler.consumeAmmoShip[ID.ShipConsume.CL]);
        this.ModelPos = new float[]{0F, 22F, 0F, 42F};

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

        // [PORT] 1.10.2 -> 1.20.1: CLTatsuta used skill attack at priority 0.
        this.goalSelector.removeAllGoals(goal -> goal instanceof ShipSkillAttackGoal);
        this.goalSelector.addGoal(0, new ShipSkillAttackGoal(this));

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
                // marriage aura: night vision to owner
                java.util.UUID ownerUUID = this.getOwnerUUID();
                Player player = ownerUUID != null ? this.level().getPlayerByUUID(ownerUUID) : null;
                if (player != null && getStateFlag(ID.F.IsMarried) && getStateFlag(ID.F.UseRingEffect) &&
                        getStateMinor(ID.M.NumGrudge) > 0 &&
                        this.distanceToSqr(player) < 256.0D) {
                    int level = getStateMinor(ID.M.ShipLevel);
                    player.addEffect(new MobEffectInstance(
                            MobEffects.NIGHT_VISION,
                            100 + level, 0, false, false));
                }
            }
        }
    }

    // night bonus: +0.15 CRI, +0.15 DODGE
    @Override
    public void calcShipAttributesAddRaw() {
        super.calcShipAttributesAddRaw();

        if (!this.level().isDay()) {
            this.shipAttrs.setAttrsBuffed(ID.Attrs.CRI,
                    this.shipAttrs.getAttrsBuffed(ID.Attrs.CRI) + 0.15F);
            this.shipAttrs.setAttrsBuffed(ID.Attrs.DODGE,
                    this.shipAttrs.getAttrsBuffed(ID.Attrs.DODGE) + 0.15F);
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        if (this.isOrderedToSit()) {
            if (getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                return this.getBbHeight() * 0.2F;
            } else {
                return this.getBbHeight() * 0.27F;
            }
        } else {
            return this.getBbHeight() * 0.7F;
        }
    }
}
