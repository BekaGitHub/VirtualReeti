/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.Gender;

import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

/**
 * @author Beka
 */
public class Fear extends AnimationStickman3D
{

    public Fear()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Fear(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // fear
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "FEAR"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "SAD"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "SAD"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mHead, "rotate", 10));

        if (mStickman3D.mType == Gender.TYPE.MALE)
        {
            // Left Hand
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", -70));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -100));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -30));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -130));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", 20));

            // Right Hand
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", 70));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -95));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", 30));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 130));

        } else
        {
            // Left Hand
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -55));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", -60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -105));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -25));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -200));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", 20));

            // Right Hand
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", 60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -100));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", 25));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 200));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", 20));
        }
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no fear
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "FEAREND"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "SADEND"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "SADEND"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mHead, "rotate", -10));

        if (mStickman3D.mType == Gender.TYPE.MALE)
        {
            // Left Hand
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", 60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", 70));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", 100));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", 30));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", 130));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", -20));

            // Right Hand
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", 60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", -70));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 95));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", -30));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -130));
        } else
        {
            // Left Hand
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", 55));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", 60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", 105));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", 25));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", 200));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", -20));

            // Right Hand
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", 60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", -60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 100));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", -25));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -200));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", -20));

        }
        playAnimationPart(mDuration);

        // pauseAnimation(1200);
        // mAnimationPart = new ArrayList<>();
        // mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mHead,
        // "yrotate", -90));
        // mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mUpperBody,
        // "yrotate", -90));
        // playAnimationPart(500);
        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
