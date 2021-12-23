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
import com.news.pojo.News;

/**
 * Servlet Filter implementation class NewsListFilter
 */
@WebFilter(filterName="/AuthorNewsList" ,urlPatterns={"/news-author/authorshow.jsp", "/news-author/authordeletenews.jsp"})
public class AuthorNewsList implements Filter {
    /**
     * Default constructor.
     */
    public  AuthorNewsList() {
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
        String author_id = request.getParameter("authorid");
        System.out.println("author_id");
        System.out.println(author_id);
        try {
            Statement createStatement = connection.createStatement();
            String sql="select * from news where authorId='" + author_id+"'";
            ResultSet executeQuery = createStatement.executeQuery(sql);
            ArrayList<News> list = new ArrayList<>();
            while(executeQuery.next()){
                News news = new News();
                int id = executeQuery.getInt("id");
                int category_id = executeQuery.getInt("category_id");
                int author = executeQuery.getInt("authorId");
                String title = executeQuery.getString("title");
                String content = executeQuery.getString("content");
                int state = executeQuery.getInt("state");
                Date create_date = executeQuery.getDate("create_date");
                Date update_date = executeQuery.getDate("update_date");

                news.setId(id);
                news.setCategory_id(category_id);
                news.setAuthorId(author);
                news.setTitle(title);
                news.setContent(content);
                news.setState(state);
                news.setCreate_date(create_date);
                news.setUpdate_date(update_date);

                list.add(news);
            }
            System.out.println("authornewsfilter");
            HttpServletRequest request2 = (HttpServletRequest) request;
            HttpSession session = request2.getSession();
            session.setAttribute("authornews", list);
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

