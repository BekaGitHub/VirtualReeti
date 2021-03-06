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
public class LovedEnd extends AnimationSwing
{

    public LovedEnd(StickmanSwing sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // loved end
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mMouth, "shape", "SMILEEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "LOVEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "LOVEDEND"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
