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

public class dailychallenge extends NavigationActivity {
    private KonfettiView konfettiView = null;
    Button openMain, activities, newDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailychallenge);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String[] dailyChallengeArray = {"Write & Reflect: Take a piece of paper and write down how your day has been going. This activity should take 5 minutes"
                , "Tranquil Retreat: Isolate yourself from distractions and find a silent place to rest. Then reflect on everything bad that happened today. This activity should take 5 minutes.", "Gratitude Journaling: Write down three things you are grateful for today. Reflecting on positive aspects of your life can boost your mood and foster a sense of appreciation.", "Positive Affirmations: Repeat three positive affirmations to yourself. Focus on self-love, resilience, and inner strength.", "Acts of Kindness: Perform a kind gesture for someone today, such as offering help, giving a compliment, or sending a thoughtful message."
        };
        String dailyChallengeText = dailyChallengeArray[day % dailyChallengeArray.length];
        TextView dailyChallenge = findViewById(R.id.dailyChallenge);
        dailyChallenge.setText(dailyChallengeText);

        KonfettiView konfettiView = findViewById(R.id.theUIKonfettiView);
        Button completedButton = findViewById(R.id.dailyChallengeButton);
        completedButton.setOnClickListener(view ->
                konfettiView.start(party)
        );
        setNewDayClicker();
        setActivitiesClicker();
        setMainClicker();
        setButtonColor(R.id.dailychallenge);
    }
}