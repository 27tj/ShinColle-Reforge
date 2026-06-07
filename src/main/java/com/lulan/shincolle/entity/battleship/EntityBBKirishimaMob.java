package com.lulan.shincolle.entity.battleship;

import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;

/**
 * Battleship Kirishima mob entity.
 * model state: 0:equip, 1:head, 2:glasses
 */
public class EntityBBKirishimaMob extends BasicEntityShipHostile {

    private float entityWidth = 0.6F;
    private float entityHeight = 1.875F;

    public EntityBBKirishimaMob(EntityType<? extends EntityBBKirishimaMob> type, Level level) {
        super(type, level);

        // init values
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.BBKirishima);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.BATTLESHIP);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.BATTLESHIP);
        this.setStateMinor(ID.M.NumState, 3);

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

        // model display: random state 5 or 7
        this.setStateEmotion(ID.S.State, this.random.nextInt(2) == 0 ? 5 : 7, false);

        this.postInit();
    }

    @Override
    public void setSizeWithScaleLevel() {
        switch (this.getScaleLevel()) {
            case 3:
                this.entityWidth = 2.4F;
                this.entityHeight = 7.5F;
                break;
            case 2:
                this.entityWidth = 1.8F;
                this.entityHeight = 5.625F;
                break;
            case 1:
                this.entityWidth = 1.2F;
                this.entityHeight = 3.75F;
                break;
            default:
                this.entityWidth = 0.6F;
                this.entityHeight = 1.875F;
                break;
        }
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.fixed(this.entityWidth, this.entityHeight);
    }

}
