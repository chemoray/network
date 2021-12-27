<%@ page import="com.news.pojo.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.news.pojo.AdminUser" %>
<%@ page import="com.news.dao.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css">.security-right-title[data-v-d88496a2]{height:50px;padding-left:30px;border-bottom:1px solid #ddd}.security-right-title-icon[data-v-d88496a2]{float:left;width:4px;height:16px;margin-top:18px;background-color:#00a1d6;border-radius:4px}.security-right-title-text[data-v-d88496a2]{float:left;margin:15px 0 0 5px;color:#00a1d6;font-size:14px;cursor:default}.secuirty-rught-title-sub[data-v-d88496a2]{float:left;font-size:12px;line-height:50px;margin-left:10px;color:#878787}</style>
    <style type="text/css">.user-setting-warp .padding-dom{width:789px;height:39px;border-bottom:1px solid #e5e9ef;margin-bottom:40px}.el-form-item__content{line-height:30px}.user-local,.user-my-aim,.user-my-btn,.user-my-date,.user-my-love,.user-my-school,.user-my-sex,.user-my-sign,.user-nick-name,.user-nick-rel-name{float:left;width:789px}.user-setting-warp{padding:20px 20px 0;position:relative}.el-form-item__label{width:95px;text-align:right;margin-right:20px;float:left;line-height:30px;padding:0}.user-nick-name .el-input,.user-nick-name .el-input__inner{float:left;width:225px;height:30px;margin-right:40px}.nick-name-not{color:#aaa}.user-my-sign .el-textarea,.user-my-sign .el-textarea .el-textarea__inner{float:left;width:618px;height:88px;resize:none}.user-my-sex .el-radio-button__inner{margin-right:20px;padding:5px 8px;border:1px solid #bfcbd9;border-radius:5px!important;background:#f4f4f4;color:#717171}.user-my-date .el-input__inner{height:30px;color:#b7b7b7}.user-local .el-select{margin-right:30px}.el-select-dropdown{width:210px!important}.user-local .el-input__inner,.user-love .el-input__inner,.user-my-aim .el-input__inner,.user-my-love .el-input__inner{color:#99a2aa}.user-my-btn-warp{float:left;width:789px;height:36px;position:relative}.user-my-btn .el-button--primary{width:110px;position:absolute;top:50%;left:50%;-webkit-transform:translate(-50%,-50%);transform:translate(-50%,-50%);background:#00a1d6!important}.user-my-btn .el-button--primary:hover{background-color:#00b5e5!important}.setting-no-data{width:800px;height:500px;position:relative}.loading-icon{width:100px;height:100px;position:absolute;top:50%;left:50%;-webkit-transform:translate(-50%,-50%);transform:translate(-50%,-50%);background:url(https://s1.hdslb.com/bfs/static/account-fe/static/img/loadTV.99606e2.gif) no-repeat;background-size:100% 100%}.userinfo-descript{font-size:14px;color:#898989}.user-setting-warp .el-radio-button__orig-radio:checked+.el-radio-button__inner{background-color:#22a1d6!important;border-color:#22a1d6!important}</style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>工大新闻</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="viewport"
          content="width=device-width, initial-scale=1,maximum-scale=1">
    <link href="./home_files/app.26dd445c5a4992587eb35774ac43f575.css" rel="stylesheet">
    <link href="./home_files/main-2ada0a57df.css" rel="stylesheet">
</head>
<body></body>
<div class="security_content">
    <div class="security-right">
        <div data-v-d88496a2="" class="security-right-title">
            <span data-v-d88496a2="" class="security-right-title-icon">

            </span>
            <span data-v-d88496a2="" class="security-right-title-text">我的信息</span>
            <!---->
        </div>
        <div class="user-setting-warp">
            <div>
                <form class="el-form clearfix" mode="[object Object]">
                    <div class="el-form-item user-nick-name">
                        <label class="el-form-item__label">昵称:</label>
                        <div class="el-form-item__content">
                            <div class="el-input">
                                <!---->
                                <!---->
                                <span class="userinfo-descript">${author_login_info.username}</span>
                                <!---->
                                <!---->
                            </div>
                            <!---->
                        </div>
                    </div>
                    <div class="el-form-item user-nick-rel-name">
                        <label class="el-form-item__label">作者ID:</label>
                        <div class="el-form-item__content">
                            <span class="userinfo-descript">${author_login_info.id}</span>
                            <!---->
                        </div>
                    </div>
                    <div class="el-form-item user-nick-rel-name">
                        <label class="el-form-item__label">邮 箱:</label>
                        <div class="el-form-item__content">
                            <span class="userinfo-descript">${author_login_info.email}</span>
                            <!---->
                        </div>
                    </div>
                    <div class="el-form-item user-nick-rel-name">
                        <label class="el-form-item__label">号 码:</label>
                        <div class="el-form-item__content">
                            <span class="userinfo-descript">${author_login_info.phone}</span>
                            <!---->
                        </div>
                    </div>
                    <div class="el-form-item user-nick-rel-name">
                        <label class="el-form-item__label">发布新闻数:</label>
                        <div class="el-form-item__content">
                            <span class="userinfo-descript">${author_login_info.newsnumber}</span>
                            <!---->
                        </div>
                    </div>
                    <div class="el-form-item user-my-date">
                        <label class="el-form-item__label">创建日期:</label>
                        <div class="el-form-item__content">
                            <div class="el-date-editor el-input el-date-editor--date" id="el-date-pick">
                                <!---->
                                创建日期: <span class="userinfo-descript">${author_login_info.create_date}</span>
                                <!---->
                                <!---->
                            </div><!---->
                        </div>
                    </div>
                    <div class="el-form-item user-my-btn">
                        <!---->
                        <div class="el-form-item__content">
                            <div class="padding-dom">
                                <div class="user-my-btn-warp">
                                    <!----><!---->
                                    <a href="updateauthorinfo.jsp" align="center">编辑个人信息</a>

                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

