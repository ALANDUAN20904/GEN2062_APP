package com.example.p20241227;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
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

        TextView box1 = (TextView) findViewById(R.id.box1);
        TextView box2 = (TextView) findViewById(R.id.box2);
        TextView box3 = (TextView) findViewById(R.id.box3);
        TextView box4 = (TextView) findViewById(R.id.box4);
        TextView box5 = (TextView) findViewById(R.id.box5);
        TextView box6 = (TextView) findViewById(R.id.box6);
        TextView box7 = (TextView) findViewById(R.id.box7);
        TextView box8 = (TextView) findViewById(R.id.box8);
        TextView box9 = (TextView) findViewById(R.id.box9);
        TextView boxplus = (TextView) findViewById(R.id.boxplus);
        TextView box0 = (TextView) findViewById(R.id.box0);
        TextView boxequal = (TextView) findViewById(R.id.boxequal);


        touchbox tb = new touchbox(); // create a new object to be used that inherits touchbox class with the onTouchListener method
        box1.setOnTouchListener(tb);
        box2.setOnTouchListener(tb);
        box3.setOnTouchListener(tb);
        box4.setOnTouchListener(tb);
        box5.setOnTouchListener(tb);
        box6.setOnTouchListener(tb);
        box7.setOnTouchListener(tb);
        box8.setOnTouchListener(tb);
        box9.setOnTouchListener(tb);
        boxplus.setOnTouchListener(tb);
        box0.setOnTouchListener(tb);
        boxequal.setOnTouchListener(tb);
    }

    class touchbox implements View.OnTouchListener{
        public boolean onTouch(View v, MotionEvent ev){

            TextView number = (TextView) findViewById(R.id.number);
            String abc = "";
            abc = (String) number.getText();
            if(ev.getAction() == 0) {
                if (v.getId() == R.id.box1) {
                    number.setText(abc + "1");
                }
                if (v.getId() == R.id.box2) {
                    number.setText(abc + "2");
                }
                if (v.getId() == R.id.box3) {
                    number.setText(abc + "3");
                }
                if (v.getId() == R.id.box4) {
                    number.setText(abc + "4");
                }if (v.getId() == R.id.box5) {
                    number.setText(abc + "5");
                }


            }

            // a convention to put a return
            return true;
        }
    }
}




