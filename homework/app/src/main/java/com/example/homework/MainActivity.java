package com.example.homework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static int currentcolour = 0; // global variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // frame to draw on
        FrameLayout frame = (FrameLayout) findViewById(R.id.fl1);
        frametouch ft = new frametouch(this);

        // frame set touch listener
        frame.setOnTouchListener(ft);

        // create buttons
        Button btR = (Button) findViewById(R.id.btR);
        Button btG = (Button) findViewById(R.id.btG);
        Button btB = (Button) findViewById(R.id.btB);
        Button btclear = (Button) findViewById(R.id.btclear);

        // red colour
        // green colour
        btR.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent ev) {
                if(ev.getAction()==0){ // push
                    MainActivity.currentcolour = 0;
                }
                return true;
            }
        });

        // green colour
        btG.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent ev) {
                if(ev.getAction()==0){ // push
                    MainActivity.currentcolour = 1;
                }
                return true;
            }
        });

        // blue colour
        btB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent ev) {
                if(ev.getAction()==0){ // push
                    MainActivity.currentcolour = 2;
                }
                return true;
            }
        });

        // white colour to clear
        btclear.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent ev) {
                if(ev.getAction()==0){ // push
                    MainActivity.currentcolour = 3;
                }
                return true;
            }
        });

    }

    // create frametouch class
    class frametouch implements View.OnTouchListener{
        Context this2;
        frametouch(Context this2) {
            this.this2 = this2;
        }

        @Override
        public boolean onTouch(View v, MotionEvent ev) {
            if(ev.getAction() == 2) {  // moving
                // ev.getX(), ev.getY()
                FrameLayout frame1 = (FrameLayout) findViewById(R.id.fl1);
                // make a new instance of makeview
                makeview mv = new makeview( this2, ev.getX(), ev.getY() );
                frame1.addView(mv);
            }
            return true;
        }
    }


    class makeview extends View {

        float x_pos, y_pos;

        makeview(Context this1, float x_pos, float y_pos ) {
            super( this1 );
            this.x_pos = x_pos;
            this.y_pos = y_pos;
        }
        public void onDraw(Canvas cv) { // for drawing
            Paint pt = new Paint();
            if(MainActivity.currentcolour == 0) {
                pt.setColor(Color.RED);
            }
            if(MainActivity.currentcolour == 1) {
                pt.setColor(Color.GREEN);
            }
            if(MainActivity.currentcolour == 2) {
                pt.setColor(Color.BLUE);
            }
            if(MainActivity.currentcolour == 3) {
                pt.setColor(Color.WHITE);
            }

            pt.setStrokeWidth(50f);
            pt.setStrokeCap(Paint.Cap.ROUND);
            pt.setStyle(Paint.Style.STROKE);

            cv.drawPoint( x_pos,y_pos, pt);
        }
    }
}