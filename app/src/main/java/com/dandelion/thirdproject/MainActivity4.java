package com.dandelion.thirdproject;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font.ttf");
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button button10 = (Button) findViewById(R.id.button10);
        Button button11 = (Button) findViewById(R.id.button11);
        Button button12 = (Button) findViewById(R.id.button12);
        Button button13 = (Button) findViewById(R.id.button13);
        button8.setTypeface(typeface);
        button9.setTypeface(typeface);
        button10.setTypeface(typeface);
        button11.setTypeface(typeface);
        button12.setTypeface(typeface);
        button13.setTypeface(typeface);

    }
}
