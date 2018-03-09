$(document).ready(function(){

	$(function(){
		$("#input-id").fileinput({
			language: 'zh',
			allowedFileExtensions: ['csv','txt'],
			uploadUrl: 'http://localhost:8080/file/dataFile',
			maxFileCount: 1/*允许最大上传数，可以多个，当前设置单个*/
		}).on("fileuploaded",function(event,data,previewId,index){
		    //打印文件上传信息
            alert('上传成功，HDFS路径为' + data.response.srcHdfs);
            console.log(data.response);
			var result = data.response; //后台返回的json
		});
	});

});