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
import com.news.pojo.Author;
import com.news.pojo.User;

/**
 * Servlet Filter implementation class UserList
 */
@WebFilter(filterName="/AuthorList", urlPatterns={"/news-admin/authortable.jsp", "/news-admin/deleteauthortable.jsp"})
public class AuthorList implements Filter {

        /**
         * Default constructor.
         */
        public AuthorList() {
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
                try {
                        Statement statement = connection.createStatement();
                        String sql = "select `author`.authorname,`author`.authorId,`author`.authorphone,`author`.authoremail,`author`.create_date,`author`.newsnumber FROM `author`";
                        ResultSet resultSet = statement.executeQuery(sql);
                        ArrayList<Author> list = new ArrayList<>();
                        while(resultSet.next()){
                                Author author = new Author();
                                int authorId = resultSet.getInt("authorId");
                                String authorname = resultSet.getString("authorname");

                                String authoremail = resultSet.getString("authoremail");
                                String authorphone = resultSet.getString("authorphone");
                                int newsnumber = resultSet.getInt("newsnumber");
                                Date create_date = resultSet.getDate("create_date");
                                author.setPhone(authorphone);
                                author.setUsername(authorname);
                                author.setId(authorId);
                                author.setEmail(authoremail);
                                author.setNewsnumber(newsnumber);
                                author.setCreate_date(create_date);
                                list.add(author);
                        }
                        HttpServletRequest request2 = (HttpServletRequest) request;
                        HttpSession session = request2.getSession();
                        session.setAttribute("authors", list);
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                // pass the request along the filter chain
                chain.doFilter(request, response);
        }

        /**
         * @see Filter#init(FilterConfig)
         */
        public void init(FilterConfig fConfig) throws ServletException {
                // TODO Auto-generated method stub
        }

}

