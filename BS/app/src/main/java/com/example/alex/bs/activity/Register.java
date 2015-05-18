package com.example.alex.bs.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.alex.bs.R;

/**
 * Created by alex on 2015/5/15.
 */
public class Register extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


    }

    /*
    *添加注册时的menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.register, menu);
        setRegisterActionBar();
        return super.onCreateOptionsMenu(menu);
    }


    /*
    *menu选择监听器，可选择邮箱注册和手机注册，加载不同的layout
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        LinearLayout linearLayout1 = (LinearLayout)findViewById(R.id.register_layout1);
        LinearLayout linearLayout2 = (LinearLayout)findViewById(R.id.register_layout2);

        switch (itemId){
            case R.id.register_menu_phone:
                if(linearLayout1.getVisibility()== View.GONE){
                    linearLayout2.setVisibility(View.GONE);
                    linearLayout1.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.register_menu_emailBox:
                if(linearLayout2.getVisibility()== View.GONE){
                    linearLayout1.setVisibility(View.GONE);
                    linearLayout2.setVisibility(View.VISIBLE);
                }
                break;
            case  android.R.id.home:
                onBackPressed();break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    public  void setRegisterActionBar(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("注册");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
