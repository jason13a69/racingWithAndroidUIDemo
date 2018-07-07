package com.example.xd.racingwithandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RacerViewActivity_RecyclerViewAdapter extends RecyclerView.Adapter<RacerViewActivity_RecyclerViewAdapter.ViewHolder> {

    private String[] str_textView1, str_textView2, str_textView3;
    private int[] int_imageView1;
    private Context context;
    private RacerViewActivity activity;
    View view1;
    RacerViewActivity_RecyclerViewAdapter.ViewHolder viewHolder1;
    TextView textView;


    public RacerViewActivity_RecyclerViewAdapter(Context context1, int[] int_imageView1, String[] str_textView1, String[] str_textView2) {
        context = context1;
        activity = new RacerViewActivity();
        this.int_imageView1 = int_imageView1;
        this.str_textView1 = str_textView1;
        this.str_textView2 = str_textView2;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView1, textView2;
        public ImageView imageView1;

        public ViewHolder(View v, final Context context, final Activity activity) {
            super(v);
            imageView1 = (ImageView) v.findViewById(R.id.RacerViewimageView1);
            textView1 = (TextView) v.findViewById(R.id.RacerViewTextView1);
            textView2 = (TextView) v.findViewById(R.id.RacerViewTextView2);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() != RecyclerView.NO_POSITION) {
                        Intent homeIntent = new Intent(context, RacerEditViewActivity.class);
                        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        homeIntent.setFlags(homeIntent.FLAG_ACTIVITY_NEW_TASK); /* https://stackoverflow.com/questions/3918517/calling-startactivity-from-outside-of-an-activity-context */
                        context.startActivity(homeIntent);
                        activity.finish();
                        if (getAdapterPosition() == 1) {
                        } /* 如果點擊的元件位置getAdapterPosition() == 1，則第1列的指定元件點擊事件被觸發，執行if內的描述 */
                        Log.d("View1", "testestests" + getAdapterPosition());
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public RacerViewActivity_RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view1 = LayoutInflater.from(context).inflate(R.layout.racer_view_recyclerview, parent, false);
        viewHolder1 = new RacerViewActivity_RecyclerViewAdapter.ViewHolder(view1, context, activity);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull RacerViewActivity_RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textView1.setText(str_textView1[position]);
        holder.textView2.setText(str_textView2[position]);
        holder.imageView1.setImageResource(int_imageView1[position]);
        if (position == 0) {
            holder.textView2.setVisibility(View.GONE); /* http://redshoee.blogspot.com/2012/05/android-viewsetvisibility.html */
        }
    }

    @Override
    public int getItemCount() {
        return str_textView1.length;
    }
}
