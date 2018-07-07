package com.example.xd.racingwithandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DragRaceViewActivity_RecyclerViewAdapter extends RecyclerView.Adapter<DragRaceViewActivity_RecyclerViewAdapter.ViewHolder> {

    String[] SubjectValues;
    Context context;
    View view1;
    DragRaceViewActivity_RecyclerViewAdapter.ViewHolder viewHolder1;
    TextView textView;

    public DragRaceViewActivity_RecyclerViewAdapter(Context context1, String[] SubjectValues1) {
        SubjectValues = SubjectValues1;
        context = context1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.DragRaceViewSpeedTabTextView1);
        }
    }

    @NonNull
    @Override
    public DragRaceViewActivity_RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view1 = LayoutInflater.from(context).inflate(R.layout.drag_race_view_speed_tab, parent, false);
        viewHolder1 = new DragRaceViewActivity_RecyclerViewAdapter.ViewHolder(view1);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull DragRaceViewActivity_RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textView.setText(SubjectValues[position]);
    }

    @Override
    public int getItemCount() {
        return SubjectValues.length;
    }
}
