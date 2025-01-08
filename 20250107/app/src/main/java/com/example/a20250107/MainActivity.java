package com.example.a20250107;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
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

        // lines
        makeline mkl = new makeline(this);
        FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
        fl1.addView(mkl);

        frametouch ft = new frametouch(this);
        fl1.setOnTouchListener(ft);
    }

    int flag = -1;
    int[][] mesh = new int[40][40];

    class frametouch implements View.OnTouchListener {
        Context this1;
        frametouch(Context this1) {
            this.this1 = this1;
        }
        @Override
        public boolean onTouch(View v, MotionEvent ev) {
            FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
            TextView tv1 = (TextView) findViewById(R.id.tv1);
            TextView tv2 = (TextView) findViewById(R.id.tv2);
            if(ev.getAction() == 0) {  // push

                float xpos = Math.round((ev.getX()) * 0.01f) * 100 - 50f;
                float ypos = Math.round((ev.getY()) * 0.01f) * 100 - 50f;

                if(mesh[(int)((ypos+50)/100)][(int)((xpos+50)/100)] == 0) {
                    stone stone1 = new stone(this1);
                    fl1.addView(stone1);
                    stone1.setX(xpos);
                    stone1.setY(ypos);
                    mesh[(int)((ypos+50)/100)][(int)((xpos+50)/100)] = flag;
                    flag *= -1;
                    tv1.setText(xpos + " " + ypos);
                    tv2.setText((int)((ypos+50)/100)+" " + (int)((xpos+50)/100));
                }

            }
            return true;
        }
    }

    class stone extends View {
        stone(Context this1) {
            super(this1);
        }
        public void onDraw(Canvas cv) {
            Paint pt = new Paint();
            if(flag > 0) {
                pt.setColor(Color.BLACK);
            } else {
                pt.setColor(Color.WHITE);
            }
            pt.setStyle(Paint.Style.FILL);
            pt.setStrokeWidth(1f);

            cv.drawCircle(50,50,50,pt);
        }
    }



    class makeline extends View {
        makeline(Context this1) {
            super(this1);
        }
        public void onDraw(Canvas cv) {
            Paint pt = new Paint();
            pt.setColor(Color.BLACK);
            pt.setStrokeWidth(5f);

            for(int i=0; i<40; i++) {
                cv.drawLine(0, 100*i, cv.getWidth(), 100*i, pt);
                cv.drawLine(100*i, 0, 100*i, cv.getHeight(), pt);
            }

        }
    }
}