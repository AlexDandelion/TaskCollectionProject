package com.dandelion.thirdproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAction();
    }

    private void myAction() {
        Button buttonRed = (Button) findViewById(R.id.redButton);
        Button buttonYellow = (Button) findViewById(R.id.yellowButton);
        Button buttonGreen = (Button) findViewById(R.id.greenButton);
        Button popupButton = (Button) findViewById(R.id.popupButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.redButton:
                        relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorRed));
                        break;
                    case R.id.yellowButton:
                        relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorYellow));
                        break;
                    case R.id.greenButton:
                        relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                        break;
                    case R.id.popupButton:
                        showPopup(v);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "WTF ONCLICK", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        buttonRed.setOnClickListener(onClickListener);
        buttonYellow.setOnClickListener(onClickListener);
        buttonGreen.setOnClickListener(onClickListener);
        popupButton.setOnClickListener(onClickListener);
    }

    private void showPopup(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu1:
                        Toast.makeText(getApplicationContext(), "menu1", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu2:
                        Toast.makeText(getApplicationContext(), "menu2", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu3:
                        Toast.makeText(getApplicationContext(), "menu3", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu4:
                        Toast.makeText(getApplicationContext(), "menu4", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu5:
                        Toast.makeText(getApplicationContext(), "menu5", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu6:
                        Toast.makeText(getApplicationContext(), "menu6", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.submenu:
                        Toast.makeText(getApplicationContext(), "submenu", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }

    public void onClickMain2(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void onClickMain3(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void onClickMain4(View view) {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }

    public void onClickMain5(View view) {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }

    public void onClickMain6(View view) {
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }

    public void onClickMain7(View view) {
        Intent intent = new Intent(this, MainActivity7.class);
        startActivity(intent);
    }

    public void onClickMain8(View view) {
        Intent intent = new Intent(this, MainActivity8.class);
        startActivity(intent);
    }

    public void onClickMain9(View view) {
        Intent intent = new Intent(this, MainActivity9.class);
        startActivity(intent);
    }

    public void onClickMain10(View view) {
        Intent intent = new Intent(this, MainActivity10.class);
        startActivity(intent);
    }

    public void onClickMain11(View view) {
        Intent intent = new Intent(this, MainActivity11.class);
        startActivity(intent);
    }

    public void onClickMain12(View view) {
        Intent intent = new Intent(this, MainActivity12.class);
        startActivity(intent);
    }

    public void onClickMain13(View view) {
        Intent intent = new Intent(this, MainActivity13.class);
        startActivity(intent);
    }

    public void onClickMain14(View view) {
        Intent intent = new Intent(this, MainActivity14.class);
        startActivity(intent);
    }

    public void onClickMain15(View view) {
        Intent intent = new Intent(this, MainActivity15.class);
        startActivity(intent);
    }

    public void onClickMain16(View view) {
        Intent intent = new Intent(this, MainActivity16.class);
        startActivity(intent);
    }

    public void onClickMain17(View view) {
        Intent intent = new Intent(this, MainActivity17.class);
        startActivity(intent);
    }

    public void onClickMain18(View view) {
        Intent intent = new Intent(this, MainActivity18.class);
        startActivity(intent);
    }

    public void onClickMain19(View view) {
        Intent intent = new Intent(this, MainActivity19.class);
        startActivity(intent);
    }
}
