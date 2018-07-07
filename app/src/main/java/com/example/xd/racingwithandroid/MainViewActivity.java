package com.example.xd.racingwithandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        getWindow().setWindowAnimations(0);
    }

    public void dragRaceClick(View view){
        Intent homeIntent = new Intent(MainViewActivity.this, DragRaceViewActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
        finish();
    }

    public void circuitRaceClick(View view){
        Intent homeIntent = new Intent(MainViewActivity.this, CircuitRaceViewActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
        finish();
    }

    public void historyClick(View view){
        Intent homeIntent = new Intent(MainViewActivity.this, HistoryViewActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
        finish();
    }

    public void racerClick(View view){
        Intent homeIntent = new Intent(MainViewActivity.this, RacerViewActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
        finish();
    }

    public void settingClick(View view){
        Intent homeIntent = new Intent(MainViewActivity.this, SettingsViewActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
        finish();
    }
}

/* 去除轉場動畫 http://kxitnote.blogspot.com/2012/03/android-activity.html */
