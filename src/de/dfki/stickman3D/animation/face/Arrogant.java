/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Arrogant extends AnimationStickman3D
{

    /**
     * @param sm       StickmanSwing
     * @param duration Control the speed of the movement from one emotion state
     *                 to another emotion state.
     * @param block    block or not the others movements, when one movement is not
     *                 finished.
     */
    public Arrogant()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Arrogant(Stickman3D sm, int duration, boolean block)
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
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mHead, "rotate", -10));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "ANGRYSMALLMOUTH"));

        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -45));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", -10));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -20));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "yrotate", -25));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", 110));

        if (mStickman3D.mType == Gender.TYPE.FEMALE)
        {
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger1, "zrotate", -20));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "rotate", 90));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "rotate", 90));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "rotate", 90));
        } else
        {
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", -20));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger1, "zrotate", -20));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "rotate", 70));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "rotate", 70));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "rotate", 70));

        }

        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", -40));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", 10));

        if (mStickman3D.mType == Gender.TYPE.FEMALE)
        {
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "yrotate", 13));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", -120));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", -70));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -20));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "zrotate", 10));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger2, "rotate", 120));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger3, "rotate", 120));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger4, "rotate", 120));
        } else
        {
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "yrotate", 10));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", -120));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", -60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", -30));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "zrotate", 20));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger2, "rotate", 50));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger3, "rotate", 50));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger4, "rotate", 50));
        }

        playAnimationPart(500);

        pauseAnimation(1000);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mHead, "rotate", 10));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mMouth, "shape", "ANGRYSMALLMOUTHEND"));

        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", 45));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "zrotate", 10));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", 20));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "yrotate", 25));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -110));

        if (mStickman3D.mType == Gender.TYPE.FEMALE)
        {
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger1, "zrotate", 20));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "rotate", -90));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "rotate", -90));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "rotate", -90));
        } else
        {
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftWrist, "rotate", 20));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger1, "zrotate", 20));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger2, "rotate", -70));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger3, "rotate", -70));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftFinger4, "rotate", -70));
        }

        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "rotate", 40));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightUpperArm, "zrotate", -10));

        if (mStickman3D.mType == Gender.TYPE.FEMALE)
        {
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "yrotate", -13));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", 120));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", 70));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 20));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "zrotate", -10));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger2, "rotate", -120));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger3, "rotate", -120));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger4, "rotate", -120));
        } else
        {
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "yrotate", -10));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightForeArm, "zrotate", 120));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "rotate", 60));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "yrotate", 30));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightWrist, "zrotate", -20));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger2, "rotate", -50));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger3, "rotate", -50));
            mAnimationPart.add(new AnimationContent3D(mStickman3D.mRightFinger4, "rotate", -50));
        }
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
