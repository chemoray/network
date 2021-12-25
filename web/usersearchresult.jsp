<!DOCTYPE html>
<html lang="en">
<%@ page import="com.news.pojo.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>搜 索</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="viewport"
          content="width=device-width, initial-scale=1,maximum-scale=1">
    <link href="./home_files/main-2ada0a57df.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="./asset/css/bootstrap.min.css">
    <!-- plugins -->
    <link rel="stylesheet" type="text/css" href="./asset/css/plugins/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="./asset/css/plugins/simple-line-icons.css"/>
    <link rel="stylesheet" type="text/css" href="./asset/css/plugins/animate.min.css"/>
    <link rel="stylesheet" type="text/css" href="./asset/css/plugins/fullcalendar.min.css"/>
    <link href="./asset/css/style.css" rel="stylesheet">
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
        <c:choose>
            <c:when test="${user_login != null}">
                <a href="userhome.html">欢迎:${user_login.name}</a>
                <button class="button"><a href="home.jsp">退出登录</a></button>
            </c:when>

            <c:when test="${author_login_info != null}">
                <a href="admin-author/authormain.html">欢迎/作者：${author_login_info.username}</a>
                <button class="button"><a href="home.jsp">退出登录</a></button>
            </c:when>
            <c:when test="${login_info != null}">
                <a href="admin-admin/main.html">欢迎/管理员：${login_info.username}</a>
                <button class="button"><a href="home.jsp">退出登录</a></button>
            </c:when>
            <c:otherwise>
                <div class="icon-user">
                    <button class="button"><a href="userlogin.html">登陆</a></button>
                    <button class="button"><a href="regist.jsp">注册</a></button>
                    <button class="button"><a href="login.html">管理员</a></button>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

</div>

<div class="news-nav area">
    <ul>
        <li class="index cur"><a href="#"
                                 target="">首页</a></li>
        <c:forEach items="${cateGory_list}" var="catelist">
            <li><a target="_blank" href="CategorySearchServlet?categoryId=${catelist.id}">${catelist.name}</a></li>
        </c:forEach>
    </ul>
</div>

<div class="list16">
    <ul>
        <c:forEach items="${SearchResult}" var="list">
            <li>
                <a title="${list.title}" href="NewsSearchServlet?newsid=${list.id}&action=user">
                        ${list.title}
                </a>
            </li>
        </c:forEach>
    </ul>
</div>


<style>
    .panel-body-main{
        width: 60%;
        height: 100%;
        margin-left: 20%;
        /*background-color: red;*/
    }
</style>

<footer class="footer area">
    <p>
        <a href="#" rel="nofollow">搜狗输入法</a>
        - <a href="#" rel="nofollow">支付中心</a>
        - <a href="#" rel="nofollow">理工招聘</a>
        - <a href="#" rel="nofollow">广告服务</a>
        - <a href="#"
             rel="nofollow">联系方式</a> - <a href="#"
                                          rel="nofollow">About SOHU</a> - <a
            href="#"
            rel="nofollow">公司介绍</a>
    </p>
    <p>
        Copyright © 2018 Sohu All Rights Reserved. 理工公司 <a
            href="#"
            rel="nofollow">版权所有</a>
    </p>
    <p>
        理工不良信息举报邮箱：<a href="mailto:logic_c@163.com">logic_c@163.com</a>
    </p>
</footer>
</body>
</html>