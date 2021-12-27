package com.news.service;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.dao.AdminDao;
import com.news.dao.AuthorDao;
import com.news.pojo.AdminUser;
import com.news.pojo.Author;

/**
 * Servlet implementation class ShowUpdateAdminServlet
 */
@WebServlet("/ShowUpdateAdminServlet")
public class ShowUpdateAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUpdateAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        String author_id = request.getParameter("authorid");
        int id = Integer.parseInt(author_id);
        AuthorDao authorDao = new AuthorDao();
        Author author = authorDao.selectAuthorByID(id);
        HttpSession session = request.getSession();
        session.setAttribute("updateauthor", author);
        response.sendRedirect("news-admin/updateauthor.jsp");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
