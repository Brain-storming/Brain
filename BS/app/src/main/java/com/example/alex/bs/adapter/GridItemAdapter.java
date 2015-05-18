package com.example.alex.bs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.bs.bean.GridItem;
import com.example.alex.bs.R;

import java.util.List;

/**
 * Created by alex on 2015/5/18.
 */
public class GridItemAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    List<GridItem> mItems;
    Context con;

    public GridItemAdapter(Context context, List<GridItem> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mItems = data;
        this.con = context;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public GridItem getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        GridItem item = getItem(position);
        TextView textItem = null;
        ImageView imageItem = null;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.grid_image_item, null);
        }

        textItem = (TextView)convertView.findViewById(R.id.tags_item_text);
        imageItem = (ImageView)convertView.findViewById(R.id.tags_item_image);

        textItem.setText(item.getTextItem());
        imageItem.setBackground(item.getImageItem());

        //gridItem监听器
        imageItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }
}
