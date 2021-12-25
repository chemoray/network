package com.news.dao;
/*
* 根据内容 标题 种类名 新闻id选择新闻
*
* */
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.news.dbutils.C3p0Utils;
import com.news.pojo.News;
import com.news.pojo.Comment;

public class SearchDao {

    public  ArrayList<News> SearchNewsByContent(String content){
        Connection connection = C3p0Utils.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from news where content like '%" + content + "%'";
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<News> list = new ArrayList<>();
            while(resultSet.next()){
                News news = new News();
                int id = resultSet.getInt("id");
                int category_id = resultSet.getInt("category_id");
                String title = resultSet.getString("title");
                String news_content = resultSet.getString("content");
                int author_id = resultSet.getInt("authorId");
                int state = resultSet.getInt("state");
                Date create_date = resultSet.getDate("create_date");
                Date update_date = resultSet.getDate("update_date");
                news.setId(id);
                news.setCategory_id(category_id);
                news.setTitle(title);
                news.setContent(news_content);
                news.setAuthorId(author_id);
                news.setState(state);
                news.setCreate_date(create_date);
                news.setUpdate_date(update_date);
                list.add(news);
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public ArrayList<News> SearchNewsByTitle(String search_title) {
        Connection connection = C3p0Utils.getConnection();
        try{
            Statement statement = connection.createStatement();
            String sql = "select * from news where title like '%" +search_title + "%'";
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<News> list = new ArrayList<>();
            while(resultSet.next()){
                News news = new News();
                int id = resultSet.getInt("id");
                int category_id = resultSet.getInt("category_id");
                int author_id = resultSet.getInt("authorId");
                String title = resultSet.getString("title");
                String news_content = resultSet.getString("content");
                int state = resultSet.getInt("state");
                Date create_date = resultSet.getDate("create_date");
                Date update_date = resultSet.getDate("update_date");
                news.setId(id);
                news.setCategory_id(category_id);
                news.setTitle(title);
                news.setContent(news_content);
                news.setAuthorId(author_id);
                news.setState(state);
                news.setCreate_date(create_date);
                news.setUpdate_date(update_date);
                list.add(news);
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<News> SearchNewsByCategoryId(int categoryId){
        try {
            Connection connection = C3p0Utils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from news where category_id = " + categoryId;
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<News> list = new ArrayList<>();
            while(resultSet.next()){
                News news = new News();
                int id = resultSet.getInt("id");
                int category_id = resultSet.getInt("category_id");
                int author_id = resultSet.getInt("authorId");
                String title = resultSet.getString("title");
                String news_content = resultSet.getString("content");
                int state = resultSet.getInt("state");
                Date create_date = resultSet.getDate("create_date");
                Date update_date = resultSet.getDate("update_date");
                news.setId(id);
                news.setCategory_id(category_id);
                news.setTitle(title);
                news.setAuthorId(author_id);
                news.setContent(news_content);
                news.setState(state);
                news.setCreate_date(create_date);
                news.setUpdate_date(update_date);
                list.add(news);
                return list;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;

    }

    public  News SearchNewsByID(String Newsid){
        Connection connection = C3p0Utils.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from news where id = " + Newsid ;
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                News news = new News();
                int id = resultSet.getInt("id");
                int category_id = resultSet.getInt("category_id");
                int author_id = resultSet.getInt("authorId");
                String title = resultSet.getString("title");
                String news_content = resultSet.getString("content");
                int state = resultSet.getInt("state");
                Date create_date = resultSet.getDate("create_date");
                Date update_date = resultSet.getDate("update_date");
                news.setId(id);
                news.setCategory_id(category_id);
                news.setAuthorId(author_id);
                news.setTitle(title);
                news.setContent(news_content);
                news.setState(state);
                news.setCreate_date(create_date);
                news.setUpdate_date(update_date);
                return news;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public ArrayList<Comment> SearchCommentByID(String Newsid){
        Connection connection = C3p0Utils.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from comment where news_id = " + Newsid ;
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Comment> list = new ArrayList<>();
            while(resultSet.next()) {
                Comment comment = new Comment();
                int id = resultSet.getInt("user_id");
                int news_id = resultSet.getInt("news_id");
                String news_comment = resultSet.getString("content");
                Date create_time = resultSet.getDate("create_time");
                Date update_time = resultSet.getDate("update_time");
                comment.setUser_id(id);
                comment.setNews_id(news_id);
                comment.setContent(news_comment);
                comment.setCreate_time(create_time);
                comment.setUpdate_time(update_time);
                list.add(comment);
                return list;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Comment SearchCommentByCommentID(int comment_id){
        Connection connection = C3p0Utils.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from comment where comment_id = " +comment_id;
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                Comment comment  = new  Comment ();
                int id = resultSet.getInt("user_id");
                int news_id = resultSet.getInt("news_id");
                String news_comment = resultSet.getString("content");
                Date create_time = resultSet.getDate("create_time");
                Date update_time = resultSet.getDate("update_time");
                comment.setUser_id(id);
                comment.setComment_id(comment_id);
                comment.setNews_id(news_id);
                comment.setContent(news_comment);
                comment.setCreate_time(create_time);
                comment.setUpdate_time(update_time);
                return comment;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }





}

