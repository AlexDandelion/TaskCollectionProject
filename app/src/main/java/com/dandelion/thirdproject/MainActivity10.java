package com.dandelion.thirdproject;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity10 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font.ttf");

        Toolbar toolbarTop = (Toolbar) findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbarTop);

        TextView mTitle = (TextView) findViewById(R.id.toolbar_title);
        Button button = (Button) findViewById(R.id.button2);
        button.setTypeface(typeface);
        mTitle.setTypeface(typeface);
    }

    public void onClick(View view) {
        Toast.makeText(this, Locale.getDefault().toString(), Toast.LENGTH_SHORT).show();
    }
}
