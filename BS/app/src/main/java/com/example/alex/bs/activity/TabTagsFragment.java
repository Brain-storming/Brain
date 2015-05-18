package com.example.alex.bs.activity;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.alex.bs.R;
import com.example.alex.bs.adapter.GridItemAdapter;
import com.example.alex.bs.bean.GridItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 2015/5/18.
 */
public class TabTagsFragment extends Fragment{

    private GridView mGridView;
    private List<GridItem> mData = new ArrayList<GridItem>();

    //初始化list数据项
    Drawable[] imageItems;
    String[] textItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mGridView = (GridView) inflater.inflate(R.layout.fragment_tab_tags, container, false);
        mGridView.setPadding(0,20,0,0);
        for (int i = 0; i < 12; i++)
            mData.add(new GridItem((getResources().getDrawable(R.drawable.ic_head_sculpture)),"测试"));
        GridItemAdapter gridItemAdapter = new GridItemAdapter(this.getActivity(), mData);
        mGridView.setAdapter(gridItemAdapter);

        //监听器
        mGridView.getOnItemClickListener();
        return mGridView;
    }
}
