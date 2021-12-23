package com.news.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.dao.AuthorDao;
import com.news.pojo.Author;
import com.news.pojo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AuthorLoginServlet")
public class AuthorLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorLoginServlet() {
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
        //TODO Auto-generated method stub
        //doGet(request, response);
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String valiDate = request.getParameter("valiDate");
        System.out.println("authorservlet");
        System.out.println(username);
        System.out.println(password);
        Author author = new Author();
        author.setUsername(username);
        author.setPassword(password);
        AuthorDao authorDao = new AuthorDao();
        Author selectAuthorByAuthor= authorDao.selectAuthorByAuthor(author);
        HttpSession session = request.getSession();
        String check_code = (String) session.getAttribute("check_code");

        if (selectAuthorByAuthor != null && check_code.equals(valiDate)) {
            session.setAttribute("author_login_info", selectAuthorByAuthor);
            response.sendRedirect("news-author/authormain.html");
        }else{
            response.sendRedirect("authorlogin.html");
        }
    }

}
