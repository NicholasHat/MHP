package com.example.test;

import android.os.Bundle;

public class start extends NavigationActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        setMainClicker();
    }
}