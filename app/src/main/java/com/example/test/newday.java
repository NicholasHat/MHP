package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Calendar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class newday extends NavigationActivity {
    public static final String FILE_NAME = "log.txt";
    public static final String FILE_DATE= "log-date.txt";
    Button openMain, activities, save, dailyChallenge;
    TextView selectedValue, currentDate;
    SeekBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newday);

        currentDate = findViewById(R.id.textView7);
        pb = findViewById(R.id.rate);
        selectedValue = findViewById(R.id.textView2);
        save = findViewById(R.id.submitLog);
        pb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                selectedValue.setText(String.valueOf(pb.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // we must keep blank, even though we don't use it we are implementing an abstract interface
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // we must keep blank, even though we don't use it we are implementing an abstract interface
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(pb.getProgress());
                openMain();
            }
        });
        setMainClicker();
        setActivitiesClicker();
        setDailyClicker();
        setButtonColor(R.id.newday);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
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