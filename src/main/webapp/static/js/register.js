$(document).ready(function(){

	$("#register").click(function(){
		var formData = new Object;
		formData.userEmail = $('#userEmail').val();
		formData.userName = $('#userName').val();
		formData.userPasswd = $('#userPasswd').val();
		formData.roleName = $('input[name="role"]:checked').val();
		var jsonData = JSON.stringify(formData);
		console.log(jsonData);

		if ($('#userPasswd').val() == $('#confirmPasswd').val()) {
			$.ajax({
		        type : 'POST',
		        url : 'http://localhost:8080/loginRegister/userRegister',
		        contentType:'application/json;charset=UTF-8',
		        dataType: 'json',
		        data: jsonData,
		        beforeSend: loadFunction,
		        success : succFunction,
		        error: errorFunction
		    });
		}else{
			alert('两次输入的密码不一致！');
		}
		
	});

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
        
    };

});