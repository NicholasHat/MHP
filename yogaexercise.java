package com.example.test;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import nl.dionsegijn.konfetti.xml.KonfettiView;

public class yogaexercise extends NavigationActivity {
    private String[] poseNames = {"Boat Pose","Chair Pose", "Chaturanga Pose", "Child Pose", "Crecent Lunge Pose", "Dolphin Pose", "Downward Dog Pose", "Forearm Plank Pose", "Half Moon Pose", "Plank Pose", "Pyramid Pose", "Reverse Plank Pose", "Sugarcane Pose", "Triangle Pose", "Upward Dog Pose", "Warrior II Pose", "Waterfall Pose"};
    private ArrayList<String> poses = new ArrayList<>();
    private Random rand = new Random();
    private ImageButton begin, back;
    private int test = 0;
    private ImageView firstPic, nextPic;
    private TextView firstText, nextText, coundown;
    private ArrayList<Integer> allposes = new ArrayList<>();
    private ArrayList<Integer> usedPoses = new ArrayList<>();
    private Chronometer timer;

    private KonfettiView konfettiView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yogaexercise);

        setNewDayClicker();
        setActivitiesClicker();
        setDailyClicker();
        setButtonColor(R.id.activities);

        konfettiView = findViewById(R.id.theUIKonfettiView);
        int remove;

        //5 seconds till start, 30 seconds pose, 4 seconds transition, 30 seconds pose, 4 seconds transition,
        // 30 seconds pose, 4 seconds transition, 30 second pose, 4 seconds transition, 30 seconds pose, repeat once

        timer = findViewById(R.id.timer);

        begin = findViewById(R.id.begin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.setBase(SystemClock.elapsedRealtime());
                startTimer(v);

            }
        });
        
        /*back = findViewById(R.id.yogaTitle);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });*/

        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if( chronometer.getText().toString().equalsIgnoreCase("00:00")) {
                    coundown.setVisibility(View.VISIBLE);
                    coundown.setText("5");
                }
                if( chronometer.getText().toString().equalsIgnoreCase("00:01"))
                    coundown.setText("4");
                if( chronometer.getText().toString().equalsIgnoreCase("00:02"))
                    coundown.setText("3");
                if( chronometer.getText().toString().equalsIgnoreCase("00:03"))
                    coundown.setText("2");
                if( chronometer.getText().toString().equalsIgnoreCase("00:04"))
                    coundown.setText("1");
                if( chronometer.getText().toString().equalsIgnoreCase("00:05"))
                    coundown.setText("0");
                if( chronometer.getText().toString().equalsIgnoreCase("00:06"))
                    coundown.setVisibility(View.INVISIBLE);


                if( chronometer.getText().toString().equalsIgnoreCase("00:35")) {
                    secondExercise();
                    coundown.setVisibility(View.VISIBLE);
                    coundown.setText("5");
                }

                if( chronometer.getText().toString().equalsIgnoreCase("00:36"))
                    coundown.setText("4");
                if( chronometer.getText().toString().equalsIgnoreCase("00:37"))
                    coundown.setText("3");
                if( chronometer.getText().toString().equalsIgnoreCase("00:38"))
                    coundown.setText("2");
                if( chronometer.getText().toString().equalsIgnoreCase("00:39"))
                    coundown.setText("1");
                if( chronometer.getText().toString().equalsIgnoreCase("00:40"))
                    coundown.setText("0");
                if( chronometer.getText().toString().equalsIgnoreCase("00:41"))
                    coundown.setVisibility(View.INVISIBLE);

                if( chronometer.getText().toString().equalsIgnoreCase("01:15")) {
                    thirdExercise();
                    coundown.setVisibility(View.VISIBLE);
                    coundown.setText("5");
                }

                if( chronometer.getText().toString().equalsIgnoreCase("01:16"))
                    coundown.setText("4");
                if( chronometer.getText().toString().equalsIgnoreCase("01:17"))
                    coundown.setText("3");
                if( chronometer.getText().toString().equalsIgnoreCase("01:18"))
                    coundown.setText("2");
                if( chronometer.getText().toString().equalsIgnoreCase("01:19"))
                    coundown.setText("1");
                if( chronometer.getText().toString().equalsIgnoreCase("01:20"))
                    coundown.setText("0");
                if( chronometer.getText().toString().equalsIgnoreCase("01:21"))
                    coundown.setVisibility(View.INVISIBLE);

                if( chronometer.getText().toString().equalsIgnoreCase("01:45")) {
                    fourthExercise();
                    coundown.setVisibility(View.VISIBLE);
                    coundown.setText("5");
                }

                if( chronometer.getText().toString().equalsIgnoreCase("01:46"))
                    coundown.setText("4");
                if( chronometer.getText().toString().equalsIgnoreCase("01:47"))
                    coundown.setText("3");
                if( chronometer.getText().toString().equalsIgnoreCase("01:48"))
                    coundown.setText("2");
                if( chronometer.getText().toString().equalsIgnoreCase("01:49"))
                    coundown.setText("1");
                if( chronometer.getText().toString().equalsIgnoreCase("01:50"))
                    coundown.setText("0");
                if( chronometer.getText().toString().equalsIgnoreCase("01:51"))
                    coundown.setVisibility(View.INVISIBLE);

                if( chronometer.getText().toString().equalsIgnoreCase("02:20")) {
                    fifthExercise();
                    coundown.setVisibility(View.VISIBLE);
                    coundown.setText("5");
                }

                if( chronometer.getText().toString().equalsIgnoreCase("02:21"))
                    coundown.setText("4");
                if( chronometer.getText().toString().equalsIgnoreCase("02:22"))
                    coundown.setText("3");
                if( chronometer.getText().toString().equalsIgnoreCase("02:23"))
                    coundown.setText("2");
                if( chronometer.getText().toString().equalsIgnoreCase("02:24"))
                    coundown.setText("1");
                if( chronometer.getText().toString().equalsIgnoreCase("02:24"))
                    coundown.setText("0");
                if( chronometer.getText().toString().equalsIgnoreCase("02:25"))
                    coundown.setVisibility(View.INVISIBLE);

                if( chronometer.getText().toString().equalsIgnoreCase("02:55"))
                    finishedExercise();
            }
        });

        coundown = findViewById(R.id.countdown);

        firstPic = findViewById(R.id.currentimage);
        nextPic = findViewById(R.id.nextupimage);
        firstText = findViewById(R.id.currenttext);
        nextText = findViewById(R.id.nextuptext);

        allposes.add(R.drawable.chairpose);
        allposes.add(R.drawable.chaturanga);
        allposes.add(R.drawable.childpose);
        allposes.add(R.drawable.crecentlunge);
        allposes.add(R.drawable.dolphin);
        allposes.add(R.drawable.downwardfaceingdog);
        allposes.add(R.drawable.forearmplank);
        allposes.add(R.drawable.halfmoon);
        allposes.add(R.drawable.plank);
        allposes.add(R.drawable.pyramid);
        allposes.add(R.drawable.reverseplank);
        allposes.add(R.drawable.sugarcane);
        allposes.add(R.drawable.trianglepose);
        allposes.add(R.drawable.tripod);
        allposes.add(R.drawable.upwarddog);
        allposes.add(R.drawable.warrior);
        allposes.add(R.drawable.waterfall);
        for(int j=0;j<5;j++) {
            remove = rand.nextInt(17-j);
            usedPoses.add(allposes.get(remove));
            allposes.remove(remove);
            poses.add(poseNames[remove]);
        }

        firstExercise();
    }
    private void fifthExercise() {
        firstPic.setImageResource(usedPoses.get(4));
        nextPic.setImageResource(usedPoses.get(4));
    }
    private void fourthExercise() {
        firstPic.setImageResource(usedPoses.get(3));
        nextPic.setImageResource(usedPoses.get(4));
    }
    private void thirdExercise() {
        firstPic.setImageResource(usedPoses.get(2));
        nextPic.setImageResource(usedPoses.get(3));
    }

    private void secondExercise() {
        firstPic.setImageResource(usedPoses.get(1));
        nextPic.setImageResource(usedPoses.get(2));
    }

    private void firstExercise() {
        firstPic.setImageResource(usedPoses.get(0));
        nextPic.setImageResource(usedPoses.get(1));
    }

    private void finishedExercise() {
        konfettiView.start(party);
        timer.stop();
    }

    private void startTimer(View v) {
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();
    }
    private void changePictures() {

        for(int i=0; i<5; i++) {
            firstPic.setImageResource(usedPoses.get(i));
            nextPic.setImageResource(R.drawable.greengradient);

        }
        finishedExercise();


        /*String TTW;
        int pics = 0;
        for(int i=0; i<10; i++) {
            if(i==1 || i==3 || i==5 || i==7 || i==9) {
                TTW = "00:30";
                firstPic.setImageResource(usedPoses.get(pics));
                pics++;
                nextPic.setImageResource(R.drawable.greengradient);
            }
            else {
                TTW = "00:04";
                firstPic.setImageResource(R.drawable.greengradient);
                nextPic.setImageResource(usedPoses.get(pics));
            }
            String finalTTW = TTW;
            timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                @Override
                public void onChronometerTick(Chronometer chronometer) {
                    if( chronometer.getText().toString().equalsIgnoreCase(finalTTW))
                        resetTimer();
                }
            });
        }
        finishedExercise(); */
    }
}