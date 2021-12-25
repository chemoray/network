<%--
  Created by IntelliJ IDEA.
  User: chemoray
  Date: 2021/12/25
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新闻评论</title>
</head>
<body background="img/skin_/beijing.jpg">
<h3 align="center">新闻评论</h3>

<form action="#" method="post" >
    <table border="1" cellspacing="2" bgcolor="#ADD8E6" >
        <tr align="center">
            <td width="40"> </td>
            <td width="100">新闻ID</td>
            <td width="100">分类ID</td>
            <td width="160">新闻标题</td>
            <td width="300">新闻内容</td>
            <td width="100">新闻状态</td>
            <td width="200">创建时间</td>
            <td width="200">更新时间</td>
            <td width="100">操作</td>
        </tr>
        <c:forEach items="${publishauthornews}" var="news">
            <tr align="center">
                <td><input type="checkbox" value="${news.getId()}"
                           name="newsid"/></td>
                <td>${news.getId()}</td>
                <td>${news.getCategory_id()}</td>
                <td>${news.getTitle()}</td>
                <td>${news.getContent()}</td>
                <td>${news.getState()}</td>
                <td>${news.getCreate_date()}</td>
                <td>${news.getUpdate_date()}</td>
                <td><a href="deletecommenttable.jsp?newsid=${news.getId()}">评论</a>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>