/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class SurprisedStart extends AnimationStickman3D
{

    public SurprisedStart(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {

        // surprised
        AnimationStickman3D.isSurprisedInAction = true;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "SURPRISED"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
