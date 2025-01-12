package com.example.a20250107;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
    float startz,endz;
    float velocity_X,velocity_Y,velocity_Z;
    float x_pos,y_pos,z_pos;
    float speed_x = 1f;
    float speed_y = 1f;

    float speed_z = 1f;

    boolean touched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        FrameLayout fl1 = new FrameLayout(this);
        FrameLayout.LayoutParams flsize = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        fl1.setLayoutParams(flsize);
        fl1.setBackgroundColor(Color.BLACK);


        makeball redball = new makeball(this);
//        FrameLayout fl1 = (FrameLayout)findViewById(R.id.fl1);
        fl1.addView(redball);


        makerect bluerect = new makerect(this);


        fl1.addView(bluerect);


        // activate thread
        Thread thr = new Thread("temp"){
            @Override
            public void run(){
                for(;;){

                counter += 1;
                x_pos += velocity_X*speed_x;
                y_pos += velocity_Y*speed_y;
                z_pos += velocity_Z*speed_z;
                redball.setX(x_pos);
                redball.setY(y_pos);
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

                bluerect.setX(z_pos);
                bluerect.setY(2200);
                if(bluerect.getX() + 300 > fl1.getWidth()){
                    speed_z *= -1;
                }
                if(bluerect.getX() < 0){
                    speed_z *= -1;
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

        setContentView(fl1);

    }

    class frametouch implements View.OnTouchListener{
        @Override
        public boolean onTouch(View v, MotionEvent ev){
            // TextView tv =(TextView)findViewById(R.id.tv1);
            // calculate X-directional distance
            if(ev.getAction() == 0){// when push
//                startx = ev.getX();
//                starty = ev.getY();
                startz = ev.getX();
                starttime = counter;
                touched = true;
            }
            if(ev.getAction() == 1){// up

                if (ev.getX() > 1000) {
                    endx = ev.getX()/1000;// endx: distance between current_position and startx
                }
                if (ev.getX() <= 1000) {
                    endx = ev.getX();// endx: distance between current_position and startx
                }
                if (ev.getX() > 500) {
                    endy = ev.getY()/1000;// endx: distance between current_position and startx
                }
                if (ev.getX() <= 500) {
                    endy = ev.getY();// endx: distance between current_position and startx
                }

                endz = ev.getX() - startz;
                endtime = counter - starttime; // endtime: elapsed time

                velocity_X = endx / endtime;

                velocity_Y = endy / endtime;

                velocity_Z = endz / endtime;

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
            pt.setColor(Color.YELLOW);
            pt.setStrokeWidth(30f);
            pt.setStyle(Paint.Style.FILL);

            cv.drawCircle(100,100,50,pt);
        }
    }

    class makerect extends View{

        makerect(Context this2){
            super(this2);
        }
        public void onDraw(Canvas cv){
            Paint pt = new Paint();
            pt.setColor(Color.BLUE);
            pt.setStrokeWidth(30f);
            pt.setStyle(Paint.Style.FILL);

            cv.drawRect(0,0,300,40,pt);
        }
    }


}