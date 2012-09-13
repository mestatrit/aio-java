function sbmt() {
	if (checkForm()) {
		document.forms[0].submit(); 
	}
}

function reset() {
	var j_username = document.getElementById("j_username");
	var j_password = document.getElementById("j_password");

	j_username.value = "";
	j_password.value = "";
	
	$("#login_error_msg").empty();
}

function checkForm() {
	// 登陆用户名、密码检查
	var j_username = document.getElementById("j_username");
	var j_password = document.getElementById("j_password");

	if (j_username.value == "") {
		$("#login_error_msg").empty();
		$("#login_error_msg").append("username can not be empty");;
		document.all.j_username.focus();
		return false;
	}

	if (j_password.value == "") {
		$("#login_error_msg").empty();
		$("#login_error_msg").append("password can not be empty");;
		document.all.j_password.focus();
		return false;
	}
	
	return true;
}