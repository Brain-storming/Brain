package com.example.alex.bs.bean;

/**
 * Created by alex on 2015/5/13.
 */
import android.graphics.drawable.Drawable;

public class DrawerListItem {

    private Drawable icon;//图标
    private String title;//文本

    public DrawerListItem() {
    }

    public DrawerListItem(Drawable icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public Drawable getIcon() {
        return icon;
    }
    public String getTitle() {
        return title;
    }
    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
    public void setTitle(String title) {
        this.title = title;
    }


}