package com.example.alex.bs.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.alex.bs.R;
import com.example.alex.bs.adapter.PostItemAdapter;
import com.example.alex.bs.bean.PostItem;
import com.example.alex.bs.wiget.AutoListView;
import com.example.alex.bs.wiget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 2015/5/17.
 */
public class TabBSFragment extends Fragment{

    private AutoListView mPostListView;
    private List<PostItem> mData = new ArrayList<PostItem>();

    //初始化bs list数据项
    CircleImageView[] headSculpture;
    int[] headSculptureRes;
    String[] userNames;
    String[] postContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPostListView = (AutoListView) inflater.inflate(R.layout.fragment_tab_home, container, false);

        for(int i=0; i<12; i++)
            mData.add(new PostItem(getResources().getDrawable(R.drawable.ic_head_sculpture),"Braining Storm","2015/5/17","测试"));
        PostItemAdapter postListItemAdapter = new PostItemAdapter(this.getActivity(),mData);
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
