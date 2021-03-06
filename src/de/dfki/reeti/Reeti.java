package de.dfki.reeti;

import de.dfki.common.agents.Agent3D;
import de.dfki.common.parts.FXParts;
import de.dfki.reeti.animationlogic.AnimationLoaderReeti;
import de.dfki.reeti.animationlogic.AnimationSchedulerReeti;
import de.dfki.reeti.body.LeftEye;
import de.dfki.reeti.body.Head;
import de.dfki.reeti.body.Mouth;
import de.dfki.reeti.body.Body;
import de.dfki.reeti.body.RightEyelid;
import de.dfki.reeti.body.LeftEyelid;
import de.dfki.reeti.body.Neck;
import de.dfki.reeti.body.RightEye;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.Gender;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.reeti.animation.environment.Blinking;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.EventAnimationReeti;
import de.dfki.reeti.body.LeftCheek;
import de.dfki.reeti.body.LeftEar;
import de.dfki.reeti.body.MouthDownLip;
import de.dfki.reeti.body.MouthLeftCorner;
import de.dfki.reeti.body.MouthRightCorner;
import de.dfki.reeti.body.MouthUpperLip;
import de.dfki.reeti.body.RightCheek;
import de.dfki.reeti.body.RightEar;
import de.dfki.reeti.environment.SpeechBubbleFX;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.scene.effect.InnerShadow;
import javafx.scene.transform.Affine;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

/**
 * @author Beka Aptsiauri
 *         <p>
 *         This work is inspired by the stickmans drawn by Sarah Johnson
 *         (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot
 *         by Ross Ching in 2012
 */
public class Reeti extends Agent3D
{
    public enum LED
    {
        LEFTLED, RIGHTLED, BOTHLED
    }

    private static final double REETI_HEIGHT = 480;

    public Blinking mBlinking;
    public AnimationSchedulerReeti mAnimationSchedulerReeti;

    // body parts
    public Head mHead;
    public LeftEyelid mLeftEyelid;
    public LeftEye mLeftEye;
    public RightEye mRightEye;
    public LeftEar mLeftEar;
    public RightEar mRightEar;
    public RightEyelid mRightEyelid;
    public LeftCheek mLeftCheek;
    public RightCheek mRightCheek;
    public Mouth mMouth;
    public MouthLeftCorner mMouthLeftCorner;
    public MouthRightCorner mMouthRightCorner;
    public MouthUpperLip mMouthUpperLip;
    public MouthDownLip mMouthDownLip;
    public Neck mNeck;
    public Body mBody;
    // environment
    public SpeechBubbleFX mSpeechBubble;
    private StageRoom stageController = null;
    // logging
    public final Logger mLogger = Logger.getAnonymousLogger();

    //Movement
    private double mUpperLipOldPos = 0;
    private double mDownLipOldPos = 20;
    private double mLeftCornerOldPos = 8;
    private double mRightCornerOldPos = 8;
    private double mLeftEyelidOldPos = 100;
    private double mRightEyelidOldPos = 100;
    private double mLeftEye_X_OldPos = 40;
    private double mLeftEye_Y_OldPos = 42;
    private double mRightEye_X_OldPos = 60;
    private double mRightEye_Y_OldPos = 42;
    private double mLeftEarOldPos = 80;
    private double mRightEarOldPos = 80;
    private double mNeckRotatOldPos = 50;
    private double mNeckPanOldPos = 50;
    private double mNeckTiltOldPos = 50;

    private static Reeti sReeti;

    public Reeti(String name, Gender.TYPE gender, float scale, Dimension size)
    {
        mSize = size;
        this.mScale = scale;
        this.isFullScreen = true;
        this.mName = name;
        this.mType = gender;

        this.init();
        this.addAllParts();
        this.posOnScreen();
        sReeti = this;
    }

