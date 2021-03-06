/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.body;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

/**
 * @author Patrick Gebhard
 */
public class LeftUpperArm extends StickmanSwingParts
{

    LeftShoulder mLeftShoulder;

    int mArmLength = 70;
    Dimension mSize = new Dimension(mArmLength, mArmLength);

    Point mStart;
    Point mEnd;

    GeneralPath mArm;

    public LeftUpperArm(LeftShoulder shoulder)
    {
        mLeftShoulder = shoulder;

        mDefaultRotation = -30;
        mRotation = mDefaultRotation;
        mToDegree = mDefaultRotation;
        mRotationStep = 0.0f;

        init();

        calculate(0);
    }

    public Point getLeftUpperArmEndPosition()
    {
        return (mArm != null) ? new Point((int) mArm.getCurrentPoint().getX() + 1, (int) mArm.getCurrentPoint().getY()) : new Point(0, 0);
    }

    @Override
    public void calculate(int step)
    {
        mStart = mLeftShoulder.getLeftShoulderEndPosition();
        mEnd = new Point(mStart.x, mStart.y + mArmLength);

        mArm = new GeneralPath();
        mArm.moveTo(mStart.x, mStart.y + 2);
        mArm.quadTo(mStart.x + 5, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y);

        AffineTransform t = new AffineTransform();
        t.rotate(Math.toRadians(mRotation), mStart.x, mStart.y);
        mArm.transform(t);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //create();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // draw outlines
        g2.setColor(new Color(80, 80, 80));

        if (mLeftShoulder.mBody.mNeck.mHead.mStickman.setCharacterInvisible == true)
        {
            if (mLeftShoulder.mBody.mNeck.mHead.mStickman.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mLeftShoulder.mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep * 12;
                if (fadeFactor <= 24)
                {
                    fadeFactor = 0;
                }
                g2.setColor(new Color(80, 80, 80, fadeFactor));
            } else
            {
                int fadeFactor = (20 - mLeftShoulder.mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216)
                {
                    fadeFactor = 255;
                }
                g2.setColor(new Color(80, 80, 80, fadeFactor));
            }
        }

        g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        g2.draw(mArm);
    }
}
