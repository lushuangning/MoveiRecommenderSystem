<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String web_domain = request.getScheme()+"://" + request.getServerName() + ":8080";
	String file_domain = "http://shuangfile.site";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>电影推荐系统</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

		<link rel="stylesheet" type="text/css" href="<%=web_domain %>/static/css/public/bootstrap-3.3.7/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="<%=web_domain %>/static/css/public/font-awesome-4.7.0/css/font-awesome.min.css">
    	<link rel="stylesheet" type="text/css" href="<%=web_domain %>/static/css/public/styles.css">
    	<link rel="stylesheet" type="text/css" href="<%=web_domain %>/static/components/fileinput.css">
    	<link rel="icon" href="<%=web_domain %>/static/img/easyicon.ico" type="image/x-ico" />
	</head>
	<body>
		<div class="wrapper">
		    <div class="box">
		        <div class="row row-offcanvas row-offcanvas-left">
		            <%@ include file="/static/html/sidebar.html" %>
		          
		            <%@ include file="/static/html/upload-file.html" %>
		        </div>
		    </div>
		</div>

		<script type="text/javascript" src="<%=file_domain %>/framework/jquery/jquery-3.1.1.js"></script>
		<script type="text/javascript" src="<%=web_domain %>/static/components/fileinput.js"></script>
		<script type="text/javascript" src="<%=web_domain %>/static/components/fileinput-zh.js"></script>
		<script type="text/javascript" src="<%=web_domain %>/static/js/upload-page.js"></script>
	</body>
</html>