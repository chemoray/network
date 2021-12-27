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
			<input type="hidden" name="id" value="${updateauthor.id }"><br/>
			<input type="hidden" name="newsnumber" value="${updateauthor.newsnumber}"><br/>
			用户名：<input type="text" name="username" value="${updateauthor.username }"><br/>
			密码：<input type="password" name="password" value="${updateauthor.password }"><br/>
			邮箱：<input type="email" name="email" value="${updateauthor.email }"><br/>
			电话：<input type="phone" name="phone" value="${updateauthor.phone }"><br/>
			<input type="submit" value="提交修改">
		</form>
	</center>
</body>
</html>