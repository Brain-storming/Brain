package com.example.alex.bs.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by alex on 2015/5/18.
 */
public class GridItem {

    Drawable ImageItem;//图片
    String TextItem;//标签

    public GridItem() {
    }

    public GridItem(Drawable imageItem,String textItem){
        this.ImageItem = imageItem;
        this.TextItem = textItem;
    }
    public Drawable getImageItem() {
        return ImageItem;
    }

    public void setImageItem(Drawable imageItem) {
        ImageItem = imageItem;
    }

    public String getTextItem() {
        return TextItem;
    }

    public void setTextItem(String textItem) {
        TextItem = textItem;
    }


}
