package com.lulan.shincolle.utility;

import com.lulan.shincolle.client.model.IModelEmotion;
import com.lulan.shincolle.client.model.IModelEmotionAdv;
import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Values;

import net.minecraft.util.Mth;

/**
 * Emotion helper - drives face/mouth/flush rendering based on entity emotion
 * state.
 */
public class EmotionHelper {

    public EmotionHelper() {
    }

    /**
     * roll basic emotion
     */
    public static void rollEmotion(IModelEmotion model, IShipEmotion ent) {
        switch (ent.getStateEmotion(ID.S.Emotion)) {
            case 6:
            case 7:
            case 8:
            case 9:
                model.setFace(ent.getStateEmotion(ID.S.Emotion) - 5);
                break;
            case ID.Emotion.BLINK:
                applyEmotionBlink(model, ent);
                break;
            case ID.Emotion.T_T:
                model.setFace(2);
                break;
            case ID.Emotion.O_O:
                applyEmotion(model, ent, ID.Emotion.O_O, 45);
                break;
            case ID.Emotion.HUNGRY:
                model.setFace(4);
                break;
            case ID.Emotion.BORED:
            default:
                if (ent.getFaceTick() <= 0) {
                    model.setFace(0);
                } else {
                    applyEmotionBlink(model, ent);
                }
                if ((ent.getTickExisted() & 127) == 0) {
                    int emotionRand = ent.getRand().nextInt(10);
                    if (emotionRand > 7) {
                        applyEmotionBlink(model, ent);
                    }
                }
                break;
        }
    }

    /**
     * roll advanced emotion
     */
    @SuppressWarnings("fallthrough")
    public static void rollEmotionAdv(IModelEmotionAdv model, IShipEmotion ent) {
        switch (ent.getStateEmotion(ID.S.Emotion)) {
            case 9:
                model.setFace(ent.getStateEmotion(ID.S.Emotion));
                break;
            case ID.Emotion.BLINK:
                applyEmotionBlinkAdv(model, ent);
                break;
            case ID.Emotion.T_T:
                applyEmotionAdv(model, ent, ID.Emotion.T_T, 80);
                break;
            case ID.Emotion.O_O:
                applyEmotionAdv(model, ent, ID.Emotion.O_O, 45);
                break;
            case ID.Emotion.HUNGRY:
                model.setFaceHungry(ent);
                ent.setFaceTick(-1);
                break;
            case ID.Emotion.ANGRY:
                applyEmotionAdv(model, ent, ID.Emotion.ANGRY, 40);
                break;
            case ID.Emotion.SHY:
                applyEmotionAdv(model, ent, ID.Emotion.SHY, 80);
                break;
            case ID.Emotion.XD:
                applyEmotionAdv(model, ent, ID.Emotion.XD, 60);
                break;
            case ID.Emotion.BORED:
                model.setFaceBored(ent);
                // $FALL-THROUGH$ for blink rolling
            default:
                if (ent.getFaceTick() <= 0) {
                    if (ent.getStateEmotion(ID.S.Emotion) != ID.Emotion.BORED)
                        model.setFaceNormal(ent);
                } else {
                    applyEmotionBlinkAdv(model, ent);
                }
                if ((ent.getTickExisted() & 127) == 0) {
                    int emotionRand = ent.getRand().nextInt(10);
                    if (emotionRand > 7) {
                        applyEmotionBlinkAdv(model, ent);
                    }
                }
                break;
        }
    }

    /**
     * Head tilt angle calculation
     */
    public static float getHeadTiltAngle(IShipEmotion ent, float f2) {
        int cd = ent.getTickExisted() - ent.getHeadTiltTick();
        float maxAngle = -0.27F;
        float partTick = f2 - (int) f2 + cd;

        if (cd > 70 + ent.getRand().nextInt(5)) {
            ent.setHeadTiltTick(ent.getTickExisted());
            partTick = f2 - (int) f2;
            ent.setStateFlag(ID.F.HeadTilt, ent.getRand().nextInt(10) > 4);
        }

        if (ent.getStateFlag(ID.F.HeadTilt)) {
            if (ent.getStateEmotion(ID.S.Emotion2) > 0) {
                return maxAngle;
            } else {
                float f = Mth.sin(partTick * 0.1F * 1.5708F) * maxAngle;
                if (f - 0.03F < maxAngle || partTick > 10F) {
                    ent.setStateEmotion(ID.S.Emotion2, 1, false);
                    f = maxAngle;
                }
                return f;
            }
        } else {
            if (ent.getStateEmotion(ID.S.Emotion2) <= 0) {
                return 0F;
            } else {
                float f = (1F - Mth.sin(partTick * 0.2F * 1.5708F)) * maxAngle;
                if (f + 0.03F > 0F || partTick > 8F) {
                    ent.setStateEmotion(ID.S.Emotion2, 0, false);
                    f = 0F;
                }
                return f;
            }
        }
    }

