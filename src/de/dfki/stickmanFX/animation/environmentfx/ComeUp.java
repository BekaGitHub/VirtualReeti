/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import java.util.ArrayList;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickmanFX;
import javafx.application.Platform;

/**
 * @author Beka
 */
public class ComeUp extends AnimationStickmanFX
{

    private StickmanFX mStickmanFX;

    public ComeUp(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation()
    {
        int rotationUnit = 5;
        int speed = 7;

        mStickmanFX.voffset = 480;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit * 2));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 32));
        playAnimationPart(100);

        for (int i = 0; i < 6; i++)
        {
            // wave right
            for (int j = 0; j < 8; j++)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit));

                playComeSpeed(speed);
                playAnimationPart(20);
            }

            // wave left
            for (int j = 0; j < 8; j++)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit));

                playComeSpeed(speed);
                playAnimationPart(20);
            }
        }

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit * 2));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 32));
        playAnimationPart(200);
    }

    private void playComeSpeed(int Speed)
    {
        if (mStickmanFX.voffset > 0)
        {
            mStickmanFX.voffset = mStickmanFX.voffset - Speed;
        } else
        {
            mStickmanFX.voffset = 0;
        }
        Platform.runLater(() -> mStickmanFX.update());
    }
}
