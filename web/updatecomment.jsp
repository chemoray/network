<%--
  Created by IntelliJ IDEA.
  User: chemoray
  Date: 2021/12/25
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>评论编辑页面</title>
</head>
<body background="img/skin_/beijing.jpg">
<form action="UpdateCommentServlet" method="post">
    <h3 align="center">评论编辑页面</h3>
    <table align="center">

        <tr>
            <td><p style="line-height: 13px">评论内容:</p></td>
            <td><textarea style="width: 400px; height: 200px;"
                          name="content" >${commentDetail.content}</textarea></td>
        </tr>
        <%-- <tr>
            <td><p style="line-height: 13px">发布时间:</p></td>
            <td><input type="text" name="date"
                value="${Newsdetail.create_date}"></td>
        </tr> --%>
        <tr>
            <td><p style="line-height: 13px">
                <input type="hidden" name="comment_id" value="${commentDetail.comment_id}">
                <input type="submit" value="提交">
            </p></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>