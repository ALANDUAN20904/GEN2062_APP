package com.example.askme;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll1 = (LinearLayout)findViewById(R.id.ll1);
        ImageView iv1 = (ImageView)findViewById(R.id.iv1);

        ScaleAnimation enlargeAni = new ScaleAnimation(
                1f,1.1f,1f,1.1f,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        enlargeAni.setDuration(1000);
        enlargeAni.setRepeatMode(Animation.REVERSE);
        enlargeAni.setRepeatCount(-1);

        iv1.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent ev){
                if(ev.getAction() == 0){ // set animation when push
                    iv1.startAnimation(enlargeAni);
                }
                if(ev.getAction() == 1){ // clear animation when lift up
                    iv1.clearAnimation();
                }
                return true;
            }
        });
    }
}