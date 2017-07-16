/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.common.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class FadeIn extends AnimationStickmanFX
{

    private StickmanFX mStickmanFX;

    public FadeIn(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation()
    {
//		star fade in
        mStickmanFX.starShowControler = true;
        mStickmanFX.starShowC = true;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mStarsFX, "shape", "STARSFADEIN"));
        playAnimationPart(1000);

//		character fade in
        mStickmanFX.starShowControler = false;
        mStickmanFX.setCharacterInvisible = true;
        mStickmanFX.fadeControler = false;

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mHeadFX, "shape", "DEFAULT"));

        if (mStickmanFX.mType == Gender.TYPE.MALE)
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "shape", "DEFAULT"));
        } else
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "shape", "DEFAULT"));
        }

        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mNeckFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightShoulderFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftShoulderFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightHandFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "shape", "DEFAULT"));
        //mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightFootFX, "shape", "DEFAULT"));
        //mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "shape", "DEFAULT"));
        playAnimationPart(1000);
        mStickmanFX.setCharacterInvisible = false;

//		stars fade out
        mStickmanFX.starShowC = true;
        mStickmanFX.setCharacterInvisible = false;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mStarsFX, "shape", "STARSFADEOUT"));
        playAnimationPart(500);

        // bring upper arm and fore arm in position
        int rotationUnit = 10;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 16));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 16));
        playAnimationPart(200);
        pauseAnimation(100);

        // wave right
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 4));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 4));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        // wave right
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 4));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 4));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);
        pauseAnimation(200);

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 16));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 16));
        playAnimationPart(20);

        mStickmanFX.setCharacterInvisible = false;
        mStickmanFX.starShowControler = false;
        mStickmanFX.starShowC = false;

    }
}
