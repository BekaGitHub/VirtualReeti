/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.posture;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class TurnLeftStart extends AnimationStickman3D
{

    public TurnLeftStart(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation()
    {
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", -20));
        playAnimationPart(100);

        if (mStickman3D.mType == Gender.TYPE.MALE)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -40));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mUpperBody, "yrotate", -60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", -20));
            playAnimationPart(500);
        } else
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -70));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mUpperBody, "yrotate", -60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mHead, "yrotate", -20));
            playAnimationPart(500);
        }

        pauseAnimation(10);
    }
}
