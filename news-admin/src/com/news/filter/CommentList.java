package com.news.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.news.dbutils.C3p0Utils;
import com.news.pojo.Comment;

/**
 * Servlet Filter implementation class NewsListFilter
 */
@WebFilter(filterName="/CommentList" ,urlPatterns={"/newsitem.jsp","/news-author/deletecommenttable.jsp","/news-admin/deletecommenttable.jsp"})
public class CommentList implements Filter {
    /**
     * Default constructor.
     */
    public  CommentList() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        // place your code here
        Connection connection = C3p0Utils.getConnection();
        int news_id = Integer.parseInt(request.getParameter("newsid"));
        System.out.println("commentlist_news_id");
        System.out.println(news_id);
        try {
            Statement createStatement = connection.createStatement();
            String sql="select * from comment where news_id='" + news_id+"'";
            ResultSet resultSet = createStatement.executeQuery(sql);
            ArrayList<Comment> list = new ArrayList<>();
            while(resultSet.next()){
                Comment comment = new Comment();
                int comment_id=resultSet.getInt("comment_id");
                int user_id = resultSet.getInt("user_id");
                int news = resultSet.getInt("news_id");
                String news_comment = resultSet.getString("content");
                Date create_time = resultSet.getDate("create_time");
                Date update_time = resultSet.getDate("update_time");
                comment.setComment_id(comment_id);
                comment.setUser_id(user_id);
                comment.setNews_id(news);
                comment.setContent(news_comment);
                comment.setCreate_time(create_time);
                comment.setUpdate_time(update_time);
                list.add(comment);
            }
            System.out.println("commentlistfilter");
            HttpServletRequest request2 = (HttpServletRequest) request;
            HttpSession session = request2.getSession();
            session.setAttribute("newsComment", list);
            chain.doFilter(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // pass the request along the filter chain
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}


