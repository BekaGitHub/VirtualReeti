/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import javafx.application.Platform;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class DisappearToSmall extends AnimationStickman3D
{

    public DisappearToSmall()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public DisappearToSmall(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
        mStickman3D = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation()
    {
        float recordOriginScale = mStickman3D.mScale;
        mStickman3D.starShowControler = false;
        int rotationUnit = 5;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", -rotationUnit * 30));
        playAnimationPart(200);
        pauseAnimation(100);

        // wave right
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -rotationUnit * 8));
        playAnimationPart(180);

        // wave left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", rotationUnit * 8));
        playAnimationPart(180);

        for (int i = 0; i < 1; i++)
        {
            // wave right
            for (int j = 0; j < 9; j++)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", -rotationUnit));

                mStickman3D.mScale = mStickman3D.mScale * 0.95f;
                playAnimationPart(20);
                Platform.runLater(() -> mStickman3D.update());
            }

            // wave left
            for (int j = 0; j < 9; j++)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "zrotate", rotationUnit));

                mStickman3D.mScale = mStickman3D.mScale * 0.95f;
                playAnimationPart(20);
                Platform.runLater(() -> mStickman3D.update());
            }
        }

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftUpperArm, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent3D(mStickman3D.mLeftForeArm, "rotate", rotationUnit * 30));
        playAnimationPart(20);

        // show stars
        mStickman3D.hideAllPartsWithout(mStickman3D.mStars);
        mStickman3D.mScale = recordOriginScale;

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
