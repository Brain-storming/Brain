package com.example.alex.bs.activity;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.alex.bs.R;
import com.example.alex.bs.adapter.PostListItemAdapter;
import com.example.alex.bs.bean.PostListItem;
import com.example.alex.bs.wiget.AutoListView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by alex on 2015/5/16.
 */
public class TabHomeFragment extends Fragment {

    private AutoListView mPostListView;
    private List<PostListItem> mData = new ArrayList<PostListItem>();



    //初始化list数据项
    Drawable[] headSculptures;
    int[] headSculptureRes;
    String[] userNames;
    String[] postNames;
    String[] postTitles;
    String[] postContext;
    int[] priseNumbers;
    int[] commentNumbers;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPostListView = (AutoListView) inflater.inflate(R.layout.fragment_tab_home, container, false);
        for(int i=0; i<12; i++)
            mData.add(new PostListItem(getResources().getDrawable(R.drawable.ic_head_sculpture),"Braining Storm","2015/5/17","我的第一个帖子","测试",
                    9,9));
        PostListItemAdapter postListItemAdapter = new PostListItemAdapter(this.getActivity(),mData);
        mPostListView.setAdapter(postListItemAdapter);

        //当条目过少，不显示上拉加载
        if(mPostListView.getCount()<=10)
            mPostListView.setLoadEnable(false);

        //上拉下拉监听器
        mPostListView.setOnRefreshListener(new AutoListView.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
        mPostListView.setOnLoadListener(new AutoListView.OnLoadListener() {
            @Override
            public void onLoad() {

            }
        });
        //选择帖子监听器
        mPostListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mData.get(position);
            }
        });
        return mPostListView;
    }
}
