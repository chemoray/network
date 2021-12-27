<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<center>
    <form action="UserUpdateServlet" method="post">
        <input type="hidden" name="action" value="user"><br/>
        <input type="hidden" name="userid" value="${user_login.id}"><br/>
        用户名：<input type="text" name="username" value="${user_login.name }"><br/>
        密码：<input type="password" name="password" value="${user_login.password }"><br/>
        邮箱：<input type="text" name="email" value="${user_login.email}"><br/>
        <input type="submit" value="提交修改"/>
    </form>
</center>
</body>
</html>