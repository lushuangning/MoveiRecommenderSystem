$(document).ready(function(){

    $(function () {
        var oTable = new TableInit();
        oTable.Init();
    });

    var TableInit = function () {
        var oTableInit = new Object();
        oTableInit.Init = function () {
            $('#recommend').bootstrapTable({
                url: 'http://localhost:8080/recommend/show',
                toolbar: '#toolbar',    //工具按钮用哪个容器
                method:"POST",
                cache: false,   //是否启用缓存
                undefinedText : '-',
                dataType: "json",
                striped: true,
                pagination: true,   //是否显示分页（*）
                sidePagination: "client",   //分页方式,可选client和server
                showRefresh: true,
                search: true, //表格内搜索
                onLoadSuccess : function(data) {
                    alert('加载成功了！' + data);//这边是有数据的
                },
                onLoadError : function(status) {
                    alert('出错了！出错原因：' + status);
                },
                columns: [{
                    field: 'title',
                    title: '电影名'
                }, {
                    field: 'genres',
                    title: '电影类型'
                }]
            });
        };

        return oTableInit;
    };


});