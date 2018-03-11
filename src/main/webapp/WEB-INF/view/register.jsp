<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String web_domain = request.getScheme()+"://"+request.getServerName() + ":" + request.getServerPort();
    String file_domain = "http://shuangfile.site";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="<%=web_domain %>/static/framework/bootstrap-3.3.7/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="<%=web_domain %>/static/css/login.css">
    <link rel="icon" href="<%=web_domain %>/static/img/easyicon.ico" type="image/x-ico" />
</head>
<body>
<div class="login-main">

    <div class="container">
        <div class="row clearfix">


            <div class="col-md-8 column">

            </div>

            <div class="col-md-4 column jumbotron">

                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h4 class="title-center">欢迎注册</h4>
                    </div>
                </div>

                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <form id="user-register" class="form-horizontal" role="form">

                            <div class="form-group">

                                <div class="">
                                    <input type="email" class="form-control" id="userEmail" placeholder="邮箱"/>
                                </div>

                            </div>

                            <div class="form-group">

                                <div class="">
                                    <input type="text" class="form-control" id="userName" placeholder="昵称"/>
                                </div>

                            </div>

                            <div class="form-group">

                                <div class="">
                                    <input type="password" class="form-control" id="userPasswd" placeholder="密码"/>
                                </div>

                            </div>

                            <div class="form-group">

                                <div class="">
                                    <input type="password" class="form-control" id="confirmPasswd" placeholder="确认密码"/>
                                </div>

                            </div>

                            <div class="form-group">
                                <div class="row clearfix">
                                    <div class="col-md-4 column">

                                        <label class="title-center"><input type="radio" checked="checked" name="role"/>管理员</label>
                                    </div>

                                    <div class="col-md-4 column">
                                        <label class="title-center"><input type="radio" name="role"/>普通用户</label>
                                    </div>

                                    <div class="col-md-4 column">
                                        <label class="title-center"><input type="radio" name="role"/>新用户</label>
                                    </div>

                                </div>
                            </div>

                            <div class="form-group">
                                <div class="">
                                    <button type="button" class="btn btn-info btn-block">注&nbsp;&nbsp;&nbsp;册</button>
                                </div>
                            </div>

                        </form>

                        
                    </div>
                </div>

                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <span class="title-center"><a href="<%=web_domain %>">已有账号？返回登录</a></span>
                    </div>
                </div>


            </div>


        </div>


    </div>
</div>

</div>
</body>
</html>