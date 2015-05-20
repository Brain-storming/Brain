package com.example.stone.brainstorm2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by stone on 2015/5/6.
 */
public class Fatie extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fatie_layout);
        Button quxiao = (Button)findViewById(R.id.button_quxiao);
        Button fabiao = (Button)findViewById(R.id.button_fabiao);

        //底部按钮页面跳转
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        fabiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fatie.this,Main_activity.class);
                startActivity(intent);
            }
        });
    }
}
