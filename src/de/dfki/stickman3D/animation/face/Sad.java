/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class Sad extends AnimationStickman3D
{

    public Sad()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Sad(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // sad
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "SAD"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "SAD"));  // add by Robbie
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "SAD")); // add by Robbie
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no sad
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "SADEND"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "SADEND"));  // add by Robbie
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "SADEND")); // add by Robbie
        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
