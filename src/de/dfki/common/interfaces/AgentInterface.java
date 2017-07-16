package de.dfki.common.interfaces;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.Gender;
import de.dfki.common.parts.FXParts;

/**
 * Created by alvaro on 9/4/16.
 */
public interface AgentInterface
{
    StageRoom getStageController();

    void setStageController(StageRoom s);

    void setShowName(boolean show);

    boolean isShowName();

    void endAnimationScheduler();

    Gender.TYPE getType();

    AnimationInterface doAnimation(String name, int duration, boolean block);

    AnimationInterface doAnimation(String name, int frequent, int actionDuration, boolean block);

    AnimationInterface doAnimation(String name, Object param, boolean block);

    AnimationInterface doAnimation(String name, int duration, Object param, boolean block);

    AnimationInterface doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block);

    public abstract FXParts getSpeechBubble();
}
