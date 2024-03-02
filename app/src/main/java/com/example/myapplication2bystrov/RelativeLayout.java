package com.example.myapplication2bystrov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RelativeLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        Intent intent = getIntent();

        TextView textView = findViewById(R.id.textView3);
        textView.setText(intent.getStringExtra("text"));
    }
}