package com.example.powerzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Diet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
    }

    public void dietadavn(View view) {
gotoUrl("https://youtu.be/oPRrl-ZhrJQ");
    }


    public void dietinter(View view) {
        gotoUrl("https://youtu.be/Zu6vI0Nge9U");
    }

    public void dietbegi(View view) {
        gotoUrl("https://youtu.be/WFKik6EXSOM");
    }


    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}