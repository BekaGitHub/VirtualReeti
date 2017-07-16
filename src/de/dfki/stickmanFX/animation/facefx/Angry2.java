/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.facefx;

import de.dfki.common.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Angry2 extends AnimationStickmanFX
{

    StickmanFX mStickmanFX;
    int rotationUnit;

    public Angry2()
    {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    /**
     * @param sm       StickmanSwing
     * @param duration Control the speed of the movement from one emotion state
     *                 to another emotion state.
     * @param block    block or not the others movements, when one movement is not
     *                 finished.
     */
    public Angry2(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation()
    {
        if (mStickmanFX.mType == Gender.TYPE.MALE)
        {
            rotationUnit = 20;
        } else
        {
            rotationUnit = 30;
        }
        // angry
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRY"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));

        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -(rotationUnit + 3)));

        if (mStickmanFX.mType == Gender.TYPE.MALE)
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit));
        } else
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit - 20));
        }

        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit));

        playAnimationPart(mDuration);

        //foot
        for (int i = 0; i < 8; i++)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightFootFX, "rotate", 40));
            playAnimationPart(200);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightFootFX, "rotate", -40));
            playAnimationPart(100);
        }

        pauseAnimation(1200);

        // no angry
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRYEND"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));

        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit + 3));

        if (mStickmanFX.mType == Gender.TYPE.MALE)
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit));
        } else
        {
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -(rotationUnit - 20)));
        }

        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit));

        playAnimationPart(20);
    }
}
