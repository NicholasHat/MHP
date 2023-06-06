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

public class utilFunctions {
    public static void disableButtons(View v){
        Button yogabutton = v.findViewById(R.id.yogaButton);
        Button meditationbutton = v.findViewById(R.id.meditationButton);
    }
    public static void enableButtons() {

    }
}
