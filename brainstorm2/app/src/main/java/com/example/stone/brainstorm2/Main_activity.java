package com.example.stone.brainstorm2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.*;

/**
 * Created by stone on 2015/4/22.
 */
public class Main_activity extends ActionBarActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ListView list = (ListView)findViewById(R.id.listView);
        Button jingpin = (Button)findViewById(R.id.button_jingpin1);
        Button geren = (Button)findViewById(R.id.button_geren1);
        Button shezhi = (Button)findViewById(R.id.button_shezhi1);
        //生成动态数组，并且转载数据
        ArrayList<HashMap<String, String>> my_list = new ArrayList<HashMap<String, String>>();
        for(int i=0;i<30;i++)
        {
            HashMap<String, String>map = new HashMap<String, String>();
            map.put("Text","This is text.....");
            map.put("Button","顶一下");
            my_list.add(map);
        }
        String[] from = { "Text", "Button" };
        int[] to = { R.id.text, R.id.button};
        SimpleAdapter adapter  = new SimpleAdapter(this,my_list,R.layout.listitem,from, to);
                //添加并且显示
                list.setAdapter(adapter );
        //点开帖子查看详细
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Main_activity.this,Tiezineirong.class);
                startActivity(intent);
            }
        });

        //底部按钮页面跳转
        jingpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_activity.this,Jingpin.class);
                startActivity(intent);
            }
        });
        geren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_activity.this,Geren.class);
                startActivity(intent);
            }
        });
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_activity.this,Shezhi.class);
                startActivity(intent);
            }
        });

    }
    }
