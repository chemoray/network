<%@ page import="com.news.pojo.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>新闻详情</title>
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
  <script>
    //定义敏感字符
    var forbiddenArray =['草','日','黄色'];
    //定义函数
    function Checkfunc(){
      //验证是否登录
     if (${user_login == null}){
       alert("请登陆后评论！")
       return false;
     }
    //获取文本输入框中的内容

      var value = document.getElementById("comment_content").value;

      var re = '';

      for(var i=0;i<forbiddenArray.length;i++){
        if(i==forbiddenArray.length-1)
          re+=forbiddenArray[i];
        else
          re+=forbiddenArray[i]+"|";
      }
      //定义正则表示式对象
      //利用RegExp可以动态生成正则表示式
      var pattern = new RegExp(re,"g");
      if(pattern.test(value)){
        alert("含敏感词汇！");
        return false;
      }else{
        return true;
      }
    }
  </script>

</head>
<body class="news-index">
<div class="logo-search area">
  <div class="logo left">
    <a href="#">新闻首页</a>
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
        <a href="userhome.jsp?user_id=${user_login.id}">欢迎:${user_login.name}</a>
        <button class="button"><a href="home.jsp">退出登录</a></button>
      </c:when>
      <c:when test="${author_login_info != null}">
        <a href="news-author/authormain.html">欢迎/作者：${author_login_info.username}</a>
        <button class="button"><a href="home.jsp">退出登录</a></button>
      </c:when>
      <c:when test="${login_info != null}">
        <a href="news-admin/main.html">欢迎/管理员：${login_info.username}</a>
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

<!-- end: Header -->

<div id="content">
  <div class="form-element">
    <div class="col-md-12 padding-0">
      <div class="col-md-12">
        <div class="panel form-element-padding">
          <div class="panel-heading" style="text-align: center;">
            <h3>${Newsdetail.title}</h3>
            <p>种类：${Newsdetail.category_id}&nbsp;&nbsp;&nbsp;&nbsp;作者:${Newsdetail.authorId}&nbsp;&nbsp;&nbsp;&nbsp;发表日期：${Newsdetail.create_date}</p>
          </div>
          <div class="panel-body" style="padding-bottom:30px;">
            <div class="panel-body-main">
              ${Newsdetail.content}
            </div>
            <hr>
          </div>
          <div class="panel-body" style="padding-bottom:30px;">
            <div class="panel-body-main">
              <form id="user" action="AddCommentServlet" method="post">
                <input type="hidden" value="${Newsdetail.id}" name="news_id">
                <input type="hidden" value="${user_login.id}" name="user_id">
                <input type="text" id="comment_content" placeholder="期待您的评论" name="comment_content"/>
                <label for="comment_content"></label>
                <input type="submit" value="提交" onclick="return Checkfunc()"/>
              </form>
            </div>
            <hr>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- end: content -->
<div id="conmment">
    <table border="1" cellspacing="2" bgcolor="#ADD8E6" >
      <tr align="center">
        <td width="100">用户ID</td>
        <td width="160">评论内容</td>
        <td width="200">创建时间</td>
        <td width="200">更新时间</td>
      </tr>
      <c:forEach items="${newsComment}" var="comment">
        <tr align="center">
          <td>${comment.user_id}</td>
          <td>${comment.content}</td>
          <td>${comment.create_time}</td>
          <td>${comment.update_time}</td>
        </tr>
      </c:forEach>

    </table>
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
<div id="float-btn" class="float-links">
  <ul data-spm="user-feedback">

    <li class="back-sohu prize-survey" data-role="on_back"><a
            href="#" ><em>返回<br>首页
    </em></a></li>

    <li class="user-feedback"><a
            href="#"
            data-spm-acode="8072"><em>用户<br>反馈
    </em></a></li>

    <li class="back-top" data-role="go_top"><a
            href="javascript:void(0)" style="display: none;"><i class="icon"></i></a></li>
  </ul>
</div>
</body>
</html>