package com.dandelion.thirdproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    private TextView menuItemShowTextView, appleCountTextView, rememberTextView;
    private EditText editTextMainActivity;
    private Button showTheAppleButton;
    private int count = 0;
    private static final String KEY_COUNT = "COUNT";
    public static final String APP_PREFERENCES = "my_settings";
    public static final String APP_PREFERENCES_TEXT_VIEW = "text_view";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        editTextMainActivity = (EditText) findViewById(R.id.editTextOwlGoodMorning);
        menuItemShowTextView = (TextView) findViewById(R.id.menuItemShowTextView);
        appleCountTextView = (TextView) findViewById(R.id.textViewShowApple);
        rememberTextView = (TextView) findViewById(R.id.rememberTextView);
        showTheAppleButton = (Button) findViewById(R.id.showTheAppleButton);

        showTheAppleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appleCountTextView.setText("I have " + ++count + " apples");
            }
        });

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT, 0);
            appleCountTextView.setText("I have " + count + " apples");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sharedPreferences.contains(APP_PREFERENCES_TEXT_VIEW)) {
            rememberTextView.setText(sharedPreferences.getString(APP_PREFERENCES_TEXT_VIEW, "wtf"));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(APP_PREFERENCES_TEXT_VIEW, rememberTextView.getText().toString());
        editor.apply();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_COUNT, count);
    }

    public void finish3(View view) {
        finish();
    }

    public void onClickGoodMorning(View view) {
        Toast toast;
        LinearLayout linearLayout;
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(R.drawable.icon);
        if (editTextMainActivity.getText().length() == 0) {
            toast = Toast.makeText(getApplicationContext(), "Good morning man", Toast.LENGTH_SHORT);
            linearLayout = (LinearLayout) toast.getView();
            linearLayout.addView(imageView, 0);
            toast.show();
        } else {
            toast = Toast.makeText(this, "Good morning " + editTextMainActivity.getText(), Toast.LENGTH_SHORT);
            linearLayout = (LinearLayout) toast.getView();
            linearLayout.addView(imageView, 0);
            toast.show();
            rememberTextView.setText(editTextMainActivity.getText());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_save_file:
                menuItemShowTextView.setText("big");
                return true;
            case R.id.menu_middle:
                menuItemShowTextView.setText("middle");
                return true;
            case R.id.menu_small:
                menuItemShowTextView.setText("small");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
