package com.lulan.shincolle.entity.battleship;

import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;

/**
 * Battleship Nagato mob entity.
 * model state: 0:head, 1:equip
 */
public class EntityBattleshipNagatoMob extends BasicEntityShipHostile {

    private float entityWidth = 0.7F;
    private float entityHeight = 2.0F;

    public EntityBattleshipNagatoMob(EntityType<? extends EntityBattleshipNagatoMob> type, Level level) {
        super(type, level);

        // init values
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.BBNagato);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.BATTLESHIP);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.BATTLESHIP);
        this.setStateMinor(ID.M.NumState, 2);

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

        // model display: state = 3
        this.setStateEmotion(ID.S.State, 3, false);

        this.postInit();
    }

    @Override
    public void setSizeWithScaleLevel() {
        switch (this.getScaleLevel()) {
            case 3:
                this.entityWidth = 2.2F;
                this.entityHeight = 8.0F;
                break;
            case 2:
                this.entityWidth = 1.7F;
                this.entityHeight = 6.0F;
                break;
            case 1:
                this.entityWidth = 1.2F;
                this.entityHeight = 4.0F;
                break;
            default:
                this.entityWidth = 0.7F;
                this.entityHeight = 2.0F;
                break;
        }
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.fixed(this.entityWidth, this.entityHeight);
    }

}
