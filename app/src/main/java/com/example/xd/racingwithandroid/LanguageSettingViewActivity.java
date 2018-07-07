package com.example.xd.racingwithandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class LanguageSettingViewActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter LanguageSettingAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    String[] LanguageSetting_TextView1 =
            {
                    "English",
                    "日文語",
                    "繁體中文"
            };

    int[] LanguageSetting_ImageView1 =
            {
                    R.drawable.ic_check_circle_white,
                    R.drawable.ic_lens_gray,
                    R.drawable.ic_lens_gray};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_setting_view);
        getWindow().setWindowAnimations(0);

        context = getApplicationContext();
        relativeLayout = (RelativeLayout) findViewById(R.id.LanguageSettingViewRelativeLayout);
        recyclerView = (RecyclerView) findViewById(R.id.LanguageSettingViewRecyclerView);
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        LanguageSettingAdapter = new LanguageSettingViewActivity_RecyclerViewAdapter(context, LanguageSetting_TextView1, LanguageSetting_ImageView1);
        recyclerView.setAdapter(LanguageSettingAdapter);
    }

    public void backClick(View view){
        Intent homeIntent = new Intent(LanguageSettingViewActivity.this, SettingsViewActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //當返回按鈕，按下所需要去觸發的動作，如:彈跳出對話視窗
            Intent homeIntent = new Intent(LanguageSettingViewActivity.this, SettingsViewActivity.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(homeIntent);
            finish();
        }
        return false;
    }

    public void gpsClick(View view){
        Intent homeIntent = new Intent(LanguageSettingViewActivity.this, GPSStatusViewInternalActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
    }
}
