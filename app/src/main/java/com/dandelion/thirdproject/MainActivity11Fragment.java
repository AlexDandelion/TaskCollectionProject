package com.dandelion.thirdproject;

import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class MainActivity11Fragment extends Fragment {

    private ImageView faceImageView;
    private AnimationDrawable animation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main11_fra, container, false);

        faceImageView = (ImageView) v.findViewById(R.id.faceImageView);
        faceImageView.setBackgroundResource(R.drawable.animation_face);
        animation = (AnimationDrawable) faceImageView.getBackground();
        animation.setOneShot(true);
        animation.stop();
        animation.start();

        return v;
    }
}
