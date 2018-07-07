package com.example.xd.racingwithandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class AboutViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_view);
        getWindow().setWindowAnimations(0);
    }

    public void backClick(View view){
        Intent homeIntent = new Intent(AboutViewActivity.this, SettingsViewActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //當返回按鈕，按下所需要去觸發的動作，如:彈跳出對話視窗
            Intent homeIntent = new Intent(AboutViewActivity.this, SettingsViewActivity.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(homeIntent);
            finish();
        }
        return false;
    }

    public void gpsClick(View view){
        Intent homeIntent = new Intent(AboutViewActivity.this, GPSStatusViewInternalActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
    }
}
