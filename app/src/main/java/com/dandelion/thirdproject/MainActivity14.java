package com.dandelion.thirdproject;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity14 extends AppCompatActivity implements View.OnClickListener {

    final String MY_LOG = "MyLog";
    private String locale = "en";
    private Button readFromXmlButton;
    private Button enButton;
    private Button ukButton;
    private Button ruButton;
    private TextView tipTextView;
    private TextView authorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font.ttf");

        readFromXmlButton = (Button) findViewById(R.id.readFromXmlButton);
        enButton = (Button) findViewById(R.id.enButton);
        ukButton = (Button) findViewById(R.id.ukButton);
        ruButton = (Button) findViewById(R.id.ruButton);
        tipTextView = (TextView) findViewById(R.id.tip);
        authorTextView = (TextView) findViewById(R.id.author);

        readFromXmlButton.setOnClickListener(this);
        enButton.setOnClickListener(this);
        ukButton.setOnClickListener(this);
        ruButton.setOnClickListener(this);

        enButton.setTypeface(typeface);
        ukButton.setTypeface(typeface);
        ruButton.setTypeface(typeface);
        tipTextView.setTypeface(typeface);
        authorTextView.setTypeface(typeface);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.enButton:
                locale = "en";
                break;
            case R.id.ukButton:
                locale = "uk";
                break;
            case R.id.ruButton:
                locale = "ru";
                break;
            case R.id.readFromXmlButton:
                XmlPullParser xmlPullParser = getResources().getXml(R.xml.question_advices);

                int randomTip = (int) (Math.random() * 172 + 1);
                int countTips = 0;
                List<String> tip = new ArrayList<>();
                boolean findTip = false;
                boolean correctLocale = false;

                try {
                    while (xmlPullParser.getEventType() != XmlPullParser.END_DOCUMENT
                            && !findTip) {
                        String name = xmlPullParser.getName();
                        String text = xmlPullParser.getText();
                        switch (xmlPullParser.getEventType()) {
                            case XmlPullParser.START_TAG:
                                if (correctLocale && "dict".equals(name)) {
                                    countTips++;
                                } else if (locale.equals(name)) {
                                    correctLocale = true;
                                }
                                break;
                            case XmlPullParser.TEXT:
                                if (countTips == randomTip && !("avtor".equals(text))
                                        && !("advise".equals(text))) {
                                    tip.add(text);
                                }
                                break;
                            case XmlPullParser.END_TAG:
                                if (countTips == randomTip && "dict".equals(name)) {
                                    findTip = true;
                                }
                                break;
                            default:
                                break;
                        }
                        xmlPullParser.next();
                    }
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                authorTextView.setText(tip.get(0));
                tipTextView.setText(tip.get(1));
                break;
            default:
                break;
        }
    }

    public void readCountFromXML(View view) {
        switch (view.getId()) {
            case R.id.enButton:
                locale = "en";
                break;
            case R.id.ukButton:
                locale = "uk";
                break;
            case R.id.ruButton:
                locale = "ru";
                break;
            case R.id.readFromXmlButton:
                XmlPullParser xmlPullParser = getResources().getXml(R.xml.day_advices);

                int allAdvise = 0;
                int ruAdvise = 0;
                int enAdvise = 0;
                int ukAdvise = 0;
                boolean ruAdviseTrue = false;
                boolean enAdviseTrue = false;
                boolean ukAdviseTrue = false;

                try {
                    while (xmlPullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                        String name = xmlPullParser.getName();
                        switch (xmlPullParser.getEventType()) {
                            case XmlPullParser.START_TAG:
                                if ("dict".equals(name)) {
                                    allAdvise++;
                                    if(ruAdviseTrue) {
                                        ruAdvise++;
                                    }
                                    if(enAdviseTrue) {
                                        enAdvise++;
                                    }
                                    if(ukAdviseTrue) {
                                        ukAdvise++;
                                    }
                                } else if ("ru".equals(name)) {
                                    ruAdviseTrue = true;
                                }else if ("en".equals(name)) {
                                    enAdviseTrue = true;
                                }else if ("uk".equals(name)) {
                                    ukAdviseTrue = true;
                                }
                                break;
                            case XmlPullParser.END_TAG:
                                if ("ru".equals(name)) {
                                    ruAdviseTrue = false;
                                }else if ("en".equals(name)) {
                                    enAdviseTrue = false;
                                }else if ("uk".equals(name)) {
                                    ukAdviseTrue = false;
                                }
                                break;
                            default:
                                break;
                        }
                        xmlPullParser.next();
                    }
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.e("*****", "allAdvise " + allAdvise);
                Log.e("*****", "ruAdvise " + ruAdvise);
                Log.e("*****", "enAdvise " + enAdvise);
                Log.e("*****", "ukAdvise " + ukAdvise);
                break;
            default:
                break;
        }
    }

    public void readFromXML(View view) {
        Log.d(MY_LOG, "Start");
        XmlPullParser xmlPullParser = getResources().getXml(R.xml.ma14_xml_pull_parser);
        try {
            while (xmlPullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (xmlPullParser.getEventType()) {
                    case XmlPullParser.START_DOCUMENT:
                        Log.d(MY_LOG, "START_DOCUMENT");
                        break;
                    case XmlPullParser.START_TAG:
                        Log.d(MY_LOG, "START_TAG: name= " + xmlPullParser.getName()
                                + " dept " + xmlPullParser.getDepth() + " atr.count = "
                                + xmlPullParser.getAttributeCount());
                        String text = "";

                        for (int a = 0; a < xmlPullParser.getAttributeCount(); a++) {
                            text += xmlPullParser.getAttributeName(a) + " = "
                                    + xmlPullParser.getAttributeValue(a) + " , ";
                        }
                        Log.d(MY_LOG, text);
                        break;
                    case XmlPullParser.END_TAG:
                        Log.d(MY_LOG, "END_TAG:name= " + xmlPullParser.getName());
                        break;
                    case XmlPullParser.TEXT:
                        Log.d(MY_LOG, " text= " + xmlPullParser.getText());
                        break;
                    default:
                        break;
                }
                xmlPullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(MY_LOG, "END_DOCUMENT");
    }
}
