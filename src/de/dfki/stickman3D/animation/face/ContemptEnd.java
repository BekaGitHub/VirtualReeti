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
 * @author Beka Aptsiauri
 */
public class ContemptEnd extends AnimationStickman3D
{

    public ContemptEnd(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // Contempt end
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "CONTEMPTEND"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "CONTEMPTEND"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "CONTEMPTEND"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
