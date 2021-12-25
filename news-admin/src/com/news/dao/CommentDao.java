package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.news.dbutils.C3p0Utils;
import com.news.pojo.Comment;

public class CommentDao{

    public int insertComment(Comment comment){
        try {
            Connection connection = C3p0Utils.getConnection();
            String sql = "insert into comment(user_id,content,create_time,update_time,news_id) values(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, comment.getUser_id());
            statement.setString(2, comment.getContent());
            statement.setDate(3, comment.getCreate_time());
            statement.setDate(4, comment.getUpdate_time());
            statement.setInt(5, comment.getNews_id());
            int update = statement.executeUpdate();
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int updateComment(Comment comment){
        try {
            Connection connection = C3p0Utils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "update comment set content='" + comment.getContent() + "',update_time='"+comment.getUpdate_time()+"' where comment_id=" + comment.getComment_id();
            int update = statement.executeUpdate(sql);
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    public int deleteComment(int comment_id){
        try {
            Connection connection = C3p0Utils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "delete from comment where comment_id=" + comment_id;
            int update = statement.executeUpdate(sql);
            return update;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }



}

