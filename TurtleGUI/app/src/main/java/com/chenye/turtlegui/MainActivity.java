package com.chenye.turtlegui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> turtleList = new ArrayList<>();
        turtleList.add("Don");
        turtleList.add("Mike");
        turtleList.add("Leo");
        turtleList.add("Raph");
        Spinner spinner = findViewById(R.id.Spinner);
        // 为下拉列表定义一个适配器，使用到上面定义的turtleList
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, turtleList);
        // 为适配器设置下拉列表下拉时的菜单样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 将适配器添加到下拉列表上
        spinner.setAdapter(adapter);
        // 为下拉框设置事件的响应
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             *
             * @param adapterView
             * @param view   显示的布局
             * @param i      在布局显示的位置id
             * @param l      将要显示的数据
             */
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayAdapter<String> adapter = (ArrayAdapter<String>) adapterView.getAdapter();
                ImageButton turtleImaBtn = findViewById(R.id.turtleImg);
                if(adapter.getItem(i).equals("Don")){
                    turtleImaBtn.setImageResource(R.drawable.don);
                }
                else if(adapter.getItem(i).equals("Mike")){
                    turtleImaBtn.setImageResource(R.drawable.mike);
                }
                else if(adapter.getItem(i).equals("Leo")){
                    turtleImaBtn.setImageResource(R.drawable.leo);
                }
                else if(adapter.getItem(i).equals("Raph")){
                    turtleImaBtn.setImageResource(R.drawable.raph);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void listChooseTurtle(AdapterView<?> adapterView, View view){
        ImageButton turtleImaBtn = findViewById(R.id.turtleImg);

    }

/*
    public void chooseTurtle(View view) {
        ImageButton turtleImaBtn = findViewById(R.id.turtleImg);
        if(view.getId() == R.id.DonTurtle){
            turtleImaBtn.setImageResource(R.drawable.don);

        }else if(view.getId() == R.id.MikeTurtle){
            turtleImaBtn.setImageResource(R.drawable.mike);

        }else if(view.getId() == R.id.LeoTurtle){
            turtleImaBtn.setImageResource(R.drawable.leo);

        }else if(view.getId() == R.id.RaphTurtle){
            turtleImaBtn.setImageResource(R.drawable.raph);
        }

    }
    */
}