    public Reeti(String name, Gender.TYPE gender, float scale, double height)
    {
        this.mScale = scale;
        this.isFullScreen = false;
        this.stageHeight = height;
        this.mName = name;
        this.mType = gender;

        this.init();
        this.addAllParts();
        this.posOnScreen();
        sReeti = this;
    }

    public Reeti(String name, Gender.TYPE gender)
    {
        this.mName = name;
        this.mType = gender;

        this.init();
        this.addAllParts();
        this.posOnScreen();
        sReeti = this;
    }

    private void init()
    {
        mName = "Reeti";
        this.mHead = new Head(this);
        this.mLeftEyelid = new LeftEyelid(mHead);
        this.mLeftEye = new LeftEye(mHead);
        this.mRightEye = new RightEye(mHead);
        this.mLeftEar = new LeftEar(mHead);
        this.mRightEar = new RightEar(mHead);
        this.mRightEyelid = new RightEyelid(mHead);
        this.mLeftCheek = new LeftCheek(mHead);
        this.mRightCheek = new RightCheek(mHead);
        this.mMouth = new Mouth(mHead);
        this.mMouthLeftCorner = new MouthLeftCorner(mMouth);
        this.mMouthRightCorner = new MouthRightCorner(mMouth);
        this.mMouthUpperLip = new MouthUpperLip(mMouth);
        this.mMouthDownLip = new MouthDownLip(mMouth);
        this.mNeck = new Neck(mHead);
        this.mBody = new Body(mNeck);
        this.mSpeechBubble = new SpeechBubbleFX(mHead);

        this.setPrefHeight(mSize.height);
        this.setPrefWidth(mSize.width);
        this.setMinHeight(mSize.height);
        this.setMinWidth(mSize.width);

        InnerShadow is = new InnerShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new logFormatter());

        this.mLogger.addHandler(ch);
        this.mLogger.setUseParentHandlers(false);

