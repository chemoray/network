package com.news.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Comment implements Serializable{

    private int comment_id;
    private int user_id;
    private String content;
    private int news_id;
    private Date create_time;
    private Date update_time;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "News [user_id=" + user_id + ", content=" + content +"news_id="+news_id+ ", create_date="+create_time+ "update_date=" + update_time + "]";
    }




}

