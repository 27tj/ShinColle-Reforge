package com.lulan.shincolle.entity.transport;

import com.lulan.shincolle.ai.ShipPickItemGoal;
import com.lulan.shincolle.entity.BasicEntityShipSmall;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Transport Wa-class entity.
 * model state: 0:equip, 1:leg, 2:hat
 */
public class EntityTransportWa extends BasicEntityShipSmall {

    public EntityTransportWa(EntityType<? extends EntityTransportWa> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.TRANSPORT);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.APWA);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.UNDEFINED);
        this.setStateMinor(ID.M.NumState, 3);
        this.setGrudgeConsumption(1);
        this.setAmmoConsumption(1);
        this.ModelPos = new float[]{-3F, 20F, 0F, 45F};

        // set attack type: transport has no attack capabilities
        this.StateFlag[ID.F.AtkType_Light] = false;
        this.StateFlag[ID.F.AtkType_Heavy] = false;
        this.StateFlag[ID.F.AtkType_AirLight] = false;
        this.StateFlag[ID.F.AtkType_AirHeavy] = false;
        this.StateFlag[ID.F.CanPickItem] = true;

        this.postInit();
    }

    /**
     * Equip type: 1=cannon+misc (but all attacks disabled)
     */
    @Override
    public int getEquipType() {
        return 1;
    }

    @Override
    public void setAIList() {
        super.setAIList();

        // pick item (high priority, large range for transport)
        this.goalSelector.addGoal(5, new ShipPickItemGoal(this, 8.0F));
    }

    @Override
    public double getPassengersRidingOffset() {
        if (this.isOrderedToSit()) {
            return 0;
        } else {
            return this.getBbHeight() * 0.64F;
        }
    }
}
