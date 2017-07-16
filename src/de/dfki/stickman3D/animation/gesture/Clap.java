/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

/**
 * @author Beka
 */
public class Clap extends AnimationStickman3D
{

    public Clap()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Clap(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -30));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -30));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -70));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -90));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -120));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -10));
        playAnimationPart(500);

        for (int i = 0; i < 10; i++)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", 10));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", -15));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 17));
            playAnimationPart(200);

            pauseAnimation(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -10));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", 15));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -17));
            playAnimationPart(200);
        }

        pauseAnimation(1000);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", 30));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", 30));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", 70));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 90));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", 120));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 10));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);

    }

}
