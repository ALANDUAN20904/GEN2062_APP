package com.example.p20241227;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView
        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(
                200,200
        );

        TextView[] tv = new TextView[10];
        LinearLayout tlinear = (LinearLayout) findViewById(R.id.lI1);
        buttonclick btc = new buttonclick();



        for(int i = 0;i<3;i++) {
            tv[i] = new TextView(this);// create object
            tv[i].setTextSize(50f);
            tv[i].setText(i+"");
            tv[i].setId((int) (i+1));
            tv[i].setTextColor(Color.BLACK);
            tv[i].setBackgroundColor(Color.parseColor("#FF9800"));
            tv[i].setGravity(Gravity.CENTER);
            tv[i].setLayoutParams(size);
            tv[i].setOnClickListener(btc);
        }

        LinearLayout [] row = new LinearLayout[4];
        LinearLayout.LayoutParams rowsize = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT
        );
        row.setLayoutParams(rowsize);
        row.setGravity(Gravity.CENTER);
        row.addView(tv[0]);
        row.addView(tv[1]);
        row.addView(tv[2]);
        tlinear.addView(row);
    }


    String num = "";
    class buttonclick implements View.OnClickListener{
        @Override
        public void onClick(View v){
            TextView screen = (TextView) findViewById(R.id.screen);
            for(int i = 0;i<3;i++) {
                if (v.getId() == i) {
                    num += i;
                }
                screen.setText(num);
            }
        }
    }

}




