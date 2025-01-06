package com.example.p20250106;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(200,200);
//        size.setMargins(10,10,10,10);
//
        TableRow.LayoutParams tvsize = new TableRow.LayoutParams(200,200);
        tvsize.setMargins(10,10,10,10);


        TableLayout tl = (TableLayout) findViewById(R.id.tl1);

        ArrayList<TableRow> row = new ArrayList<TableRow>();

        Random random = new Random();

        for (int i=0;i<7;i++) {
            row.add(new TableRow(this));
            int randomint = random.nextInt(5);

            // insert textview, only add the checked btv to row no need tv
            for(int j=0;j<5;j++){
                TextView btv = new TextView(this);
                btv.setLayoutParams(tvsize); // set basic params only
                btv.setTextSize(50f);
                btv.setGravity(Gravity.CENTER);
                if(j==randomint) { // define checked btv
                    btv.setText((i + 1) + " ");
                    btv.setTextColor(Color.WHITE);
                    btv.setBackgroundColor(Color.BLACK);
                }else{
                    btv.setBackgroundColor(Color.WHITE);
                }
                row.get(i).addView(btv);
            }
            tl.addView(row.get(i));
        }
    }
}