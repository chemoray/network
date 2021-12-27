<%--
  Created by IntelliJ IDEA.
  User: chemoray
  Date: 2021/12/27
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<center>
    <form action="../UpdateAuthorServlet" method="post">
        <input type="hidden" name="id" value="${author_login_info.id }"><br/>
        <input type="hidden" name="action" value="author"><br/>
        <input type="hidden" name="newsnumber" value="${author_login_info.newsnumber}"><br/>
        用户名：<input type="text" name="username" value="${author_login_info.username }"><br/>
        密码：<input type="password" name="password" value="${author_login_info.password }"><br/>
        邮箱：<input type="email" name="email" value="${author_login_info.email }"><br/>
        电话：<input type="phone" name="phone" value="${author_login_info.phone }"><br/>
        <input type="submit" value="提交修改">
    </form>
</center>
</body>
</html>