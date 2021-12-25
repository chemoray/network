<%@ page import="com.news.pojo.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.news.pojo.AdminUser" %>
<%@ page import="com.news.dao.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>工大新闻</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="viewport"
          content="width=device-width, initial-scale=1,maximum-scale=1">
    <link href="./home_files/main-2ada0a57df.css" rel="stylesheet">
</head>
<body class="news-index">
<div class="logo-search area">
    <div class="logo left">
        <a href="home.jsp">新闻首页</a>
    </div>
    <!--搜索栏-->
    <form action="HomeSearchServlet" method="post">
        <div class="search left" id="search">
            <!--怎么根据热点进行搜索 value=""-->
            <input type="text" class="search-input left" value=""
                   data-val="key" data-spm-acode="8066" name="text">
            <span class="search-btn"><input type="submit" class="search-icon icon" value=""></span>
        </div>
    </form>
    <!--欢迎用户/注册登录-->
    <div class="product-list right">
        <a href="userhome.html">欢迎:${user_login.name}</a>
        <button class="button"><a href="home.jsp">退出登录</a></button>
    </div>
</div>


    <div>
    <form>
        <fieldset>
            <legend>个人资料</legend>
            用户ID: <span>${user_login.id}</span>
            用户名: <span>${user_login.name}</span>
            邮 箱: <span>${user_login.email}</span>
            创建日期: <span>${user_login.create_date}</span>
        </fieldset>
    </form>
    </div>

    <div id="conmment">
        <table border="1" cellspacing="2" bgcolor="#ADD8E6" >
            <tr align="center">
                <td width="100">用户ID</td>
                <td width="160">评论内容</td>
                <td width="200">创建时间</td>
                <td width="200">更新时间</td>
                <td width="100">操作</td>
            </tr>
            <c:forEach items="${userComment}" var="comment">
                <tr align="center">
                    <td>${comment.user_id}</td>
                    <td>${comment.content}</td>
                    <td>${comment.create_time}</td>
                    <td>${comment.update_time}</td>
                    <td><a href="UserCommentSearchServlet?comment_id=${comment.comment_id}&action=user">编辑</a>&nbsp;&nbsp;&nbsp;
                        <a href="DeleteCommentServlet?comment_id=${comment.comment_id}&action=user">删除</a>
                </tr>
            </c:forEach>

        </table>
    </div>



</div>
</body>