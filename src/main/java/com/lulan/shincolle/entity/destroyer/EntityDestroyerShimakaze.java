package com.lulan.shincolle.entity.destroyer;

import com.lulan.shincolle.ai.ShipPickItemGoal;
import com.lulan.shincolle.ai.ShipRangeAttackGoal;
import com.lulan.shincolle.entity.BasicEntityShipSmall;
import com.lulan.shincolle.entity.IShipSummonAttack;
import com.lulan.shincolle.entity.other.EntityAbyssMissile;
import com.lulan.shincolle.entity.other.EntityRensouhou;
import com.lulan.shincolle.entity.other.EntityRensouhouS;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModEntities;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.unitclass.MissileData;
import com.lulan.shincolle.utility.CombatHelper;
import com.lulan.shincolle.utility.EmotionHelper;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * Destroyer Shimakaze entity.
 * model state: 0:rensouhou type, 1:cannon, 2:hair anchor, 3:hat1, 4:hat2,
 * 5:hat3
 */
public class EntityDestroyerShimakaze extends BasicEntityShipSmall implements IShipSummonAttack {

    public int numRensouhou;

    public EntityDestroyerShimakaze(EntityType<? extends EntityDestroyerShimakaze> type, Level level) {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipType.DESTROYER);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.DDShimakaze);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.DESTROYER);
        this.setStateMinor(ID.M.NumState, 6);
        this.setGrudgeConsumption(ConfigHandler.consumeGrudgeShip[ID.ShipConsume.DD]);
        this.setAmmoConsumption(ConfigHandler.consumeAmmoShip[ID.ShipConsume.DD]);
        this.ModelPos = new float[]{0F, 25F, 0F, 45F};

        this.numRensouhou = 6;

        // set attack type
        this.StateFlag[ID.F.AtkType_AirLight] = false;
        this.StateFlag[ID.F.AtkType_AirHeavy] = false;
        this.StateFlag[ID.F.CanPickItem] = true;

        this.postInit();
    }

    /**
     * Equip type: 1=cannon+misc, 2=cannon+airplane+misc, 3=airplane+misc
     */
    public int getEquipType() {
        return 1;
    }

    @Override
    public void setAIList() {
        super.setAIList();

        // range attack
        this.goalSelector.addGoal(11, new ShipRangeAttackGoal(this));

        // pick item
        this.goalSelector.addGoal(20, new ShipPickItemGoal(this, 4.0F));
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.level().isClientSide()) {
            // add rensouhou + aura every 128 ticks
            if (this.tickCount % 128 == 0) {
                if (this.numRensouhou < 6)
                    numRensouhou++;

                // marriage aura: speed boost to owner
                java.util.UUID ownerUUID = this.getOwnerUUID();
                Player player = ownerUUID != null ? this.level().getPlayerByUUID(ownerUUID) : null;
                if (player != null && getStateFlag(ID.F.IsMarried) && getStateFlag(ID.F.UseRingEffect) &&
                        getStateMinor(ID.M.NumGrudge) > 0 &&
                        this.distanceToSqr(player) < 256.0D) {
                    int level = getStateMinor(ID.M.ShipLevel) / 35 + 1;
                    player.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                            net.minecraft.world.effect.MobEffects.MOVEMENT_SPEED,
                            80 + getStateMinor(ID.M.ShipLevel), level, false, false));
                }
            }
        }
    }

    @Override
    public boolean attackEntityWithAmmo(Entity target) {
        // consume ammo
        if (!decrAmmoNum(0, 4 * this.getAmmoConsumption()))
            return false;

        // check rensouhou availability
        if (this.numRensouhou <= 0)
            return false;
        this.numRensouhou--;

        // experience + grudge + morale
        addShipExp(ConfigHandler.expGain[1] * 2);
        decrGrudgeNum(ConfigHandler.consumeGrudgeAction[0]);
        decrMorale(1);
        setCombatTick(this.tickCount);

        // play attack sound
        if (this.random.nextInt(10) > 7) {
            this.playSound(getCustomSound(1, this), this.getSoundVolume(), this.getVoicePitch());
        }

        // send attack animation sync to clients
        setStateTimer(ID.T.AttackTime, 20);
        sendSyncPacketEmotion();

        // spawn rensouhou: check model state 0 to determine type
        if (EmotionHelper.checkModelState(0, this.getStateEmotion(ID.S.State))) {
            EntityRensouhouS rensoho = new EntityRensouhouS(ModEntities.RENSOUHOU_S.get(), this.level());
            rensoho.initAttrs(this, target, 0);
            this.level().addFreshEntity(rensoho);
        } else {
            EntityRensouhou rensoho = new EntityRensouhou(ModEntities.RENSOUHOU.get(), this.level());
            rensoho.initAttrs(this, target, 0);
            this.level().addFreshEntity(rensoho);
        }

        applyEmotesReaction(3);
        return true;
    }

    @Override
    public boolean attackEntityWithHeavyAmmo(Entity target) {
        // consume heavy ammo
        if (!decrAmmoNum(1, this.getAmmoConsumption()))
            return false;

        float atk = getAttackBaseDamage(2, target) * 0.3F;
        float kbValue = 0.15F;

        // launch position
        float launchPos = (float) this.getY() + this.getBbHeight() * 0.7F;

        // experience + grudge + morale
        addShipExp(ConfigHandler.expGain[2]);
        decrGrudgeNum(ConfigHandler.consumeGrudgeAction[1]);
        decrMorale(2);
        setCombatTick(this.tickCount);

        // play heavy fire sound
        applySoundAtAttacker(2, target);

        // target position
        float tarX = (float) target.getX();
        float tarY = (float) target.getY();
        float tarZ = (float) target.getZ();
        float tarHeightOff = target.getBbHeight() * 0.1F;

        // send attack animation sync to clients
        setStateTimer(ID.T.AttackTime2, 20);
        sendSyncPacketEmotion();

        // get missile data
        MissileData md = this.getMissileData(2);
        int moveType = CombatHelper.calcMissileMoveType(this, target.getY(), 2);
        if (moveType == 1) {
            moveType = 0;
        }

        // spawn 5 missiles in cross pattern
        // 2026/04/07・哦itHub Copilot縺ｫ繧医▲縺ｦ遒ｺ隱肴ｸ医∩
        spawnMissile(atk, kbValue, launchPos, tarX, tarY + tarHeightOff, tarZ,
                md, moveType);
        spawnMissile(atk, kbValue, launchPos, tarX + 3.5F, tarY + tarHeightOff, tarZ + 3.5F,
                md, moveType);
        spawnMissile(atk, kbValue, launchPos, tarX + 3.5F, tarY + tarHeightOff, tarZ - 3.5F,
                md, moveType);
        spawnMissile(atk, kbValue, launchPos, tarX - 3.5F, tarY + tarHeightOff, tarZ + 3.5F,
                md, moveType);
        spawnMissile(atk, kbValue, launchPos, tarX - 3.5F, tarY + tarHeightOff, tarZ - 3.5F,
                md, moveType);

        applyEmotesReaction(3);
        return true;
    }

    /**
     * Helper to spawn a single EntityAbyssMissile
     */
    private void spawnMissile(float atk, float kbValue, float launchPos,
                              float tarX, float tarY, float tarZ, MissileData md, int moveType) {
        EntityAbyssMissile missile = new EntityAbyssMissile(
                ModEntities.ABYSS_MISSILE.get(), this.level());
        missile.initMissile(this, md.type, moveType,
                atk, kbValue, launchPos, tarX, tarY, tarZ,
                160, 0.25F, md.vel0, md.accY1, md.accY2);
        this.level().addFreshEntity(missile);
    }

    @Override
    public void calcShipAttributesAddEquip() {
        super.calcShipAttributesAddEquip();

        MissileData md = this.getMissileData(2);
        if (md != null) {
            md.vel0 += 0.2F;
            md.accY1 += 0.025F;
            md.accY2 += 0.025F;
        }
    }

    @Override
    public int getNumServant() {
        return this.numRensouhou;
    }

    @Override
    public void setNumServant(int num) {
        this.numRensouhou = num;
    }

    @Override
    public double getPassengersRidingOffset() {
        if (this.isOrderedToSit()) {
            if (getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED) {
                return this.getBbHeight() * -0.04F;
            } else {
                return this.getBbHeight() * 0.16F;
            }
        } else {
            return this.getBbHeight() * 0.67F;
        }
    }
}
