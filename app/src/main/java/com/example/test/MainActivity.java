package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String FILE_NAME = "log.txt";

    Button openActivities, newday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newday = findViewById(R.id.newday);
        newday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewDay();
            }
        });

        openActivities = findViewById(R.id.activities);
        openActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivities();
            }
        });

        load();
    }

    private void openNewDay() {
        Intent I = new Intent(this, newday.class);
        startActivity(I);
    }

    private void openActivities() {
        Intent I = new Intent(this, activities.class);
        startActivity(I);
    }

    public void load() {
        List<String> lines = null;
        ArrayList<String> load = new ArrayList<String>(5);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getFilesDir() + FILE_NAME));
            lines = Files.readAllLines(Paths.get(getFilesDir() + FILE_NAME));
            if(lines.size() < 5) {
                load.add("0");
                for (int i = 0; i < lines.size(); i++) {
                    load.add(lines.get(i));
                }
            }
            else
                for(int i = lines.size()-5; i <= lines.size()-1; i++) {
                    load.add(lines.get(i));
                }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(lines==null) {
            lines = new ArrayList<String>();
            lines.add("10");
        }

        GraphView graphView = (GraphView) findViewById(R.id.graphView);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {});
        if(load.size() < 5) {
            for(int i = 0; i < load.size(); i++) {
                series.appendData(new DataPoint(i, Integer.parseInt(load.get(i))), false, 5);
            }
        }
        else {
            for(int i = 0; i < load.size(); i++) {
                series.appendData(new DataPoint(lines.size()-(5-i), Integer.parseInt(load.get(i))), false, 5);
            }
        }
        if(load.size() == 0)
            series.appendData(new DataPoint(0,0), false, 1);
        GridLabelRenderer gridLabel = graphView.getGridLabelRenderer();
        graphView.getViewport().setMaxY(10);
        graphView.getViewport().setYAxisBoundsManual(true);
        if(lines.size() < 5) {
            graphView.getViewport().setMaxX(lines.size());
            graphView.getViewport().setMinX(0);
        }
        else {
            graphView.getViewport().setMaxX(lines.size());
            graphView.getViewport().setMinX(lines.size()-5);
        }
        graphView.getViewport().setXAxisBoundsManual(true);
        gridLabel.setPadding(20);
        gridLabel.setGridColor(1);
        graphView.addSeries(series);
    }
}