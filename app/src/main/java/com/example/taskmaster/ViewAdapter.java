package com.example.taskmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private List<Task> localDataSet;
    public ViewAdapter(List<Task> tasks) {
        localDataSet = tasks;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title ;
        TextView body ;
        TextView status ;



//        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.textViewOne);
            body = (TextView) view.findViewById(R.id.textViewTow);
            status = (TextView) view.findViewById(R.id.textViewThre);
        }

        public TextView getTextView() {
            return title;
        }
    }


    public void CustomAdapter(List<Task> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_task, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        viewHolder.title.setText(localDataSet.get(position).getTitle());
//        System.out.println(localDataSet[0].toString()+"sssssssssssssssss");
        viewHolder.body.setText(localDataSet.get(position).getBody());
        viewHolder.status.setText(localDataSet.get(position).getState());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
