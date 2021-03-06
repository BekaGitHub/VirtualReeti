/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;

import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class SurprisedStart extends AnimationSwing
{

    public SurprisedStart(StickmanSwing sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {

        // surprised start
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "SURPRISED"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
