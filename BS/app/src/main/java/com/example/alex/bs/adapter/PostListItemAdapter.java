package com.example.alex.bs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alex.bs.bean.PostListItem;
import com.example.alex.bs.R;

import java.util.List;

/**
 * Created by alex on 2015/5/17.
 */
public class PostListItemAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<PostListItem> mItems;
    Context con;

    public PostListItemAdapter(Context context, List<PostListItem> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mItems = data;
        this.con = context;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public PostListItem getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PostListItem item = getItem(position);
        LinearLayout head = null;
        TextView userName = null;
        TextView postTime = null;
        TextView postTitle = null;
        TextView postContext = null;
        TextView priseNumber = null;
        TextView commentNumber = null;
        ImageView postPrise = null;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.post_list_item, null);
        }
        head = (LinearLayout)convertView.findViewById(R.id.post_list_head);
        userName = (TextView)convertView.findViewById(R.id.post_user_name);
        postTime = (TextView)convertView.findViewById(R.id.post_time);
        postTitle = (TextView)convertView.findViewById(R.id.post_title);
        postContext = (TextView)convertView.findViewById(R.id.post_context);
        postPrise = (ImageView)convertView.findViewById(R.id.post_prise);
        priseNumber = (TextView)convertView.findViewById(R.id.prise_number);
        commentNumber = (TextView)convertView.findViewById(R.id.comment_number);

        userName.setText(item.getUserName());
        postTime.setText(item.getPostTime());
        postTitle.setText(item.getTitle());
        postContext.setText(item.getPostContext());
        priseNumber.setText(String.valueOf(item.getPriseNumber()));
        commentNumber.setText(String.valueOf(item.getCommentNumber()));

        //head栏监听器
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //点赞监听器
        postPrise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }

    public void addItem(PostListItem item){
        mItems.add(item);
    }

}
