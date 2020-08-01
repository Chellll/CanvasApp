package com.example.canvasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;

import com.example.canvasapp.databinding.ActivityMainBinding;
import com.example.canvasapp.draw.DrawView;
import com.example.canvasapp.fragment.FigureFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private DrawView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.сontainer, FigureFragment.newInstance())
                .commit();
    }
}