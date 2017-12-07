package com.example.admin.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tic,tac,toe,entireTextView;
    Animation animation1,animation2,animation3;
    Handler handler1 = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tic = (TextView) findViewById(R.id.tic);
        tac =(TextView)findViewById(R.id.tac);
        toe = (TextView)findViewById(R.id.toe);
        entireTextView=(TextView)findViewById(R.id.entireTextView);
        //bounce is the xml animation file
        animation1= AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);
        animation2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
        animation3=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);

        entireTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        animation2.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                        startActivity(intent);
                    }
                }, 700);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        tic.startAnimation(animation1);
        tac.startAnimation(animation2);
        toe.startAnimation(animation1);


    }


    /*@Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }*/
}
