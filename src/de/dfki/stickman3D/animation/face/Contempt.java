/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class Contempt extends AnimationStickman3D
{

    public Contempt()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Contempt(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // Contempt
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "CONTEMPT"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "CONTEMPT"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "CONTEMPT"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no Contempt
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "CONTEMPTEND"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "CONTEMPTEND"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "CONTEMPTEND"));
        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
