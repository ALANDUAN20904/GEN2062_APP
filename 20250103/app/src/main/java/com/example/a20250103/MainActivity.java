package com.example.a20250103;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a20250103.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    float ox_pos,oy_pos;
    float wx_pos,wy_pos;
    TextView obox; // need to make obox a global variable
    ArrayList<TextView> obox = new ArrayList<TextView>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // white box
        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(200,200);
        TextView wbox = new TextView(this);
        wbox.setLayoutParams(size);
        wbox.setBackgroundColor(Color.WHITE);
        wbox.setId((int)100);

        LinearLayout tlinear = (LinearLayout)findViewById(R.id.ll2);
        tlinear.addView(wbox);

        //one obox

        obox = new TextView(this);
        obox.setId((int)1);
        obox.setGravity(Gravity.CENTER);
        obox.setText("1");
        obox.setX(20f);
        obox.setTextSize(40f);
        obox.setTextColor(Color.BLACK);
        obox.setBackgroundColor(Color.parseColor("#FF9800"));
        obox.setLayoutParams(size);


        FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
        fl1.addView(obox);

        boxtouch btch = new boxtouch();
        obox.setOnTouchListener(btch);
        wbox.setOnTouchListener(btch);

        // attempt to use array
//        TextView[] tv = new TextView[4];
//        for(int i = 0;i<4;i++){
//            tv[i] = new TextView(this);
//            tv[i].setLayoutParams(size);
//            tv[i].setTextSize(40);
//            tv[i].setText((i+1)+"");
//            tv[i].setGravity(Gravity.CENTER);
//            tv[i].setBackgroundColor(Color.parseColor("#FF9800"));
//            tv[i].setId((int)i);
//
//            FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
//            fl1.addView(tv[i]);
//        }
    }

    class boxtouch implements View.OnTouchListener{
        @Override
        public boolean onTouch(View v, MotionEvent ev){

            TextView tv1 = (TextView) findViewById(R.id.tv1);
            if(v.getId()==(int)1){
                if(ev.getAction() == 0) {
                    ox_pos = v.getX();
                    oy_pos = v.getY();

                    tv1.setText(ox_pos + "" + oy_pos + "");
                }
            }
            if(v.getId()==(int)100){
                if(ev.getAction() == 0) {
                    wx_pos = v.getX();
                    wy_pos = v.getY();

                    // make the animation here
                    Animation ani = new TranslateAnimation(
                            0,wx_pos-ox_pos,
                            0,wy_pos-oy_pos);
                    // parameters input should be at top left of obox
                    ani.setDuration(1500);

                    Animation ani2 = new AlphaAnimation(1,0);

                    // Ccombine animation

                    AnimationSet cani = new AnimationSet(true);
                    cani.addAnimation(ani);
                    cani.addAnimation(ani2);

                    cani.setDuration(1500);

                    obox.startAnimation(cani);

                    FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
                    fl1.removeView(obox);
                }
            }

            return true;
        }
    }
}