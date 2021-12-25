<%--
  Created by IntelliJ IDEA.
  User: chemoray
  Date: 2021/12/25
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>评论删除</title>
</head>
<body background="img/skin_/beijing.jpg">
<h3 align="center">评论删除</h3>

<form action="#" method="post" >
    <table border="1" cellspacing="2" bgcolor="#ADD8E6" >
        <tr align="center">
            <td width="100">用户ID</td>
            <td width="160">评论内容</td>
            <td width="200">创建时间</td>
            <td width="200">更新时间</td>
            <td width="100">操作</td>
        </tr>
        <c:forEach items="${newsComment}" var="comment">
            <tr align="center">
                <td>${comment.user_id}</td>
                <td>${comment.content}</td>
                <td>${comment.create_time}</td>
                <td>${comment.update_time}</td>
                <td><a href="../DeleteCommentServlet?comment_id=${comment.comment_id}&action=author&news_id=${comment.news_id}">删除</a>
            </tr>
        </c:forEach>

    </table>

    </table>
</form>
</body>
</html>
