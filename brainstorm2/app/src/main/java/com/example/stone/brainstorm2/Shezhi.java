package com.example.stone.brainstorm2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by stone on 2015/5/4.
 */
public class Shezhi extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shezhi);

        //声明变量
        Button shouye = (Button)findViewById(R.id.button_shouye4);
        Button jingpin = (Button)findViewById(R.id.button_jingpin4);
        Button geren = (Button)findViewById(R.id.button_geren4);

        //底部按钮页面跳转
        shouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shezhi.this,Main_activity.class);
                startActivity(intent);
            }
        });
        jingpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shezhi.this,Jingpin.class);
                startActivity(intent);
            }
        });
        geren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shezhi.this,Geren.class);
                startActivity(intent);
            }
        });


    }
}

