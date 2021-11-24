package com.example.powerzone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class motivation extends AppCompatActivity {
GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);
        gridView=(GridView) findViewById(R.id.grid);
        gridView.setAdapter(new ImageAdapter(this));

    }
}