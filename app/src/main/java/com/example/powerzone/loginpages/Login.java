package com.example.powerzone.loginpages;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.powerzone.R;

public class Login extends AppCompatActivity {
    Switch sw;
    ImageButton right, left;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        replaceFragment(new loginFragment());
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.purple_200));
        }

        right = findViewById(R.id.rightbt);
        left = findViewById(R.id.leftbt);
        tv1 = findViewById(R.id.tv2);
        tv2 = findViewById(R.id.tv3);
        left.setEnabled(false);
        left.setVisibility(View.GONE);
        tv1.setVisibility(View.GONE);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new signup());
                right.setEnabled(false);
                right.setVisibility(View.GONE);
                tv2.setVisibility(View.GONE);


                left.setVisibility(View.VISIBLE);
                tv1.setVisibility(View.VISIBLE);
                left.setEnabled(true);
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new loginFragment());
                left.setEnabled(false);
                left.setVisibility(View.GONE);
                tv1.setVisibility(View.GONE);


                right.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                right.setEnabled(true);
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }
}