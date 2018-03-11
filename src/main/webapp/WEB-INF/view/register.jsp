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
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="<%=web_domain %>/static/framework/bootstrap-3.3.7/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="<%=web_domain %>/static/css/login.css">
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
                        <form class="form-horizontal" role="form">

                            <div class="form-group">

                                <div class="">
                                    <input type="email" class="form-control" id="inputEmail" placeholder="邮箱"/>
                                </div>

                            </div>

                            <div class="form-group">

                                <div class="">
                                    <input type="password" class="form-control" id="inputPasswd" placeholder="密码"/>
                                </div>

                            </div>

                            <div class="form-group">

                                <div class="">
                                    <input type="password" class="form-control" id="confirmPasswd" placeholder="确认密码"/>
                                </div>

                            </div>


                        </form>

                        <div class="form-group">
                            <div class="">
                                <button type="submit" class="btn btn-info btn-block">注&nbsp;&nbsp;&nbsp;册</button>
                            </div>
                        </div>
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