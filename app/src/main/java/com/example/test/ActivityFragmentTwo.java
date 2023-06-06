package com.example.test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ActivityFragmentTwo extends Fragment {
    Button exitbutton;
    public ActivityFragmentTwo() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_two, container, false);
        System.out.println("m");
        exitbutton = view.findViewById(R.id.button2);
        exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button yogabutton = v.findViewById(R.id.yogaButton);
                Button meditationbutton = v.findViewById(R.id.meditationButton);

                Fragment fr;
                fr = new ActivityFragmentOne();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragmentContainerView2, fr);
                transaction.commit();
            }
        });
        return view;
    }

}