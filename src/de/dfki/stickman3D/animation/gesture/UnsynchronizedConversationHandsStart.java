/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Beka
 */
public class UnsynchronizedConversationHandsStart extends AbstractConversationHands
{

    private static boolean movementStarted = false;

    public UnsynchronizedConversationHandsStart(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
        intensity = 10;
    }

    public UnsynchronizedConversationHandsStart(Stickman3D sm, int duration, boolean block, HashMap<String, String> extraParams)
    {
        super(sm, duration, block, extraParams);
    }

    @Override
    public void playAnimation()
    {
        if (!movementStarted)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -38));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "yrotate", 13));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", -18));

            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -76));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "yrotate", 35));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", START_LEFT_FORE_ARM_POSITION));

            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", 0));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "yrotate", -54));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "zrotate", 7));


            //Right Part
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -56));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "yrotate", 28));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", 27));

            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "rotate", -19));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "yrotate", 27));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", START_RIGHT_FORE_ARM_POSITION));

            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", -8));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 34));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "zrotate", 0));
            playAnimationPart(200);
            pauseAnimation(mDuration);
            movementStarted = true;
        }

        mAnimationPart = new ArrayList<>();
        moveConversationHands();
        playAnimationPart(200);
    }


    protected int getLeftArmMovement()
    {
        int leftForeArmZ;
        leftForeArmZ = START_LEFT_FORE_ARM_POSITION - getMovementDistance();
        return leftForeArmZ;
    }

    protected int getRightArmMovement()
    {
        int rightForeArmZ;
        rightForeArmZ = START_RIGHT_FORE_ARM_POSITION + getMovementDistance();
        return rightForeArmZ;
    }


}
