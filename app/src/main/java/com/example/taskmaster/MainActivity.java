package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements ContactAdapter.OnInteractingWithTaskListener {

    Database database;


    @Override
    public void onResume() {
        super.onResume();


        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textView=findViewById(R.id.myTaskTitle);
        String user=sharedPref.getString("userName","user");
        textView.setText(user);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = Room.databaseBuilder(getApplicationContext(), Database.class, "tasks")
                .allowMainThreadQueries()
                .build();


        ArrayList<Task> tasks = (ArrayList<Task>) database.taskDao().getAllTasks();

        RecyclerView recyclerView = findViewById(R.id.taskRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContactAdapter(tasks, this));

        Button addTaskButton = MainActivity.this.findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddTask.class);
                startActivity(i);
            }
        });

        Button addSettingsButton = MainActivity.this.findViewById(R.id.settingsButtonHome);
        addSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SettingPage.class);
                startActivity(i);
            }
        });

        Button allTasksButton = MainActivity.this.findViewById(R.id.allTasksButton);
        allTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllTasks.class);
                startActivity(i);
            }
        });


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor preferenceEditor = preferences.edit();

    }


    @Override
    public void taskListener(Task task) {
        Intent intent = new Intent(MainActivity.this, TaskDetail.class);
        intent.putExtra("title", task.title);
        intent.putExtra("body", task.body);
        intent.putExtra("state", task.state);
        this.startActivity(intent);

    }
}