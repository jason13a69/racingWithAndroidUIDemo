package com.example.xd.racingwithandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GPSSettingViewActivity_RecyclerViewAdapter extends RecyclerView.Adapter<GPSSettingViewActivity_RecyclerViewAdapter.ViewHolder> {

    private String[] str_textView1;
    private int[] int_imageView1;
    private Context context;
    View view1;
    GPSSettingViewActivity_RecyclerViewAdapter.ViewHolder viewHolder1;
    TextView textView;


    public GPSSettingViewActivity_RecyclerViewAdapter(Context context1, String[] str_textView1, int[] int_imageView1) {
        context = context1;
        this.str_textView1 = str_textView1;
        this.int_imageView1 = int_imageView1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView1;
        public ImageView imageView1;

        public ViewHolder(View v) {
            super(v);
            textView1 = (TextView) v.findViewById(R.id.GPSSettingViewTextView1);
            imageView1 = (ImageView) v.findViewById(R.id.GPSSettingViewimageView1);
        }
    }

    @NonNull
    @Override
    public GPSSettingViewActivity_RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view1 = LayoutInflater.from(context).inflate(R.layout.gpssetting_view_recyclerview, parent, false);
        viewHolder1 = new GPSSettingViewActivity_RecyclerViewAdapter.ViewHolder(view1);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull GPSSettingViewActivity_RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textView1.setText(str_textView1[position]);
        holder.imageView1.setImageResource(int_imageView1[position]);
    }

    @Override
    public int getItemCount() {
        return str_textView1.length;
    }
}
