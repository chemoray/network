<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新闻发布</title>
</head>
<hr size="3" color="#87CEFA " >
<body background="img/skin_/beijing.jpg">
	<form action="../AddNewsServlet" method="post">
		<h3 align="center">新闻发布页面</h3>
		<table align="center" >
			<tr>
				<td>作者ID:</td>
				<td><input type="radio" name="authorid" value="${author_login_info.id}">${author_login_info.username}</td>
			</tr>
			<tr>
				<td>新闻类别:</td>
				<td><input type="radio" name="category" value="时政">时政
				<input type="radio" name="category" value="国际">国际
				<input type="radio" name="category" value="军事">军事
				<input type="radio" name="category" value="公益">公益
				<input type="radio" name="category" value="汽车">汽车</td>
			</tr>
			<tr> 
			<td></td>
			 <td>
				<input type="radio" name="category" value="房产">房产
				<input type="radio" name="category" value="教育">教育
				<input type="radio" name="category" value="时尚">时尚
				<input type="radio" name="category" value="科技">科技
				<input type="radio" name="category" value="娱乐">娱乐</td>
			</tr>	
				
				
			<tr>
				<td><p style="line-height: 13px">新闻标题:</p></td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td><p style="line-height: 13px">新闻内容:</p></td>
				<td><textarea style="width: 400px; height: 200px;" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td><p style="line-height: 13px">发布时间:</p></td>
				<td><input type="date" name="date"></td>
			</tr>
			
<!-- 			<tr>
				<td><p style="line-height: 13px">更新时间:</p></td>
				<td><input type="text"></td>
			</tr> -->
			
			<tr>
				<td><p style="line-height: 13px">
						<input type="submit" value="提交"></p></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
	<hr size="3" color="#87CEFA " noshade>
</body>
</html>