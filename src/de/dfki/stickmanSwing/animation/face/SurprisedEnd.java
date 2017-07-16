/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;

import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class SurprisedEnd extends AnimationSwing
{

    public SurprisedEnd(StickmanSwing sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {

        // surprised end
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mLeftEyebrow, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "SURPRISEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mRightEyebrow, "shape", "SURPRISEDEND"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
