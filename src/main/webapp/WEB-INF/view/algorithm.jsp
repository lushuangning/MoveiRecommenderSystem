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
    <link rel="stylesheet" href="../../static/framework/bootstrap-3.3.7/css/bootstrap.min.css" />
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
                            <ul class="tm-nav uk-nav" data-uk-nav>
                                <li class="uk-nav-header">功能选择</li>
                                <li><a href="index">首页</a></li>
                                <li><a href="algorithm">推荐设置</a></li>
                                <li><a href="showRecommendation">结果展示</a></li>
                                <li><a href="upload">上传文件</a></li>
                                <li><a href="http://localhost:8088/cluster">任务进度监控</a></li>
                                <li><a href="http://localhost:50070/explorer.html#/">HDFS文件管理</a></li>
                            </ul>
                        </ul>

                    </div>

                    <div class="tm-main uk-width-medium-3-4">
                        <div class="uk-badge uk-badge-success">进行推荐设置</div>
                        <form class="uk-form uk-form-horizontal">

                            <div class="uk-form-row">

                                <label class="uk-form-label">最近邻个数</label>
                                <div class="uk-form-icon">
                                    <i class="uk-icon-calendar"></i>
                                    <input id="nearestNeighbor" type="number" placeholder="最近邻个数" class="uk-form-width-medium" min="10" max="100" />
                                </div>

                            </div>

                            <div class="uk-form-row">

                                <label class="uk-form-label">推荐数量</label>
                                <div class="uk-form-icon">
                                    <i class="uk-icon-child"></i>
                                    <input id="recommendNum" type="number" placeholder="推荐数量，默认是10" class="uk-form-width-medium" min="1" max="20" />
                                </div>

                            </div>


                            <div class="uk-form-row">

                                <label class="uk-form-label">推荐算法选择</label>
                                <div class="uk-form-icon">
                                    <select name="" id="whichCF" class="uk-form-width-medium">
                                        <option value="ItemCF" selected="selected">Item Based</option>
                                        <option value="UserCF">User Based</option>
                                    </select>
                                </div>

                            </div>

                            <div class="uk-form-row">

                                <label class="uk-form-label">相似度计算函数</label>
                                <div class="uk-form-icon">
                                    <select name="" id="similarityClassname" class="uk-form-width-medium">
                                        <option value="SIMILARITY_EUCLIDEAN_DISTANCE" selected="selected">欧式距离</option>
                                        <option value="SIMILARITY_COSINE">余弦相似度</option>
                                        <option value="SIMILARITY_PEARSON_CORRELATION">皮尔逊相似度</option>
                                        <option value="SIMILARITY_PEARSON_CORRELATION_WEIGHT">加权皮尔逊</option>
                                    </select>
                                </div>

                            </div>

                            <div class="uk-form-row">

                                <button type="button" class="uk-button uk-width-1-4">取消</button>
                                <button type="button" id="confirm" class="uk-button uk-width-1-4 uk-button-primary">确认</button>

                            </div>

                        </form>


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

    <script type="text/javascript" src="../../static/framework/bootstrap-3.3.7/js/bootstrap.js"></script>
    <script type="text/javascript" src="../../static/js/algorithm.js"></script>

</body>
</html>
