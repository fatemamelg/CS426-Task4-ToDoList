package com.example.task4todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements ToDoAdapter.itemClickListener {

    RecyclerView r1;
    String tasks[], descriptions[];

    ToDoAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = (RecyclerView) findViewById(R.id.todoContainer);

        tasks = getResources().getStringArray(R.array.tasks);
        descriptions = getResources().getStringArray(R.array.descriptions);

        ad = new ToDoAdapter(this, tasks, descriptions, this);

        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onListItemClick(int position) {
        Log.d(TAG, "onListItemClick: clicked at " + position);
        String t = tasks[position];
        String d = descriptions[position];
        Intent intent = new Intent(this, ToDoDetailsActivity.class);
        intent.putExtra("textView5", t);
        intent.putExtra("textView6", d);
        startActivity(intent);
    }

    private static final String TAG = "MainActivity";
}