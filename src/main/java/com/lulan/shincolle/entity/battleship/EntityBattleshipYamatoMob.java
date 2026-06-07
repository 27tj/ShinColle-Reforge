package com.lulan.shincolle.entity.battleship;

import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;

/**
 * Battleship Yamato mob entity.
 * model state: 0:cannon, 1:head, 2:umbrella, 3:leg equip
 */
public class EntityBattleshipYamatoMob extends BasicEntityShipHostile {

    private float entityWidth = 0.8F;
    private float entityHeight = 2.1F;

    public EntityBattleshipYamatoMob(EntityType<? extends EntityBattleshipYamatoMob> type, Level level) {
        super(type, level);

        // init values
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.BBYamato);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.BATTLESHIP);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.BATTLESHIP);
        this.setStateMinor(ID.M.NumState, 4);

        // hostile flags: no air attacks
        this.StateFlag[ID.F.AtkType_AirLight] = false;
        this.StateFlag[ID.F.AtkType_AirHeavy] = false;

        // unlimited ammo/grudge for hostile entity
        this.StateMinor[ID.M.NumAmmoLight] = 999;
        this.StateMinor[ID.M.NumAmmoHeavy] = 999;
        this.StateMinor[ID.M.NumGrudge] = 999;
        this.setAmmoConsumption(1);

        // boss bar color: PINK (unique!)
        this.bossBarColor = BossEvent.BossBarColor.PINK;

        // model display: state = 15
        this.setStateEmotion(ID.S.State, 15, false);

        this.postInit();
    }

    @Override
    public void setSizeWithScaleLevel() {
        switch (this.getScaleLevel()) {
            case 3:
                this.entityWidth = 2.3F;
                this.entityHeight = 8.4F;
                break;
            case 2:
                this.entityWidth = 1.8F;
                this.entityHeight = 6.3F;
                break;
            case 1:
                this.entityWidth = 1.3F;
                this.entityHeight = 4.2F;
                break;
            default:
                this.entityWidth = 0.8F;
                this.entityHeight = 2.1F;
                break;
        }
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return EntityDimensions.fixed(this.entityWidth, this.entityHeight);
    }

}
