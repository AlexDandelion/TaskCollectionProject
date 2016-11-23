package com.dandelion.thirdproject;


import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MainActivity2FilePreference extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_for_file);
    }
}
