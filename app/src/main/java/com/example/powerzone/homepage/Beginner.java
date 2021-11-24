package com.example.powerzone.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toolbar;

import com.example.powerzone.R;

public class Beginner extends AppCompatActivity {
    int[] Array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        Array=new int[]{
                R.id.first_pose, R.id.second_pose, R.id.third_pose,R.id.fourth_pose,
                R.id.fifth_pose,R.id.sixth_pose,R.id.seventh_pose,R.id.eighth_pose,
                R.id.nineth_pose,R.id.tenth_pose,


        };
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    public void Imagebuttonclicked(View view) {

        for(int i=0;i<Array.length;i++){
            if(view.getId()==Array[i]){
                int value = i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent=new Intent(Beginner.this,Exersice.class);
                intent.putExtra("value",String.valueOf(value));

                startActivity(intent);
            }
        }

    }
}