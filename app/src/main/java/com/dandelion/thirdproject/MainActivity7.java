package com.dandelion.thirdproject;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity7 extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        animation();
        rotateAnimation();
    }

    private void animation() {
        ImageView imageViewHand = (ImageView) findViewById(R.id.animationViewHand);
        imageViewHand.setBackgroundResource(R.drawable.animation_hand);
        ImageView imageViewOwl = (ImageView) findViewById(R.id.animationViewOwl);
        imageViewOwl.setBackgroundResource(R.drawable.animation_owl);

        final AnimationDrawable mAnimationDrawableHand = (AnimationDrawable) imageViewHand.getBackground();
        final AnimationDrawable mAnimationDrawableOwl = (AnimationDrawable) imageViewOwl.getBackground();

        SeekBar seekBarAnimation = (SeekBar) findViewById(R.id.seekBarAnimation);
        assert seekBarAnimation != null;
        seekBarAnimation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mAnimationDrawableHand.setAlpha(progress);
                mAnimationDrawableOwl.setAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final Button btnStart = (Button) findViewById(R.id.startButton);
        assert btnStart != null;
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mAnimationDrawableHand.start();
                mAnimationDrawableOwl.start();
            }
        });

        final Button btnStop = (Button) findViewById(R.id.stopButton);
        assert btnStop != null;
        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mAnimationDrawableHand.stop();
                mAnimationDrawableOwl.stop();
            }
        });
    }

    private void rotateAnimation() {
        final ImageView redCircleImageView = (ImageView) findViewById(R.id.redCircleImageView);
        final ImageView whiteCircleImageView = (ImageView) findViewById(R.id.whiteCircleImageView);
        Button rotateCenterButton = (Button) findViewById(R.id.rotateCenterButton);
        //Button rotateCornerButton = (Button) findViewById(R.id.rotateCornerButton);
        final Animation rotateCenterRightAnimation = AnimationUtils.loadAnimation(this, R.anim.rotete_center_right);
        final Animation rotateCenterLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_center_left);

        assert rotateCenterButton != null;
        rotateCenterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redCircleImageView.startAnimation(rotateCenterRightAnimation);
                whiteCircleImageView.startAnimation(rotateCenterLeftAnimation);
                whiteCircleImageView.setVisibility(View.INVISIBLE);
                redCircleImageView.setVisibility(View.INVISIBLE);
            }
        });
//        rotateCornerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                redCircleImageView.startAnimation(rotateCenterLeftAnimation);
//                whiteCircleImageView.startAnimation(rotateCenterLeftAnimation);
//            }
//        });
    }
}
