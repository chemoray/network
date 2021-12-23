package com.news.service;



import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.convertor.StringToSqlDate;
import com.news.convertor.StringToInt;
import com.news.dao.AuthorDao;
import com.news.pojo.Author;

/**
 * Servlet implementation class UserRegistServlet
 */
@WebServlet("/AuthorRegistServlet")
public class AuthorRegistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
        Author author = new Author();
        StringToSqlDate stringToSqlDate = new StringToSqlDate();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String create_date = request.getParameter("date");
        int newsnumber=0;
        Date date = stringToSqlDate.getStringToSqlDate(create_date);
        author.setUsername(username);
        author.setPassword(password);
        author.setEmail(email);
        author.setPhone(phone);
        author.setNewsnumber(newsnumber);
        author.setCreate_date(date);
        AuthorDao authorDao = new AuthorDao();
        int insertAuthor = authorDao.insertAuthor(author);
        if (insertAuthor != 0) {
            response.sendRedirect("authorlogin.html");
        }else {
            response.sendRedirect("authorregist.jsp");
        }
    }

}
