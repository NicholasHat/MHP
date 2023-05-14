package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;
import java.util.Calendar;
import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class dailychallenge extends AppCompatActivity {
    private KonfettiView konfettiView = null;
    Button openMain, activities, newDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailychallenge);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String[] dailyChallengeArray = {"Take a piece of paper and write down how your day has been going. This activity should take 5 minutes"
                , "Isolate yourself from distractions and find a silent place to rest. Then reflect on everything bad that happened today. This activity should take 5 minutes."
        };
        String dailyChallengeText = dailyChallengeArray[day % dailyChallengeArray.length];
        TextView dailyChallenge = findViewById(R.id.dailyChallenge);
        dailyChallenge.setText(dailyChallengeText);

        KonfettiView konfettiView = findViewById(R.id.theUIKonfettiView);
        EmitterConfig emitterConfig = new Emitter(5L, TimeUnit.SECONDS).perSecond(50);
        Party party = new PartyFactory(emitterConfig)
                .angle(270)
                .spread(90)
                .setSpeedBetween(1f, 5f)
                .timeToLive(2000L)
                .sizes(new Size(12, 5f, 0.2f))
                .position(0.0, 0.0, 1.0, 0.0)
                .build();

        Button completedButton = findViewById(R.id.dailyChallengeButton);
        completedButton.setOnClickListener(view ->
                konfettiView.start(party)
        );
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
        activities = findViewById(R.id.activities);
        activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivities();
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

    private void openActivities() {
        Intent I = new Intent(this, activities.class);
        startActivity(I);
    }
}