        this.mAnimationSchedulerReeti = new AnimationSchedulerReeti(this);
        this.mAnimationSchedulerReeti.start();
    }



    @Override
    public AnimationReeti doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block)
    {
        EventAnimationReeti a = AnimationLoaderReeti.getInstance().loadEventAnimation(this, name, duration, block);

        a.setParameter(wts);

        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    @Override
    public StageRoom getStageController()
    {
        return stageController;
    }

    @Override
    public void setStageController(StageRoom s)
    {
        stageController = s;
    }

    @Override
    public void setShowName(boolean show)
    {

    }

    @Override
    public boolean isShowName()
    {
        return false;
    }

    @Override
    public void endAnimationScheduler()
    {

    }

    @Override
    public Gender.TYPE getType()
    {
        return null;
    }

    @Override
    public AnimationReeti doAnimation(String name, int duration, boolean block)
    {
        return doAnimation(name, duration, "", block);
    }

    @Override
    public AnimationReeti doAnimation(String name, int frequent, int actionDuration, boolean block)
    {
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, name, frequent, actionDuration, block);

        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    @Override
    public AnimationReeti doAnimation(String name, Object param, boolean block)
    {
        return doAnimation(name, -1, param, block);
    }

    public AnimationReeti doAnimation(String name, boolean block)
    {
        return doAnimation(name, -1, "", block);
    }

    @Override
    public AnimationReeti doAnimation(String name, int duration, Object param, boolean block)
    {
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, name, duration, block);

        a.setParameter(param); // this is for now only used by the Speech Bubble

        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }

        return a;
    }

    public void playAnimation(AnimationReeti a)
    {
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    public void posOnScreen(float... pos)
    {
        float mGeneralXTranslation;
        float mGeneralYTranslation;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Affine af = new Affine();
        int shiftFactor = (int) (REETI_HEIGHT - (REETI_HEIGHT * mScale));
        if (isFullScreen)
        {
            mGeneralYTranslation = (int) ((dim.getHeight() - REETI_HEIGHT) + shiftFactor + 100);
            if (pos.length != 0)
                mGeneralXTranslation = pos[0];
            else
                mGeneralXTranslation = 0;
        } else
        {
            mGeneralYTranslation = 350;
            //mGeneralYTranslation = (int) ((this.stageHeight - REETI_HEIGHT) + shiftFactor - 350);
            mGeneralXTranslation = 100;
        }
        af.appendTranslation(mGeneralXTranslation, mGeneralYTranslation);
        af.appendScale(mScale, mScale);
        this.getTransforms().clear();
        this.getTransforms().add(af);
    }

    @Override
    public FXParts getSpeechBubble()
    {
        return this.mSpeechBubble;
    }

    public void setScale(float scale)
    {
        mScale = scale;
    }


    private void addAllParts()
    {
        this.getChildren().addAll(mNeck, mHead, mBody, mSpeechBubble);
    }

    /**
     * @param color red, green, lightGreen, blue, darkBlue, turquoise, yellow, violer, white, swop
     */
    public void setLedColor(String color)
    {
        Color ledColor = checkColor(color);
        if (ledColor.equals(Color.BLACK))
        {
            ledOFF("B");
        } else
        {
            ledON(ledColor, ledColor, ledColor, 0.3f, 0.9f, 0.1f, "B");
        }
    }

    /**
     * @param color red, green, lightGreen, blue, darkBlue, turquoise, yellow, violer, white, swop
     * @param led   left, right, both
     */
    public void setLedColor(String color, LED led)
    {
        Color ledColor = checkColor(color);
        if (ledColor.equals(Color.BLACK))
        {
            switch (led)
            {
                case LEFTLED:
                    ledOFF("L");
                    break;
                case RIGHTLED:
                    ledOFF("R");
                    break;
                default:
                    ledOFF("B");
                    break;
            }
        } else
        {
            switch (led)
            {
                case LEFTLED:
                    ledON(ledColor, ledColor, ledColor, 0.3f, 0.9f, 0.1f, "L");
                    break;
                case RIGHTLED:
                    ledON(ledColor, ledColor, ledColor, 0.3f, 0.9f, 0.1f, "R");
                    break;
                default:
                    ledON(ledColor, ledColor, ledColor, 0.3f, 0.9f, 0.1f, "B");
                    break;
            }
        }

    }

    public void setLedColor(Color color, LED led)
    {
        switch (led)
        {
            case LEFTLED:
                ledON(color, color, color, 0.3f, 0.9f, 0.1f, "L");
                break;
            case RIGHTLED:
                ledON(color, color, color, 0.3f, 0.9f, 0.1f, "R");
                break;
            default:
                ledON(color, color, color, 0.3f, 0.9f, 0.1f, "B");
                break;
        }
    }

    public void ledON(Color color1, Color color2, Color color3,
                      float intensityForColor1,
                      float intensityForColor2,
                      float intensitiForColor3,
                      String cheek)
    {

        int size = mLeftCheek.getSize();

        InnerShadow ledOnShadow = new InnerShadow(BlurType.TWO_PASS_BOX, color3, 0.05 * size, intensityForColor1, 0, 0);
        ledOnShadow.setInput(new DropShadow(BlurType.TWO_PASS_BOX, color2, 0.05 * size, intensityForColor2, 0, 0));

        RadialGradient highlightGradient = new RadialGradient(0, 0,
                0.3 * size, 0.3 * size,
                0.29 * size,
                false, CycleMethod.NO_CYCLE,
                new Stop(intensitiForColor3, color1),
                new Stop(1.0, Color.TRANSPARENT));

        if (cheek.equalsIgnoreCase("L"))
        {
            mLeftCheek.getLed().setEffect(ledOnShadow);
            mLeftCheek.getLed().setFill(highlightGradient);
            mLeftCheek.getLedGroup().setVisible(true);
        } else if (cheek.equalsIgnoreCase("R"))
        {
            mRightCheek.getLed().setEffect(ledOnShadow);
            mRightCheek.getLed().setFill(highlightGradient);
            mRightCheek.getLedGroup().setVisible(true);
        } else if (cheek.equalsIgnoreCase("B"))
        {
            mLeftCheek.getLed().setEffect(ledOnShadow);
            mLeftCheek.getLed().setFill(highlightGradient);
            mRightCheek.getLed().setEffect(ledOnShadow);
            mRightCheek.getLed().setFill(highlightGradient);
            mLeftCheek.getLedGroup().setVisible(true);
            mRightCheek.getLedGroup().setVisible(true);
        }
    }

    public void ledOFF(String cheek)
    {
        if (cheek.equalsIgnoreCase("R"))
        {
            mRightCheek.getLedGroup().setVisible(false);
        } else if (cheek.equalsIgnoreCase("L"))
        {
            mLeftCheek.getLedGroup().setVisible(false);
        } else if (cheek.equalsIgnoreCase("B"))
        {
            mRightCheek.getLedGroup().setVisible(false);
            mLeftCheek.getLedGroup().setVisible(false);
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */

    public void rightLC(int pos, double... duration)
    {
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        pos = (pos * 16) / 100;
        double distance = mRightCornerOldPos - pos;
        this.mMouthRightCorner.setRightCornerRegulator(distance);
        mRightCornerOldPos = pos;
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "RightLC", (int) dur, pos, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void leftLC(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        pos = (pos * 16) / 100;
        double distance = mLeftCornerOldPos - pos;
        this.mMouthLeftCorner.setLeftCornerRegulator(distance);
        mLeftCornerOldPos = pos;
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "LeftLC", (int) dur, pos, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 0)
     */
    public void topLip(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }

        pos = (pos * 25) / 100;

        double distance = mUpperLipOldPos - pos;
        this.mMouthUpperLip.setUpperLipRegulator(distance);
        mUpperLipOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "UpperLip", (int) dur, pos, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 100)
     */
    public void bottomLip(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }

        pos = (pos * 20) / 100;

        double distance = pos - mDownLipOldPos;
        this.mMouthDownLip.setDownLipRegulator(-distance);
        mDownLipOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "DownLip", (int) dur, pos, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 30)
     */
    public void leftEyeTilt(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];

        if (pos > 100)
            pos = 100;
        else if (pos < 20)
            pos = 20;

        double rot = mLeftEye_Y_OldPos - pos;
        mLeftEye_Y_OldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "LeftEye_X", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 40)
     */
    public void leftEyePan(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mLeftEye_X_OldPos - pos;
        mLeftEye_X_OldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "LeftEye_Y", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 30)
     */
    public void rightEyeTilt(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];

        if (pos > 100)
            pos = 100;
        else if (pos < 23)
            pos = 23;

        double rot = mRightEye_Y_OldPos - pos;
        mRightEye_Y_OldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "RightEye_X", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 60)
     */
    public void rightEyePan(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mRightEye_X_OldPos - pos;
        mRightEye_X_OldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "RightEye_Y", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 100)
     */
    public void leftEyeLid(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mLeftEyelidOldPos - pos;
        mLeftEyelidOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "BlinkLeftEyelid", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 100)
     */
    public void rightEyeLid(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mRightEyelidOldPos - pos;
        mRightEyelidOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "BlinkRightEyelid", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void leftEar(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mLeftEarOldPos - pos;
        mLeftEarOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "LeftEarMovement", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void rightEar(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mRightEarOldPos - pos;
        mRightEarOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "RightEarMovement", (int) dur, (int) -rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void neckRotat(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mNeckRotatOldPos - pos;
        mNeckRotatOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "NeckRotation", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void neckTilt(int pos, double... duration)
    {
        if (pos == -1)
            return;

        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }

        double rot = mNeckPanOldPos - pos;
        rot = (rot * 40) / 100;
        mNeckPanOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "NeckPan", (int) dur, (int) rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    /**
     * @param pos a int between 0 and 100 (default value is 50)
     */
    public void neckPan(int pos, double... duration)
    {
        if (pos == -1)
            return;
        double dur = (duration.length == 0) ? 500 : duration[0];
        if (pos > 100)
        {
            pos = 100;
        }
        double rot = mNeckTiltOldPos - pos;
        rot = (rot * 40) / 100;
        mNeckTiltOldPos = pos;

        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "NeckTilt", (int) dur, (int) -rot, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    public void defaultPose()
    {
        AnimationReeti a = AnimationLoaderReeti.getInstance().loadAnimation(this, "Default", 100, false);
        try
        {
            mAnimationLaunchControl.acquire();
            a.start();
        } catch (InterruptedException ex)
        {
            mLogger.severe(ex.getMessage());
        }
    }

    private Color checkColor(String color)
    {
        Color ledColor = null;
        switch (color)
        {
            case "red":
                ledColor = Color.RED;
                break;
            case "green":
                ledColor = Color.GREEN;
                break;
            case "lightGreen":
                ledColor = Color.LIGHTGREEN;
                break;
            case "blue":
                ledColor = Color.BLUE;
                break;
            case "darkBlue":
                ledColor = Color.DARKBLUE;
                break;
            case "turquoise":
                ledColor = Color.TURQUOISE;
                break;
            case "yellow":
                ledColor = Color.YELLOW;
                break;
            case "violet":
                ledColor = Color.VIOLET;
                break;
            case "white":
                ledColor = Color.WHITE;
                break;
            case "stop":
                ledColor = Color.BLACK;
                break;
        }
        return ledColor;
    }

    //VSM static stuff
    public static void vsm_ledOn(String color)
    {
        sReeti.setLedColor(color);
    }

    public static void vsm_ledOf()
    {
        sReeti.ledOFF("B");
    }

    public static void vsm_rightLC(int pos, int duration)
    {
        sReeti.rightLC(pos, duration);
    }

    public static void vsm_leftLC(int pos, int duration)
    {
        sReeti.leftLC(pos, duration);
    }

    public static void vsm_topLip(int pos, int duration)
    {
        sReeti.topLip(pos, duration);
    }

    public static void vsm_bottomLip(int pos, int duration)
    {
        sReeti.bottomLip(pos, duration);
    }

    public static void vsm_leftEyeTilt(int pos, int duration)
    {
        sReeti.leftEyeTilt(pos, duration);
    }

    public static void vsm_rightEyeTilt(int pos, int duration)
    {
        sReeti.rightEyeTilt(pos, duration);
    }

    public static void vsm_leftEyePan(int pos, int duration)
    {
        sReeti.leftEyePan(pos, duration);
    }

    public static void vsm_rightEyePan(int pos, int duration)
    {
        sReeti.rightEyePan(pos, duration);
    }

    public static void vsm_leftEyeLid(int pos, int duration)
    {
        sReeti.leftEyeLid(pos, duration);
    }

    public static void vsm_rightEyeLid(int pos, int duration)
    {
        sReeti.rightEyeLid(pos, duration);
    }

    public static void vsm_leftEar(int pos, int duration)
    {
        sReeti.leftEar(pos, duration);
    }

    public static void vsm_rightEar(int pos, int duration)
    {
        sReeti.rightEar(pos, duration);
    }

    public static void vsm_neckRotat(int pos, int duration)
    {
        sReeti.neckRotat(pos, duration);
    }

    public static void vsm_neckPan(int pos, int duration)
    {
        sReeti.neckPan(pos, duration);
    }

    public static void vsm_neckTilt(int pos, int duration)
    {
        sReeti.neckTilt(pos, duration);
    }

    public static void vsm_defaultPose()
    {
        sReeti.defaultPose();
    }

}
