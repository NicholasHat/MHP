package com.example.test;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NavigationActivity extends AppCompatActivity {
    Button activities, dailyChallenge, newday, openMain;
    public void setNewDayClicker() {
        newday = findViewById(R.id.newday);
        newday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewDay();
            }
        });
    }
    public void setMainClicker() {
        openMain = findViewById(R.id.main);
        openMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });
    }
    public void setDailyClicker() {
        dailyChallenge = findViewById(R.id.dailychallenge);
        dailyChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDailyChallenge();
            }
        });
    }
    public void setActivitiesClicker(){
        activities = findViewById(R.id.activities);
        activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivities();
            }
        });
    }
    public void openNewDay() {
        Intent I = new Intent(this, newday.class);
        startActivity(I);
    }
    public void openActivities() {
        Intent I = new Intent(this, activities.class);
        startActivity(I);
    }
    public void openDailyChallenge() {
        Intent I = new Intent(this, dailychallenge.class);
        startActivity(I);
    }
    public void openMain() {
        Intent I = new Intent(this, MainActivity.class);
        startActivity(I);
    }
}
