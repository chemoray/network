package com.news.service;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.dbutils.C3p0Utils;
import com.news.pojo.AdminUser;
import com.news.pojo.Author;
import com.news.pojo.User;

/**
 * Servlet implementation class DeleteNewsServlet
 */
@WebServlet("/DeleteCommentServlet")
public class DeleteCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentServlet () {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());

        String comment_id = request.getParameter("comment_id");
        String action=request.getParameter("action");

        java.sql.Connection connection = C3p0Utils.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "delete from comment where comment_id = " + comment_id;
            int update = statement.executeUpdate(sql);

            if (update != 0) {
                if(action.equals("user"))  {
                    HttpSession session = request.getSession();
                    User user = (User) session.getAttribute("user_login");
                    response.sendRedirect("userhome.jsp?user_id="+user.getId());
                }
                if(action.equals("admin"))  {
                    String news_id=request.getParameter("news_id");
                    System.out.println("admindeletecommentServlet"+news_id);
                    response.sendRedirect("news-admin/deletecommenttable.jsp?newsid="+news_id);}
                if(action.equals("author")){
                    String news_id=request.getParameter("news_id");
                    System.out.println("authordeletecommentServlet"+news_id);
                    response.sendRedirect("news-author/deletecommenttable.jsp?newsid="+news_id);}
            }else {
                String msg = "error";
                HttpSession session = request.getSession();
                session.setAttribute("code", msg);
                if(action.equals("user"))  response.sendRedirect("userhome.jsp");
                if(action.equals("admin"))  response.sendRedirect("news-admin/msg.jsp");
                if(action.equals("author"))  response.sendRedirect("news-author/msg.jsp");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

