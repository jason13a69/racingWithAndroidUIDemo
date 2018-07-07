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

public class RacerViewActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter RacerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;

    int[] RacerView_ImageView1 =
            {
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background
            };

    String[] RacerView_TextView1 =
            {
                    "Edit",
                    "Sign out"};

    String[] RacerView_TextView2 =
            {
                    "Sign out",
                    "qaerty@qstarz.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racer_view);
        getWindow().setWindowAnimations(0);

        context = getApplicationContext();
        relativeLayout = (RelativeLayout) findViewById(R.id.RacerViewRelativeLayout);
        recyclerView = (RecyclerView) findViewById(R.id.RacerViewRecyclerView);
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        RacerViewAdapter = new RacerViewActivity_RecyclerViewAdapter(context,RacerView_ImageView1, RacerView_TextView1, RacerView_TextView2);
        recyclerView.setAdapter(RacerViewAdapter);
    }

    public void backClick(View view){
        Intent homeIntent = new Intent(RacerViewActivity.this, MainViewActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //當返回按鈕，按下所需要去觸發的動作，如:彈跳出對話視窗
            Intent homeIntent = new Intent(RacerViewActivity.this, MainViewActivity.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(homeIntent);
            finish();
        }
        return false;
    }

    public void gpsClick(View view){
        Intent homeIntent = new Intent(RacerViewActivity.this, GPSStatusViewInternalActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(homeIntent);
    }
}
