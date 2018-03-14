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
    <title>用户登录</title>
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
                        <h4 class="title-center">个性化电影推荐系统</h4>
                    </div>
                </div>

                <div class="row clearfix">
                    <div class="col-md-12 column">

                        <form id="user-login" class="form-horizontal" role="form">

                            <div class="form-group">

                                <input type="email" id="userEmail" name="userEmail" class="form-control" placeholder="邮箱" required="required" />

                            </div>

                            <div class="form-group">

                                <input type="password" id="userPasswd" name="userPasswd" class="form-control" placeholder="密码" required="required"/>

                            </div>

                            <div class="form-group">

	                            <button id="login" type="button" class="btn btn-info btn-block" disabled="true">登&nbsp;&nbsp;&nbsp;录</button>

	                        </div>
                            
                        </form>

                        
                    </div>
                </div>

                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <span class="title-center"><a href="<%=web_domain %>/register">没有账号？立即注册</a></span>
                    </div>
                </div>


            </div>


        </div>


    </div>
</div>

<script type="text/javascript" src="<%=file_domain %>/framework/jquery/jquery-3.1.1.js"></script>
<script type="text/javascript" src="../../static/js/jquery.serializejson.js"></script>
<script type="text/javascript" src="../../static/js/login.js"></script>
</body>
</html>