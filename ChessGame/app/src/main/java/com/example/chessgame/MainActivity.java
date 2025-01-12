package com.example.chessgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
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

        // lines
        makeline mkl = new makeline(this);
        FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);
        fl1.addView(mkl);

        // implement frametouch
        frametouch ft = new frametouch(this);
        fl1.setOnTouchListener(ft);
    }

    // check each line, see if got 5 consecutive, if got, then the textview tv1 settext to whoever win by checking the flags
    // check line
    private void checkWinner() {
        TextView tv1 = findViewById(R.id.tv1);

        // Check rows
        for (int y = 0; y < 40; y++) {
            for (int x = 0; x <= 35; x++) {
                if (mesh[y][x] != 0 &&
                        mesh[y][x] == mesh[y][x + 1] &&
                        mesh[y][x] == mesh[y][x + 2] &&
                        mesh[y][x] == mesh[y][x + 3] &&
                        mesh[y][x] == mesh[y][x + 4]) {

                    // if conditioon is met, the one you push as mesh[y][x] will be the colour to be 1
                    tv1.setText(mesh[y][x] == 1 ? "White Wins!" : "Black Wins!");
                    return; // get the result out
                }
            }
        }

        // Check columns
        for (int x = 0; x < 40; x++) {
            for (int y = 0; y <= 35; y++) {
                if (mesh[y][x] != 0 &&
                        mesh[y][x] == mesh[y + 1][x] &&
                        mesh[y][x] == mesh[y + 2][x] &&
                        mesh[y][x] == mesh[y + 3][x] &&
                        mesh[y][x] == mesh[y + 4][x]) {

                    tv1.setText(mesh[y][x] == 1 ? "White Wins!" : "Black Wins!");
                    return;
                }
            }
        }

        // Check diagonal to the right
        for (int x = 0; x < 35; x++) {
            for (int y = 0; y <= 35; y++) {
                if (mesh[y][x] != 0 &&
                        mesh[y][x] == mesh[y + 1][x + 1] &&
                        mesh[y][x] == mesh[y + 2][x + 2] &&
                        mesh[y][x] == mesh[y + 3][x + 3] &&
                        mesh[y][x] == mesh[y + 4][x + 4]) {

                    tv1.setText(mesh[y][x] == 1 ? "White Wins!" : "Black Wins!");
                    return;
                }
            }
        }

        // Check diagonal to the left
        for (int x = 0; x < 35; x++) {
            for (int y = 0; y <= 35; y++) {
                if (mesh[y][x] != 0 &&
                        mesh[y][x] == mesh[y + 1][x - 1] &&
                        mesh[y][x] == mesh[y + 2][x - 2] &&
                        mesh[y][x] == mesh[y + 3][x - 3] &&
                        mesh[y][x] == mesh[y + 4][x - 4]) {

                    tv1.setText(mesh[y][x] == 1 ? "White Wins!" : "Black Wins!");
                    return;
                }
            }
        }

        // No winner
        tv1.setText("No Winner Yet");
    }


// distinguish colour
    int flag = -1;
    int[][] mesh = new int[40][40];

    // put on frametouch
    class frametouch implements View.OnTouchListener {
        Context this1;
        frametouch(Context this1) {
            this.this1 = this1;
        }
        @Override
        public boolean onTouch(View v, MotionEvent ev) {
            FrameLayout fl1 = (FrameLayout) findViewById(R.id.fl1);

            // create textviews to show stone positions
            TextView tv1 = (TextView) findViewById(R.id.tv1);
            TextView tv2 = (TextView) findViewById(R.id.tv2);
            if(ev.getAction() == 0) {  // push

                float xpos = Math.round((ev.getX()) * 0.01f) * 100 - 50f;
                float ypos = Math.round((ev.getY()) * 0.01f) * 100 - 50f;

                // static array
                if(mesh[(int)((ypos+50)/100)][(int)((xpos+50)/100)] == 0) { // check if the spot is empty
                    // implement stones
                    stone stone1 = new stone(this1);
                    fl1.addView(stone1);
                    stone1.setX(xpos);
                    stone1.setY(ypos);
                    mesh[(int)((ypos+50)/100)][(int)((xpos+50)/100)] = flag;
                    flag *= -1;
//                    tv1.setText(xpos + " " + ypos);
//                    tv2.setText((int)((ypos+50)/100)+" " + (int)((xpos+50)/100));
                    checkWinner();
                }

            }
            return true;
        }
    }

    // create stone, using onDraw
    class stone extends View {
        stone(Context this1) {
            super(this1);
        }
        public void onDraw(Canvas cv) {
            Paint pt = new Paint();
            if(flag > 0) {
                pt.setColor(Color.BLACK);
            } else {
                pt.setColor(Color.WHITE);
            }
            pt.setStyle(Paint.Style.FILL);
            pt.setStrokeWidth(1f);

            cv.drawCircle(50,50,50,pt);
        }
    }


    // draw lines
    class makeline extends View {
        makeline(Context this1) {
            super(this1);
        }
        public void onDraw(Canvas cv) {
            Paint pt = new Paint();
            pt.setColor(Color.BLACK);
            pt.setStrokeWidth(5f);

            for(int i=0; i<40; i++) {
                cv.drawLine(0, 100*i, cv.getWidth(), 100*i, pt);
                cv.drawLine(100*i, 0, 100*i, cv.getHeight(), pt);
            }

        }
    }
}