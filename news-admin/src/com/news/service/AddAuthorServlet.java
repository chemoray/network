package com.news.service;


import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.news.convertor.StringToSqlDate;
import com.news.dao.AuthorDao;
import com.news.pojo.Author;

/**
 * Servlet implementation class AddAuthorServlet
 */
@WebServlet("/AddAuthorServlet")
public class AddAuthorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAuthorServlet() {
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

        String username = request.getParameter("authorname");
        String password = request.getParameter("password");
        String authorphone = request.getParameter("authorphone");
        String authoremail = request.getParameter("authoremail");
        Author author = new Author();
        author.setPhone(authorphone);
        author.setPassword(password);
        author.setUsername(username);
        author.setEmail(authoremail);
        author.setNewsnumber(0);
        java.util.Date date = new java.util.Date();
        author.setCreate_date(new Date(date.getTime()));


        AuthorDao authorDao = new AuthorDao();
        int insertAuthor = authorDao.insertAuthor(author);
        if (insertAuthor  != 0) {
            response.sendRedirect("news-admin/authortable.jsp");
			/*String msg = "success";
			HttpSession session = request.getSession();
			session.setAttribute("code", msg);
			response.sendRedirect("news-admin/msg.jsp");*/
        }else {
            String msg = "error";
            HttpSession session = request.getSession();
            session.setAttribute("code", msg);
            response.sendRedirect("news-admin/msg.jsp");
        }
    }

}
