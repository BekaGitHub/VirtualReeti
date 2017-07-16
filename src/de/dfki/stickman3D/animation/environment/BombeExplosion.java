package de.dfki.stickman3D.animation.environment;///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package de.dfki.stickman3D.animation.environmentfx;
//
//import java.util.ArrayList;
//
//import de.dfki.stickman3D.Stickman3D;
//import de.dfki.stickman3D.animationlogic.AnimationContent3D;
//import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
//import javafx.application.Platform;
//import javafx.scene.paint.Color;
//
///**
// *
// * @author Beka
// *
// */
//public class BombeExplosion extends AnimationStickman3D
//{
//
//	public BombeExplosion(Stickman3D sm, int duration, boolean block)
//	{
//		super(sm, duration, block);
//		mStickmanSwing = sm;
//	}
//
//	@Override
//	public void playAnimation() 
//	{
//		int translationUnit = 8;
//		int rotationUnit = 10;
//            
//		mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mBombeFX, "shape", "BOMBETRANSITION"));
//        playAnimationPart(mDuration);
//        
//     // headTilt
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEye, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEyebrow, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyeFX, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyebrowFX, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mHeadFX, "tilt", translationUnit));
//        
//        if(mStickmanSwing.mType == Gender.TYPE.MALE)
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mMaleHairFX, "tilt", translationUnit));
//        else
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mFemaleHairFX, "tilt", translationUnit));
//        
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mMouth, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkleFX, "tilt", translationUnit));
//        
//     // embarrassed
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mMouth, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyeFX, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyebrowFX, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkleFX, "shape", "EMBARRASSED"));   ///Add by Robbie
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEye, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEyebrow, "shape", "EMBARRASSED"));
//        playAnimationPart(mDuration);
//        
//        pauseAnimation(2000);
//        
//        //end HeadTilt
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEye, "tilt", -translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEyebrow, "tilt", -translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyeFX, "tilt", -translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyebrowFX, "tilt", -translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mHeadFX, "tilt", -translationUnit));
//        
//        if(mStickmanSwing.mType == Gender.TYPE.MALE)
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mMaleHairFX, "tilt", -translationUnit));
//        else
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mFemaleHairFX, "tilt", -translationUnit));
//        
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mMouth, "tilt", -translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkleFX, "tilt", -translationUnit));
//        
//        //change embarrassed with angry
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyeFX, "shape", "SURPRISED"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyebrowFX, "shape", "SURPRISED"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEye, "shape", "SURPRISED"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEyebrow, "shape", "SURPRISED"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mMouth, "shape", "SURPRISED"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkleFX, "shape", "EMBARRASSEDEND"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkleFX, "shape", "SURPRISED"));
//        playAnimationPart(mDuration);
//        
//        pauseAnimation(1000);
//        
//        //Blink
//        for(int i = 0; i<3; i++)
//        {
//        	mAnimationPart = new ArrayList<>();
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyebrowFX, "shape", "SURPRISED"));
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEyebrow, "shape", "SURPRISED"));
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyeFX, "shape", "BLINK"));
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEye, "shape", "BLINK"));
//        	playAnimationPart(100);
//        	
//        	pauseAnimation(300);
//        	
//        	mAnimationPart = new ArrayList<>();
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyeFX, "shape", "SURPRISED"));
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEye, "shape", "SURPRISED"));
//        	playAnimationPart(100);
//        	
//        }
//        
//        pauseAnimation(1500);
//        
//     // headTilt
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEye, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEyebrow, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyeFX, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyebrowFX, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mHeadFX, "tilt", translationUnit));
//        
//        if(mStickmanSwing.mType == Gender.TYPE.MALE)
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mMaleHairFX, "tilt", translationUnit));
//        else
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mFemaleHairFX, "tilt", translationUnit));
//        
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mMouth, "tilt", translationUnit));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkleFX, "tilt", translationUnit));
//     // embarrassed
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mMouth, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyeFX, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyebrowFX, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mFaceWrinkleFX, "shape", "EMBARRASSED"));   ///Add by Robbie
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEye, "shape", "EMBARRASSED"));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEyebrow, "shape", "EMBARRASSED"));
//        playAnimationPart(mDuration);
//        
//        //playAnimationPart(mDuration);
//        
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftUpperLegFX, "rotate", -rotationUnit * 5));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftForeLegFX, "rotate", rotationUnit*2));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftFootFX, "rotate", rotationUnit*3));
//        playAnimationPart(mDuration);
//        
//        for(int i = 0; i<3; i++)
//        {
//        	mAnimationPart = new ArrayList<>();
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftForeLegFX, "rotate", -rotationUnit));
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftFootFX, "rotate", -rotationUnit*3));
//        	playAnimationPart(200);
//        	
//        	pauseAnimation(150);
//        	
//        	mAnimationPart = new ArrayList<>();
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftForeLegFX, "rotate", rotationUnit));
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftFootFX, "rotate", rotationUnit*3));
//        	playAnimationPart(200);
//        }
//        
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mBombeFX, "shape", "BOMBEEXPLOSION"));
//        playAnimationPart(mDuration);
//        
//        //mStickmanSwing.mBodyFX.currentColor = Color.BLACK;
////        Platform.runLater(() -> mStickmanSwing.mBodyFX.paintFrontOrientation(Color.BLACK));
//        mStickmanSwing.mHeadFX.mColor = Color.BLACK;
//        
//        
//        
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mBombeFX, "shape", "DEFAULT"));
//        playAnimationPart(20);
//        
//		mStickmanSwing.mLeftHandFX.setVisible(false);
//		mStickmanSwing.mLeftForeArmFX.setVisible(false);
//		mStickmanSwing.mLeftUpperArmFX.setVisible(false);
//		
//		mStickmanSwing.mRightHandFX.setVisible(false);
//		mStickmanSwing.mRightForeArmFX.setVisible(false);
//		mStickmanSwing.mRightUpperArmFX.setVisible(false);
//		
//		mStickmanSwing.mRightShoulderFX.setVisible(false);
//		mStickmanSwing.mLeftShoulderFX.setVisible(false);
//		mStickmanSwing.mNeck.setVisible(false);
//		mStickmanSwing.mLeftEyebrowFX.setVisible(false);
//		mStickmanSwing.mRightEyebrow.setVisible(false);
//		mStickmanSwing.mMouth.setVisible(false);
//		mStickmanSwing.mFaceWrinkleFX.setVisible(false);
//		
//        mAnimationPart = new ArrayList<>();
//        mStickmanSwing.mHeadFX.translateRight = true;
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mHeadFX, "Translate", -2000));
//        if(mStickmanSwing.mType == Gender.TYPE.FEMALE)
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mFemaleHairFX, "Translate", -2000));
//        else
//        	mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mMaleHairFX, "Translate", -2000));
//        mStickmanSwing.mBodyFX.setVisible(false);
//        playAnimationPart(mDuration);
//        
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightForeLegFX, "rotate", 90));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightForeLegFX, "translate", 100));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftForeLegFX, "rotate", 70));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftForeLegFX, "translate", 120));
//        playAnimationPart(100);
//        
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightUpperLegFX, "rotate", 90));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightUpperLegFX, "translate", 155));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftUpperLegFX, "rotate", 120));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftUpperLegFX, "translate", 160));
//        playAnimationPart(100);
//        
//        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mLeftEyeFX, "rotate", 90));
//        mAnimationPart.add(new AnimationContent3D(mStickmanSwing.mRightEye, "rotate", 170));
//        playAnimationPart(100);
//        
//        mStickmanSwing.mLeftEyeFX.setVisible(false);
//        mStickmanSwing.mRightEye.setVisible(false);
//        
//
//	}
//}
