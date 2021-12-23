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
import com.news.dao.CategoryDao;
import com.news.pojo.Category;

/**
 * Servlet implementation class AddCategoryServlet
 */
@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategoryServlet() {
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
        request.setCharacterEncoding("UTF-8");
        String categeor_name = request.getParameter("news-classify");
        String ceeate_date = request.getParameter("news-time");
        StringToSqlDate stringToSqlDate = new StringToSqlDate();
        Date date = stringToSqlDate.getStringToSqlDate(ceeate_date);

        Category category = new Category();
        category.setName(categeor_name);
        category.setState(1);
        category.setCreate_date(date);
        category.setUpdate_date(date);

        CategoryDao categoryDao = new CategoryDao();
        int insertCategory = categoryDao.insertCategory(category);
        if (insertCategory != 0) {
            String msg = "success";
            HttpSession session = request.getSession();
            session.setAttribute("code", msg);
            response.sendRedirect("news-admin/msg.jsp");
        }else {
            String msg = "error";
            HttpSession session = request.getSession();
            session.setAttribute("code", msg);
            response.sendRedirect("news-admin/msg.jsp");
        }

    }

}
