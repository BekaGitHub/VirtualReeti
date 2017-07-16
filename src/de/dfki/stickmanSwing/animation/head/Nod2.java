/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.head;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;

import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
////////////nod 3 time by Guo
public class Nod2 extends AnimationSwing
{

    public Nod2(StickmanSwing sm, int duration, boolean block)
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
            mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "translate", translationUnit));
            mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mRightEye, "translate", translationUnit));
            mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "translate", translationUnit));
            mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "translate", translationUnit));
            mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mHead, "translate", translationUnit));
            mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mMouth, "translate", translationUnit));
            playAnimationPart(200);
            pauseAnimation(200);

            // head up
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "translate", -translationUnit));
            mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mRightEye, "translate", -translationUnit));
            mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "translate", -translationUnit));
            mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "translate", -translationUnit));
            mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mHead, "translate", -translationUnit));
            mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mMouth, "translate", -translationUnit));

            playAnimationPart(200);
            pauseAnimation(200);
        }
    }
}
