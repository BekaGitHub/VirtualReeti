/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.facefx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;

import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class Embarrassed extends AnimationStickmanFX
{

    public Embarrassed()
    {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Embarrassed(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {

        // embarrassed
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "EMBARRASSED"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "EMBARRASSED"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no embarrassed
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "EMBARRASSEDEND"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "EMBARRASSEDEND"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "EMBARRASSEDEND"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "EMBARRASSEDEND"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "EMBARRASSEDEND"));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "EMBARRASSEDEND"));
        playAnimationPart(20);
    }
}
