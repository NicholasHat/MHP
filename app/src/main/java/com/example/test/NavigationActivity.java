package com.example.test;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Size;

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
    EmitterConfig emitterConfig = new Emitter(5L, TimeUnit.SECONDS).perSecond(50);
    public Party party = new PartyFactory(emitterConfig)
            .angle(270)
            .spread(90)
            .setSpeedBetween(1f, 5f)
            .timeToLive(2000L)
            .sizes(new Size(12, 5f, 0.2f))
            .position(0.0, 0.0, 1.0, 0.0)
            .build();
    public void setButtonColor(int buttonId) {
        Button button = findViewById(buttonId);
        button.setSelected(true);
    }
}
