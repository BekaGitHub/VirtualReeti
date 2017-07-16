package de.dfki.stickmanFX.animation.gesturefx;

import java.util.ArrayList;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;

/**
 * @author Beka
 */
public class CoverMouth extends AnimationStickmanFX
{

    public CoverMouth()
    {
        mAnimType = ANIMTYPE.Gesture;
    }

    public CoverMouth(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        int rotationUnit = 16;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftShoulderFX, "rotate", -rotationUnit * 3));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 9));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 9));
        playAnimationPart(200);

        pauseAnimation(1200);

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftShoulderFX, "rotate", +rotationUnit * 3));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 9));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 9));
        playAnimationPart(300);
    }
}
