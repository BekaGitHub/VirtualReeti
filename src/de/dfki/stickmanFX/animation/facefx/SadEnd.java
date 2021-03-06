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
 * @author Beka
 */
public class SadEnd extends AnimationStickmanFX
{

    public SadEnd()
    {
        super();
    }

    public SadEnd(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // no sad
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SADEND"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "DISGUSTEDEND"));  // add by Robbie
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "DISGUSTEDEND")); // add by Robbie
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
