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
import com.news.pojo.News;

/**
 * Servlet implementation class ContentsearchServlet
 */
@WebServlet("/NewsSearchServlet")
public class NewsSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public NewsSearchServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        String news_id = request.getParameter("newsid");
        String action = request.getParameter("action");
        //System.out.println(news_id);
        SearchDao searchDao = new SearchDao();
        System.out.println("action");
        System.out.println(action);
        News news = searchDao.SearchNewsByID(news_id);
        HttpSession session = request.getSession();
        session.setAttribute("Newsdetail", news);
        if(action.equals("author")){
            response.sendRedirect("news-author/authorupdatenews.jsp");
        }
        if(action.equals("user")) {response.sendRedirect("newsitem.jsp");}
        if(action.equals("admin")) {response.sendRedirect("news-admin/updatenews.jsp");}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
