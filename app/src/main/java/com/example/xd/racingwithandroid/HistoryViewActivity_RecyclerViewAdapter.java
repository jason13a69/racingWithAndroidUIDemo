package com.example.xd.racingwithandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HistoryViewActivity_RecyclerViewAdapter extends RecyclerView.Adapter<HistoryViewActivity_RecyclerViewAdapter.ViewHolder> {

    private String[] str_textView1, str_textView2, str_textView3, str_textView4;
    private int[] int_imageView1;
    private Context context;
    private HistoryViewActivity activity;
    View view1;
    HistoryViewActivity_RecyclerViewAdapter.ViewHolder viewHolder1;
    TextView textView;


    public HistoryViewActivity_RecyclerViewAdapter(Context context1, String[] str_textView1, String[] str_textView2, String[] str_textView3, String[] str_textView4, int[] int_imageView) {
        context = context1;
        activity = new HistoryViewActivity();
        this.str_textView1 = str_textView1;
        this.str_textView2 = str_textView2;
        this.str_textView3 = str_textView3;
        this.str_textView4 = str_textView4;
        this.int_imageView1 = int_imageView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView1, textView2, textView3, textView4;
        public ImageView imageView1;

        public ViewHolder(View v, final Context context, final Activity activity) {
            super(v);
            textView1 = (TextView) v.findViewById(R.id.HistoryViewDragTabTextView1);
            textView2 = (TextView) v.findViewById(R.id.HistoryViewDragTabTextView2);
            textView3 = (TextView) v.findViewById(R.id.HistoryViewDragTabTextView3);
            textView4 = (TextView) v.findViewById(R.id.HistoryViewDragTabTextView4);
            imageView1 = (ImageView) v.findViewById(R.id.HistoryViewDragTabimageView1);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() != RecyclerView.NO_POSITION) {
                        Intent homeIntent = new Intent(context, SessionDetailView.class);
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
    public HistoryViewActivity_RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view1 = LayoutInflater.from(context).inflate(R.layout.history_view_drag_tab, parent, false);
        viewHolder1 = new HistoryViewActivity_RecyclerViewAdapter.ViewHolder(view1, context, activity);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewActivity_RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textView1.setText(str_textView1[position]);
        holder.textView2.setText(str_textView2[position]);
        holder.textView3.setText(str_textView3[position]);
        holder.textView4.setText(str_textView4[position]);
        holder.imageView1.setImageResource(int_imageView1[position]);

    }

    @Override
    public int getItemCount() {
        return str_textView1.length;
    }
}
