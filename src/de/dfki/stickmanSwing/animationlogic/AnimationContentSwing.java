/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanSwing.body.StickmanSwingParts;

/**
 * @author Patrick Gebhard
 */
public class AnimationContentSwing extends AnimationContent
{

    public StickmanSwingParts mBodyPart;
    public String mAction;
    public int mParam;
    public String mParamString;
    public WordTimeMarkSequence mWTS;

    public AnimationContentSwing(StickmanSwingParts bp, String a, int p)
    {
        mBodyPart = bp;
        mAction = a;
        mParam = p;
        mParamString = "";
    }

    public AnimationContentSwing(StickmanSwingParts bp, String a, String p)
    {
        mBodyPart = bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
    }

    public AnimationContentSwing(StickmanSwingParts bp, String a, String p, WordTimeMarkSequence wts)
    {
        mBodyPart = bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
        mWTS = wts;
    }
}
