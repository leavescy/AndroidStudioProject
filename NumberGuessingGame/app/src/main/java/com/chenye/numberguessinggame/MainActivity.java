package com.chenye.numberguessinggame;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int num1 = 0;
    private int num2 = 0;
    private int points = 0;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pickNumbers();
        hideNumbers();
    }

    public void hideNumbers(){
        Button leftBtn = findViewById(R.id.leftButton);
        Button rightBtn = findViewById(R.id.rightButton);
        leftBtn.setText("猜我，猜我！");
        rightBtn.setText("猜我，猜我！");
    }
    public void pickNumbers(){
        Button leftBtn = findViewById(R.id.leftButton);
        Button rightBtn = findViewById(R.id.rightButton);

        Random random = new Random();
        while(true){
            num1 = random.nextInt(10);
            num2 = random.nextInt(10);
            if(num1 != num2) break;
        }

        System.out.print("num1 = " + num1 + ", num2 = " + num2);

    }

    public void leftBtnClick(View view) {

        if(num1 > num2){
            Toast.makeText(this, "正确", Toast.LENGTH_SHORT).show();
            points ++;
        }else{
            Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
            points --;
        }
        Button leftBtn = findViewById(R.id.leftButton);
        Button rightBtn = findViewById(R.id.rightButton);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                hideNumbers();
            }
        };
        leftBtn.setText("" + num1);
        rightBtn.setText("" + num2);
        handler.postDelayed(runnable, 2000);
        pickNumbers();
        TextView pointsView = findViewById(R.id.pointsTextView);
        pointsView.setText("得分: " + points);
    }

    public void rightBtnClick(View view) {

        if(num2 > num1){
            Toast.makeText(this, "正确", Toast.LENGTH_SHORT).show();
            points ++;
        }else{
            Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
            points --;
        }
        Button leftBtn = findViewById(R.id.leftButton);
        Button rightBtn = findViewById(R.id.rightButton);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                hideNumbers();

            }
        };
        leftBtn.setText("" + num1);
        rightBtn.setText("" + num2);
        handler.postDelayed(runnable, 2000);
        pickNumbers();
        TextView pointsView = findViewById(R.id.pointsTextView);
        pointsView.setText("得分: " + points);
    }
}
