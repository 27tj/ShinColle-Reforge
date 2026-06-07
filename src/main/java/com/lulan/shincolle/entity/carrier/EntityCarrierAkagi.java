package com.lulan.shincolle.entity.carrier;

import com.lulan.shincolle.ai.ShipCarrierAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipCV;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.reference.ID;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

/**
 * Carrier Akagi entity.
 * model state: 0:cannon, 1:head, 2:weapon, 3:armor, 4:flight deck, 5:quiver,
 * 6:bow, 7:cape
 */
public class EntityCarrierAkagi extends BasicEntityShipCV {

    public EntityCarrierAkagi(EntityType<? extends EntityCarrierAkagi> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.STANDARD_CARRIER);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.CVAkagi);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.CARRIER);
        this.setStateMinor(ID.M.NumState, 8);
        this.setGrudgeConsumption(ConfigHandler.consumeGrudgeShip[ID.ShipConsume.CV]);
        this.setAmmoConsumption(ConfigHandler.consumeAmmoShip[ID.ShipConsume.CV]);
        this.ModelPos = new float[]{0F, 20F, 0F, 40F};

        // set attack type: carrier has no cannon attacks
        this.StateFlag[ID.F.AtkType_Light] = false;
        this.StateFlag[ID.F.AtkType_Heavy] = false;

        // initialize aircraft counts
        this.setNumAircraftLight(6);
        this.setNumAircraftHeavy(3);

        this.postInit();
    }

    /**
     * Equip type: 3=airplane+misc
     */
    @Override
    public int getEquipType() {
        return 3;
    }

    @Override
    public void setAIList() {
        super.setAIList();

        // carrier attack
        this.goalSelector.addGoal(11, new ShipCarrierAttackGoal(this));
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            if (this.tickCount % 128 == 0) {
                // ring effect: JUMP to nearby same-owner ships
                java.util.UUID ownerUUID = this.getOwnerUUID();
                if (ownerUUID != null && getStateFlag(ID.F.IsMarried) && getStateFlag(ID.F.UseRingEffect) &&
                        getStateMinor(ID.M.NumGrudge) > 0) {

                    int level = getStateMinor(ID.M.ShipLevel);
                    int amp = level / 85;
                    int duration = 50 + level;

                    AABB area = this.getBoundingBox().inflate(16.0D);
                    List<BasicEntityShip> nearby = this.level().getEntitiesOfClass(BasicEntityShip.class, area,
                            e -> e != this && e.isAlive() && ownerUUID.equals(e.getOwnerUUID()));

                    for (BasicEntityShip ship : nearby) {
                        ship.addEffect(new MobEffectInstance(MobEffects.JUMP, duration, amp, false, false));
                    }
                }
            }
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        if (this.isOrderedToSit()) {
            if (getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                return this.getBbHeight() * 0.35F;
            } else {
                return this.getBbHeight() * 0.45F;
            }
        } else {
            return this.getBbHeight() * 0.72F;
        }
    }
}
