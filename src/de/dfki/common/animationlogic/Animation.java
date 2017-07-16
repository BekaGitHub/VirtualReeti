package de.dfki.common.animationlogic;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by EmpaT on 16.07.2017.
 */
public abstract class Animation extends Thread
{
    public Semaphore mAnimationPartStart = new Semaphore(0);
    public Semaphore mAnimationStart = new Semaphore(1);
    public ArrayList<AnimationContent> mAnimationPart = new ArrayList<>();
    public Object mParameter = "";
    public String mID;
    public String mName = "";
    public String mAgentName;
    public boolean mBlocking = false;
    public int mDuration = -1;
}
