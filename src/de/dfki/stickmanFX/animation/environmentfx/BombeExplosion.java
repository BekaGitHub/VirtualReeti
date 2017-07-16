/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import java.util.ArrayList;

import de.dfki.common.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import javafx.application.Platform;
import javafx.scene.paint.Color;

/**
 * @author Beka
 */
public class BombeExplosion extends AnimationStickmanFX
{

    public BombeExplosion(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    @Override
    public void playAnimation()
    {
        int translationUnit = 8;
        int rotationUnit = 10;

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mBombeFX, "shape", "BOMBETRANSITION"));
        playAnimationPart(mDuration);

        // headTilt
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mHeadFX, "tilt", translationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE)
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "tilt", translationUnit));
        } else
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "tilt", translationUnit));
        }

        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "tilt", translationUnit));

        // embarrassed
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "EMBARRASSED"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "EMBARRASSED"));
        playAnimationPart(mDuration);

        pauseAnimation(2000);

        //end HeadTilt
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mHeadFX, "tilt", -translationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE)
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "tilt", -translationUnit));
        } else
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "tilt", -translationUnit));
        }

        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "tilt", -translationUnit));

        //change embarrassed with angry
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "EMBARRASSEDEND"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "SURPRISED"));
        playAnimationPart(mDuration);

        pauseAnimation(1000);

        //Blink
        for (int i = 0; i < 3; i++)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "SURPRISED"));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "SURPRISED"));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "BLINK"));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "BLINK"));
            playAnimationPart(100);

            pauseAnimation(300);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "SURPRISED"));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "SURPRISED"));
            playAnimationPart(100);

        }

        pauseAnimation(1500);

        // headTilt
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mHeadFX, "tilt", translationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE)
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "tilt", translationUnit));
        } else
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "tilt", translationUnit));
        }

        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "tilt", translationUnit));
        // embarrassed
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "EMBARRASSED"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "EMBARRASSED"));
        playAnimationPart(mDuration);

        //playAnimationPart(mDuration);
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", -rotationUnit * 5));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", rotationUnit * 2));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "rotate", rotationUnit * 3));
        playAnimationPart(mDuration);

        for (int i = 0; i < 3; i++)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", -rotationUnit));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "rotate", -rotationUnit * 3));
            playAnimationPart(200);

            pauseAnimation(150);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", rotationUnit));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "rotate", rotationUnit * 3));
            playAnimationPart(200);
        }

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mBombeFX, "shape", "BOMBEEXPLOSION"));
        playAnimationPart(mDuration);

        //mStickmanSwing.mBodyFX.currentColor = Color.BLACK;
        Platform.runLater(() -> mStickmanFX.mBodyFX.paintFrontOrientation(Color.BLACK));
        mStickmanFX.mHeadFX.mColor = Color.BLACK;

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mBombeFX, "shape", "DEFAULT"));
        playAnimationPart(20);

        mStickmanFX.mLeftHandFX.setVisible(false);
        mStickmanFX.mLeftForeArmFX.setVisible(false);
        mStickmanFX.mLeftUpperArmFX.setVisible(false);

        mStickmanFX.mRightHandFX.setVisible(false);
        mStickmanFX.mRightForeArmFX.setVisible(false);
        mStickmanFX.mRightUpperArmFX.setVisible(false);

        mStickmanFX.mRightShoulderFX.setVisible(false);
        mStickmanFX.mLeftShoulderFX.setVisible(false);
        mStickmanFX.mNeckFX.setVisible(false);
        mStickmanFX.mLeftEyebrowFX.setVisible(false);
        mStickmanFX.mRightEyebrowFX.setVisible(false);
        mStickmanFX.mMouthFX.setVisible(false);
        mStickmanFX.mFaceWrinkleFX.setVisible(false);

        mAnimationPart = new ArrayList<>();
        mStickmanFX.mHeadFX.translateRight = true;
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mHeadFX, "Translate", -2000));
        if (mStickmanFX.mType == Gender.TYPE.FEMALE)
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "Translate", -2000));
        } else
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "Translate", -2000));
        }
        mStickmanFX.mBodyFX.setVisible(false);
        playAnimationPart(mDuration);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "rotate", 90));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "translate", 100));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", 70));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "translate", 120));
        playAnimationPart(100);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "rotate", 90));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "translate", 155));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", 120));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "translate", 160));
        playAnimationPart(100);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "rotate", 90));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "rotate", 170));
        playAnimationPart(100);

        mStickmanFX.mLeftEyeFX.setVisible(false);
        mStickmanFX.mRightEyeFX.setVisible(false);

    }
}
