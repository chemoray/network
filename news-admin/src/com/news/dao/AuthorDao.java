package com.news.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.news.dbutils.C3p0Utils;
import com.news.pojo.Author;

public class AuthorDao{

    public int insertAuthor(Author author){
        try {
            Connection connection = C3p0Utils.getConnection();
            String sql = "insert into author(authorname,password,authoremail,create_date,newsnumber,authorphone) values(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, author.getUsername());
            statement.setString(2, author.getPassword());
            statement.setString(3, author.getEmail());
            statement.setDate(4, author.getCreate_date());
            statement.setInt(5, author.getNewsnumber());
            statement.setString(6, author.getPhone());
            int update = statement.executeUpdate();
            System.out.println("update:");
            System.out.println(update);
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int updateAuthor(Author author){
        try {
            Connection connection = C3p0Utils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "update author set authorname='" + author.getUsername() + "',password='" + author.getPassword() + "',authoremail='" + author.getEmail() +
                    "',authorphone='"+author.getPhone()+"',newsnumber='"+author.getNewsnumber()+"' where authorId=" + author.getId();
            int update = statement.executeUpdate(sql);
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    public int deleteAuthor(int authorId){
        try {
            Connection connection = C3p0Utils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "delete from author where authorId=" + authorId;
            int update = statement.executeUpdate(sql);
            return update;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }
    public Author selectAuthorByAuthor(Author author){
        try {
            Connection connection = C3p0Utils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from author where authorname = '" + author.getUsername() + "' and password = '" + author.getPassword() + "'";
            ResultSet executeQuery = statement.executeQuery(sql);
            if (executeQuery.next()) {
                Author author2 = new Author();
                String author_name = executeQuery.getString("authorname");
                author2.setUsername(author_name);
                int author_id = executeQuery.getInt("authorId");
                author2.setId(author_id);
                System.out.println("authordao sql");
                System.out.println(author_name);
                System.out.println(author_id);
                return author2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}

