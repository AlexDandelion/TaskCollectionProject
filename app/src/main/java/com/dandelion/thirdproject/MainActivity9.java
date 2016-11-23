package com.dandelion.thirdproject;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;

public class MainActivity9 extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.pref);

//        PreferenceScreen preferenceScreen = getPreferenceManager().createPreferenceScreen(this);
//        setPreferenceScreen(preferenceScreen);
//
//        SwitchPreference switchPreference1 = new SwitchPreference(this);
//        switchPreference1.setKey("wifi");
//        switchPreference1.setTitle(R.string.wifi_title);
//        switchPreference1.setSummary(R.string.wifi_summary);
//        switchPreference1.setDefaultValue(true);
//        preferenceScreen.addPreference(switchPreference1);
//
//        SwitchPreference switchPreference2 = new SwitchPreference(this);
//        switchPreference2.setKey("hints");
//        switchPreference2.setTitle(R.string.hints_title);
//        switchPreference2.setSummary(R.string.hints_summary);
//        switchPreference2.setDefaultValue(false);
//        preferenceScreen.addPreference(switchPreference2);
//
//        ListPreference listPreference = new ListPreference(this);
//        listPreference.setKey("languages");
//        listPreference.setTitle(R.string.languages_title);
//        listPreference.setSummary(R.string.languages_summary);
//        listPreference.setEntries(R.array.languages);
//        listPreference.setEntryValues(R.array.languages);
//        listPreference.setDialogTitle("Выберите стиль для шрифта");
//        preferenceScreen.addPreference(listPreference);

    }
}
