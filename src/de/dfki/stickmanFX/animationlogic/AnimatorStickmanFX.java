package de.dfki.stickmanFX.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.animationlogic.Animator2D;
import de.dfki.stickmanFX.StickmanFX;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * @author Beka Aptsiauri
 */
public class AnimatorStickmanFX extends Animator2D
{

    public AnimatorStickmanFX(StickmanFX sm, AnimationStickmanFX a, ArrayList<AnimationContent> animComps)
    {
        agent = sm;
        mAnimation = a;
        mAnimationComponents = animComps;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();
        mRenderPauseDuration = 40; // 40 milliseconds equals 25fps - resulting that by default an animation takes 500ms

        render();
    }

    public AnimatorStickmanFX(StickmanFX sm, AnimationStickmanFX a, ArrayList<AnimationContent> animComps, int duration)
    {
        agent = sm;
        mAnimation = a;
        mAnimationComponents = animComps;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();

        mRenderPauseDuration = new Float(duration / sMAX_ANIM_STEPS).intValue();
        mRenderPauseDuration = (mRenderPauseDuration < 1) ? 1 : mRenderPauseDuration; // minimum delay is 1 millisecond
        render();
    }

    public AnimatorStickmanFX(StickmanFX sm, AnimationStickmanFX a, ArrayList<AnimationContent> animComps, WordTimeMarkSequence wts)
    {
        agent = sm;
        mAnimation = a;
        mAnimationComponents = animComps;
        mWTS = wts;
        mDescription = mAnimation.getClass().getSimpleName() + " (" + mAnimation.mID + "), " + mAnimation.toString();

        renderEventAnimation();
    }
}
