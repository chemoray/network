package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.news.dbutils.C3p0Utils;
import com.news.pojo.News;

public class NewsDao {
    public int insertNews(News news){
        try{
            Connection connection = C3p0Utils.getConnection();
            String sql="insert into news(category_id,authorId,title,content,state,create_date,update_date)values(?,?,?,?,?,?,?)";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1, news.getCategory_id());
            statement.setInt(2, news.getAuthorId());
            statement.setString(3, news.getTitle());
            statement.setString(4, news.getContent());
            statement.setInt(5, news.getState());
            statement.setDate(6, news.getCreate_date());
            statement.setDate(7, news.getUpdate_date());
            int update =statement.executeUpdate();
            return update;
        }catch(Exception e){
            e.printStackTrace();

        }
        return 0;




    }

}
