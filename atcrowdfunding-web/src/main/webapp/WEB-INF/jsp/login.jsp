<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("PATH",request.getContextPath());
    /*
     * request.getContextPath()以/开头，不已/结束
     * */
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <form class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 用户登录</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="userAccount" name="userAccount" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="password" name="password" placeholder="请输入登录密码" style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <select class="form-control" >
                <option value="member">会员</option>
                <option value="user">管理</option>
            </select>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
            <br>
            <label>
                忘记密码
            </label>
            <label style="float:right">
                <a href="reg.html">我要注册</a>
            </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()" > 登录</a>
    </form>
</div>
<script src="jquery/jquery-2.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="layer/layer.js"></script>
<script>
    $(function () {
       //如果顶层窗口不是当前窗口
        if(window.top!=window){
            //将顶层窗口设置为当前窗口
            window.top.location=window.location;
        }
        $(window).keydown(function (e) {
            var userAccount=$("#userAccount").val();
            var password=$("#password").val();

            if(userAccount == ""){
                layer.msg("账号不能为空，请输入", {time:2000, icon:5, shift:6}, function () {

                });
                return;
            }
            if(password == ""){
                layer.msg("密码不能为空，请输入", {time:2000, icon:5, shift:6}, function () {

                });
                return;
            }
            if(e.keyCode==13){
                login(userAccount,password);
            }
        })
    })
    function dologin() {
       var userAccount=$("#userAccount").val();
       var password=$("#password").val();

       if(userAccount == ""){
           layer.msg("账号不能为空，请输入", {time:2000, icon:5, shift:6}, function () {
               
           });
           return;
       }  
       if(password == ""){
           layer.msg("密码不能为空，请输入", {time:2000, icon:5, shift:6}, function () {
               
           });
           return;
       }

       login(userAccount,password)


    }

    function login(userAccount,password) {
        var loadingIndex =null;
        $.ajax({
            url:"doLogin",
            data:{
                "userAccount":userAccount,
                "password":password
            },
            type:"POST",
            dataType:"json",
            beforeSend:function () {
                loadingIndex = layer.msg('处理中', {icon: 16});

            },
            success:function (data) {
                layer.close(loadingIndex);
                if(data.success){
                    window.location.href="main";
                }else {
                    layer.msg("账号或者密码错误", {time:2000, icon:5, shift:6}, function () {

                    });
                }

            }
        })
    }
</script>
</body>
</html>
