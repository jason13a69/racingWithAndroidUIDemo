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

public class SessionDetailView extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter SummaryTabAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    String[] Summary_Tab_TextView1 =
            {
                    "Lap",
                    "1",
                    "2",
                    "3"};

    String[] Summary_Tab_TextView2 =
            {
                    "Time(diff)",
                    "7.612(+0.045)",
                    "7.834(+0.366)",
                    "7.588"};

    String[] Summary_Tab_TextView3 =
            {
                    "Distance",
                    "83.55 m",
                    "79.25 m",
                    "73.13 m"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_detail_view);
        getWindow().setWindowAnimations(0);

        context = getApplicationContext();
        relativeLayout = (RelativeLayout) findViewById(R.id.SessionDetailViewSummaryTabRelativeLayout);
        recyclerView = (RecyclerView) findViewById(R.id.SessionDetailViewSummaryTabRecyclerView);
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        SummaryTabAdapter = new SessionDetailViewActivity_RecyclerViewAdapter(context, Summary_Tab_TextView1, Summary_Tab_TextView2, Summary_Tab_TextView3);
        recyclerView.setAdapter(SummaryTabAdapter);
    }

    public void backClick(View view){
        Intent homeIntent = new Intent(SessionDetailView.this, HistoryViewActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //當返回按鈕，按下所需要去觸發的動作，如:彈跳出對話視窗
            Intent homeIntent = new Intent(SessionDetailView.this, HistoryViewActivity.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(homeIntent);
            finish();
        }
        return false;
    }

    public void gpsClick(View view){
        Intent homeIntent = new Intent(SessionDetailView.this, GPSStatusViewInternalActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
    }
}
