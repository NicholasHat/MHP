package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activities extends AppCompatActivity {
    Button openMain, newDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        newDay = findViewById(R.id.newday);
        newDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewDay();
            }
        });

        openMain = findViewById(R.id.main);
        openMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

    }

    private void openNewDay() {
        Intent I = new Intent(this, newday.class);
        startActivity(I);
    }

    private void openMain() {
        Intent I = new Intent(this, MainActivity.class);
        startActivity(I);
    }
}