package com.example.taskmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.TaskViewHolder> {

    public ArrayList<Task> task;
    public OnInteractingWithTaskListener listener;

    public ContactAdapter(ArrayList<Task> task, OnInteractingWithTaskListener listener) {
        this.task = task;
        this.listener = listener;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public Task task;
        public View itemView;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }


    @NonNull
    @Override
    public ContactAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_task, parent, false);

            final TaskViewHolder viewHolder = new TaskViewHolder(view);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println(" this is the task title on click " + viewHolder.task.title);
                    listener.taskListener(viewHolder.task);
                }
            });

        return viewHolder;
    }

    public static interface OnInteractingWithTaskListener{
        public void taskListener(Task task);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.TaskViewHolder holder, int position) {
        holder.task = task.get(position);

        TextView titleTextView = holder.itemView.findViewById(R.id.titleView);
        TextView bodyTextView = holder.itemView.findViewById(R.id.bodyView);
        TextView stateTextView = holder.itemView.findViewById(R.id.stateView);
        titleTextView.setText(holder.task.title);
        bodyTextView.setText(holder.task.body);
        stateTextView.setText(holder.task.state);


    }

    @Override
    public int getItemCount() {
        return task.size();
    }




}