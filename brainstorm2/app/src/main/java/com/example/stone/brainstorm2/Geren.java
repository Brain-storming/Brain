package com.example.stone.brainstorm2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by stone on 2015/5/4.
 */
public class Geren extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gerenxinxi);

        //声明变量
        Button shouye = (Button)findViewById(R.id.button_shouye3);
        Button jingpin = (Button)findViewById(R.id.button_jingpin3);
        Button shezhi = (Button)findViewById(R.id.button_shezhi3);
        Button fatie = (Button)findViewById(R.id.button_fatie);
        //监听器
        fatie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Geren.this,Fatie.class);
                startActivity(intent);
            }
        });

        //底部按钮页面跳转
        shouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Geren.this,Main_activity.class);
                startActivity(intent);
            }
        });
        jingpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Geren.this,Jingpin.class);
                startActivity(intent);
            }
        });
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Geren.this,Shezhi.class);
                startActivity(intent);
            }
        });

    }
}

