package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
        setButtonColor(R.id.activities);
    }
    public void selectFragment(View view) {
        Button yogabutton = findViewById(R.id.yogaButton);
        Button meditationbutton = findViewById(R.id.meditationButton);
        Button problemsButton = findViewById(R.id.problemButton);
        Button musicButton = findViewById(R.id.musicButton);
        yogabutton.setClickable(false);
        meditationbutton.setClickable(false);
        problemsButton.setClickable(false);
        musicButton.setClickable(false);
    }
}