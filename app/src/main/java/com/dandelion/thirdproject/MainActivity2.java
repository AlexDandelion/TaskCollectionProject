package com.dandelion.thirdproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity2 extends AppCompatActivity {

    public static final String FILE_NAME = "MyFile.txt";
    private EditText fileEditText;
    private int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fileEditText = (EditText) findViewById(R.id.myFileEditText);
    }

    public void action(View view) {
        progressStatus = 0;
        final Handler handler = new Handler();
        final TextView progressTextView = (TextView) findViewById(R.id.progressTextView);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100) {
                    progressStatus++;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            progressTextView.setText("Progress: " + progressStatus + "/" + progressBar.getMax());
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(sharedPreferences.getBoolean(getString(R.string.pref_open_mode), false)) {
            openFile(FILE_NAME);
        }
        float textSize = Float.parseFloat(sharedPreferences
                .getString(getString(R.string.pref_size), "20"));
        fileEditText.setTextSize(textSize);
    }

    private void saveFile(String fileName) {
        try {
            OutputStream outputStream = openFileOutput(fileName, 0);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(fileEditText.getText().toString());
            outputStreamWriter.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG);
        }
    }

    private void openFile(String fileName) {
        try {
            InputStream inputStream = openFileInput(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            fileEditText.setText(stringBuilder.toString());
            inputStream.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG);
        }
    }

    public void onClickOpen(View view) {
        openFile(FILE_NAME);
    }

    public void onClickActionSettings(View view) {
        Intent intent = new Intent(this, MainActivity2FilePreference.class);
        startActivity(intent);
    }

    public void onClickSave(View view) {
        saveFile(FILE_NAME);
    }
}
