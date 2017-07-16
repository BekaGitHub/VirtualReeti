/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.facefx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;

import java.util.ArrayList;

/**
 * @author beka Aptsiauri
 */
public class DisgustedStart extends AnimationStickmanFX
{

    public DisgustedStart()
    {
        super();
    }

    public DisgustedStart(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // disgusted
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "DISGUSTED"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
