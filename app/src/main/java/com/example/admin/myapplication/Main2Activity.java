package com.example.admin.myapplication;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    TextView b1, b2, b3, b4, b5, b6, b7, b8, b9, reset, label, Xwins, Ywins, Draw, MatchNum;
    String B1, B2, B3, num_of_matches = "", alertBoxText;
    int x = 0, y = 0, draw = 0, drawf = 0, tournamentCount = 0,match_number = 1;
    Boolean isTournament = false;
    int whoseChance = 1;
    Handler handler1 = new Handler();
    Handler handler2 = new Handler();
    Handler handler3 = new Handler();
    int i = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            num_of_matches = extras.getString("num_matches");
            if (num_of_matches.equals("")) {

                //Toast.makeText(getApplicationContext(),"Nothing.",Toast.LENGTH_SHORT).show();
            } else {
                isTournament = true;
                tournamentCount = Integer.parseInt(num_of_matches);
                //Toast.makeText(getApplicationContext(),num_of_matches,Toast.LENGTH_SHORT).show();
            }
            //The key argument here must match that used in the other activity
        }


        b1 = (TextView) findViewById(R.id.b1);
        b2 = (TextView) findViewById(R.id.b2);
        b3 = (TextView) findViewById(R.id.b3);
        b4 = (TextView) findViewById(R.id.b4);
        b5 = (TextView) findViewById(R.id.b5);
        b6 = (TextView) findViewById(R.id.b6);
        b7 = (TextView) findViewById(R.id.b7);
        b8 = (TextView) findViewById(R.id.b8);
        b9 = (TextView) findViewById(R.id.b9);
        Xwins = (TextView) findViewById(R.id.Xwins);
        Ywins = (TextView) findViewById(R.id.Ywins);
        Draw = (TextView) findViewById(R.id.Draw);
        reset = (TextView) findViewById(R.id.reset);
        label = (TextView) findViewById(R.id.label);
        MatchNum = (TextView)findViewById(R.id.match_num);

        b1.setBackgroundResource(R.drawable.bgplain);
        b2.setBackgroundResource(R.drawable.bgplain);
        b3.setBackgroundResource(R.drawable.bgplain);
        b4.setBackgroundResource(R.drawable.bgplain);
        b5.setBackgroundResource(R.drawable.bgplain);
        b6.setBackgroundResource(R.drawable.bgplain);
        b7.setBackgroundResource(R.drawable.bgplain);
        b8.setBackgroundResource(R.drawable.bgplain);
        b9.setBackgroundResource(R.drawable.bgplain);

        if (isTournament){
            reset.setVisibility(View.GONE);
            MatchNum.setVisibility(View.VISIBLE);
        }
        else{
            reset.setVisibility(View.VISIBLE);
            MatchNum.setVisibility(View.GONE);
        }


      reset();
        Xwins.setText(Integer.toString(x));
        Ywins.setText(Integer.toString(y));
        Draw.setText(Integer.toString(drawf));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rate_us:
                return true;
            case R.id.send_feedback:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "anushah1411@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "FeedBack For Tic-Tac-Toe");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

                return true;
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.b1:
                if (b1.getText().toString() == "") {
                    if (i % 2 == 0) {
                        b1.setText("0");
                        draw++;
                        if (checkRow1() || checkColumn1() || checkDiagonal1()) {
                            //Toast.makeText(this, "Player2", Toast.LENGTH_SHORT).show();
                            updatey();
                        }
                        label.setText(R.string.player_1);

                    } else {

                        b1.setText("X");
                        draw++;
                        if (checkRow1() || checkColumn1() || checkDiagonal1()) {
                           // Toast.makeText(this, "Player1", Toast.LENGTH_SHORT).show();
                            updatex();
                        }
                        label.setText(R.string.pkayer_2);
                    }
                    i++;
                } else {

                }
                updateDraw();
                break;

            case R.id.b2:
                if (b2.getText().toString() == "") {
                    if (i % 2 == 0) {
                        b2.setText("0");
                        draw++;
                        if (checkRow1() || checkColumn2()) {
                           // Toast.makeText(this, "Player2", Toast.LENGTH_SHORT).show();
                            updatey();
                        }
                        label.setText(R.string.player_1);
                    } else {
                        b2.setText("X");
                        draw++;
                        if (checkRow1() || checkColumn2()) {
                           // Toast.makeText(this, "Player1", Toast.LENGTH_SHORT).show();
                            updatex();
                        }
                        label.setText(R.string.pkayer_2);

                    }
                    i++;
                }
                updateDraw();
                break;

            case R.id.b3:
                if (b3.getText().toString() == "") {
                    if (i % 2 == 0) {
                        b3.setText("0");
                        draw++;
                        if (checkRow1() || checkColumn3() || checkDiagonal2()) {
                           // Toast.makeText(this, "Player2", Toast.LENGTH_SHORT).show();
                            updatey();
                        }
                        label.setText(R.string.player_1);
                    } else {
                        b3.setText("X");
                        draw++;
                        if (checkRow1() || checkColumn3() || checkDiagonal2()) {
                            //Toast.makeText(this, "Player1", Toast.LENGTH_SHORT).show();
                            updatex();
                        }
                        label.setText(R.string.pkayer_2);

                    }
                    i++;
                } else {

                }
                updateDraw();
                break;

            case R.id.b4:
                if (b4.getText().toString() == "") {
                    if (i % 2 == 0) {
                        b4.setText("0");
                        draw++;
                        if (checkRow2() || checkColumn1()) {
                            //Toast.makeText(this, "Player2", Toast.LENGTH_SHORT).show();
                            updatey();
                        }
                        label.setText(R.string.player_1);
                    } else {
                        b4.setText("X");
                        draw++;
                        if (checkRow2() || checkColumn1()) {
                            //Toast.makeText(this, "Player1", Toast.LENGTH_SHORT).show();
                            updatex();
                        }
                        label.setText(R.string.pkayer_2);

                    }
                    i++;
                } else {

                }
                updateDraw();
                break;

            case R.id.b5:
                if (b5.getText().toString() == "") {
                    if (i % 2 == 0) {
                        b5.setText("0");
                        if (checkRow2() || checkColumn2() || checkDiagonal1() || checkDiagonal2()) {
                           // Toast.makeText(this, "Player2", Toast.LENGTH_SHORT).show();
                            updatey();
                        }
                        draw++;
                        label.setText(R.string.player_1);
                    } else {
                        b5.setText("X");
                        if (checkRow2() || checkColumn2() || checkDiagonal1() || checkDiagonal2()) {
                           // Toast.makeText(this, "Player1", Toast.LENGTH_SHORT).show();
                            updatex();
                        }
                        draw++;
                        label.setText(R.string.pkayer_2);

                    }
                    i++;
                } else {

                }
                updateDraw();
                break;

            case R.id.b6:
                if (b6.getText().toString() == "") {
                    if (i % 2 == 0) {
                        b6.setText("0");
                        if (checkRow2() || checkColumn3()) {
                          //  Toast.makeText(this, "Player2", Toast.LENGTH_SHORT).show();
                            updatey();
                        }
                        draw++;
                        label.setText(R.string.player_1);
                    } else {
                        b6.setText("X");
                        if (checkRow2() || checkColumn3()) {
                           // Toast.makeText(this, "Player1", Toast.LENGTH_SHORT).show();
                            updatex();
                        }
                        draw++;
                        label.setText(R.string.pkayer_2);

                    }
                    i++;
                } else {

                }
                updateDraw();
                break;

            case R.id.b7:
                if (b7.getText().toString() == "") {
                    if (i % 2 == 0) {
                        b7.setText("0");
                        if (checkRow3() || checkColumn1() || checkDiagonal2()) {
                            //Toast.makeText(this, "Player2", Toast.LENGTH_SHORT).show();
                            updatey();
                        }
                        draw++;
                        label.setText(R.string.player_1);
                    } else {
                        b7.setText("X");
                        if (checkRow3() || checkColumn1() || checkDiagonal2()) {
                          //  Toast.makeText(this, "Player1", Toast.LENGTH_SHORT).show();
                            updatex();
                        }
                        draw++;
                        label.setText(R.string.pkayer_2);

                    }
                    i++;
                } else {

                }
                updateDraw();
                break;

            case R.id.b8:
                if (b8.getText().toString() == "") {
                    if (i % 2 == 0) {
                        b8.setText("0");
                        if (checkRow3() || checkColumn2()) {
                         //   Toast.makeText(this, "Player2", Toast.LENGTH_SHORT).show();
                            updatey();
                        }
                        draw++;
                        label.setText(R.string.player_1);
                    } else {
                        b8.setText("X");
                        if (checkRow3() || checkColumn2()) {
                            //Toast.makeText(this, "Player1", Toast.LENGTH_SHORT).show();
                            updatex();
                        }
                        draw++;
                        label.setText(R.string.pkayer_2);

                    }
                    i++;
                } else {

                }
                updateDraw();
                break;

            case R.id.b9:
                if (b9.getText().toString() == "") {
                    if (i % 2 == 0) {
                        b9.setText("0");
                        if (checkRow3() || checkColumn3() || checkDiagonal1()) {
                         //   Toast.makeText(this, "Player2", Toast.LENGTH_SHORT).show();
                            updatey();
                        }
                        draw++;
                        label.setText(R.string.player_1);
                    } else {
                        b9.setText("X");
                        if (checkRow3() || checkColumn3() || checkDiagonal1()) {
                          //  Toast.makeText(this, "Player1", Toast.LENGTH_SHORT).show();
                            updatex();
                        }
                        draw++;

                        label.setText(R.string.pkayer_2);

                    }
                    i++;
                } else {

                }
                updateDraw();
                break;

            case R.id.reset:
                Xwins.setText("0");
                Ywins.setText("0");
                Draw.setText("0");
                reset();
                break;

        }
    }

    public void reset() {
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        reset.setOnClickListener(this);
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        b1.setBackgroundResource(R.drawable.bgplain);
        b2.setBackgroundResource(R.drawable.bgplain);
        b3.setBackgroundResource(R.drawable.bgplain);
        b4.setBackgroundResource(R.drawable.bgplain);
        b5.setBackgroundResource(R.drawable.bgplain);
        b6.setBackgroundResource(R.drawable.bgplain);
        b7.setBackgroundResource(R.drawable.bgplain);
        b8.setBackgroundResource(R.drawable.bgplain);
        b9.setBackgroundResource(R.drawable.bgplain);
        i = 1;
        draw = 0;
        if(whoseChance==1)
        {
        label.setText(R.string.player_1);
            i=1;
    }
        else{
            label.setText(R.string.pkayer_2);
            i=2;
        }
    }

    public boolean checkRow1() {
        B1 = b1.getText().toString();
        B2 = b2.getText().toString();
        B3 = b3.getText().toString();
        if (B1.equals(B2) && B1.equals(B3)) {
            b1.setBackgroundResource(R.drawable.bghori);
            b2.setBackgroundResource(R.drawable.bghori);
            b3.setBackgroundResource(R.drawable.bghori);

            return true;
        } else
            return false;
    }

    public boolean checkRow2() {
        B1 = b4.getText().toString();
        B2 = b5.getText().toString();
        B3 = b6.getText().toString();
        if (B1.equals(B2) && B1.equals(B3)) {
            b4.setBackgroundResource(R.drawable.bghori);
            b5.setBackgroundResource(R.drawable.bghori);
            b6.setBackgroundResource(R.drawable.bghori);

            return true;
        } else
            return false;
    }

    public boolean checkRow3() {
        B1 = b7.getText().toString();
        B2 = b8.getText().toString();
        B3 = b9.getText().toString();
        if (B1.equals(B2) && B1.equals(B3)) {
            b7.setBackgroundResource(R.drawable.bghori);
            b8.setBackgroundResource(R.drawable.bghori);
            b9.setBackgroundResource(R.drawable.bghori);

            return true;
        } else
            return false;
    }

    public boolean checkColumn1() {
        B1 = b1.getText().toString();
        B2 = b4.getText().toString();
        B3 = b7.getText().toString();
        if (B1.equals(B2) && B1.equals(B3)) {

            b1.setBackgroundResource(R.drawable.bgver);
            b4.setBackgroundResource(R.drawable.bgver);
            b7.setBackgroundResource(R.drawable.bgver);

            return true;
        } else
            return false;
    }

    public boolean checkColumn2() {
        B1 = b2.getText().toString();
        B2 = b5.getText().toString();
        B3 = b8.getText().toString();
        if (B1.equals(B2) && B1.equals(B3)) {

            b2.setBackgroundResource(R.drawable.bgver);
            b5.setBackgroundResource(R.drawable.bgver);
            b8.setBackgroundResource(R.drawable.bgver);

            return true;
        } else
            return false;
    }

    public boolean checkColumn3() {
        B1 = b3.getText().toString();
        B2 = b6.getText().toString();
        B3 = b9.getText().toString();
        if (B1.equals(B2) && B1.equals(B3)) {
            b3.setBackgroundResource(R.drawable.bgver);
            b6.setBackgroundResource(R.drawable.bgver);
            b9.setBackgroundResource(R.drawable.bgver);
            return true;
        } else
            return false;
    }

    public boolean checkDiagonal1() {
        B1 = b1.getText().toString();
        B2 = b5.getText().toString();
        B3 = b9.getText().toString();
        if (B1.equals(B2) && B1.equals(B3)) {

            b1.setBackgroundResource(R.drawable.bgdiagone);
            b5.setBackgroundResource(R.drawable.bgdiagone);
            b9.setBackgroundResource(R.drawable.bgdiagone);
            return true;
        } else
            return false;
    }

    public boolean checkDiagonal2() {
        B1 = b3.getText().toString();
        B2 = b5.getText().toString();
        B3 = b7.getText().toString();
        if (B1.equals(B2) && B1.equals(B3)) {
            b3.setBackgroundResource(R.drawable.bgdiagtwo);
            b5.setBackgroundResource(R.drawable.bgdiagtwo);
            b7.setBackgroundResource(R.drawable.bgdiagtwo);
            return true;
        } else
            return false;
    }

    public void updatex() {
        x++;
        draw--;
        whoseChance=whoseChance*(-1);
        onWinningonClickNull();
        Xwins.setText(Integer.toString(x));

        tournamentCount--;
       if(tournamentCount>0)
       {
           match_number++;
           MatchNum.setText("Match number:"+Integer.toString(match_number));
       }
        if (tournamentCount == 0) {
            isTournament = false;
            if (x > y) {
                alertBoxText = "Congratulation X. You win.";
                displayWinningAlertBox(alertBoxText);
                // Toast.makeText(getApplicationContext(),"X wins",Toast.LENGTH_SHORT).show();
            } else if (y > x) {
                alertBoxText = "Kuddos 0. You win";
                displayWinningAlertBox(alertBoxText);
                //Toast.makeText(getApplicationContext(),"Y wins",Toast.LENGTH_SHORT).show();
            } else {
                alertBoxText = "Uh-oh! We have a tie";
                displayWinningAlertBox(alertBoxText);
                //Toast.makeText(getApplicationContext(),"Draw",Toast.LENGTH_SHORT).show();

            }

        }
        else {

            Toast toast = Toast.makeText(this, "X wins this round", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    reset();
                   // b1.setOnClickListener(null);
                }
            }, 2000);

        }


    }
    public void updatey() {
        draw--;
        whoseChance=whoseChance*(-1);
        y++;
        onWinningonClickNull();
        Ywins.setText(Integer.toString(y));
        tournamentCount--;
        if(tournamentCount>0)
        {
            match_number++;
            MatchNum.setText("Match number:"+Integer.toString(match_number));
        }
        if (tournamentCount == 0) {
            isTournament = false;

            if (x > y) {
                alertBoxText = "Congratulation X. You win.";
                displayWinningAlertBox(alertBoxText);
                // Toast.makeText(getApplicationContext(),"X wins",Toast.LENGTH_SHORT).show();
            } else if (y > x) {
                alertBoxText = "Kuddos 0. You win";
                displayWinningAlertBox(alertBoxText);
                //Toast.makeText(getApplicationContext(),"Y wins",Toast.LENGTH_SHORT).show();
            } else {
                alertBoxText = "Uh-oh! We have a tie";
                displayWinningAlertBox(alertBoxText);
                //Toast.makeText(getApplicationContext(),"Draw",Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast toast = Toast.makeText(this, "0 wins this round", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                reset();
            }
        }, 2000);

    }}

    public void updateDraw() {
        if (draw >= 9) {
            onWinningonClickNull();
            drawf++;
            whoseChance=whoseChance*(-1);

            Draw.setText(Integer.toString(drawf));
            tournamentCount--;
            if(tournamentCount>0)
            {
                match_number++;
                MatchNum.setText("Match number:"+Integer.toString(match_number));
            }
            if (tournamentCount == 0) {
                isTournament = false;
                if (x > y) {
                    alertBoxText = "Congratulation X. You win.";
                    displayWinningAlertBox(alertBoxText);
                    // Toast.makeText(getApplicationContext(),"X wins",Toast.LENGTH_SHORT).show();
                } else if (y > x) {
                    alertBoxText = "Kuddos Y. You win";
                    displayWinningAlertBox(alertBoxText);
                    //Toast.makeText(getApplicationContext(),"Y wins",Toast.LENGTH_SHORT).show();
                } else {
                    alertBoxText = "Uh-oh! We have a tie";
                    displayWinningAlertBox(alertBoxText);
                    //Toast.makeText(getApplicationContext(),"Draw",Toast.LENGTH_SHORT).show();
                }
            } else {

                Toast toast = Toast.makeText(this, "Draw", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        reset();
                    }
                }, 2000);


            }
        }
    }
    public void displayWinningAlertBox(String result) {
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(result);

            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    finish();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    public void onWinningonClickNull(){
        b1.setOnClickListener(null);
        b2.setOnClickListener(null);
        b3.setOnClickListener(null);
        b4.setOnClickListener(null);
        b5.setOnClickListener(null);
        b6.setOnClickListener(null);
        b7.setOnClickListener(null);
        b8.setOnClickListener(null);
        b9.setOnClickListener(null);

    }
}



