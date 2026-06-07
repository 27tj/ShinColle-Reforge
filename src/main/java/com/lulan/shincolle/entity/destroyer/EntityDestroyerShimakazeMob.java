package com.lulan.shincolle.entity.destroyer;

import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;

/**
 * model state:
 * 0:rensouhou type, 1:cannon, 2:hair anchor, 3:hat1, 4:hat2, 5:hat3
 * if 3 & 4 false = no hat
 */
public class EntityDestroyerShimakazeMob extends BasicEntityShipHostile {

    public int numRensouhou;
    private float entityWidth = 0.5F;
    private float entityHeight = 1.6F;

    public EntityDestroyerShimakazeMob(EntityType<? extends EntityDestroyerShimakazeMob> type, Level level) {
        super(type, level);

        // init values
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.DDShimakaze);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.DESTROYER);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.DESTROYER);
        this.setStateMinor(ID.M.NumState, 6);
        this.numRensouhou = 10;

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
        this.setStateEmotion(ID.S.State, this.random.nextInt(64), false);

        this.postInit();
    }

    @Override
    public void setSizeWithScaleLevel() {
        switch (this.getScaleLevel()) {
            case 3:
                this.entityWidth = 1.7F;
                this.entityHeight = 6.4F;
                break;
            case 2:
                this.entityWidth = 1.3F;
                this.entityHeight = 4.8F;
                break;
            case 1:
                this.entityWidth = 0.9F;
                this.entityHeight = 3.2F;
                break;
            default:
                this.entityWidth = 0.5F;
                this.entityHeight = 1.6F;
                break;
        }
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.fixed(this.entityWidth, this.entityHeight);
    }

    // num rensouhou regeneration
    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            // regenerate rensouhou every 128 ticks
            if (this.tickCount % 128 == 0) {
                if (this.numRensouhou < 10) {
                    this.numRensouhou++;
                }
            }
        }
    }

}
