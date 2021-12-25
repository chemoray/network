package com.news.service;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.dao.CommentDao;
import com.news.pojo.Comment;
import com.news.pojo.User;

/**
 * Servlet implementation class NewsUpdateServlet
 */
@WebServlet("/UpdateCommentServlet")
public class UpdateCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        request.setCharacterEncoding("UTF-8");
        int comment_id = Integer.parseInt(request.getParameter("comment_id"));
        String content = request.getParameter("content");

        Comment comment = new Comment();
        comment.setComment_id(comment_id);
        comment.setContent(content);

        java.util.Date date = new java.util.Date();
        comment.setUpdate_time(new Date(date.getTime()));
        CommentDao commentDao = new  CommentDao();
        int updateComment = commentDao.updateComment(comment);
        System.out.println("updatecommentservlet");
        System.out.println(comment_id);
        System.out.println(content);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_login");
        if(updateComment!=0){
            response.sendRedirect("userhome.jsp?user_id="+user.getId());
        }
        else{
            response.sendRedirect("userhome.jsp?user_id="+user.getId());
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
