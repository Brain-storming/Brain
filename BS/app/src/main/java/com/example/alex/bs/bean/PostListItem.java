package com.example.alex.bs.bean;

/**
 * Created by alex on 2015/5/13.
 */
import android.graphics.drawable.Drawable;

public class PostListItem {

    private Drawable headSculpture;//头像
    private String userName;//用户名
    private  String postTime;//发帖时间
    private String title;//帖子标题
    private  String postContext;//内容
    private int priseNumber;//点赞数
    private int commentNumber;//收藏数

    public PostListItem() {
    }

    public PostListItem(Drawable headSculpture,String userName,String postTime,
                        String title,String postContext,int priseNumber,int commentNumber) {
        this.headSculpture = headSculpture;
        this.userName = userName;
        this.postTime = postTime;
        this.title = title;
        this.postContext = postContext;
        this.priseNumber = priseNumber;
        this.commentNumber = commentNumber;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostContext() {
        return postContext;
    }

    public void setPostContext(String postContext) {
        this.postContext = postContext;
    }

    public int getPriseNumber() {
        return priseNumber;
    }

    public void setPriseNumber(int priseNumber) {
        this.priseNumber = priseNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }
}