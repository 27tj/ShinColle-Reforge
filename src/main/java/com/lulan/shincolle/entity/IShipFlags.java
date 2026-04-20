package com.lulan.shincolle.entity;

public interface IShipFlags {
    int getStateMinor(int id);

    void setStateMinor(int state, int par1);

    boolean getStateFlag(int flag);

    void setStateFlag(int id, boolean flag);

    void setUpdateFlag(int id, boolean value);

    boolean getUpdateFlag(int id);
}
