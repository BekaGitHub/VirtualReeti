/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animationlogic;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.Animation;
import de.dfki.common.interfaces.AnimationInterface;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.util.ios.IOSIndentWriter;
import de.dfki.util.xml.XMLParseAction;
import de.dfki.util.xml.XMLParseError;
import de.dfki.util.xml.XMLParseable;
import de.dfki.util.xml.XMLWriteError;
import de.dfki.util.xml.XMLWriteable;

import org.w3c.dom.Element;

/**
 * @author Patrick Gebhard
 * @modified Beka Aptsiauri
 */
public class AnimationSwing extends Animation implements XMLParseable, XMLWriteable, AnimationInterface
{
    public enum ANIMTYPE
    {
        EmotionExpression, Gesture
    }

    public AnimatorSwing mAnimator;
    public AnimationPause mAnimationPause;
    public StickmanSwing mStickmanSwing;
    public ANIMTYPE mAnimType = null;

    public AnimationSwing()
    {

    }

    public String getmID()
    {
        return mID;
    }

    public AnimationSwing(StickmanSwing sm, int duration, boolean block)
    {
        mName = getClass().getSimpleName();
        mStickmanSwing = sm;
        mAgentName = mStickmanSwing.mName;
        setName(mAgentName + "'s AnimationSwing " + mName);
        mID = mStickmanSwing.getID(); // default ID;
        mBlocking = block;
        mDuration = duration;
    }

    public void setParameter(Object p)
    {
        mParameter = p;
    }

    public void setID(String id)
    {
        mID = id;
    }

    public void setStickmanName(String stickmanName)
    {
        mAgentName = stickmanName;
        //mStickmanSwing = StickmanStageSwing.getAgent(mAgentName);
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
        mStickmanSwing.mAnimationScheduler.introduce(this);
        // block this animation for animation - AnimationSheduler will unblock
        try
        {
            mAnimationStart.acquire(1);
        } catch (InterruptedException ex)
        {
            mStickmanSwing.mLogger.severe(ex.getMessage());
        }

        // tell Agent this animation has been scheduled and a next one can come
        mStickmanSwing.mAnimationLaunchControl.release();
    }

    public void play()
    {
        // wait until AnimationScheduler says go!
        try
        {
            mAnimationStart.acquire(1);
        } catch (InterruptedException ex)
        {
            mStickmanSwing.mLogger.severe(ex.getMessage());
        }

        playAnimation();
    }

    public void playAnimation()
    {
        // place animation code here
    }

    public void playAnimationPart(int duration)
    {
        mAnimator = new AnimatorSwing(mStickmanSwing, this, mAnimationPart, duration);

        try
        {
            mAnimationPartStart.acquire();
        } catch (InterruptedException ex)
        {
            mStickmanSwing.mLogger.severe(ex.getMessage());
        }

    }

    public void pauseAnimation(int duration)
    {
        mAnimationPause = new AnimationPause(mStickmanSwing, this, duration);

        try
        {
            mAnimationPartStart.acquire();
        } catch (InterruptedException ex)
        {
            mStickmanSwing.mLogger.severe(ex.getMessage());
        }
    }

    public void finalizeAnimation()
    {
        //mStickmanSwing.mLogger.info(mStickmanSwing.mName + "'s AnimationSwing " + getClass().getSimpleName() + " with id " + mID + " has ended - notify Listeners!");
        // unblock AnimationScheduler if animation is a blocking animation
        if (mBlocking)
        {
            //mStickmanSwing.mLogger.info("unblocking AnimationScheduler");
            mStickmanSwing.mAnimationScheduler.proceed(this);
        } else
        {
            mStickmanSwing.mAnimationScheduler.removeAnimation(this);
        }
        // send event that AnimationSwing is ended

        // send event that AnimationSwing is ended - if there is a recipient
        if (mStickmanSwing.getStageController() != null)
        {
            // API or TCP-Interface
            if (!mStickmanSwing.getStageController().ismNetwork())
            {
                mStickmanSwing.notifyListeners(mID);
            } else
            {
                mStickmanSwing.getStageController().sendAnimationUpdate("end", getmID());
            }
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
        out.pop().println("</StickmanAnimation>");
    }

    @Override
    public void parseXML(final Element element) throws XMLParseError
    {

        mAgentName = element.getAttribute("stickmanname");
        mName = element.getAttribute("name");
        mID = element.getAttribute("id");
        mDuration = Integer.parseInt(element.getAttribute("duration"));
        mBlocking = Boolean.parseBoolean(element.getAttribute("blocking"));

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
        //mStickmanSwing.mLogger.info(mStickmanSwing.mName + "'s AnimationSwing " + getClass().getSimpleName() + " wait for clearance.");
        waitForClearance();

        //mStickmanSwing.mLogger.info(mStickmanSwing.mName + "'s AnimationSwing " + getClass().getSimpleName() + " play.");
        play();

        //mStickmanSwing.mLogger.info(mStickmanSwing.mName + "'s AnimationSwing " + getClass().getSimpleName() + " finalize.");
        finalizeAnimation();
    }

    @Override
    public String toString()
    {
        return mName + ", " + getName();
    }
}
