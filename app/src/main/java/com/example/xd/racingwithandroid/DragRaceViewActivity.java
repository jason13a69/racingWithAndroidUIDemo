package com.example.xd.racingwithandroid;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class DragRaceViewActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabHost host;



    /* 以下 Tab 2 => drag_race_view_speed_tab */
    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter SpeedTabAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    String[] Speed_Tab_String =
            {
                    "0-60 km/h",
                    "0-100 km/h",
                    "0-160 km/h",
                    "100-200 km/h",
                    "200-300 km/h"};
    /* 以上 Tab 2 => drag_race_view_speed_tab */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_race_view);
        getWindow().setWindowAnimations(0);

        host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Recent");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Recent");
        host.addTab(spec);

        /* 以下 Tab 2 => drag_race_view_speed_tab */
        spec = host.newTabSpec("Speed");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Speed");
        host.addTab(spec);

        context = getApplicationContext();
        relativeLayout = (RelativeLayout) findViewById(R.id.DragRaceViewSpeedTabRelativeLayout);
        recyclerView = (RecyclerView) findViewById(R.id.DragRaceViewSpeedTabRecyclerView);
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        SpeedTabAdapter = new DragRaceViewActivity_RecyclerViewAdapter(context, Speed_Tab_String);
        recyclerView.setAdapter(SpeedTabAdapter);
        /* 以上 Tab 2 => drag_race_view_speed_tab */


        //Tab 3
        spec = host.newTabSpec("Distance");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Distance");
        host.addTab(spec);

        //Tab 4
        spec = host.newTabSpec("Performance");
        spec.setContent(R.id.tab4);
        spec.setIndicator("Performance");
        host.addTab(spec);

        //Tab 5
        spec = host.newTabSpec("User");
        spec.setContent(R.id.tab5);
        spec.setIndicator("User");
        host.addTab(spec);


        host.setCurrentTab(1); /* How to set 2nd tab as default when app opens */ /* 要等全部的頁籤都置入完後才可以使用此方法 */

        host.getTabWidget().setRightStripDrawable(R.drawable.toolbar_green_underline);
        host.getTabWidget().setLeftStripDrawable(R.drawable.toolbar_green_underline);

        updateTab(host);

        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                updateTab(host); /* 一旦被切換就更新Tab的狀態，讓Tab能在滑到當下的頁籤更新文字顏色等 */
            }
        });/* Tab頁籤被切換的監聽器 */
    }

    private void updateTab(final TabHost tabHost) {
        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextSize(12);
            tv.setTransformationMethod(null);/* 設定不要是大寫 */
            // tv.setTypeface(Typeface.SERIF, 2); /* 設定字體和風格 */
            if (tabHost.getCurrentTab() == i) {/* 選中 */
                //view.setBackgroundDrawable(getResources().getDrawable(R.drawable.category_current));/* 選中後的背景 */
                tv.setTextColor(Color.WHITE);
            } else {/* 未選中 */
                //view.setBackgroundDrawable(getResources().getDrawable(R.drawable.category_bg));/* 非選擇的背景 */
                tv.setTextColor(Color.GRAY);
            }
        }
    }

    public void backClick(View view){
        Intent homeIntent = new Intent(DragRaceViewActivity.this, MainViewActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //當返回按鈕，按下所需要去觸發的動作，如:彈跳出對話視窗
            Intent homeIntent = new Intent(DragRaceViewActivity.this, MainViewActivity.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(homeIntent);
            finish();
        }
        return false;
    }

    public void gpsClick(View view){
        Intent homeIntent = new Intent(DragRaceViewActivity.this, GPSStatusViewInternalActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
    }
}

/* http://givemepass.blogspot.com/2015/12/toolbarmenu.html */
