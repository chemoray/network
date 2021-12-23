<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册</title>
    <script>
        function Checkfunc()
        // 给注册绑定单击事件
        {
            //验证用户名：必须不为空
            var username = document.getElementById('username').value;
            // 验证密码：必须由字母，数字组成，并且长度为5到12位
            //1 获取用户名输入框里的内容
            var passwordText = document.getElementById('password').value;
            //2 创建正则表达式对象
            var passwordPatt = /^[a-zA-Z\d_]{5,12}$/;
            //3 使用test方法验证
            if (!passwordPatt.test(passwordText)) {
                //4 提示用户结果
                alert("密码不合法，必须由字母，数字组成，长度为5到12位");
                return false;
            }
            // 验证确认密码：和密码相同
            //1 获取确认密码内容
            var repwdText = document.getElementById('repassword').value;
            //2 和密码相比较
            if (repwdText != passwordText) {
                //3 提示用户
                alert("密码不一致");
                return false;
            }
            //验证邮箱号：
            var emailText = document.getElementById('email').value;
            var emailPatt = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
            if (!emailPatt.test(emailText)) {
                //4 提示用户结果
                alert("邮箱不正确");
                return false;
            }

            //验证手机号：只能由数字组成长度为11位
            var phoneText = document.getElementById('phone').value;
            var phonePatt = /^1[34578]\d{9}$/;
            if (!phonePatt.test(phoneText)) {
                //4 提示用户结果
                alert("手机号不正确，输入十一位手机号");
                return false;
            }
        }
    </script>

    <style>
        body, div, h1, form, fieldset, input, textarea {
            margin: 0;
            padding: 0;
            border: 0;
            outline: none;
        }
        html {
            height: 100%;
        }
        body {
            font-family: 宋体;
            margin-bottom:20px;
            padding-bottom:40px;
            background-image: url("./home_files/userloginbg.jpg");
        }
        #container {
            width: 430px;
            margin: 30px auto;
            padding: 60px 30px;
            background: #ffffff;
            border: 1px solid #e1e1e1;
        }
        h1 {
            font-size: 35px;
            color: #445668;
            text-align: center;
            margin: 0 0 35px 0;
            text-shadow: 0px 2px 0px #f2f2f2;
        }
        label {
            float: left;
            clear: left;
            margin: 11px 20px 0 0;
            width: 95px;
            text-align: right;
            font-size: 18px;
            font-family:宋体;
            color: #000E00;
            text-shadow: 0px 1px 0px #f2f2f2;
        }
        input {
            width: 210px;
            height: 35px;
            padding: 5px 20px 0px 20px;
            margin: 0 0 20px 0;
            background: #B0E0E6;
            border-radius: 5px;
            font-family: 宋体, sans-serif;
            font-size: 16px;
            color: #000000;
            text-shadow: 0px -1px 0px #ffffff;
        }
        textarea {
            width: 210px;
            height: 170px;
            padding: 12px 20px 0px 20px;
            margin: 0 0 20px 0;
            background: #5E768D;
            font-family: 宋体, sans-serif;
            font-size: 16px;
            color: #000E00;
            text-shadow: 0px -1px 0px #000E00;
        }
        textarea {
            color: #AFEEEE;
            text-shadow: 0px -1px 0px #38506b;
        }
        input:focus, textarea:focus {
            background: #FFFAFA;
        }
        p {
            margin-left:140px;
        }
        input[type=submit],input[type=reset]{
            width: 105px;
            height: 42px;
            border: 1px solid #000E00;
            cursor: pointer;
            color:#000E00;
        }
    </style>




</head>

<body>
<div id="container">
    <h1>用户注册</h1>
    <form id="user" action="AuthorRegistServlet" method="post">
        <fieldset>
            <label for="name">用户名:</label>
            <input type="text" id="username" placeholder="请输入您的用户名" name="username"/>
            <label for="email">Email:</label>
            <input type="email" id="email" placeholder="Enter your email address" name="email"/>
            <label for="email">Phone:</label>
            <input type="text" id="phone" placeholder="Enter your phone number" name="phone"/>
            <label for="password">密 码:</label>
            <input type="password" id="password" placeholder="输入密码" name="password"/>
            <label for="password">确认密码:</label>
            <input type="password" id="repassword" placeholder="确认密码" name="repassword"/>
            <label for="date">注册时间:</label>
            <input type="date" id="date" name="date" />
            <p>
                <input type="reset" value="重 置" />
                <input type="submit" value="注 册" onclick="return Checkfunc()"/>
            </p>
        </fieldset>
    </form>


</div>
</body>
</html>


