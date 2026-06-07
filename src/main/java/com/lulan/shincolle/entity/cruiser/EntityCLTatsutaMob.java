package com.lulan.shincolle.entity.cruiser;

import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;

/**
 * Light Cruiser Tatsuta hostile entity.
 * model state: 0:cannon, 1:head, 2:weapon
 */
public class EntityCLTatsutaMob extends BasicEntityShipHostile {

    private float entityWidth = 0.75F;
    private float entityHeight = 1.65F;

    public EntityCLTatsutaMob(EntityType<? extends EntityCLTatsutaMob> type, Level level) {
        super(type, level);

        // init values
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.CLTatsuta);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.LIGHT_CRUISER);
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
        this.bossBarColor = BossEvent.BossBarColor.PURPLE;

        // model display
        this.setStateEmotion(ID.S.State, this.random.nextInt(8), false);

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
                this.entityWidth = 0.75F;
                this.entityHeight = 1.65F;
                break;
        }
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.fixed(this.entityWidth, this.entityHeight);
    }

}
