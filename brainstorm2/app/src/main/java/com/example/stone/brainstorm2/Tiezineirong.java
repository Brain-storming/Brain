package com.example.stone.brainstorm2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by stone on 2015/5/4.
 */
public class Tiezineirong extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tiezineirong);
        Button fanhui = (Button)findViewById(R.id.fanhui_button);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ListView list = (ListView)findViewById(R.id.listView2);
        //生成动态数组，并且转载数据
        ArrayList<HashMap<String, String>> my_list = new ArrayList<HashMap<String, String>>();
        for(int i=0;i<30;i++)
        {
            HashMap<String, String>map = new HashMap<String, String>();
            map.put("Text","This is 评论.....");
            map.put("Button","顶一下");
            my_list.add(map);
        }
        String[] from = { "Text", "Button" };
        int[] to = { R.id.text, R.id.button};
        SimpleAdapter adapter  = new SimpleAdapter(this,my_list,R.layout.listitem,from, to);
        //添加并且显示
        list.setAdapter(adapter);

    }
}
