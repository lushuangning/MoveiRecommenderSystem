$(document).ready(function(){


	$("#confirm").click(function(){
		var formData = new Object;

        formData.nearestNeighbor = $('#nearestNeighbor').val();
        formData.recommendNum = $('#recommendNum').val();
        formData.similarityClassname = $('#similarityClassname').val();
        formData.whichCF = $('#whichCF').val();

		var jsonData = JSON.stringify(formData);
		console.log(jsonData);
        $.ajax({
	        type : 'POST',
	        url : 'http://localhost:8080/recommend/setting',
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