package com.news.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.dao.SearchDao;
import com.news.pojo.Comment;
import com.news.pojo.News;

/**
 * Servlet implementation class ContentsearchServlet
 */
@WebServlet("/UserCommentSearchServlet")
public class UserCommentSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public UserCommentSearchServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        int comment_id = Integer.parseInt(request.getParameter("comment_id"));
        //System.out.println(news_id);
        SearchDao searchDao = new SearchDao();
        Comment comment= searchDao.SearchCommentByCommentID(comment_id);
        HttpSession session = request.getSession();
        session.setAttribute("commentDetail",comment);
        response.sendRedirect("updatecomment.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}