package com.example.powerzone.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.powerzone.R;

public class Exersice2 extends AppCompatActivity {
    String buttonvalue1;

    Button startbn;
    private CountDownTimer countdowntimer;
    TextView mtextview;
    private boolean runningtime;
    private long lefttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exersice2);

        Intent intent= getIntent();
        buttonvalue1=intent.getStringExtra("value1");


        int intvalue = Integer.valueOf(buttonvalue1);

        switch (intvalue){

            case 1:
                setContentView(R.layout.activity_first);
                break;

            case 2:
                setContentView(R.layout.activity_second);
                break;
            case 3:
                setContentView(R.layout.activity_third);
                break;
            case 4:
                setContentView(R.layout.activity_four);
                break;
            case 5:
                setContentView(R.layout.activity_five);
                break;
            case 6:
                setContentView(R.layout.activity_six);
                break;
            case 7:
                setContentView(R.layout.activity_seven);
                break;
            case 8:
                setContentView(R.layout.activity_eight);
                break;
            case 9:
                setContentView(R.layout.activity_nine);
                break;
            case 10:
                setContentView(R.layout.activity_ten);
                break;
            case 11:
                setContentView(R.layout.activity_eleven);
                break;
            case 12:
                setContentView(R.layout.activity_twelve);
                break;
            case 13:
                setContentView(R.layout.activity_thirteen);
                break;
            case 14:
                setContentView(R.layout.activity_fourteen);
                break;
            case 15:
                setContentView(R.layout.activity_fifteen);
                break;


        }
        startbn= findViewById(R.id.startbutton);
        mtextview=findViewById(R.id.timerbutton);

        startbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(runningtime){
                    stoptimer();
                }
                else{
                    starttimer();
                }





            }

        });



    }
    private void stoptimer(){
        countdowntimer.cancel();
        runningtime=false;
        startbn.setText("START");
    }

    private void starttimer(){
        final CharSequence value1= mtextview.getText();
        String num1= value1.toString();
        String num2=num1.substring(0,2);
        String num3=num1.substring(3,5);



        final int number=Integer.valueOf(num2)*60+Integer.valueOf(num3);
        lefttime=number*1000;


        countdowntimer=new CountDownTimer(lefttime,1000) {
            @Override
            public void onTick(long millisecondfinished) {

                lefttime=millisecondfinished;
                updatetimer();

            }

            @Override
            public void onFinish() {

                int newvalue= Integer.valueOf(buttonvalue1)+1;
                if(newvalue<=15)
                {
                    Intent intent=new Intent(Exersice2.this,Exersice2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value1",String.valueOf(newvalue));
                    startActivity(intent);
                }

                else
                {
                    newvalue=1;
                    Intent intent=new Intent(Exersice2.this,Exersice2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value1",String.valueOf(newvalue));
                    startActivity(intent);


                }

            }
        }.start();
        startbn.setText("PAUSE");
        runningtime=true;
    }

    private void updatetimer(){
        int minutes=(int) lefttime/60000;
        int seconds=(int) lefttime%60000/1000;

        String timelefttext="";
        if(minutes<10)
            timelefttext="0";
        timelefttext=timelefttext+minutes+":";
        if(seconds<10)
            timelefttext+="0";
        timelefttext+=seconds;
        mtextview.setText(timelefttext);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}


