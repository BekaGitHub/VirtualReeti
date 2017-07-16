/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.bodyfx.StickmanFXParts;

/**
 * @author Beka Aptsiauri
 */
public class AnimationContentFX extends AnimationContent
{

    public StickmanFXParts mBodyPartFX;
    public String mAction;
    public int mParam;
    public String mParamString;
    public WordTimeMarkSequence mWTS;

    public AnimationContentFX(StickmanFXParts bp, String a, int p)
    {
        mBodyPartFX = bp;
        mAction = a;
        mParam = p;
        mParamString = "";
    }

    public AnimationContentFX(StickmanFXParts bp, String a, String p)
    {
        mBodyPartFX = bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
    }

    public AnimationContentFX(StickmanFXParts bp, String a, String p, WordTimeMarkSequence wts)
    {
        mBodyPartFX = bp;
        mAction = a;
        mParam = 0;
        mParamString = p;
        mWTS = wts;
    }
}
