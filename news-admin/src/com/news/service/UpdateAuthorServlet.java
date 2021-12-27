package com.news.service;

import java.io.IOException;

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
 * Servlet implementation class UpdateAuthorServlet
 */
@WebServlet("/UpdateAuthorServlet")
public class UpdateAuthorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAuthorServlet() {
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
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int newsnumber = Integer.parseInt(request.getParameter("newsnumber"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Author author = new Author();
        author.setId(id);
        author.setNewsnumber(newsnumber);
        author.setPassword(password);
        author.setEmail(email);
        author.setPhone(phone);
        author.setUsername(username);
        AuthorDao authorDao = new AuthorDao();
        int update = authorDao.updateAuthor(author);
        if (update != 0) {
            response.sendRedirect("news-admin/authortable.jsp");
        }else {
            String msg = "error";
            HttpSession session = request.getSession();
            session.setAttribute("code", msg);
            response.sendRedirect("news-admin/msg.jsp");
        }
    }

}
