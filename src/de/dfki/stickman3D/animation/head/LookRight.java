package de.dfki.stickman3D.animation.head;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class LookRight extends AnimationStickman3D
{

    public LookRight()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public LookRight(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "LOOKRIGHT"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "LOOKRIGHT"));
        playAnimationPart(100);

        pauseAnimation(100);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "LOOKRIGHTEND"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "LOOKRIGHTEND"));
        playAnimationPart(100);

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);
    }
}
