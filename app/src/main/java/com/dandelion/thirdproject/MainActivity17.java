package com.dandelion.thirdproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity17 extends AppCompatActivity implements View.OnClickListener {
    private ListView mCompleteListView;
    private Button mAddItemToList;
    private List<String> mItems;
    private MainActivity17CompleteListAdapter mListAdapter;
    private static final int MIN = 0, MAX = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        initViews();
        mItems = new ArrayList<>();
        mListAdapter = new MainActivity17CompleteListAdapter(this, mItems);
        mCompleteListView.setAdapter(mListAdapter);
    }

    private void initViews() {
        mCompleteListView = (ListView) findViewById(R.id.completeList);
        mAddItemToList = (Button) findViewById(R.id.addItemToList);
        mAddItemToList.setOnClickListener(this);
    }

    private void addItemsToList() {
        int randomVal = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
        mItems.add(String.valueOf(randomVal));
        mListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addItemToList:
                addItemsToList();
                break;
        }
    }
}
