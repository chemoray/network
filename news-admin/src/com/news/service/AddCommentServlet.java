package com.news.service;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.convertor.StringToInt;
import com.news.convertor.StringToSqlDate;
import com.news.dao.CommentDao;
import com.news.dao.NewsDao;
import com.news.pojo.Comment;
import com.news.pojo.News;
import com.news.pojo.Author;

/**
 * Servlet implementation class AddNewsServlet
 */
@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
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
        request.setCharacterEncoding("UTF-8");
        Comment comment= new Comment();
        int news_id = Integer.parseInt(request.getParameter("news_id"));
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String content=request.getParameter("comment_content");
        java.util.Date date = new java.util.Date();
        Date time=new Date(date.getTime());

        comment.setUpdate_time(time);
        comment.setCreate_time(time);
        comment.setNews_id(news_id);
        comment.setUser_id(user_id);
        comment.setContent(content);

        CommentDao commentDao = new CommentDao();
        int insertComment = commentDao.insertComment(comment);
        if(insertComment!=0){
            response.sendRedirect("newsitem.jsp?newsid="+news_id);

        }else{
            response.sendRedirect("newsitem.jsp");



        }
    }

}

