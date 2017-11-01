package uk.co.reddiapps.reactor;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class level1 extends AppCompatActivity {

    public Chronometer timer;
    public int level1Points = 0;
    boolean playerTouch;
    public ImageView image;
    public Random rnd = new Random();
    int bgColor;
    public TextView points;
    public int i = 0;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        image = (ImageView) findViewById(R.id.ImageView);
        timer = findViewById(R.id.level1chronometer);
        points = (TextView) findViewById(R.id.PointsTextview);

        AlertDialog.Builder builder1 = new AlertDialog.Builder(level1.this);
        builder1.setMessage("The image will change from red to green randomly, you need to tap the screen when green is showing. Points are awarded when green, " +
                "points are deducted when red. The color changes faster, the more you get right. Get 50 points to unlock level 2. **Bonus** Complete this level within 2 minutes. Are you ready to play?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        startlevel();

                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                        finish();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

        new ImageChanger().execute(level1Points, rnd, bgColor);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bgColor == 2) {
                    level1Points = level1Points + 1;
                    points.setText(Integer.toString(level1Points));

                } else {
                    level1Points = level1Points - 1;
                    points.setText(Integer.toString(level1Points));
                }
            }

        });

    }

    private void startlevel() {
        timer.start();
        if (level1Points == 50) {
            timer.stop();
        }
    }
}


//                   final Snackbar mySnackbar = Snackbar.make(findViewById(R.id.level1Activity),"The image will change from red to green randomly, you need to tap the screen when green is showing. Points are awarded when green, +" +
//                    "points are deducted when red. The color changes faster, the more you get right. Get 50 points to unlock level 2. **Bonus** Complete this level within 2 minutes", BaseTransientBottomBar.LENGTH_INDEFINITE);
//
//        mySnackbar.setAction("Dismiss", new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mySnackbar.dismiss();
//                }
//
//    });

