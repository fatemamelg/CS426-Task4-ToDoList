package com.example.task4todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ToDoDetailsActivity extends AppCompatActivity {

    Button backBtn;
    TextView tv5, tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_details);

        backBtn = (Button) findViewById(R.id.backButton);
        tv5 = (TextView) findViewById(R.id.textView5);
        tv6 = (TextView) findViewById(R.id.textView6);

        String text5 = getIntent().getStringExtra("textView5");
        String text6 = getIntent().getStringExtra("textView6");

        tv5.setText(text5.toString());
        tv6.setText(text6.toString());

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDoDetailsActivity.this.finish();
            }
        });

    }
}