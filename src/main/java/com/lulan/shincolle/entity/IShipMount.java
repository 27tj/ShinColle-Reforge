package com.lulan.shincolle.entity;

public interface IShipMount extends IShipFloating {
    float[] getSeatPos();

    void setSeatPos(float[] pos);

    float[] getSeatPos2();

    void setSeatPos2(float[] pos);
}
