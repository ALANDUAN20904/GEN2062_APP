package com.example.it3010experiment;

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

    float counter=0;
    float starttime,endtime;
    float startx,endx;
    float starty,endy;
    float velocity_X,velocity_Y;
    float x_pos,y_pos;
    float speed_x = 1f;
    float speed_y = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeball redball = new makeball(this);


        FrameLayout fl1 = (FrameLayout)findViewById(R.id.fl1);
        fl1.addView(redball);

        // activate thread
        Thread thr = new Thread("temp"){
            @Override
            public void run(){
                for(;;){
                    counter += 1;
                    x_pos += velocity_X*speed_x;
                    y_pos += velocity_Y*speed_y;
                    redball.setX(x_pos);
//                    redball.setY(y_pos);
                    if (redball.getX() + 100 > fl1.getWidth()){ //right wall
                        speed_x *= -1.0f;
                    }
                    if (redball.getX() < 0){
                        speed_x *= -1.0f;
                    }
                    if (redball.getY() + 100 > fl1.getHeight()){
                        speed_y *= -1.0f;
                    }
                    if (redball.getY() < 0){
                        speed_y *= -1.0f;
                    }
                    try{
                        Thread.sleep(10);
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
            }
        };
        thr.start();


        frametouch ft = new frametouch();
        fl1.setOnTouchListener(ft);

    }

    class frametouch implements View.OnTouchListener{
        @Override
        public boolean onTouch(View v, MotionEvent ev){
            TextView tv =(TextView)findViewById(R.id.tv1);
            // calculate X-directional distance
            if(ev.getAction() == 0){// when push
                startx = ev.getX();
                starty = ev.getY();
                starttime = counter;
            }
            if(ev.getAction() == 1){// up
                endx = ev.getX() - startx;// endx: distance between current_position and startx
                endy = ev.getY() - starty;
                endtime = counter - starttime; // endtime: elapsed time

                velocity_X = endx / endtime;

                velocity_Y = endy / endtime;
                tv.setText(velocity_X + " " + velocity_Y);
            }

            return true;
        }
    }

    class makeball extends View { // inheriting from the View class, but buttonclick inherits also but no constructor
        makeball(Context this1) {
            super(this1);
        }
        public void onDraw(Canvas cv){
            Paint pt = new Paint();
            pt.setColor(Color.GREEN);
            pt.setStrokeWidth(30f);
            pt.setStyle(Paint.Style.FILL);

            cv.drawRect(0,0, 150, 150, pt);
        }
    }


}