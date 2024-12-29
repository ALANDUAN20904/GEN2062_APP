package com.example.p2024226;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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

        btclick btc = new btclick();
        Button bt1 = (Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(btc);

        Button bt2 = (Button)findViewById(R.id.bt2);
        bt2.setOnClickListener(btc);

    }

    class btclick implements View.OnClickListener{
        @Override
        public void  onClick(View v){
            LinearLayout linear = (LinearLayout) findViewById(R.id.linear1);
            if(v.getId() == R.id.bt1) {
                linear.setBackgroundColor(Color.WHITE);
            }else{
                linear.setBackgroundColor(Color.RED);
            }
        }


    }







}