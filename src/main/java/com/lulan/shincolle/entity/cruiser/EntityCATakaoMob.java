package com.lulan.shincolle.entity.cruiser;

import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;

/**
 * Heavy Cruiser Takao hostile entity.
 * model state: 0:cannon, 1:bag, 2:hat, 3:shoes
 */
public class EntityCATakaoMob extends BasicEntityShipHostile {

    private float entityWidth = 0.75F;
    private float entityHeight = 1.75F;

    public EntityCATakaoMob(EntityType<? extends EntityCATakaoMob> type, Level level) {
        super(type, level);

        // init values
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.CATakao);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.HEAVY_CRUISER);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.CRUISER);

        // hostile flags: no air attacks
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
        this.setStateEmotion(ID.S.State, this.random.nextInt(16), false);

        this.postInit();
    }

    @Override
    public void setSizeWithScaleLevel() {
        switch (this.getScaleLevel()) {
            case 3:
                this.entityWidth = 1.7F;
                this.entityHeight = 7.0F;
                break;
            case 2:
                this.entityWidth = 1.3F;
                this.entityHeight = 5.25F;
                break;
            case 1:
                this.entityWidth = 0.9F;
                this.entityHeight = 3.5F;
                break;
            default:
                this.entityWidth = 0.75F;
                this.entityHeight = 1.75F;
                break;
        }
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.fixed(this.entityWidth, this.entityHeight);
    }

    // apply slowness to attacker
    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean result = super.hurt(source, amount);

        if (!this.level().isClientSide() && source.getEntity() instanceof LivingEntity attacker) {
            int scaleLevel = this.getScaleLevel();
            attacker.addEffect(new MobEffectInstance(
                    MobEffects.MOVEMENT_SLOWDOWN,
                    100 + scaleLevel * 50, scaleLevel / 3, false, false));
        }

        return result;
    }

}
