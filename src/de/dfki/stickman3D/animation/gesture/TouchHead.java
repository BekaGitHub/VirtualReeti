/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.common.Gender;

import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

/**
 * @author Beka
 */
public class TouchHead extends AnimationStickman3D
{

    public TouchHead()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public TouchHead(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {

        if (mStickman3D.mType == Gender.TYPE.MALE)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -100));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", 100));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -82));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 130));
            playAnimationPart(500);
        } else
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -100));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", 50));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -82));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 170));
            playAnimationPart(500);
        }

        for (int i = 0; i < 4; i++)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", -5));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger4, "rotate", 40));
            playAnimationPart(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", -5));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger3, "rotate", 70));
            playAnimationPart(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", -5));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger2, "rotate", 70));
            playAnimationPart(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", 5));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger3, "rotate", -70));
            playAnimationPart(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", 5));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger2, "rotate", -70));
            playAnimationPart(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", 5));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger4, "rotate", -40));
            playAnimationPart(100);
        }

        if (mStickman3D.mType == Gender.TYPE.MALE)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", 100));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", -100));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 82));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -130));
            playAnimationPart(500);
        } else
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", 100));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", -50));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", 82));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -170));
            playAnimationPart(500);
        }

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);
    }
}
