package com.example.ballgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context gthis;
    FrameLayout fl1;
    boolean which = false;
    makeball ball;
    makebar bar;
    makesquare square;
    makesquare square1;
    makesquare square2;
    makesquare square3;
    makesquare square4;

    float ball_vel_x, ball_vel_y;
    float ref_x, bar_vel;

    float square_vel_x,square_vel_x_1,square_vel_x_2,square_vel_x_3,square_vel_x_4;

    String num = "";

    Handler handle = new Handler(Looper.myLooper());
//    ArrayList<makesquare> greenbox = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gthis = this;

        fl1 = (FrameLayout) findViewById(R.id.fl1);
        frametouch ft = new frametouch();
        fl1.setOnTouchListener(ft);

//        TextView tv1 = (TextView) findViewById(R.id.tv1);
//        tv1.setText(num);

        // calling job thread;
        Thread thr = new Thread("test") {
            @Override
            public void run() {
                for(;;) {
                    handle.post(new Runnable() {
                        @Override
                        public void run() {  // running on main thread
                            if(which) {
                                // ball
                                ball.setX(ball.getX() + ball_vel_x);
                                ball.setY(ball.getY() + ball_vel_y);

                                if(ball.getX()+100f > fl1.getWidth() ||
                                        ball.getX() < 0) {
                                    ball_vel_x *= -1;
                                }
                                if(ball.getY() < 0) {
                                    ball_vel_y *= -1;
                                }
                                if(ball.getY() > fl1.getHeight()){
                                    fl1.removeView(bar);
                                }

                                // each square
                                square.setX(square.getX()+square_vel_x);
                                square1.setX(square1.getX()+square_vel_x_1);
                                square2.setX(square2.getX()+square_vel_x_2);
                                square3.setX(square3.getX()+square_vel_x_3);
                                square4.setX(square4.getX()+square_vel_x_4);

                                // wall bouncing
                                // change to 1000f to test bouncing
                                if(square.getX() + 200f > fl1.getWidth() || square.getX()<0){
                                    square_vel_x *= -1;
                                }
                                if(square1.getX() + 200f > fl1.getWidth() || square1.getX()<0){
                                    square_vel_x_1 *= -1;
                                }
                                if(square2.getX() + 200f > fl1.getWidth() || square2.getX()<0){
                                    square_vel_x_2 *= -1;
                                }
                                if(square3.getX() + 200f > fl1.getWidth() || square3.getX()<0){
                                    square_vel_x_3 *= -1;
                                }
                                if(square4.getX() + 200f > fl1.getWidth() || square4.getX()<0){
                                    square_vel_x_4 *= -1;
                                }

                                // collision to bounce back from bluebar
                                float ballBottom = ball.getY() + 100f; // ball bottom
                                float ballTop = ball.getY(); // ball top
                                float ballCenterX = ball.getX() + 50f; // ball center
                                float barTop = bar.getY(); // bar Top
                                float barLeft = bar.getX();
                                float barRight = bar.getX() + 200f; // bar width

                                if (ballBottom >= barTop && ballBottom <= barTop + 10f && ballCenterX >= barLeft && ballCenterX <= barRight) {
                                    ball_vel_y *= -1; // ballcenter within barX range, check y first
                                }

                                // collision to bounce back from greensquare
                                float squareBottom = square.getY() +200f; // square bottom
                                float squareTop = square.getY(); // square top
                                float squareLeft = square.getX(); // square left
                                float squareRight = square.getX() + 200f; // square right

                                if (ballTop >= squareBottom && ballTop <= squareBottom + 10f && ballCenterX >= squareLeft && ballCenterX <= squareRight){
                                    ball_vel_y *= -1; // ballcenter within squareX range, check when ballY is <= squarebottom and ballY >= squarebottom +10f
                                    fl1.removeView(square);
                                    num+=5;
                                }

                                if(ballBottom >= squareTop && ballBottom <= squareTop + 10f && ballCenterX >= squareLeft && ballCenterX <= squareRight ){
                                    ball_vel_y *= -1;
                                    fl1.removeView(square);
                                }

                                float squareBottom1 = square1.getY() +200f; // square bottom
                                float squareTop1 = square1.getY(); // square top
                                float squareLeft1 = square1.getX(); // square left
                                float squareRight1 = square1.getX() + 200f; // square right

                                if (ballTop >= squareBottom1 && ballTop <= squareBottom1 + 10f && ballCenterX >= squareLeft1 && ballCenterX <= squareRight1){
                                    ball_vel_y *= -1; // ballcenter within squareX range, check when ballY is <= squarebottom and ballY >= squarebottom +10f
                                    fl1.removeView(square1);
                                    num+=5;
                                }

                                if(ballBottom >= squareTop1 && ballBottom <= squareTop1 + 10f && ballCenterX >= squareLeft1 && ballCenterX <= squareRight1 ){
                                    ball_vel_y *= -1;
                                    fl1.removeView(square1);
                                }

                                float squareBottom2 = square2.getY() +200f; // square bottom
                                float squareTop2 = square2.getY(); // square top
                                float squareLeft2 = square2.getX(); // square left
                                float squareRight2 = square2.getX() + 200f; // square right

                                if (ballTop >= squareBottom2 && ballTop <= squareBottom2 + 10f && ballCenterX >= squareLeft2 && ballCenterX <= squareRight2){
                                    ball_vel_y *= -1; // ballcenter within squareX range, check when ballY is <= squarebottom and ballY >= squarebottom +10f
                                    fl1.removeView(square2);
                                    num+=5;
                                }

                                if(ballBottom >= squareTop2 && ballBottom <= squareTop2 + 10f && ballCenterX >= squareLeft2 && ballCenterX <= squareRight2 ){
                                    ball_vel_y *= -1;
                                    fl1.removeView(square2);
                                }

                                float squareBottom3 = square3.getY() +200f; // square bottom
                                float squareTop3 = square3.getY(); // square top
                                float squareLeft3 = square3.getX(); // square left
                                float squareRight3 = square3.getX() + 200f; // square right

                                if (ballTop >= squareBottom3 && ballTop <= squareBottom3 + 10f && ballCenterX >= squareLeft3 && ballCenterX <= squareRight3){
                                    ball_vel_y *= -1; // ballcenter within squareX range, check when ballY is <= squarebottom and ballY >= squarebottom +10f
                                    fl1.removeView(square3);
                                    num+=5;
                                }

                                if(ballBottom >= squareTop3 && ballBottom <= squareTop3 + 10f && ballCenterX >= squareLeft3 && ballCenterX <= squareRight3 ){
                                    ball_vel_y *= -1;
                                    fl1.removeView(square3);
                                }

                                float squareBottom4 = square4.getY() +200f; // square bottom
                                float squareTop4 = square4.getY(); // square top
                                float squareLeft4 = square4.getX(); // square left
                                float squareRight4 = square4.getX() + 200f; // square right

                                if (ballTop >= squareBottom4 && ballTop <= squareBottom4 + 10f && ballCenterX >= squareLeft4 && ballCenterX <= squareRight4){
                                    ball_vel_y *= -1; // ballcenter within squareX range, check when ballY is <= squarebottom and ballY >= squarebottom +10f
                                    fl1.removeView(square4);
                                    num+=5;
                                }

                                if(ballBottom >= squareTop4 && ballBottom <= squareTop4 + 10f && ballCenterX >= squareLeft4 && ballCenterX <= squareRight4 ){
                                    ball_vel_y *= -1;
                                    fl1.removeView(square4);
                                }


                                // bar
                                bar.setX(bar.getX() + bar_vel);
                                if(bar.getX() + 200f > fl1.getWidth() || bar.getX()<0){
                                    bar_vel *= -1; // make the bar stay within boundary
                                }

                                // dynamic array method
                                // Move greensquares
//                                for (int i = 0; i < 5; i++) {
//                                    makesquare b = greenbox.get(i);
//                                    b.setX(b.getX() - 20f); // move square horizonal
//
//                                }

//                                for (int i = 0; i < 5; i++) {
//                                    makesquare b = greenbox.get(i);
//                                    fl1.addView();
                                    // Check collision with the ball
//                                    float bulletCenterX = b.getX() + 150f; // box width is 150
//                                    float bulletCenterY = b.getY() + 150f; // box height is 150
//                                    float ballCenterY = ball.getY() + 50f;

//                                    float distance = (float) Math.sqrt(
//                                            Math.pow(bulletCenterX - ballCenterX, 2) + Math.pow(bulletCenterY - ballCenterY, 2)
//                                    );

//                                    if (distance <= 50f) { // Radius of the ball
//                                        fl1.removeView(b);
//                                        greenbox.remove(i);
//                                        i--;
                                        // Add logic for ball hit
//                                        ball_vel_y *= -1; // Bounce the ball
//                                        break;
//                                    }
//                                }

                            }
                        }
                    });

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        };
        thr.start();

    }
    class frametouch implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent ev) {

            if(ev.getAction() == 0) { // push
                if(which == false) {
                    ball_vel_x = (float)Math.random() * 10f;
                    ball_vel_y = (float)Math.random() * 20f;

                    square_vel_x = (float)Math.random() * 10f;
                    square_vel_x_1 = (float)Math.random() * 10f;
                    square_vel_x_2 = (float)Math.random() * 10f;
                    square_vel_x_3 = (float)Math.random() * 10f;
                    square_vel_x_4 = (float)Math.random() * 10f;

                    square = new makesquare();
                    fl1.addView(square,200,200);
                    square.setX(ev.getX()-30f); // subject to changes later
                    square.setY(10f); // subject to changes later

                    square1 = new makesquare();
                    fl1.addView(square1,200,200);
                    square1.setX(ev.getX()-50f); // subject to changes later
                    square1.setY(300f); // subject to changes later

                    square2 = new makesquare();
                    fl1.addView(square2,200,200);
                    square2.setX(ev.getX()-50f); // subject to changes later
                    square2.setY(800f); // subject to changes later

                    square3 = new makesquare();
                    fl1.addView(square3,200,200);
                    square3.setX(ev.getX()-50f); // subject to changes later
                    square3.setY(1100f); // subject to changes later

                    square4 = new makesquare();
                    fl1.addView(square4,200,200);
                    square4.setX(ev.getX()-50f); // subject to changes later
                    square4.setY(1500f); // subject to changes later

                    bar = new makebar();
                    fl1.addView(bar, 200, 20);
                    bar.setX(fl1.getWidth() / 2 - 100);
                    bar.setY(fl1.getHeight() - 30);

                    ball = new makeball();
                    fl1.addView(ball, 100, 100);
                    ball.setX(ev.getX() - 50f);
                    ball.setY(ev.getY() - 50f);
                    which = true;
                }
                ref_x = ev.getX();
            }

            if(ev.getAction() == 2) {
                bar_vel = (ev.getX() - ref_x) * 0.1f;
            }

            return true;
        }
    }

    class makeball extends View {
        makeball() {
            super(gthis);
        }
        public void onDraw(Canvas cv) {
            Paint pt = new Paint();
            pt.setColor(Color.YELLOW);
            pt.setStyle(Paint.Style.FILL);
            cv.drawCircle(50,50,50, pt);
        }
    }

    class makebar extends View {
        makebar() {
            super(gthis);
        }
        public void onDraw(Canvas cv) {
            Paint pt = new Paint();
            pt.setColor(Color.BLUE);
            pt.setStyle(Paint.Style.FILL);

            // make bar
            cv.drawRect(0,0,200,40, pt);
        }
    }

    class makesquare extends View{
        makesquare(){
            super(gthis);
        }

        public void onDraw(Canvas cv){
            Paint pt = new Paint();
            pt.setColor(Color.GREEN);
            pt.setStrokeWidth(30f);
            pt.setStyle(Paint.Style.FILL);

            // change to 1000 to test bouncing
            cv.drawRect(0,0, 200, 200, pt);
        }

    }

}