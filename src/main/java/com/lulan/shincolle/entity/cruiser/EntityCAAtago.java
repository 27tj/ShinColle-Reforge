package com.lulan.shincolle.entity.cruiser;

import com.lulan.shincolle.ai.ShipPickItemGoal;
import com.lulan.shincolle.ai.ShipRangeAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShipSmall;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

/**
 * Heavy Cruiser Atago entity.
 * model state: 0:cannon, 1:bag, 2:hat, 3:shoes
 */
public class EntityCAAtago extends BasicEntityShipSmall {

    public EntityCAAtago(EntityType<? extends EntityCAAtago> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.HEAVY_CRUISER);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.CAAtago);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.CRUISER);
        this.setStateMinor(ID.M.NumState, 4);
        this.setGrudgeConsumption(ConfigHandler.consumeGrudgeShip[ID.ShipConsume.CA]);
        this.setAmmoConsumption(ConfigHandler.consumeAmmoShip[ID.ShipConsume.CA]);
        this.ModelPos = new float[]{0F, 25F, 0F, 40F};

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

    // apply slowness to attacker
    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean result = super.hurt(source, amount);

        if (!this.level().isClientSide() && source.getEntity() instanceof LivingEntity attacker) {
            int level = getStateMinor(ID.M.ShipLevel);
            attacker.addEffect(new MobEffectInstance(
                    MobEffects.MOVEMENT_SLOWDOWN,
                    100 + level, level / 100, false, false));
        }

        return result;
    }

    @Override
    public double getPassengersRidingOffset() {
        if (this.isOrderedToSit()) {
            if (getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                return 0;
            } else {
                return this.getBbHeight() * 0.35F;
            }
        } else {
            return this.getBbHeight() * 0.75F;
        }
    }
}
