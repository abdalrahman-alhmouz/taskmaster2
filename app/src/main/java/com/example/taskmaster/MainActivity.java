package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Task> newTask = new ArrayList<>();
        Task viewOne = new Task("hello","abd","alrahman");
        Task ViewTow = new Task("hello","ahmad","kefak");
        Task ViewThree = new Task("hello","ali","mohd");


//        newTask[0]=viewOne.toString();
//        newTask[1]=ViewTow.toString();
//        newTask[2]=ViewThree.toString();

        newTask.add(viewOne);
        newTask.add(ViewTow);
        newTask.add(ViewThree);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        ViewAdapter adapter = new ViewAdapter(newTask);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        Button addTaskButton = MainActivity.this.findViewById(R.id.AddTask);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddTask.class);
                startActivity(i);
            }

        });

        Button AllTaskButton = MainActivity.this.findViewById(R.id.AllTask);
        AllTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMainActivity = new Intent(MainActivity.this, AllTasks.class);
                startActivity(goToMainActivity);
            }

        });
    }


}