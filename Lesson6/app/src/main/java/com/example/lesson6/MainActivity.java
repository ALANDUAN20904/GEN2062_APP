package com.example.lesson6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

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

        Animation ani = new TranslateAnimation(0,100,0,100);

        // set speed
        ani.setDuration(1000);
        ani.setFillAfter(true);

        // set waiting time before animation
        ani.setStartOffset(500);

        ani.setRepeatCount(4); // -1, infinite repeat

        ani.setRepeatMode(Animation.REVERSE);

        // yellow ball
        FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
        makeball yball = new makeball(this);
        yball.setAnimation(ani);
        fl1.addView(yball);
    }

    class makeball extends View{
        makeball(Context this1){
            super(this1);
        }

        public void onDraw(Canvas cv){
            Paint pt = new Paint();
            pt.setColor(Color.YELLOW);
            pt.setStrokeWidth(100f);
            pt.setStrokeCap(Paint.Cap.ROUND);
            pt.setStyle(Paint.Style.STROKE);

            cv.drawCircle(100,100,10,pt);
        }
    }
}