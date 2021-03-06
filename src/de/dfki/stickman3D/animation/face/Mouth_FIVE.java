package de.dfki.stickman3D.animation.face;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class Mouth_FIVE extends AnimationStickman3D
{

    public Mouth_FIVE(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    public void playAnimation()
    {
        // smile
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "FIVE"));
        playAnimationPart(20);
    }
}
