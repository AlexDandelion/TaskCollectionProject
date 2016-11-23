package com.dandelion.thirdproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity13PageFragment0 extends Fragment {

    public MainActivity13PageFragment0() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main13_fragment0, container, false);

        return view;
    }

//    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
//
//    int pageNumber;
//    int backColor;
//
//    static MainActivity13PageFragment0 newInstance(int page) {
//        MainActivity13PageFragment0 mainActivity13PageFragment0 = new MainActivity13PageFragment0();
//        Bundle arguments = new Bundle();
//        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
//        mainActivity13PageFragment0.setArguments(arguments);
//        return mainActivity13PageFragment0;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
//
//        Random rnd = new Random();
//        backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_main13_fragment0, null);
//
//        TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
//        tvPage.setText("Page " + pageNumber);
//        tvPage.setBackgroundColor(backColor);
//
//        return view;
//    }
}
