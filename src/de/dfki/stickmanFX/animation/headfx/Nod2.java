/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.headfx;

import java.util.ArrayList;

import de.dfki.common.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;

/**
 * @author Patrick Gebhard
 */
////////////nod 3 time by Guo
public class Nod2 extends AnimationStickmanFX
{

    public Nod2(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        int translationUnit = 3;

        for (int i = 0; i < 3; i++)
        {
            // head down
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "translate", translationUnit));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "translate", translationUnit));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "translate", translationUnit));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "translate", translationUnit));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mHeadFX, "translate", translationUnit));

            if (mStickmanFX.mType == Gender.TYPE.MALE)
            {
                mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "translate", translationUnit));
            } else
            {
                mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "translate", translationUnit));
            }

            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "translate", translationUnit));
            playAnimationPart(200);
            pauseAnimation(200);

            // head up
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "translate", -translationUnit));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "translate", -translationUnit));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "translate", -translationUnit));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "translate", -translationUnit));
            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mHeadFX, "translate", -translationUnit));

            if (mStickmanFX.mType == Gender.TYPE.MALE)
            {
                mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "translate", -translationUnit));
            } else
            {
                mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "translate", -translationUnit));
            }

            mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "translate", -translationUnit));

            playAnimationPart(200);
            pauseAnimation(200);
        }
    }
}
