package com.dandelion.thirdproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity12 extends AppCompatActivity implements Runnable {

    ImageView sun1;
    ImageView sun2;
    Animation sunRiseAnimation1;
    Animation sunRiseAnimation2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        sun1 = (ImageView) findViewById(R.id.sunView1);
        sun2 = (ImageView) findViewById(R.id.sunView2);
        sunRiseAnimation1 = AnimationUtils.loadAnimation(MainActivity12.this, R.anim.sun_ma12_1);
        sunRiseAnimation2 = AnimationUtils.loadAnimation(MainActivity12.this, R.anim.sun_ma12_2);

        run();
    }

    @Override
    public void run() {
        sun1.startAnimation(sunRiseAnimation1);
        sun2.startAnimation(sunRiseAnimation2);
    }
}
