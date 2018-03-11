<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    String web_domain = request.getScheme()+"://"+request.getServerName() + ":" + request.getServerPort();
    String file_domain = "http://shuangfile.site";
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="<%=web_domain %>/static/css/error.css">

    <title>404</title>
</head>
<body>
<div id="errorpage">
    <div class="tfans_error">
        <div class="logo"></div>
        <div class="errortans clearfix">
            <div class="e404"></div>
            <p><b>出错啦！</b></p>
            <p>您访问的页面不存在</p>
            <div class="bt" ><a href="<%=web_domain %>:8080">返回首页</a></div>
        </div>
    </div>
</div>
</body>
</html>