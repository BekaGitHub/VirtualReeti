package de.dfki.stickman3D;

import de.dfki.common.agents.Agent3D;
import de.dfki.common.parts.FXParts;
import de.dfki.stickman3D.body.*;
import de.dfki.stickman3D.body.Head3D;
import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.Gender;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickman3D.animation.environment.Blinking;
import de.dfki.stickman3D.animation.environment.Breathing;
import de.dfki.stickman3D.animation.environment.IdleBehavior;
import de.dfki.stickman3D.animationlogic.*;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import de.dfki.stickman3D.animationlogic.EventAnimation3D;
import de.dfki.stickman3D.environment.SpeechBubble3D;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Affine;

import java.awt.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

/**
 * @author Beka Aptsiauri
 *         <p>
 *         This work is inspired by the stickmans drawn by Sarah Johnson
 *         (www.sarah-johnson.com) in the Valentine music video from Kina Grannis shot
 *         by Ross Ching in 2012
 */
public class Stickman3D extends Agent3D
{
    private Text nameText = new Text();
    //steuert leaveSpeed von GoDown und ComeUp
    public double leaveSpeed = 0;

    public static String sbackground = null;
    public IdleBehavior mIdleBehavior = null;
    public Breathing mBreathing = null;
    public Blinking mBlinking = null;

    public AnimationScheduler3D mAnimationSchedulerFX;

    public Head3D mHead;
    public Nose3D mNose;
    public MaleHair3D mMaleHair;
    public FemaleHair3D mFemaleHair;
    public LeftEyebrow3D mLeftEyebrow;
    public LeftEye3D mLeftEye;
    public LeftEar3D mLeftEar;
    public RightEar3D mRightEar;
    public RightEyebrow3D mRightEyebrow;
    public RightEye3D mRightEye;
    public Mouth3D mMouth;
    public Neck3D mNeck;
    public FaceWrinkle3D mFaceWrinkle;
    public UpperBody3D mUpperBody;
    public DownBody3D mDownBody;
    public LeftUpperArm3D mLeftUpperArm;
    public LeftForeArm3D mLeftForeArm;
    public LeftWrist3D mLeftWrist;
    public LeftFinger1 mLeftFinger1;
    public LeftFinger2 mLeftFinger2;
    public LeftFinger3 mLeftFinger3;
    public LeftFinger4 mLeftFinger4;
    public RightUpperArm3D mRightUpperArm;
    public RightForeArm3D mRightForeArm;
    public RightWrist3D mRightWrist;
    public RightFinger1 mRightFinger1;
    public RightFinger2 mRightFinger2;
    public RightFinger3 mRightFinger3;
    public RightFinger4 mRightFinger4;
    public LeftUpperLeg3D mLeftUpperLeg;
    public LeftForeLeg3D mLeftForeLeg;
    public LeftFoot3D mLeftFoot;
    public Stars3D mStars;
    public RightUpperLeg3D mRightUpperLeg;
    public RightForeLeg3D mRightForeLeg;
    public RightFoot3D mRightFoot;
    public UpperBodyAndHead3D mUpperBodyAndHead;
    // environment
    public SpeechBubble3D mSpeechBubble;
    private StageRoom stageController = null;
    // logging
    public final Logger mLogger = Logger.getAnonymousLogger();

    public Stickman3D(String name, Gender.TYPE gender, float scale, Dimension size)
    {
        this.mSize = size;
        this.mScale = scale;
        this.isFullScreen = true;
        this.mName = name;
        this.mType = gender;

        this.init();
        this.addAllParts();
        this.update();
    }

    public Stickman3D(String name, Gender.TYPE gender, float scale, double height)
    {
        this.mScale = scale;
        this.isFullScreen = false;
        this.stageHeight = height;
        this.mName = name;
        this.mType = gender;

        this.init();
        this.addAllParts();
        this.update();
    }

    public Stickman3D(String name, Gender.TYPE gender)
    {
        this.mName = name;
        this.mType = gender;
        this.isFullScreen = true;
        this.init();
        this.addAllParts();
        this.update();
    }

    private void init()
    {
        this.mName = "Stickman3D";
        this.mHead = new Head3D(this);
        if (this.mType == Gender.TYPE.MALE)
            this.mMaleHair = new MaleHair3D(this);
        else
            this.mFemaleHair = new FemaleHair3D(this);
        this.mLeftEyebrow = new LeftEyebrow3D(mHead);
        this.mLeftEye = new LeftEye3D(mHead);
        this.mLeftEar = new LeftEar3D(mHead);
        this.mRightEar = new RightEar3D(mHead);
        this.mRightEyebrow = new RightEyebrow3D(mHead);
        this.mRightEye = new RightEye3D(mHead);
        this.mNose = new Nose3D(mHead);
        this.mMouth = new Mouth3D(mHead);
        this.mFaceWrinkle = new FaceWrinkle3D(mHead);
        this.mNeck = new Neck3D(mHead);
        this.mUpperBody = new UpperBody3D(mNeck);
        this.mDownBody = new DownBody3D(mUpperBody);
        this.mLeftUpperArm = new LeftUpperArm3D(mUpperBody);
        this.mLeftForeArm = new LeftForeArm3D(mLeftUpperArm);
        this.mLeftWrist = new LeftWrist3D(mLeftForeArm);
        this.mLeftFinger1 = new LeftFinger1(mLeftWrist);
        this.mLeftFinger2 = new LeftFinger2(mLeftWrist);
        this.mLeftFinger3 = new LeftFinger3(mLeftWrist);
        this.mLeftFinger4 = new LeftFinger4(mLeftWrist);
        this.mRightUpperArm = new RightUpperArm3D(mUpperBody);
        this.mRightForeArm = new RightForeArm3D(mRightUpperArm);
        this.mRightWrist = new RightWrist3D(mRightForeArm);
        this.mRightFinger1 = new RightFinger1(mRightWrist);
        this.mRightFinger2 = new RightFinger2(mRightWrist);
        this.mRightFinger3 = new RightFinger3(mRightWrist);
        this.mRightFinger4 = new RightFinger4(mRightWrist);
        this.mLeftUpperLeg = new LeftUpperLeg3D(mDownBody);
        this.mLeftForeLeg = new LeftForeLeg3D(mLeftUpperLeg);
        this.mLeftFoot = new LeftFoot3D(mLeftForeLeg);
        this.mStars = new Stars3D(mUpperBody);
        this.mRightUpperLeg = new RightUpperLeg3D(mDownBody);
        this.mRightForeLeg = new RightForeLeg3D(mRightUpperLeg);
        this.mRightFoot = new RightFoot3D(mRightForeLeg);
        this.mUpperBodyAndHead = new UpperBodyAndHead3D(mHead, mUpperBody, mNeck);
        this.mSpeechBubble = new SpeechBubble3D(mHead);

        this.setPrefHeight(mSize.height);
        this.setPrefWidth(mSize.width);
        this.setMinHeight(mSize.height);
        this.setMinWidth(mSize.width);

        InnerShadow is = new InnerShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);

