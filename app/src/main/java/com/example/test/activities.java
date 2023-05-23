package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activities extends NavigationActivity {
    Button openMain, newDay, dailyChallenge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        //This is ALL THE Buttons UwU
        setNewDayClicker();
        setDailyClicker();
        setMainClicker();
    }
}