/*添加 删除 选择 编辑作者
*包含匹配作者登录
*
* */
package com.news.dao;

import java.sql.*;

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
    public Author selectAuthorByID(int id){
        try {
            Connection connection = C3p0Utils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from author where authorId = " + id;
            ResultSet executeQuery = statement.executeQuery(sql);
            if (executeQuery.next()) {
                Author author = new Author();
                int authorId = executeQuery.getInt("authorId");
                String authorname = executeQuery.getString("authorname");
                String authoremail = executeQuery.getString("authoremail");
                String authorphone = executeQuery.getString("authorphone");
                String password = executeQuery.getString("password");
                int newsnumber = executeQuery.getInt("newsnumber");
                Date create_date = executeQuery.getDate("create_date");
                author.setPhone(authorphone);
                author.setUsername(authorname);
                author.setId(authorId);
                author.setPassword(password);
                author.setEmail(authoremail);
                author.setNewsnumber(newsnumber);
                author.setCreate_date(create_date);
                return author;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}

