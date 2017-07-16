package de.dfki.common.agents;

import java.awt.*;

/**
 * Created by EmpaT on 14.07.2017.
 */
public abstract class Agent3D extends AgentFX
{
    public double stageHeight;
    public boolean isFullScreen = false;
    public static Dimension mDefaultSize = new Dimension(300, 800);
    public Dimension mSize = new Dimension(mDefaultSize);
}
