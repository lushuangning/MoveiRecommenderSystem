$(document).ready(function(){

	$("#userEmail").on('blur',function(){
		if ($("#userEmail").val() == '' || $("#userPasswd").val() == '') {
			$("#login").attr('disabled','true');
		}else{
			$("#login").removeAttr('disabled');
		}
	});

	$("#userPasswd").on('blur',function(){
		if ($("#userEmail").val() == '' || $("#userPasswd").val() == '') {
			$("#login").attr('disabled','true');
		}else{
			$("#login").removeAttr('disabled');
		}
	});


	$("#login").click(function(){
		var formData = new Object;
		formData.userEmail = $('#userEmail').val();
		formData.userPasswd = $('#userPasswd').val();
		var jsonData = JSON.stringify(formData);
		console.log(jsonData);
		$.ajax({
	        type : 'POST',
	        url : 'http://localhost:8080/loginRegister/login',
	        contentType:'application/json;charset=UTF-8',
	        dataType: 'json',
	        data: jsonData,
	        beforeSend: loadFunction,
	        success : succFunction,
	        error: errorFunction
	    });
	});

	// var username = $("#loginUser").val();
	// var password = $("#loginPass").val();

	// 加载过程中
    function loadFunction(){
        $("#login").html("登录中...");
    };

    // 加载成功
    function succFunction(data){

        var json = eval(data);
        if (data != '') {
        	window.location.href = 'index';
        }
        
    };

    // 加载失败
    function errorFunction(jqXHR){
    	$("#login").html("登&nbsp;&nbsp;&nbsp;录");
    	
        // alert("发生错误：" + jqXHR.status);
        alert('用户名或密码不正确，请重试');
        
    };

});