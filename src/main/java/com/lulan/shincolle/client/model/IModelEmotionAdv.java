package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;

/**
 * Extended emotion interface - adds mouth, flush, and emotion-specific face
 * presets.
 */
public interface IModelEmotionAdv extends IModelEmotion {

    /**
     * set mouth: 0:normal, 1:crooked, 2:flat, 3:closed, 4:open, 5:wide
     */
    void setMouth(int par1);

    /**
     * set flush (blush)
     */
    void setFlush(boolean par1);

    /**
     * set face by emotion
     */
    void setFaceNormal(IShipEmotion ent);

    void setFaceBlink0(IShipEmotion ent);

    void setFaceBlink1(IShipEmotion ent);

    void setFaceCry(IShipEmotion ent);

    void setFaceAttack(IShipEmotion ent);

    void setFaceDamaged(IShipEmotion ent);

    void setFaceHungry(IShipEmotion ent);

    void setFaceAngry(IShipEmotion ent);

    void setFaceScorn(IShipEmotion ent);

    void setFaceBored(IShipEmotion ent);

    void setFaceShy(IShipEmotion ent);

    void setFaceHappy(IShipEmotion ent);
}
