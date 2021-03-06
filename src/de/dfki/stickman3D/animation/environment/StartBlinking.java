package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

/**
 * @author Beka
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
public class StartBlinking extends AnimationStickman3D
{

    public StartBlinking()
    {
        mAnimType = ANIMTYPE.ON;
    }

    int frequent;
    int actionDuration;

    public StartBlinking(Stickman3D sm, int frequent, int actionDuration, boolean block)
    {
        super(sm, frequent, actionDuration, block);
        mStickman3D = sm;
        this.frequent = frequent;
        this.actionDuration = actionDuration;
    }

    public StartBlinking(Stickman3D sm, int frequent, boolean block)
    {
        super(sm, frequent, block);
        mStickman3D = sm;
        this.frequent = 5000;
        this.actionDuration = 50;
    }

    @Override
    public void playAnimation()
    {
        mStickman3D.mBlinking = new Blinking(mStickman3D, frequent, actionDuration);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
