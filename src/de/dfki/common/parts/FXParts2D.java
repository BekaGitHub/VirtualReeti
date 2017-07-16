package de.dfki.common.parts;

import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by EmpaT on 15.07.2017.
 */
public abstract class FXParts2D extends FXParts
{
    public double mTranslation = mDefaultTranslation;
    public double mToTranslation = mDefaultTranslation;
    public double mTranslationStep = 0.0f;

    public double mRotation = mDefaultRotation;
    public double mToDegree = mDefaultRotation;
    public double mRotationStep = 0.0f;

    public float mColoropacity = 1.0f;

    public List<Path> mGraphicPaths = Collections.synchronizedList(new ArrayList());

    // used by ResetButton.
    public Color mColorRest = Color.rgb(0, 0, 0);
    public float mColoropacityRest = 1.0f;

    public Color mColorRecorder = mColor;
    public BasicStroke mStroke = new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
}
