package com.example.p20241227;

import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;
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

        WebView wv = (WebView) findViewById(R.id.wv1);
        wv.loadUrl("https://www.google.com");

    }
}


//        LinearLayout linear = new LinearLayout(this);
//        setContentView(linear);
//
//        //make size
//        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams
//        )

