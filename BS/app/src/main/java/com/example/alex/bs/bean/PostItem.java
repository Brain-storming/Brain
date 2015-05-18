package com.example.alex.bs.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by alex on 2015/5/17.
 */
public class PostItem {
    private Drawable headSculpture;//头像
    private String userName;//用户名
    private  String postTime;//发表时间
    private  String postContext;//内容

    public PostItem() {
    }
    public PostItem(Drawable headSculpture,String userName,String postTime,
                        String postContext) {
        this.headSculpture = headSculpture;
        this.userName = userName;
        this.postTime = postTime;
        this.postContext = postContext;
    }

    public Drawable getHeadSculpture() {
        return headSculpture;
    }

    public void setHeadSculpture(Drawable headSculpture) {
        this.headSculpture = headSculpture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getPostContext() {
        return postContext;
    }

    public void setPostContext(String postContext) {
        this.postContext = postContext;
    }
}
