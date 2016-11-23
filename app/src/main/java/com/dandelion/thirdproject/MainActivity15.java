package com.dandelion.thirdproject;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity15 extends AppCompatActivity {

    private TextView touchTextView;
    private TextView moveTextView;
    private TextView xyTextView;
    private FrameLayout frameLayout;
    private String up;
    private String down;
    private String move;
    private float x;
    private float y;
    private float x2;
    private float y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);

        touchTextView = (TextView) findViewById(R.id.touchTextView);
        moveTextView = (TextView) findViewById(R.id.moveTextView);
        xyTextView = (TextView) findViewById(R.id.xyTextView);
        frameLayout = (FrameLayout) findViewById(R.id.touchFrame);
        frameLayout.setOnTouchListener(onTouchListener);
    }

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            x = event.getX();
            y = event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    down = "Down: " + x + " , " + y;
                    up = "";
                    move = "";
                    x2 = x;
                    y2 = y;
                    break;
                case MotionEvent.ACTION_MOVE:
                    move = "Move: " + x + " , " + y;
                    break;
                case MotionEvent.ACTION_UP:
                    up = "Up: " + x + " , " + y;
                    move = "";
                    if (x > (x2 + 100f) || x < (x2 - 100f) ||
                            y > (y2 + 100f) || y < (y2 - 100f)) {
                        moveTextView.setText("Move!");
                    }
                    break;
                default:
                    break;
            }
            touchTextView.setText(down + "\n" + move + "\n" + up);
            return true;
        }
    };
}
