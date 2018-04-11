<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    String web_domain = request.getScheme()+"://"+request.getServerName() + ":" + request.getServerPort();
    String file_domain = "http://shuangfile.site";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>个性化电影推荐</title>
    <link rel="stylesheet" href="../../static/framework/uikit-2.25.0/css/uikit.min.css" />
    <link rel="stylesheet" href="../../static/framework/uikit-2.25.0/css/docs.css">
    <link rel="icon" href="<%=web_domain %>/static/img/easyicon.ico" type="image/x-ico" />
    <script type="text/javascript" src="<%=file_domain %>/framework/jquery/jquery-3.1.1.js"></script>
    <script src="../../static/framework/uikit-2.25.0/js/uikit.min.js"></script>
</head>
<body>
<div class="tm-background">

    <nav class="tm-navbar uk-navbar uk-navbar-attached">
        <div class="uk-container uk-container-center">

            <h2 class="uk-h2">个性化电影推荐系统</h2>

        </div>
    </nav>

    <div class="tm-middle">
        <div class="uk-container uk-container-center">

            <div class="uk-grid" data-uk-grid-margin>

                <div class="tm-sidebar uk-width-medium-1-4 uk-hidden-small">
                    <ul class="tm-nav uk-nav" data-uk-nav>
                        <li class="uk-nav-header">功能选择</li>
                        <li><a href="index">首页</a></li>
                        <li><a href="algorithm">推荐设置</a></li>
                        <li><a href="showRecommendation">结果展示</a></li>
                        <li><a href="upload">上传文件</a></li>
                        <li><a href="http://localhost:8088/cluster">任务进度监控</a></li>
                        <li><a href="http://localhost:50070/explorer.html#/">HDFS文件管理</a></li>
                    </ul>

                </div>

                <div class="tm-main uk-width-medium-3-4">

                    <div class="uk-grid">
                        <div class="uk-width-medium-1-1">
                            <div class="uk-panel uk-panel-header">
                                <h3 class="uk-panel-title"><i class="uk-icon-home"></i>欢迎页面</h3>
                                电影推荐系统时推荐用户可能感兴趣的推荐系统。用户注册登录后，可以选择三种不同的算法得到推荐信息。
                            </div>
                        </div>
                    </div>

                    <div class="uk-grid">
                        <div class="uk-width-medium-1-3">

                            <div class="uk-thumbnail">
                                <img src="https://image.tmdb.org/t/p/w600_and_h900_bestv2/uMZqKhT4YA6mqo2yczoznv7IDmv.jpg" alt="">
                                <div class="uk-thumbnail-caption"><h4>玩具总动员</h4></div>
                            </div>


                        </div>

                        <div class="uk-width-medium-1-3">

                            <div class="uk-thumbnail">
                                <img src="https://images-na.ssl-images-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SY1000_CR0,0,675,1000_AL_.jpg" alt="">
                                <div class="uk-thumbnail-caption"><h4>蝙蝠侠：黑暗骑士</h4></div>
                            </div>

                        </div>

                        <div class="uk-width-medium-1-3">

                            <div class="uk-thumbnail">
                                <img src="https://image.tmdb.org/t/p/w600_and_h900_bestv2/oV20u3QKMD5ftXdM2X8W1R2c2Ff.jpg" alt="">
                                <div class="uk-thumbnail-caption"><h4>五十度灰</h4></div>
                            </div>

                        </div>

                    </div>



                </div>
            </div>

        </div>
    </div>

    <div class="tm-footer">
        <div class="uk-container uk-container-center uk-text-center">

            <ul class="uk-subnav uk-subnav-line uk-flex-center">
                <li><a href="https://movielens.org/">MovieLens</a></li>
                <li><a href="https://grouplens.org/">GroupLens</a></li>
                <li><a href="http://www.imdb.com/">IMDB</a></li>
                <li><a href="https://www.themoviedb.org/">The Movie DB</a></li>
            </ul>

            <div class="uk-panel">
                <p>Made by <a href="http://baidu.com">YOOtheme</a> with love and caffeine.<br>Licensed under <a href="http://opensource.org/licenses/MIT">MIT license</a>.</p>
            </div>

        </div>
    </div>
</div>


</body>
</html>
