package com.lulan.shincolle.entity.destroyer;

import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.entity.IShipRiderType;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;

/**
 * model state:
 * 0:cannon, 1:armor, 2:hat1, 3:hat2, 4:hat3
 * if 2 & 3 & 4 false = no hat
 */
public class EntityDestroyerHibikiMob extends BasicEntityShipHostile implements IShipRiderType {

    private float entityWidth = 0.5F;
    private float entityHeight = 1.5F;

    public EntityDestroyerHibikiMob(EntityType<? extends EntityDestroyerHibikiMob> type, Level level) {
        super(type, level);

        // init values
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.DDHibiki);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.DESTROYER);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.DESTROYER);
        this.setStateMinor(ID.M.NumState, 5);

        // hostile flags: no air attacks
        this.StateFlag[ID.F.AtkType_AirLight] = false;
        this.StateFlag[ID.F.AtkType_AirHeavy] = false;

        // unlimited ammo/grudge for hostile entity
        this.StateMinor[ID.M.NumAmmoLight] = 999;
        this.StateMinor[ID.M.NumAmmoHeavy] = 999;
        this.StateMinor[ID.M.NumGrudge] = 999;
        this.setAmmoConsumption(1);

        // boss bar color
        this.bossBarColor = BossEvent.BossBarColor.WHITE;

        // model display
        this.setStateEmotion(ID.S.State, this.random.nextInt(32), false);

        this.postInit();
    }

    @Override
    public void setSizeWithScaleLevel() {
        switch (this.getScaleLevel()) {
            case 3:
                this.entityWidth = 1.7F;
                this.entityHeight = 6F;
                this.smokeX = -1.65F;
                this.smokeY = 5.3F;
                break;
            case 2:
                this.entityWidth = 1.3F;
                this.entityHeight = 4.5F;
                this.smokeX = -1.2F;
                this.smokeY = 4.1F;
                break;
            case 1:
                this.entityWidth = 0.9F;
                this.entityHeight = 3F;
                this.smokeX = -0.8F;
                this.smokeY = 2.7F;
                break;
            default:
                this.entityWidth = 0.5F;
                this.entityHeight = 1.5F;
                this.smokeX = -0.42F;
                this.smokeY = 1.4F;
                break;
        }
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.fixed(this.entityWidth, this.entityHeight);
    }

    @Override
    public int getRiderType() {
        return 0;
    }

    @Override
    public void setRiderType(int type) {
    }

}
