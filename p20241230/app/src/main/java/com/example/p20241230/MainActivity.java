package com.example.p20241230;

import android.graphics.Color;
import android.os.Bundle;
import android.text.style.LeadingMarginSpan;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLInvalidAuthorizationSpecException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ///// linear
        LinearLayout linear = new LinearLayout(this);
        LinearLayout.LayoutParams mainsize = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT
        );
        linear.setLayoutParams(mainsize);
        linear.setOrientation(LinearLayout.VERTICAL);
        linear.setGravity(Gravity.CENTER);
        mainsize.setMargins(5,5,5,5);

/////// tlinear
        LinearLayout tlinear = new LinearLayout(this);
        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
        );
        tlinear.setLayoutParams(size);
        tlinear.setOrientation(LinearLayout.HORIZONTAL);
        tlinear.setGravity(Gravity.CENTER);



        // Textview
        TextView tv = new TextView(this);
        tv.setText("1");
        tv.setTextSize(50f);
        tv.setTextColor(Color.BLACK);
        tv.setGravity(Gravity.CENTER);

        TextView tv1 = new TextView(this);
        tv1.setText("2");
        tv1.setTextSize(50f);
        tv1.setTextColor(Color.BLACK);
        tv1.setGravity(Gravity.CENTER);

        TextView tv2 = new TextView(this);
        tv2.setText("3");
        tv2.setTextSize(50f);
        tv2.setTextColor(Color.BLACK);
        tv2.setGravity(Gravity.CENTER);

        // set size
        LinearLayout.LayoutParams textviewsize = new LinearLayout.LayoutParams(200,200);
        textviewsize.setMargins(10,10,10,10);
        tv.setLayoutParams(textviewsize);
        tv.setBackgroundColor(Color.parseColor("#FF9800"));

        tv1.setLayoutParams(textviewsize);
        tv1.setBackgroundColor(Color.parseColor("#FF9800"));

        tv2.setLayoutParams(textviewsize);
        tv2.setBackgroundColor(Color.parseColor("#FF9800"));

        tlinear.addView(tv);
        tlinear.addView(tv1);
        tlinear.addView(tv2);

        /////////slinear
        LinearLayout slinear = new LinearLayout(this);
        LinearLayout.LayoutParams ssize = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
        );
        slinear.setLayoutParams(ssize);
        slinear.setOrientation(LinearLayout.HORIZONTAL);
        slinear.setGravity(Gravity.CENTER);



        // Textview
        TextView tv3 = new TextView(this);
        tv3.setText("4");
        tv3.setTextSize(50f);
        tv3.setTextColor(Color.BLACK);
        tv3.setGravity(Gravity.CENTER);

        TextView tv4 = new TextView(this);
        tv4.setText("5");
        tv4.setTextSize(50f);
        tv4.setTextColor(Color.BLACK);
        tv4.setGravity(Gravity.CENTER);

        TextView tv5 = new TextView(this);
        tv5.setText("6");
        tv5.setTextSize(50f);
        tv5.setTextColor(Color.BLACK);
        tv5.setGravity(Gravity.CENTER);

        // set size
        LinearLayout.LayoutParams textviewssize = new LinearLayout.LayoutParams(200,200);
        textviewssize.setMargins(10,10,10,10);
        tv3.setLayoutParams(textviewssize);
        tv3.setBackgroundColor(Color.parseColor("#FF9800"));

        tv4.setLayoutParams(textviewssize);
        tv4.setBackgroundColor(Color.parseColor("#FF9800"));

        tv5.setLayoutParams(textviewssize);
        tv5.setBackgroundColor(Color.parseColor("#FF9800"));

        slinear.addView(tv3);
        slinear.addView(tv4);
        slinear.addView(tv5);


        /////////plinear
        LinearLayout plinear = new LinearLayout(this);
        LinearLayout.LayoutParams sssize = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
        );
        plinear.setLayoutParams(sssize);
        plinear.setOrientation(LinearLayout.HORIZONTAL);
        plinear.setGravity(Gravity.CENTER);



        // Textview
        TextView tv6 = new TextView(this);
        tv6.setText("4");
        tv6.setTextSize(50f);
        tv6.setTextColor(Color.BLACK);
        tv6.setGravity(Gravity.CENTER);

        TextView tv7 = new TextView(this);
        tv7.setText("5");
        tv7.setTextSize(50f);
        tv7.setTextColor(Color.BLACK);
        tv7.setGravity(Gravity.CENTER);

        TextView tv8 = new TextView(this);
        tv8.setText("6");
        tv8.setTextSize(50f);
        tv8.setTextColor(Color.BLACK);
        tv8.setGravity(Gravity.CENTER);

        // set size
        LinearLayout.LayoutParams textviewsssize = new LinearLayout.LayoutParams(200,200);
        textviewsssize.setMargins(10,10,10,10);
        tv6.setLayoutParams(textviewsssize);
        tv6.setBackgroundColor(Color.parseColor("#FF9800"));

        tv7.setLayoutParams(textviewsssize);
        tv7.setBackgroundColor(Color.parseColor("#FF9800"));

        tv8.setLayoutParams(textviewsssize);
        tv8.setBackgroundColor(Color.parseColor("#FF9800"));

        plinear.addView(tv6);
        plinear.addView(tv7);
        plinear.addView(tv8);



        // display linear
        linear.addView(tlinear);
        linear.addView(slinear);
        linear.addView(plinear);
        setContentView(linear);
    }
}



//////////////////////////////////////////////////////////////////////////////

//LinearLayout tlinear = new LinearLayout(this);
//LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(
//        ViewGroup.LayoutParams.MATCH_PARENT,
//        ViewGroup.LayoutParams.MATCH_PARENT
//);
//        tlinear.setLayoutParams(size);
//        tlinear.setOrientation(LinearLayout.VERTICAL);
//
//// make slinear array
//LinearLayout[] slinear = new LinearLayout[255];
//
//LinearLayout.LayoutParams ssize = new LinearLayout.LayoutParams(
//        ViewGroup.LayoutParams.MATCH_PARENT, 10
//);
//
//
//        for (int i = 0; i < 255; i++) {
////LinearLayout slinear = new LinearLayout(this);
//slinear[i] = new LinearLayout(this);
//slinear[i].setLayoutParams(ssize);
//slinear[i].setBackgroundColor(Color.argb(255, i, 0, 0));
//        tlinear.addView(slinear[i]);
//        }
//
////tlinear.removeView(slinear[10]);
//
//setContentView(tlinear);

//////////////////////////////////////////////////////////////////////////////
////        setContentView(R.layout.activity_main);
//
//        // Linearlayout is a constructor, we make an object called linear
//        LinearLayout linear = new LinearLayout(this);
//        LinearLayout clinear = new LinearLayout(this);
//
//        // make size parameters
//        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT
//        );
//        LinearLayout.LayoutParams size1 = new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                100
//        );// default size is px
//
//        // assign the size to linear
//        linear.setLayoutParams(size);
//        clinear.setLayoutParams(size1);
//
//        // set background colour
//        linear.setBackgroundColor(Color.parseColor("#000000"));
//        clinear.setBackgroundColor(Color.parseColor("#9C2780"));
//
//        // set orientation
//        linear.setOrientation(LinearLayout.VERTICAL);
//
//        // set id, take note of different memory size, where (int) should be used
//        linear.setId((int) 5);
//
//        // add layout
//        linear.addView(clinear);
//
//        // display linear
//        setContentView(linear);