        this.nameText.setEffect(is);
        this.nameText.setX(20);
        this.nameText.setY(100);
        this.nameText.setText(mName);
        this.nameText.setFill(Color.YELLOW);
        this.nameText.setFont(Font.font(null, FontWeight.BOLD, 30));

        if (this.mType == Gender.TYPE.MALE)
        {
            this.nameText.setTranslateX(-80);
            this.nameText.setTranslateY(350);
        } else
        {
            this.nameText.setTranslateX(-90);
            this.nameText.setTranslateY(350);
        }
        this.nameText.setTranslateZ(-120);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new logFormatter());

        this.mLogger.addHandler(ch);
        this.mLogger.setUseParentHandlers(false);

        this.mAnimationSchedulerFX = new AnimationScheduler3D(this);
        this.mAnimationSchedulerFX.start();
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
    public AnimationStickman3D doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block)
    {
        EventAnimation3D a = AnimationLoader3D.getInstance().loadEventAnimation(this, name, duration, block);
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
    public AnimationStickman3D doAnimation(String name, int duration, boolean block)
    {
        return doAnimation(name, duration, "", block);
    }

    @Override
    public AnimationStickman3D doAnimation(String name, int frequent, int actionDuration, boolean block)
    {
        AnimationStickman3D a = AnimationLoader3D.getInstance().loadAnimation(this, name, frequent, actionDuration, block);

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
    public AnimationStickman3D doAnimation(String name, Object param, boolean block)
    {
        return doAnimation(name, -1, param, block);
    }

    public FXParts getSpeechBubble()
    {
        return this.mSpeechBubble;
    }

    public AnimationStickman3D doAnimation(String name, boolean block)
    {
        return doAnimation(name, -1, "", block);
    }

    @Override
    public AnimationStickman3D doAnimation(String name, int duration, Object param, boolean block)
    {
        AnimationStickman3D a = AnimationLoader3D.getInstance().loadAnimation(this, name, duration, block);
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

    public void playAnimation(AnimationStickman3D a)
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

    public void update()
    {
        float mGeneralXTranslation;
        float mGeneralYTranslation;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        double StickmanHeight = this.mHead.getHeadMeshView().getBoundsInParent().getHeight()
                + this.mNeck.getNeckMeshView().getBoundsInParent().getHeight()
                + this.mUpperBody.getBodyMeshView().getBoundsInParent().getHeight()
                + this.mDownBody.getBodyMeshView().getBoundsInParent().getHeight()
                + this.mLeftUpperLeg.getLeftUpperLegMesh().getBoundsInParent().getHeight()
                + this.mLeftForeLeg.getLeftForeLegMesh().getBoundsInParent().getHeight()
                + this.mLeftFoot.getLeftFootMeshView().getBoundsInParent().getHeight();

        Affine af = new Affine();
        int shiftFactor = (int) (StickmanHeight - (StickmanHeight * mScale));
        if (isFullScreen)
        {
            mGeneralYTranslation = (int) ((dim.getHeight() - StickmanHeight) + shiftFactor + 40);
            mGeneralXTranslation = 50;
        } else
        {
            mGeneralYTranslation = (int) ((this.stageHeight - StickmanHeight) + shiftFactor - 350);
            mGeneralXTranslation = 100;
        }
        af.appendTranslation(mGeneralXTranslation, mGeneralYTranslation);
        af.appendScale(mScale, mScale);
        af.appendTranslation(0, leaveSpeed); // Added by Robbie, GoDown
        this.getTransforms().clear();
        this.getTransforms().add(af);
    }

    public void setScale(float scale)
    {
        mScale = scale;
    }

    private void addAllParts()
    {

        this.getChildren().addAll(
                mDownBody, mStars, mSpeechBubble, nameText, mUpperBodyAndHead);

    }

    public void hideAllPartsWithout(Pane p)
    {
        this.getChildren().forEach(child
                ->
        {
            if (!child.equals(p))
            {
                child.setVisible(false);
            }
        });
    }

    public void showAllParts()
    {
        this.getChildren().forEach(child
                ->
        {
            child.setVisible(true);
        });
    }
}
