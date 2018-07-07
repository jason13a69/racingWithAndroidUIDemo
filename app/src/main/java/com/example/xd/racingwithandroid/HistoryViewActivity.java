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

public class HistoryViewActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabHost host;

    /* 以下 Tab 1 => history_view_drag_tab */
    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter DragTabAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    String[] Drag_Tab_TextView1 =
            {
                    "100 m",
                    "0-60 km/h",
                    "0-60 km/h"};

    String[] Drag_Tab_TextView2 =
            {
                    "3 laps/01:00/098 m",
                    "3 laps/01:07/808 m",
                    "3 laps/01:20/851 m"};

    String[] Drag_Tab_TextView3 =
            {
                    "C8.715@Lap3",
                    "C7.550@Lap3",
                    "C7.58H@Lap3"};

    String[] Drag_Tab_TextView4 =
            {
                    "2018/06/17 13:35:13",
                    "2018/06/17 19:32:11",
                    "2018/06/04 11:40:20"};

    int[] Drag_Tab_ImageView1 =
            {
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background
            };

    /* 以上 Tab 1 => history_view_drag_tab */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view);
        getWindow().setWindowAnimations(0);

        host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        /* 以下 Tab 1 => history_race_view_drag_tab */
        TabHost.TabSpec spec = host.newTabSpec("Drag");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Drag");
        host.addTab(spec);

        context = getApplicationContext();
        relativeLayout = (RelativeLayout) findViewById(R.id.HistoryViewDragTabRelativeLayout);
        recyclerView = (RecyclerView) findViewById(R.id.HistoryViewDragTabRecyclerView);
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        DragTabAdapter = new HistoryViewActivity_RecyclerViewAdapter(context, Drag_Tab_TextView1, Drag_Tab_TextView2,Drag_Tab_TextView3,Drag_Tab_TextView4, Drag_Tab_ImageView1);
        recyclerView.setAdapter(DragTabAdapter);
        /* 以上 Tab 1 => history_race_view_drag_tab */

        /* Tab 2 */
        spec = host.newTabSpec("Circuit");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Circuit");
        host.addTab(spec);


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
        Intent homeIntent = new Intent(HistoryViewActivity.this, MainViewActivity.class);

        startActivity(homeIntent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //當返回按鈕，按下所需要去觸發的動作，如:彈跳出對話視窗
            Intent homeIntent = new Intent(HistoryViewActivity.this, MainViewActivity.class);
            startActivity(homeIntent);
            finish();
        }
        return false;
    }

    public void gpsClick(View view){
        Intent homeIntent = new Intent(HistoryViewActivity.this, GPSStatusViewInternalActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
    }

}
