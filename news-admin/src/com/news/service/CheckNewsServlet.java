package com.news.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.dao.AuthorDao;
import com.news.dao.NewsDao;
import com.news.dao.SearchDao;


import com.news.pojo.Author;
import com.news.pojo.News;

/**
 * Servlet implementation class NewsUpdateServlet
 */
@WebServlet("/CheckNewsServlet")
public class CheckNewsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckNewsServlet() {
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
        String id = request.getParameter("newsid");
        SearchDao searchDao=new SearchDao();
        News news= searchDao.SearchNewsByID(id);
        news.setState(1);
        NewsDao newsDao = new NewsDao();
        int updateNews = newsDao.updateNews(news);
        int author_id=news.getAuthorId();
        AuthorDao authorDao = new AuthorDao();
        Author author = authorDao.selectAuthorByID(author_id);
        int news_number=author.getNewsnumber()+1;
        author.setNewsnumber(news_number);
        int update =authorDao.updateAuthor(author);
        if(updateNews!=0 && update!=0){
            String msg="success";
            HttpSession session = request.getSession();
            session.setAttribute("code",msg);
            response.sendRedirect("news-admin/checknews.jsp");
        }

        else{
            String msg="error";
            HttpSession session = request.getSession();
            session.setAttribute("code",msg);
            response.sendRedirect("news-admin/msg.jsp");



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

