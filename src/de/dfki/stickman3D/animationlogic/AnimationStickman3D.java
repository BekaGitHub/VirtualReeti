/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.Animation;
import de.dfki.common.interfaces.AnimationInterface;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.util.ios.IOSIndentWriter;
import de.dfki.util.xml.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Patrick Gebhard
 * @modified Beka Aptsiauri
 */
public class AnimationStickman3D extends Animation implements XMLParseable, XMLWriteable, AnimationInterface
{
    public enum ANIMTYPE
    {
        ON, OFF
    }
    public AnimatorStickman3D mAnimator;
    public AnimationPause3D mAnimationPause;
    public Stickman3D mStickman3D;
    public int actionDuration = -1;
    protected HashMap<String, String> extraParams = new HashMap<>();
    public ANIMTYPE mAnimType = null;

    public static boolean isSmileInAction = false;
    public static boolean isHeadTiltInAction = false;
    public static boolean isSurprisedInAction = false;
    public static boolean isAngryInAction = false;

    public AnimationStickman3D()
    {
    }

    public AnimationStickman3D(Stickman3D sm, int duration, boolean block)
    {
        mName = getClass().getSimpleName();
        mStickman3D = sm;
        mAgentName = mStickman3D.mName;
        setName(mAgentName + "'s AnimationSwing " + mName);
        mID = mStickman3D.getID(); // default ID;
        mBlocking = block;
        mDuration = duration;
    }

    public AnimationStickman3D(Stickman3D sm, int frequent, int actionDuration, boolean block)
    {
        mName = getClass().getSimpleName();
        mStickman3D = sm;
        mAgentName = mStickman3D.mName;
        setName(mAgentName + "'s AnimationSwing " + mName);
        mID = mStickman3D.getID(); // default ID;
        mBlocking = block;
        mDuration = frequent;
        this.actionDuration = actionDuration;
    }

    public AnimationStickman3D(Stickman3D sm, int frequent, int actionDuration, boolean block, HashMap<String, String> extraParams)
    {
        mName = getClass().getSimpleName();
        mStickman3D = sm;
        mAgentName = mStickman3D.mName;
        setName(mAgentName + "'s AnimationSwing " + mName);
        mID = mStickman3D.getID(); // default ID;
        mBlocking = block;
        mDuration = frequent;
        this.actionDuration = actionDuration;
        this.extraParams = extraParams;
    }

    public void setParameter(Object p)
    {
        mParameter = p;
    }

    @Override
    public String getmID()
    {
        return mID;
    }

    public void setID(String id)
    {
        mID = id;
    }

    public boolean hasExtraParams()
    {
        return extraParams.size() > 0;
    }

    public HashMap<String, String> getExtraParams()
    {
        return extraParams;
    }

    public void setStickmanName(String stickmanName)
    {
        mAgentName = stickmanName;
        setName(mAgentName + "'s AnimationSwing " + mName);
    }

    public void setAnimationName(String animationName)
    {
        mName = animationName;
    }

    public void setDuration(int duration)
    {
        mDuration = duration;
    }

    public void setBlocking(boolean blocking)
    {
        mBlocking = blocking;
    }

    public void waitForClearance()
    {
        mStickman3D.mAnimationSchedulerFX.introduce(this);
        // block this animation for animation - AnimationSheduler will unblock 
        try
        {
            mAnimationStart.acquire(1);
        } catch (InterruptedException ex)
        {
            mStickman3D.mLogger.severe(ex.getMessage());
        }

        // tell Agent this animation has been scheduled and a next one can come
        mStickman3D.mAnimationLaunchControl.release();
    }

    public void play()
    {
        // wait until AnimationScheduler says go!
        try
        {
            mAnimationStart.acquire(1);
        } catch (InterruptedException ex)
        {
            mStickman3D.mLogger.severe(ex.getMessage());
        }

        playAnimation();
    }

    public void playAnimation()
    {
        // place animation code here
    }

