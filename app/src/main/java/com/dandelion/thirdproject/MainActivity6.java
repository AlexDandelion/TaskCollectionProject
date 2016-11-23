package com.dandelion.thirdproject;


import android.annotation.TargetApi;
import android.content.pm.ActivityInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity6 extends AppCompatActivity {

    SoundPool mSoundPool;
    AssetManager mAssetManager;
    Map<String, Integer> animalsId;
    int mStreamID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            // Для устройств до Android 5
            createOldSoundPool();
        } else {
            // Для новых устройств
            createNewSoundPool();
        }

        mAssetManager = getAssets();
        animalsId = new HashMap<>();

        animalsId.put("mCatSound", loadSound("cat.ogg"));
        animalsId.put("mChickenSound", loadSound("chicken.ogg"));
        animalsId.put("mCowSound", loadSound("cow.ogg"));
        animalsId.put("mDogSound", loadSound("dog.ogg"));
        animalsId.put("mDuckSound", loadSound("duck.ogg"));
        animalsId.put("mSheepSound", loadSound("sheep.ogg"));

        ImageButton cowImageButton = (ImageButton) findViewById(R.id.imageButtonCow);
        cowImageButton.setOnClickListener(onClickListener);

        ImageButton chickenImageButton = (ImageButton) findViewById(R.id.imageButtonChicken);
        chickenImageButton.setOnClickListener(onClickListener);

        ImageButton catImageButton = (ImageButton) findViewById(R.id.imageButtonCat);
        catImageButton.setOnClickListener(onClickListener);

        ImageButton duckImageButton = (ImageButton) findViewById(R.id.imageButtonDuck);
        duckImageButton.setOnClickListener(onClickListener);

        ImageButton sheepImageButton = (ImageButton) findViewById(R.id.imageButtonSheep);
        sheepImageButton.setOnClickListener(onClickListener);

        ImageButton dogImageButton = (ImageButton) findViewById(R.id.imageButtonDog);
        dogImageButton.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageButtonCow:
                    playSound(animalsId.get("mCowSound"));
                    break;
                case R.id.imageButtonChicken:
                    playSound(animalsId.get("mChickenSound"));
                    break;
                case R.id.imageButtonCat:
                    playSound(animalsId.get("mCatSound"));
                    break;
                case R.id.imageButtonDuck:
                    playSound(animalsId.get("mDuckSound"));
                    break;
                case R.id.imageButtonSheep:
                    playSound(animalsId.get("mSheepSound"));
                    break;
                case R.id.imageButtonDog:
                    playSound(animalsId.get("mDogSound"));
                    break;
            }
        }
    };

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void createNewSoundPool() {
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        mSoundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
    }

    @SuppressWarnings("deprecation")
    private void createOldSoundPool() {
        mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
    }

    private int playSound(int sound) {
        if (sound > 0) {
            mStreamID = mSoundPool.play(sound, 1, 1, 1, 0, 1);
        }
        return mStreamID;
    }

    private int loadSound(String fileName) {
        AssetFileDescriptor afd;
        try {
            afd = mAssetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Не могу загрузить файл " + fileName,
                    Toast.LENGTH_SHORT).show();
            return -1;
        }
        return mSoundPool.load(afd, 1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            // Для устройств до Android 5
            createOldSoundPool();
        } else {
            // Для новых устройств
            createNewSoundPool();
        }

        mAssetManager = getAssets();
        animalsId = new HashMap<>();

        animalsId.put("mCatSound", loadSound("cat.ogg"));
        animalsId.put("mChickenSound", loadSound("chicken.ogg"));
        animalsId.put("mCowSound", loadSound("cow.ogg"));
        animalsId.put("mDogSound", loadSound("dog.ogg"));
        animalsId.put("mDuckSound", loadSound("duck.ogg"));
        animalsId.put("mSheepSound", loadSound("sheep.ogg"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSoundPool.release();
        mSoundPool = null;
    }

}
