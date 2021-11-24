package com.example.powerzone.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.powerzone.Diet;
import com.example.powerzone.R;
import com.example.powerzone.motivation;

public class homepage extends AppCompatActivity {
    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.purple_200));
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);






        button1= findViewById(R.id.started1);
        button2= findViewById(R.id.started2);
        button3= findViewById(R.id.started3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homepage.this,Beginner.class);
                startActivity(intent);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homepage.this,Intermediate.class);
                startActivity(intent);

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homepage.this,Advanced.class);
                startActivity(intent);

            }
        });





    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    public void beginner(View view) {
        Intent intent = new Intent(homepage.this,Beginner.class);
        startActivity(intent);
    }



    public void intermediate(View view) {
        Intent intent = new Intent(homepage.this,Intermediate.class);
        startActivity(intent);
    }

    public void advanced(View view) {
        Intent intent = new Intent(homepage.this,Advanced.class);
        startActivity(intent);
    }

    public void Diet(View view) {
        Intent intent = new Intent(homepage.this, Diet.class);
        startActivity(intent);
    }

    public void motivation(View view) {
        Intent intent = new Intent(homepage.this, motivation.class);
        startActivity(intent);
    }
}