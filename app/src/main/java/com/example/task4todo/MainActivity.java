package com.example.task4todo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ToDoAdapter.itemClickListener, ToDoAdapter.itemLongClickListener {

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

        ad = new ToDoAdapter(this, tasks, descriptions, this, this);

        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onListItemClick(int position) {
        Log.d(TAG, "onListItemClick: clicked at " + position);

        String t = tasks[position];
        String d = descriptions[position];

        //Toast.makeText(ad.ctx, R.layout.activity_main, position, d);

        Intent intent = new Intent(this, ToDoDetailsActivity.class);
        intent.putExtra("textView5", t);
        intent.putExtra("textView6", d);
        startActivity(intent);
    }

    public void onListItemLongClick(int position) {
        Log.d(TAG, "onListItemLongClick: clicked at " + position);

        //AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        //alert.setTitle("Delete Item");
        //alert.setMessage("Are you sure you want to delete this item?");
        //alert.setNeutralButton("Delete", newD);


    }

    private static final String TAG = "MainActivity";
}