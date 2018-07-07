package com.example.xd.racingwithandroid;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DragSingleLapViewActivity_RecyclerViewAdapter extends RecyclerView.Adapter<DragSingleLapViewActivity_RecyclerViewAdapter.ViewHolder> {

    private String[] str_textView1, str_textView2, str_textView3;
    private Context context;
    View view1;
    DragSingleLapViewActivity_RecyclerViewAdapter.ViewHolder viewHolder1;
    TextView textView;


    public DragSingleLapViewActivity_RecyclerViewAdapter(Context context1, String[] str_textView1, String[] str_textView2, String[] str_textView3) {
        context = context1;
        this.str_textView1 = str_textView1;
        this.str_textView2 = str_textView2;
        this.str_textView3 = str_textView3;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView1, textView2, textView3;
        public LinearLayout LinearLayout1,LinearLayout2;

        public ViewHolder(View v) {
            super(v);
            textView1 = (TextView) v.findViewById(R.id.DragSingleLapViewTab1TabTextView1);
            textView2 = (TextView) v.findViewById(R.id.DragSingleLapViewTab1TabTextView2);
            textView3 = (TextView) v.findViewById(R.id.DragSingleLapViewTab1TabTextView3);
            LinearLayout1 = (LinearLayout) v.findViewById(R.id.DragSingleLapViewTab1TabLinearLayout1);
            LinearLayout2 = (LinearLayout) v.findViewById(R.id.DragSingleLapViewTab1TabLinearLayout2);
        }
    }

    @NonNull
    @Override
    public DragSingleLapViewActivity_RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view1 = LayoutInflater.from(context).inflate(R.layout.drag_single_lap_view_tab1_tab, parent, false);
        viewHolder1 = new DragSingleLapViewActivity_RecyclerViewAdapter.ViewHolder(view1);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull DragSingleLapViewActivity_RecyclerViewAdapter.ViewHolder holder, int position) {
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
        }
    }

    @Override
    public int getItemCount() {
        return str_textView1.length;
    }
}
