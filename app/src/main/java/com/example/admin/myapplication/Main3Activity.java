package com.example.admin.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener,NumberPicker.OnValueChangeListener {
    TextView start, how_to_play, exit, tournament;
    private TextView resultText;
    String numOfMatches = "";
    int numOfMatchesInInt = 0;
    int n = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        start = (TextView) findViewById(R.id.start);
        tournament = (TextView) findViewById(R.id.play_tournament);
        how_to_play = (TextView) findViewById(R.id.how_to_play);
        exit = (TextView) findViewById(R.id.endGame);


        start.setOnClickListener(this);
        tournament.setOnClickListener(this);
        how_to_play.setOnClickListener(this);
        exit.setOnClickListener(this);


    }

    public void onBackPressed() {
        alertDialog();
    }



    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

        Log.i("value is",""+newVal);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.start:
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                // intent.putExtra("num_matches",numOfMatches);
                startActivity(intent);
                break;
            case R.id.play_tournament:
                custom_dialog_box();
                break;

            case R.id.how_to_play:
                Intent intent1 = new Intent(Main3Activity.this, HowToPlay.class);

                startActivity(intent1);
                break;

            case R.id.endGame:
                alertDialog();
                break;

        }


    }


    public void custom_dialog_box(){


        final Dialog d = new Dialog(Main3Activity.this);
        //d.setTitle("Number of matches:");
        d.setContentView(R.layout.tournament);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(12);
        np.setMinValue(1);
        np.setValue(3);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(this);
        TextView set = (TextView)d.findViewById(R.id.button1);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numOfMatchesInInt = np.getValue();
                numOfMatches = Integer.toString(numOfMatchesInInt);
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("num_matches",numOfMatches);
                startActivity(i);
                d.dismiss();
            }
        });
        d.show();
    }

    public void getNumberOfMatches(View view) {

        switch (view.getId()) {
            case R.id.one:
                n = 1;
                break;

            case R.id.two:
                n = 2;
                break;

            case R.id.three:
                n = 3;
                break;

            case R.id.four:
                n = 4;
                break;

            case R.id.five:
                n = 5;
                break;

            case R.id.six:
                n = 6;
                break;

            case R.id.seven:
                n = 7;
                break;

            case R.id.eight:
                n = 8;
                break;

            case R.id.nine:
                n = 9;
                break;

            case R.id.ten:
                n = 10;
                break;

            case R.id.eleven:
                n = 11;
                break;

            case R.id.twelve:
                n = 12;
                break;
        }
        numOfMatchesInInt = n;
        numOfMatches = Integer.toString(numOfMatchesInInt);
        Intent i = new Intent(getApplicationContext(), Main2Activity.class);
        i.putExtra("num_matches", numOfMatches);
        startActivity(i);

    }


    public void alertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Do you want to exit?");

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finishAffinity();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
