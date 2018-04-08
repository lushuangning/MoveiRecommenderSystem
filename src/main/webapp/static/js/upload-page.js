$(document).ready(function(){

	$(function(){
		$("#input-id").fileinput({
			language: 'zh',
			allowedFileExtensions: ['csv','txt'],
            uploadAsync: true, //默认异步上传
            showUpload: true, //是否显示上传按钮
            showRemove : true, //显示移除按钮
            showPreview : true, //是否显示预览
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
			uploadUrl: 'http://localhost:8080/file/dataFile',
            enctype: 'multipart/form-data',
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
            maxFileCount : 3,
            validateInitialCount:true,
		}).on("fileuploaded",function(event,data,previewId,index){
		    //打印文件上传信息
            alert('上传成功，HDFS路径为' + data.response.srcHdfs);
            console.log(data.response);
			var result = data.response; //后台返回的json
		});
	});



    $("#confirm").click(function(){
        var formData = new Object;

        formData.ratings = $('#ratings').val();
        formData.movies = $('#movies').val();
        formData.links = $('#links').val();

        var jsonData = JSON.stringify(formData);
        console.log(jsonData);
        $.ajax({
            type : 'POST',
            url : 'http://localhost:8080/file/confirm',
            contentType:'application/json;charset=UTF-8',
            dataType: 'json',
            data: jsonData,
            beforeSend: loadFunction,
            success : succFunction,
            error: errorFunction
        });
    });

    // 加载过程中
    function loadFunction(){

    };

    // 加载成功
    function succFunction(data){

        var json = eval(data);


    };

    // 加载失败
    function errorFunction(jqXHR){


        // alert("发生错误：" + jqXHR.status);
        alert('发生错误');

    };

});