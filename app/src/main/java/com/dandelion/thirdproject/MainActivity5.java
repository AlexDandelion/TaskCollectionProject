package com.dandelion.thirdproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

    }

    public void ConvertParrots(View view) {
        RadioButton metersButton = (RadioButton) findViewById(R.id.radioButton);
        RadioButton parrotssButton = (RadioButton) findViewById(R.id.radioButton2);
        EditText editText = (EditText) findViewById(R.id.editText5);
        Button converter = (Button) findViewById(R.id.button23);
        TextView textView = (TextView) findViewById(R.id.textView);

        if(editText.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Add the data", Toast.LENGTH_SHORT).show();
            return;
        }

        if(metersButton.isChecked()) {
            textView.setText(String.valueOf(fromParrotsToMeters(Float.valueOf(editText.getText().toString()))));
        } else if(parrotssButton.isChecked()) {
            textView.setText(String.valueOf(fromMetersToParrots(Float.valueOf(editText.getText().toString()))));
        }
    }

    private float fromParrotsToMeters(float parrots) {
        return (float) (parrots / 7.6);
    }

    private float fromMetersToParrots(float meters) {
        return (float) (meters * 7.6);
    }
}