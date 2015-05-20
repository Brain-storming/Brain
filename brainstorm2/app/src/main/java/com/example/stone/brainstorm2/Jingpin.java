package com.example.stone.brainstorm2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by stone on 2015/5/4.
 */
public class Jingpin extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jingpin);
        Button shouye = (Button)findViewById(R.id.button_shouye2);
        Button geren = (Button)findViewById(R.id.button_geren2);
        Button shezhi = (Button)findViewById(R.id.button_shezhi2);

        //底部按钮页面跳转
        shouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jingpin.this,Main_activity.class);
                startActivity(intent);
            }
        });
        geren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jingpin.this,Geren.class);
                startActivity(intent);
            }
        });
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jingpin.this,Shezhi.class);
                startActivity(intent);
            }
        });


    }
}
