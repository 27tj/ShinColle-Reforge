package com.lulan.shincolle.entity.submarine;

import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.entity.IShipInvisible;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.BossEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;

/**
 * Submarine Ro-500 mob (hostile) entity.
 */
public class EntitySubmRo500Mob extends BasicEntityShipHostile implements IShipInvisible {

    private float invisibleLevel = 0.35F;
    private float entityWidth = 0.6F;
    private float entityHeight = 1.4F;

    public EntitySubmRo500Mob(EntityType<? extends EntitySubmRo500Mob> type, Level level) {
        super(type, level);

        // init values
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.SSRo500);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.SUBMARINE);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.SUBMARINE);
        this.setStateMinor(ID.M.NumState, 3);

        // no air attacks for submarine
        this.StateFlag[ID.F.AtkType_AirLight] = false;
        this.StateFlag[ID.F.AtkType_AirHeavy] = false;

        // unlimited ammo/grudge for hostile entity
        this.StateMinor[ID.M.NumAmmoLight] = 999;
        this.StateMinor[ID.M.NumAmmoHeavy] = 999;
        this.StateMinor[ID.M.NumGrudge] = 999;
        this.setAmmoConsumption(1);

        // boss bar color
        this.bossBarColor = BossEvent.BossBarColor.YELLOW;

        // model display
        this.setStateEmotion(ID.S.State, this.random.nextInt(8), false);

        this.postInit();
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
    public void setSizeWithScaleLevel() {
        switch (this.getScaleLevel()) {
            case 3:
                this.entityWidth = 1.5F;
                this.entityHeight = 5.6F;
                break;
            case 2:
                this.entityWidth = 1.2F;
                this.entityHeight = 4.2F;
                break;
            case 1:
                this.entityWidth = 0.9F;
                this.entityHeight = 2.8F;
                break;
            default:
                this.entityWidth = 0.6F;
                this.entityHeight = 1.4F;
                break;
        }
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.fixed(this.entityWidth, this.entityHeight);
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            // 50% chance every 128 ticks to go invisible
            if (this.tickCount % 128 == 0) {
                if (this.random.nextInt(2) == 0) {
                    int duration = 40 + this.getScaleLevel() * 10;
                    this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, duration, 0, false, false));
                }
            }
        }
    }

}
