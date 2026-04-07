package com.lulan.shincolle.entity;

import net.minecraft.util.RandomSource;

public interface IShipEmotion extends IShipFlags {
    int getStateEmotion(int id);

    void setStateEmotion(int id, int value, boolean sync);

    int getStateTimer(int id);

    void setStateTimer(int id, int value);

    int getFaceTick();

    int getHeadTiltTick();

    int getAttackTick();

    int getAttackTick2();

    int getDeathTick();

    void setFaceTick(int par1);

    void setHeadTiltTick(int par1);

    void setAttackTick(int par1);

    void setAttackTick2(int par1);

    void setDeathTick(int par1);

    float getModelRotate(int par1);

    void setModelRotate(int par1, float par2);

    int getTickExisted();

    float getSwingTime(float partialTick);

    boolean getIsRiding();

    boolean getIsSprinting();

    boolean getIsSitting();

    boolean getIsSneaking();

    boolean getIsLeashed();

    void setEntitySit(boolean sit);

    int getRidingState();

    void setRidingState(int state);

    int getScaleLevel();

    void setScaleLevel(int par1);

    RandomSource getRand();

    double getShipDepth(int type);
}
