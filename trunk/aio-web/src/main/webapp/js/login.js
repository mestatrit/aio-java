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

// 提交登陆信息
function login_submit() {
	if (checkForm()) {
		var login_form = document.getElementById("login_form");
		login_form.submit(); 
	}
}
// 登陆信息重置
function login_reset() {
	
	var j_username = document.getElementById("j_username");
	var j_password = document.getElementById("j_password");

	j_username.value = "";
	j_password.value = "";
	
	$("#login_error_msg").empty();
}

window.onload = function() {
	// 注册登陆按钮及重置按钮上的事件处理程序
	EventUtil.addHandler(document.getElementById("img_btn_login"),"click",login_submit);
	EventUtil.addHandler(document.getElementById("img_btn_reset"),"click",login_reset);
	
	// 识别客户端浏览器类型及版本
	var browser_info = new StringBuilder;
	if(client.browser.chrome != 0) {
		browser_info.append('Chrome ');
	}
	if(client.browser.ie != 0) {
		browser_info.append('IE ');
	}
	if(client.browser.firefox != 0) {
		browser_info.append('Firefox ');
	}
	if(client.browser.safari != 0) {
		browser_info.append('Safari ');
	}
	if(client.browser.opera != 0) {
		browser_info.append('Opera ');
	}
	browser_info.append(client.browser.ver);
	browser_info.append('(当前)');
	$("#browser_tools_tips_info").text(browser_info.toString());
};

// 跳转屏幕高度
// 跨浏览器兼容
function adjust_login_height() {
	var windowHeight = getWindowHeight();
	var contentHeight = getContentHeight();
	if(contentHeight > windowHeight) {
		$("#adjust_login_height_top").attr("style", "width:1280px; height:0px;");	
		$("#adjust_login_height_bottom").attr("style", "width:1280px; height:0px;");		
	}
	
	// 支持chrome
	if(client.browser.chrome != 0) {
		var v_scrollHeight = document.body.scrollHeight;
		if(v_scrollHeight > 546) {
			$("#adjust_login_height_top").attr("style", "width:1280px; height:" + (((v_scrollHeight - 546) / 2) - 0.5) + "px;");	
			$("#adjust_login_height_bottom").attr("style", "width:1280px; height:" + (((v_scrollHeight - 546) / 2) - 0.5) + "px;");	
		}
	}
	// 支持ie
	if(client.browser.ie != 0) {
		var v_clientHeight = getWindowHeight();
		if(v_clientHeight > 546) {
			$("#adjust_login_height_top").attr("style", "width:1280px; height:" + (((v_clientHeight - 546) / 2) - 0.5) + "px;");	
			$("#adjust_login_height_bottom").attr("style", "width:1280px; height:" + (((v_clientHeight - 546) / 2) - 0.5) + "px;");	
		}
	}
	// 支持firefox
	if(client.browser.firefox != 0) {
		var v_clientHeight = getWindowHeight();
		if(v_clientHeight > 546) {
			$("#adjust_login_height_top").attr("style", "width:1280px; height:" + (((v_clientHeight - 546) / 2) - 0.5) + "px;");	
			$("#adjust_login_height_bottom").attr("style", "width:1280px; height:" + (((v_clientHeight - 546) / 2) - 0.5) + "px;");	
		}
	}
}

// 定时check屏幕大小,跳转屏幕高度
setInterval("adjust_login_height()", 20);