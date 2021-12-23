package com.news.service;


import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.convertor.StringToSqlDate;
import com.news.dao.UserDao;
import com.news.pojo.User;

/**
 * Servlet implementation class UserRegistServlet
 */
@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistServlet() {
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
        User user = new User();
        StringToSqlDate stringToSqlDate = new StringToSqlDate();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String create_date = request.getParameter("date");
        Date date = stringToSqlDate.getStringToSqlDate(create_date);
        user.setName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setState(1);
        user.setCreate_date(date);

        UserDao userDao = new UserDao();
        int insertUser = userDao.insertUser(user);
        if (insertUser != 0) {
            response.sendRedirect("userlogin.html");
        }else {
            response.sendRedirect("regist.jsp");
        }
    }

}
