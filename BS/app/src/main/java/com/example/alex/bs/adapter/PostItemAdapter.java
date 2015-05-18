package com.example.alex.bs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.bs.wiget.CircleImageView;
import com.example.alex.bs.bean.PostItem;
import com.example.alex.bs.R;

import java.util.List;

/**
 * Created by alex on 2015/5/17.
 */
public class PostItemAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<PostItem> mItems;
    Context con;

    public PostItemAdapter(Context context, List<PostItem> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mItems = data;
        this.con = context;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public PostItem getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PostItem item = getItem(position);
        CircleImageView headSculpture = null;
        TextView userName = null;
        TextView postTime = null;
        TextView postContext = null;
        ImageView comment = null;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.post_item, null);
        }
        headSculpture = (CircleImageView)convertView.findViewById(R.id.head_sculpture);
        userName = (TextView)convertView.findViewById(R.id.post_user_name);
        postTime = (TextView)convertView.findViewById(R.id.post_time);
        postContext = (TextView)convertView.findViewById(R.id.post_context);
        comment = (ImageView)convertView.findViewById(R.id.post_comment);

        headSculpture.setBackground(item.getHeadSculpture());
        userName.setText(item.getUserName());
        postTime.setText(item.getPostTime());
        postContext.setText(item.getPostContext());

        //头像监听器
        headSculpture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //评论监听器
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }
}
