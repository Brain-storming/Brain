package com.example.alex.bs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TabHost;

import com.example.alex.bs.R;

/**
 * Created by alex on 2015/5/16.
 */
public class Search extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search, menu);
        //搜索框默认展开
        MenuItem search = menu.findItem(R.id.main_menu_search);
        search.collapseActionView();
        search.expandActionView();

        SearchView searchView = (SearchView)menu.findItem(R.id.main_menu_search).getActionView();
        searchView.setSubmitButtonEnabled(true);
        if(searchView == null){
            Log.e("SearchView", "Fail to get Search View.");
            return true;
        }
        searchView.setQueryHint(Html.fromHtml("<font color = #FFFFFF>" + "请输入搜索内容" + "</font>"));


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                //当点击搜索按钮,输入法搜索按钮,会触发这个方法.在这里做相应的搜索事件,query为用户输入的值
                //当输入框为空或者""时,此方法没有被调用
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //当输入的文字发生变化的时候,会触发这个方法.在这里做匹配提示的操作等
                return true;
            }

        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    *按返回键回到上一个界面
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
