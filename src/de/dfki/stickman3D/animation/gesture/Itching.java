package de.dfki.stickman3D.animation.gesture;

import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

/**
 * @author Beka
 */
public class Itching extends AnimationStickman3D
{

    public Itching()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Itching(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", -25));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -35));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", 65));

        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", 10));
        playAnimationPart(mDuration);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "zrotate", 8));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "zrotate", -8));
        playAnimationPart(50);

        for (int i = 0; i < 4; i++)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", 10));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "rotate", 60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "rotate", 70));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "rotate", 80));
            playAnimationPart(200);

            pauseAnimation(200);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", -10));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "rotate", -60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "rotate", -70));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "rotate", -80));
            playAnimationPart(200);
        }

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "zrotate", -8));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "zrotate", 8));
        playAnimationPart(50);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", 25));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", 35));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -65));

        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -10));

        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);

    }
}
