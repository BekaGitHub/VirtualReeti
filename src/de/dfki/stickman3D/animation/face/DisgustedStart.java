/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author beka Aptsiauri
 */
public class DisgustedStart extends AnimationStickman3D
{

    public DisgustedStart(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // disgusted
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEyebrow, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEyebrow, "shape", "DISGUSTED"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
