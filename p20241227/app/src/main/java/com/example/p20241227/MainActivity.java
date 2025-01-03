package com.example.p20241227;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

// create a new linear layout
        LinearLayout tlinear = new LinearLayout(this);

// define layout parameters for the newly created linear layout
        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        // set layout parameters and properties for the LinearLayout
        tlinear.setLayoutParams(size);
        tlinear.setOrientation(LinearLayout.VERTICAL);
        tlinear.setGravity(Gravity.CENTER);

        // // set up rowsize
        LinearLayout.LayoutParams rowsize = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT
        );

        LinearLayout[] row = new LinearLayout[4];

        // set up textviewsize
        LinearLayout.LayoutParams textviewsize = new LinearLayout.LayoutParams(200,200);


        TextView[] tv = new TextView[16];
        for (int j = 0;j<4;j++) {
            // define rows
            row[j] = new LinearLayout(this);// instantiate a linearlayout
            row[j].setLayoutParams(rowsize);
            row[j].setOrientation(LinearLayout.HORIZONTAL);
            row[j].setGravity(Gravity.CENTER );

            for (int i = 0; i < 4; i++) {
                // define textview
                int id = (i+j*4);
                tv[id] = new TextView(this);
                tv[id].setText((50-5*i-5*j) + "");
                tv[id].setTextSize(50-5*i-5*j);
                tv[id].setTextColor(Color.BLACK);
                tv[id].setGravity(Gravity.CENTER);

                // set size
                textviewsize.setMargins(5, 5, 5, 5);
                tv[id].setLayoutParams(textviewsize);
                tv[id].setBackgroundColor(Color.parseColor("#00BCD4"));

                // addview
                row[j].addView(tv[id]);

                touchbox tb1 = new touchbox();
                tv[id].setOnTouchListener(tb1);
            }
            tlinear.addView(row[j]);
        }
        setContentView(tlinear);
    }

    class touchbox implements View.OnTouchListener{
        @Override
        public boolean  onTouch(View v, MotionEvent ev) {
            TextView tv = (TextView) v;
                if ( ev.getAction() == 0) {
                    tv.setBackgroundColor(Color.parseColor("#E91E63"));
                    tv.setTextColor(Color.WHITE);
                }
                if (ev.getAction() == 1){
                    tv.setBackgroundColor(Color.parseColor("#00BCD4"));
                    tv.setTextColor(Color.BLACK);
                }
            return true;
    }
}

}







