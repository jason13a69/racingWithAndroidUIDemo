package com.example.xd.racingwithandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WarnViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warn_view);
        getWindow().setWindowAnimations(0);
    }

    public void agreeClick(View view){
        Intent homeIntent = new Intent(WarnViewActivity.this, EventViewActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
        finish();
    }
}
