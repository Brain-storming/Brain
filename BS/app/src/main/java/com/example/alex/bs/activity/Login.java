package com.example.alex.bs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.bs.R;

/**
 * Created by alex on 2015/5/14.
 */
public class Login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();//隐藏actionBar

        EditText userName = (EditText) findViewById(R.id.login_useName);
        EditText password = (EditText) findViewById(R.id.login_password);
        Button login = (Button) findViewById(R.id.login_button);
        TextView textView = (TextView) findViewById(R.id.login_textview);
        ImageView imageView = (ImageView)findViewById(R.id.head_sculpture);

        //textView设置点击事件
        SpannableString spannableString = new SpannableString(
                "还没有账号么？赶紧注册吧！");
        spannableString.setSpan(null, 9, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //”注册“加注下划线
        spannableString.setSpan(new ForegroundColorSpan(R.drawable.text_color_primary_invertible),9,11,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);//改变”注册“颜色

        textView.setText(spannableString);
        /**
        *监听器
        */
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
