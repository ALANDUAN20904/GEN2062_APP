package com.example.memorygame;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int counter=0;
    Handler handle = new Handler(Looper.myLooper());

    Bundle tbundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbundle = savedInstanceState;

        // getting the tablelayout from the XML
        TableLayout tl = (TableLayout) findViewById(R.id.tl1);

        // making row
        ArrayList<TableRow> row = new ArrayList<TableRow>();  // row = []
        ArrayList<TextView> tv = new ArrayList<TextView>();  // tv = []

        // size
        TableRow.LayoutParams tvsize = new TableRow.LayoutParams(200,200);
        tvsize.setMargins(10,10,10,10);


        // Randomised black boxes
        // making 7 textViews
        for(int i=0; i<7; i++) {
            tv.add(new TextView(this)); // tv = [object ]
            tv.get(i).setId((int)(i+1));
            tv.get(i).setLayoutParams(tvsize);
            tv.get(i).setTextColor(Color.WHITE);
            tv.get(i).setBackgroundColor(Color.BLACK);
            tv.get(i).setText((i+1)+"");
            tv.get(i).setTextSize(50f);
            tv.get(i).setGravity(Gravity.CENTER);
        }

        // shuffle index
        ArrayList<Integer> sindex = new ArrayList<Integer>();
        while(sindex.size() < 7) {
            int a = (int)(Math.random()*7);
            boolean which=true;
            for(int i=0; i<sindex.size(); i++) {
                if(sindex.get(i) == a) {   // b has the a;
                    which = false;
                    break;
                }
            }
            if(which) {
                sindex.add(a);
            }
        }

        for(int i=0; i<7; i++) {  // for each row
            row.add(new TableRow(this)); // row = [ object ]
            int rand_pos = (int)(Math.random() * 5);
            // insert blank(white) textView
            for(int j=0; j<5; j++) {
                if(j == rand_pos) {
                    row.get(i).addView(tv.get(sindex.get(i)));
                } else {
                    TextView btv = new TextView(this);
                    btv.setBackgroundColor(Color.WHITE);
                    btv.setLayoutParams(tvsize);
                    row.get(i).addView(btv);
                }
            }

            tl.addView(row.get(i));
        }

        // activate touch event
        textviewtouch ttv = new textviewtouch();
        for(int i=0; i<7; i++) {
            tv.get(i).setOnTouchListener(ttv);
        }


        // job Thread
        Thread thr = new Thread("temp") {
            @Override
            public void run() {  // execute this method on job Thread

                for(;;) {
                    counter++;

                    // send a message to main thread from job thread
                    handle.post(new Runnable() {
                        @Override
                        public void run() {
                            // message to execute on main thread

                            if(counter > 5) {
                                for(int i=0; i<tv.size(); i++) {
                                    tv.get(i).setBackgroundColor(Color.GRAY);
                                    tv.get(i).setText("");
                                }
                            }

                        }
                    });

                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }

            }
        };
        thr.start();  // activate job thread

    }


    // check order
    String number = "";

    class textviewtouch implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent ev) {
            TextView tv1 = (TextView) findViewById(R.id.tv1);

            if(ev.getAction() == 0) {  // push
                number += v.getId();
                //tv1.setText(number);
                v.setVisibility(View.INVISIBLE);

                if(number.equals("1234567")) {
                    tv1.setText("success");
                }
                if(number.length() == 7 && !(number.equals("1234567"))) {
                    tv1.setText("fail");
                }

            }
            return true;
        }
    }
}
