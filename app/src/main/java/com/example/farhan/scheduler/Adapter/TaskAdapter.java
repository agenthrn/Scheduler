package com.example.farhan.scheduler.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.farhan.scheduler.R;
import com.example.farhan.scheduler.Task;


import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<Task> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,date,time;

        ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            date = (TextView) itemView.findViewById(R.id.tvDate);
            time = (TextView) itemView.findViewById(R.id.tvTime);

        }
    }

    public TaskAdapter(ArrayList<Task> data) {
        this.dataSet = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.taskrv_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        holder.title.setText(dataSet.get(position).getTitle());
        holder.date.setText(dataSet.get(position).getDate());
        holder.time.setText(dataSet.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}