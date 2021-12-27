package com.news.service;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.dao.UserDao;
import com.news.pojo.Author;
import com.news.pojo.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
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
        String action = request.getParameter("action");
        int user_id = Integer.parseInt(request.getParameter("userid"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User();
        user.setId(user_id);
        user.setName(username);
        user.setPassword(password);
        user.setEmail(email);
        UserDao userDao = new UserDao();
        int updateUser = userDao.updateUser(user);
        System.out.println(action+"   =action_user");
        if (updateUser != 0) {
            if(action.equals("user")){
                User user2=userDao.selectUserByID(user_id);
                user2.toString();
                HttpSession session = request.getSession();
                session.setAttribute("user_login", user2);
                response.sendRedirect("userhome.jsp?user_id="+user2.getId());
            }
            else{response.sendRedirect("news-admin/usertable.jsp");}
        }else {
            String msg = "error";
            HttpSession session = request.getSession();
            session.setAttribute("code", msg);
            response.sendRedirect("news-admin/msg.jsp");
        }
    }

}
