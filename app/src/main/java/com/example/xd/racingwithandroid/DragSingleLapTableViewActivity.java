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

public class DragSingleLapTableViewActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter Tab1TabAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    String[] Tab1_Tab_TextView1 =
            {
                    "Speed",
                    "0 ~ 10",
                    "10 ~ 20",
                    "20 ~ 30",
                    "30 ~ 40",
                    "40 ~ 50",
                    "50 ~ 60"};

    String[] Tab1_Tab_TextView2 =
            {
                    "Time",
                    "0.868",
                    "0.889",
                    "1.028",
                    "1.890",
                    "1.300",
                    "1.958"};

    String[] Tab1_Tab_TextView3 =
            {
                    "Distance",
                    "1.37 m",
                    "3.98 m",
                    "7.35 m",
                    "19.20 m",
                    "16.84 m",
                    "30.52 m"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_single_lap_table_view);
        getWindow().setWindowAnimations(0);

        context = getApplicationContext();
        relativeLayout = (RelativeLayout) findViewById(R.id.DragSingleLapViewTab1TabRelativeLayout);
        recyclerView = (RecyclerView) findViewById(R.id.DragSingleLapViewTab1TabRecyclerView);
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        Tab1TabAdapter = new DragSingleLapViewActivity_RecyclerViewAdapter(context, Tab1_Tab_TextView1, Tab1_Tab_TextView2, Tab1_Tab_TextView3);
        recyclerView.setAdapter(Tab1TabAdapter);
    }

    public void backClick(View view){
        Intent homeIntent = new Intent(DragSingleLapTableViewActivity.this, SessionDetailView.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //當返回按鈕，按下所需要去觸發的動作，如:彈跳出對話視窗
            Intent homeIntent = new Intent(DragSingleLapTableViewActivity.this, SessionDetailView.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(homeIntent);
            finish();
        }
        return false;
    }

    public void tab2Click(View view){
        Intent homeIntent = new Intent(DragSingleLapTableViewActivity.this, ReplayViewActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
        finish();
    }

    public void gpsClick(View view){
        Intent homeIntent = new Intent(DragSingleLapTableViewActivity.this, GPSStatusViewInternalActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
    }
}
