package com.dandelion.thirdproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity18 extends AppCompatActivity {

    MainActivity18DBHelper db;
    EditText add;
    EditText update;
    EditText delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main18);

        db = MainActivity18DBHelper.getInstance(this);
        add = (EditText) findViewById(R.id.editText1);
        update = (EditText) findViewById(R.id.editText2);
        delete = (EditText) findViewById(R.id.editText3);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.getButton:
                db.getData();
                break;
            case R.id.createButton:
                db.createData(add.getText().toString());
                break;
            case R.id.updateButton:
                db.updateData(update.getText().toString());
                break;
            case R.id.deleteButton:
                db.deleteData(delete.getText().toString());
                break;
            case R.id.closeButton:
                db.close();
                break;
            default:
                break;
        }
    }
}
