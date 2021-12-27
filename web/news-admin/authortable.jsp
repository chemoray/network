<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr bgcolor="#ededed">
			<td width="40" style="text-align: center;"><input type="checkbox"/></td>
			<td width="40" style="text-align: center;">作者ID</td>
			<td width="120" style="text-align: center;">用户名</td>
			<td width="120" style="text-align: center;">邮 箱</td>
			<td width="120" style="text-align: center;">电 话</td>
			<td width="40" style="text-align: center;">新闻数</td>
			<td width="120" style="text-align: center;">创建日期</td>
			<td width="50" style="text-align: center;">操作</td>
		</tr>
		<c:forEach items="${authors}" var="author">
			<tr>
				<td style="text-align: center;"><input type="checkbox" value="${author.getId()}" name="authorid"/></td>
				<td style="text-align: center;">${author.getId()}</td>
				<td style="text-align: center;">${author.getUsername()}</td>
				<td style="text-align: center;">${author.getEmail()}</td>
				<td style="text-align: center;">${author.getPhone()}</td>
				<td style="text-align: center;">${author.getNewsnumber()}</td>
				<td style="text-align: center;">${author.getCreate_date()}</td>
				<td style="text-align: center;"><a href="../ShowUpdateAdminServlet?authorid=${author.getId()}">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>