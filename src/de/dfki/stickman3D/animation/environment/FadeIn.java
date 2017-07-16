/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class FadeIn extends AnimationStickman3D
{

    public FadeIn()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public FadeIn(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
        mStickman3D = sm;
    }

    @Override
    public void playAnimation()
    {

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mStars, "shape", "STARSFADEIN"));
        playAnimationPart(500);

        pauseAnimation(500);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mHead, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mNose, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEar, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEar, "shape", "FADEIN"));
        if (mStickman3D.mType == Gender.TYPE.MALE)
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mMaleHair, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mNeck, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mUpperBody, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mDownBody, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "shape", "FADEIN"));

        mAnimationPart.add(new AnimationContent3D(mStickman3D.mStars, "shape", "STARSFADEOUT"));

        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger1, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger1, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger2, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger3, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger4, "shape", "FADEIN"));
        if (mStickman3D.mType == Gender.TYPE.FEMALE)
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mFemaleHair, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperLeg, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeLeg, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFoot, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperLeg, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeLeg, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFoot, "shape", "FADEIN"));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
