// JavaScript Document

// 提交登陆信息
function login_submit() {
	var login_form = document.getElementById("login_form");
	login_form.submit();
}
// 登陆信息重置
function login_reset() {
	var login_form = document.getElementById("login_form");
	login_form.reset();
}

window.onload = function() {
	// 注册登陆按钮及重置按钮上的事件处理程序
	EventUtil.addHandler(document.getElementById("img_btn_login"),"click",login_submit);
	EventUtil.addHandler(document.getElementById("img_btn_reset"),"click",login_reset);
};

// 跳转屏幕高度
// 跨浏览器兼容
function adjust_login_height() {
	var windowHeight = getWindowHeight();
	var contentHeight = getContentHeight();
	if(contentHeight > windowHeight) {
		//$("#adjust_login_height_top").attr("style", "width:100%; height:0px;");	
		$("#adjust_login_height_bottom").attr("style", "width:100%; height:0px;");		
	}
	
	// 支持chrome
	if(client.browser.chrome != 0) {
		var v_scrollHeight = document.body.scrollHeight;
		if(v_scrollHeight > 667) {
			//$("#adjust_login_height_top").attr("style", "width:100%; height:" + (((v_scrollHeight - 627) / 2) - 0.5) + "px;");	
			//$("#adjust_login_height_bottom").attr("style", "width:100%; height:" + (((v_scrollHeight - 627) / 2) - 0.5) + "px;");
			$("#adjust_login_height_bottom").attr("style", "width:100%; height:" + ((v_scrollHeight - 667) - 0.5) + "px;");
		}
	}
	// 支持ie
	if(client.browser.ie != 0) {
		var v_clientHeight = getWindowHeight();
		if(v_clientHeight > 667) {
			//$("#adjust_login_height_top").attr("style", "width:100%; height:" + (((v_clientHeight - 627) / 2) - 0.5) + "px;");	
			//$("#adjust_login_height_bottom").attr("style", "width:100%; height:" + (((v_clientHeight - 627) / 2) - 0.5) + "px;");	
			$("#adjust_login_height_bottom").attr("style", "width:100%; height:" + ((v_clientHeight - 667) - 0.5) + "px;");
		}
	}
	// 支持firefox
	if(client.browser.firefox != 0) {
		var v_clientHeight = getWindowHeight();
		
		if(v_clientHeight > 667) {
			//$("#adjust_login_height_top").attr("style", "width:100%; height:" + (((v_clientHeight - 627) / 2) - 0.5) + "px;");	
			//$("#adjust_login_height_bottom").attr("style", "width:100%; height:" + (((v_clientHeight - 627) / 2) - 0.5) + "px;");	
			$("#adjust_login_height_bottom").attr("style", "width:100%; height:" + ((v_clientHeight - 667) - 0.5) + "px;");
		}
	}
}

// 定时check屏幕大小,跳转屏幕高度
setInterval("adjust_login_height()", 20);