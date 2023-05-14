package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class newday extends AppCompatActivity {
    public static final String FILE_NAME = "log.txt";

    Button openMain, activities, save, dailyChallenge;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newday);

        pb = findViewById(R.id.rate);
        save = findViewById(R.id.submitLog);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(pb.getProgress());
                openMain();
            }
        });

        openMain = findViewById(R.id.main);
        openMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

        activities = findViewById(R.id.activities);
        activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivities();
            }
        });

        dailyChallenge = findViewById(R.id.dailychallenge);
        dailyChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDailyChallenge();
            }
        });
    }

    private void openActivities() {
        Intent I = new Intent(this, activities.class);
        startActivity(I);
    }

    private void openMain() {
        Intent I = new Intent(this, MainActivity.class);
        startActivity(I);
    }

    private void openDailyChallenge() {
        Intent I = new Intent(this, dailychallenge.class);
        startActivity(I);
    }

    public void save(int val) {
        String w = Integer.toString(val);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(getFilesDir() + FILE_NAME, true));
            writer.write(w);
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}