    public void playAnimationPart(int duration)
    {
        mAnimator = new AnimatorStickman3D(mStickman3D, this, mAnimationPart, duration);

        try
        {
            mAnimationPartStart.acquire();
        } catch (InterruptedException ex)
        {
            mStickman3D.mLogger.severe(ex.getMessage());
        }

    }

    public void pauseAnimation(int duration)
    {
        mAnimationPause = new AnimationPause3D(mStickman3D, this, duration);

        try
        {
            mAnimationPartStart.acquire();
        } catch (InterruptedException ex)
        {
            mStickman3D.mLogger.severe(ex.getMessage());
        }
    }

    public void finalizeAnimation()
    {
        // unblock AnimationScheduler if animation is a blocking animation
        if (mBlocking)
        {
            mStickman3D.mAnimationSchedulerFX.proceed(this);
        } else
        {
            mStickman3D.mAnimationSchedulerFX.removeAnimation(this);
        }
        // send event that AnimationStickman3D is ended

        // API or TCP-Interface
        if (!mStickman3D.getStageController().ismNetwork())
        {
            mStickman3D.notifyListeners(getmID());
        } else
        {
            mStickman3D.getStageController().sendAnimationUpdate("end", getmID());
        }
    }

    @Override
    public void writeXML(IOSIndentWriter out) throws XMLWriteError
    {
        out.println("<StickmanAnimation stickmanname = \"" + mAgentName + "\" name=\"" + mName + "\" id=\"" + mID + "\" duration=\"" + mDuration + "\" blocking=\"" + mBlocking + "\">").push();
        if (mParameter != null)
        {
            if (mParameter instanceof WordTimeMarkSequence)
            {
                ((WordTimeMarkSequence) mParameter).writeXML(out);
            }

            if (mParameter instanceof String)
            {
                out.println((String) mParameter);
            }
        }
        addExtraParamsToXML(out);
        out.pop().println("</StickmanAnimation>");
    }

    private void addExtraParamsToXML(IOSIndentWriter out)
    {
        if (extraParams.size() > 0)
        {
            out.println("<Params>").push();
            for (Map.Entry<String, String> entry : extraParams.entrySet())
            {
                out.println("<Param key=\"" + entry.getKey() + "\">" + entry.getValue() + "</Param>").push();
            }
            out.pop().println("</Params>");
        }
    }

    @Override
    public void parseXML(final Element element) throws XMLParseError
    {
        mAgentName = element.getAttribute("stickmanname");
        mName = element.getAttribute("name");
        mID = element.getAttribute("id");
        mDuration = Integer.parseInt(element.getAttribute("duration"));
        mBlocking = Boolean.parseBoolean(element.getAttribute("blocking"));
        extraParams = new HashMap<>();

        // Process The Child Nodes
        XMLParseAction.processChildNodes(element, new XMLParseAction()
        {
            @Override
            public void run(final Element element) throws XMLParseError
            {
                // Get The Child Tag Name
                final String name = element.getTagName();

                if (name.equalsIgnoreCase("WordTimeMarkSequence"))
                {
                    mParameter = new WordTimeMarkSequence();

                    ((WordTimeMarkSequence) mParameter).parseXML(element);
                } else if (name.equals("Params"))
                {
                    NodeList nodes = element.getChildNodes();
                    for (int i = 0; i < nodes.getLength(); i++)
                    {
                        Node node = nodes.item(i);
                        if (!node.hasAttributes())
                        {
                            continue;
                        }
                        String key = node.getAttributes().getNamedItem("key").getNodeValue();
                        String value = node.getTextContent();
                        extraParams.put(key, value);
                    }
                } else
                {
                    mParameter = (String) element.getTextContent();
                }
            }
        });
    }

    @Override
    public void run()
    {
        waitForClearance();
        play();
        finalizeAnimation();
    }

    @Override
    public String toString()
    {
        return mName + ", " + getName();
    }
}
