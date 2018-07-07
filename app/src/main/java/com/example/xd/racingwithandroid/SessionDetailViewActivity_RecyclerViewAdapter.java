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

public class SessionDetailViewActivity_RecyclerViewAdapter extends RecyclerView.Adapter<SessionDetailViewActivity_RecyclerViewAdapter.ViewHolder> {

    private String[] str_textView1, str_textView2, str_textView3;
    private Context context;
    private SessionDetailView activity;
    View view1;
    SessionDetailViewActivity_RecyclerViewAdapter.ViewHolder viewHolder1;
    TextView textView;


    public SessionDetailViewActivity_RecyclerViewAdapter(Context context1, String[] str_textView1, String[] str_textView2, String[] str_textView3) {
        context = context1;
        activity = new SessionDetailView();
        this.str_textView1 = str_textView1;
        this.str_textView2 = str_textView2;
        this.str_textView3 = str_textView3;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView1, textView2, textView3;
        public LinearLayout LinearLayout1,LinearLayout2;

        public ViewHolder(View v,final Context context, final Activity activity) {
            super(v);
            textView1 = (TextView) v.findViewById(R.id.SessionDetailViewSummaryTabTextView1);
            textView2 = (TextView) v.findViewById(R.id.SessionDetailViewSummaryTabTextView2);
            textView3 = (TextView) v.findViewById(R.id.SessionDetailViewSummaryTabTextView3);
            LinearLayout1 = (LinearLayout) v.findViewById(R.id.SessionDetailViewSummaryTabLinearLayout1);
            LinearLayout2 = (LinearLayout) v.findViewById(R.id.SessionDetailViewSummaryTabLinearLayout2);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() != RecyclerView.NO_POSITION) {
                        Intent homeIntent = new Intent(context, DragSingleLapTableViewActivity.class);
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
    public SessionDetailViewActivity_RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view1 = LayoutInflater.from(context).inflate(R.layout.session_detail_view_summary_tab, parent, false);
        viewHolder1 = new SessionDetailViewActivity_RecyclerViewAdapter.ViewHolder(view1, context, activity);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull SessionDetailViewActivity_RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textView1.setText(str_textView1[position]);
        holder.textView2.setText(str_textView2[position]);
        holder.textView3.setText(str_textView3[position]);
        if (position == 0) {
            holder.textView1.setBackgroundColor(Color.parseColor("#263646"));
            holder.textView2.setBackgroundColor(Color.parseColor("#263646"));
            holder.textView3.setBackgroundColor(Color.parseColor("#263646"));
        } else if (position % 2 == 1) {
            holder.textView1.setBackgroundColor(Color.parseColor("#202020"));
            holder.textView2.setBackgroundColor(Color.parseColor("#202020"));
            holder.textView3.setBackgroundColor(Color.parseColor("#202020"));
        } else if (position % 2 == 0) {
            holder.textView1.setBackgroundColor(Color.parseColor("#333333"));
            holder.textView2.setBackgroundColor(Color.parseColor("#333333"));
            holder.textView3.setBackgroundColor(Color.parseColor("#333333"));
            holder.LinearLayout1.setPadding(0,10,0,0);
        }
    }

    @Override
    public int getItemCount() {
        return str_textView1.length;
    }
}
