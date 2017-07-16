package de.dfki.stickmanFX.animation.headfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;

import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class LookLeft extends AnimationStickmanFX
{

    public LookLeft(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        int translationUnit = 3;

        // look left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOOKLEFT"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOOKLEFT"));
        playAnimationPart(20);

//		// blink up
//		mAnimationPart = new ArrayList<>();
//		mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mLeftEye, "shape", "DEFAULT"));
//		mAnimationPart.add(new AnimationContentSwing(mStickmanSwing.mRightEye, "shape", "DEFAULT"));
//		playAnimationPart(2);
    }
}