    /**
     * Basic blink animation
     */
    public static void applyEmotionBlink(IModelEmotion model, IShipEmotion ent) {
        if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.NORMAL) {
            ent.setFaceTick(ent.getTickExisted());
            ent.setStateEmotion(ID.S.Emotion, ID.Emotion.BLINK, false);
            model.setFace(1);
        }
        int emoTime = ent.getTickExisted() - ent.getFaceTick();
        if (emoTime > 25) {
            model.setFace(0);
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BLINK) {
                ent.setStateEmotion(ID.S.Emotion, ID.Emotion.NORMAL, false);
            }
            ent.setFaceTick(-1);
        } else if (emoTime > 20) {
            model.setFace(1);
        } else if (emoTime > 10) {
            model.setFace(0);
        } else if (emoTime > -1) {
            model.setFace(1);
        }
    }

    /**
     * Advanced blink animation
     */
    public static void applyEmotionBlinkAdv(IModelEmotionAdv model, IShipEmotion ent) {
        if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.NORMAL) {
            ent.setFaceTick(ent.getTickExisted());
            ent.setStateEmotion(ID.S.Emotion, ID.Emotion.BLINK, false);
            model.setFaceBlink1(ent);
        }
        int emoTime = ent.getTickExisted() - ent.getFaceTick();
        if (emoTime > 25) {
            model.setFaceBlink0(ent);
            if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BLINK) {
                ent.setStateEmotion(ID.S.Emotion, ID.Emotion.NORMAL, false);
            }
            ent.setFaceTick(-1);
        } else if (emoTime > 20) {
            model.setFaceBlink1(ent);
        } else if (emoTime > 10) {
            model.setFaceBlink0(ent);
        } else if (emoTime > -1) {
            model.setFaceBlink1(ent);
        }
    }

    /**
     * Apply basic emotion with time limit
     */
    public static void applyEmotion(IModelEmotion model, IShipEmotion ent, int type, int maxTime) {
        if (ent.getFaceTick() <= 0) {
            ent.setFaceTick(ent.getTickExisted());
        }
        int emoTime = ent.getTickExisted() - ent.getFaceTick();
        if (emoTime > maxTime) {
            model.setFace(0);
            ent.setStateEmotion(ID.S.Emotion, ID.Emotion.NORMAL, false);
            ent.setFaceTick(-1);
        } else {
            if (type == ID.Emotion.O_O) {
                model.setFace(3);
            }
        }
    }

    /**
     * Apply advanced emotion with time limit
     */
    public static void applyEmotionAdv(IModelEmotionAdv model, IShipEmotion ent, int type, int maxTime) {
        if (ent.getFaceTick() <= 0) {
            ent.setFaceTick(ent.getTickExisted());
        }
        int emoTime = ent.getTickExisted() - ent.getFaceTick();
        if (emoTime > maxTime) {
            model.setFaceNormal(ent);
            ent.setStateEmotion(ID.S.Emotion, ID.Emotion.NORMAL, false);
            ent.setFaceTick(-1);
        } else {
            switch (type) {
                case ID.Emotion.O_O:
                    if ((ent.getTickExisted() & 2047) > 1024) {
                        model.setFaceDamaged(ent);
                    } else {
                        model.setFaceScorn(ent);
                    }
                    break;
                case ID.Emotion.T_T:
                    model.setFaceCry(ent);
                    break;
                case ID.Emotion.ANGRY:
                    model.setFaceAngry(ent);
                    break;
                case ID.Emotion.SHY:
                    model.setFaceShy(ent);
                    break;
                case ID.Emotion.XD:
                    model.setFaceHappy(ent);
                    break;
            }
        }
    }

    /**
     * Check model display flags.
     * id = 0, 1, 2, ..., 15
     * state = entity.getStateEmotion(ID.S.State)
     */
    public static boolean checkModelState(int id, int state) {
        return (state & Values.N.Pow2[id]) == Values.N.Pow2[id];
    }
}
