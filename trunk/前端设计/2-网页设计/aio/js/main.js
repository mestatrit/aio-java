// JavaScript Document			
// 跳转屏幕高度
// 跨浏览器兼容
function adjust_desktop_height() {
	
	var windowHeight = getWindowHeight();
	var contentHeight = getContentHeight();
	if(contentHeight > windowHeight) {
		var adjust_desktop_height_top_height = $("#adjust_desktop_height_top").css("height");
		if(adjust_desktop_height_top_height != "0px") {
			$("#adjust_desktop_height_top").attr("style", "width:100%; height:0px;");	
			$("#adjust_desktop_height_bottom").attr("style", "width:100%; height:0px;");
			// 调整屏幕大小时，自动隐藏开始菜单
			startmenu.remove_startmenu_adjust();
		}
	}
	
	// 支持chrome
	if(client.browser.chrome != 0) {
		var v_clientHeight = document.body.scrollHeight;
		if(v_clientHeight > 612) {
			var adjust_desktop_height_top_height = $("#adjust_desktop_height_top").css("height");
			if(adjust_desktop_height_top_height == "0px" || adjust_desktop_height_top_height != (Math.ceil(((v_clientHeight - 612) / 2) - 0.5)) + "px" ) {
				$("#adjust_desktop_height_top").attr("style", "width:100%; height:" + (Math.ceil(((v_clientHeight - 612) / 2) - 0.5)) + "px;");	
				$("#adjust_desktop_height_bottom").attr("style", "width:100%; height:" + (Math.ceil(((v_clientHeight - 612) / 2) - 0.5)) + "px;");	
				// 调整屏幕大小时，自动隐藏开始菜单
				startmenu.remove_startmenu_adjust();
			}
		}
	}
	
	// 支持ie
	if(client.browser.ie != 0) {
		var v_clientHeight = getWindowHeight();
		if(v_clientHeight > 612) {
			var adjust_desktop_height_top_height = $("#adjust_desktop_height_top").css("height");
			if(adjust_desktop_height_top_height == "0px" || adjust_desktop_height_top_height != (Math.ceil(((v_clientHeight - 612) / 2) - 0.5)) + "px" ) {
				$("#adjust_desktop_height_top").attr("style", "width:100%; height:" + (Math.ceil(((v_clientHeight - 612) / 2) - 0.5)) + "px;");	
				$("#adjust_desktop_height_bottom").attr("style", "width:100%; height:" + (Math.ceil(((v_clientHeight - 612) / 2) - 0.5)) + "px;");	
				// 调整屏幕大小时，自动隐藏开始菜单
				startmenu.remove_startmenu_adjust();
			}
		}
	}
	// 支持firefox
	if(client.browser.firefox != 0) {
		var v_clientHeight = getWindowHeight();
		if(v_clientHeight > 612) {
			var adjust_desktop_height_top_height = $("#adjust_desktop_height_top").css("height");
			if(adjust_desktop_height_top_height == "0px" || adjust_desktop_height_top_height != (Math.ceil(((v_clientHeight - 612) / 2) - 0.5)) + "px" ) {
				$("#adjust_desktop_height_top").attr("style", "width:100%; height:" + (Math.ceil(((v_clientHeight - 612) / 2) - 0.5)) + "px;");	
				$("#adjust_desktop_height_bottom").attr("style", "width:100%; height:" + (Math.ceil(((v_clientHeight - 612) / 2) - 0.5)) + "px;");
				// 调整屏幕大小时，自动隐藏开始菜单
				startmenu.remove_startmenu_adjust();
			}
		}
	}
	
}

// 定时check屏幕大小,跳转屏幕高度
setInterval("adjust_desktop_height()", 20);

// 内容面板切换
function switch_content_panel(event) {
	var click_object = null;
	if (event.target) {
		click_object = event.target;
	} else if (event.srcElement) {
		click_object = event.srcElement;
	}
	
	if(click_object) {
		var click_object_id = click_object.id;
		if(click_object_id) {
			var content_panel_index = click_object_id.substr(5,1);
			var content_panel_id = "#content_panel_" + content_panel_index;
			content_panel_initialization(); //相关样式恢复初始化
			$("#btn_c" + content_panel_index + "_bg").attr("style", "background:url(images/btn_c_bg.jpg) repeat-x;"); //变更点击背景
			$("#btn_c" + content_panel_index).attr("src", "images/pressed_btn_c" + content_panel_index + ".png"); //变更点击点样式
			
			//每个内容面板使用不同的处理效果
			/************************************************
			switch(content_panel_index) {
				case "0" : 
					$(content_panel_id).toggle("quick"); 
					break;
				case "1" : 
					$(content_panel_id).slideToggle("slow"); 
					break;
				case "2" : 
					$(content_panel_id).fadeToggle("slow"); 
					break;
				case "3" : 
					$(content_panel_id).slideToggle("slow"); 
					break;
				case "4" : 
					$(content_panel_id).toggle("quick"); 
					break;
			}
			************************************************/
			// 统一切换效果
			$(content_panel_id).fadeToggle("slow"); 
		}
	}
}

// 初始化所有内容面板的相关样式
function content_panel_initialization() {
	var content_panel_total_num = 5;
	for(var i = 0; i < content_panel_total_num; i++) {
		$("#content_panel_" + i).attr("style", "display:none;");
		$("#btn_c" + i + "_bg").attr("style", "");
		$("#btn_c" + i).attr("src", "images/btn_c" + i + ".png");
	}
}