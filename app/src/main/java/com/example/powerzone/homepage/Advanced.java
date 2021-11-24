package com.example.powerzone.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toolbar;

import com.example.powerzone.R;

public class Advanced extends AppCompatActivity {
    int Array2[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        Array2=new int[]{
                R.id.first_pose, R.id.second_pose, R.id.third_pose,R.id.fourth_pose,
                R.id.fifth_pose,R.id.sixth_pose,R.id.seventh_pose,R.id.eighth_pose,
                R.id.nineth_pose,R.id.tenth_pose,R.id.eleven_pose,R.id.twelve_pose,
                R.id.thirteen_pose,R.id.fourteen_pose,R.id.fifteen_pose,


        };
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    public void Imagebuttonclicked(View view) {

        for(int i=0;i<Array2.length;i++){
            if(view.getId()==Array2[i]){
                int value = i+1;
                Log.i("THIRD",String.valueOf(value));
                Intent intent=new Intent(Advanced.this,Exersice3.class);
                intent.putExtra("value2",String.valueOf(value));

                startActivity(intent);
            }
        }
    }
}
