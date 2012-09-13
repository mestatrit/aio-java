/************************************************************************************************/
// 函数功能：使用新的内容html填充已经存在的Node
function replaceHtml(el, html) {
	var oldEl = typeof el == "string" ? document.getElementById(el) : el;
	var newEl = oldEl.cloneNode(false);
	newEl.innerHTML = html;
	oldEl.parentNode.replaceChild(newEl, oldEl);
	return newEl;
};

var global_id = '';
var parentbject;

// 开始菜单
window.start_menu = function() {
	this.object = '';
	this.id2 = '';
	this.taskid = 0;
	this.delaySec = 10; // 默认延迟多少毫秒出现提示框
	
	this.btn_status = 0;
	
	/************************************************************************************************/
	// 函数功能：初始化类库
	this.init_startmenu = function() {
		var objBody = document.getElementsByTagName("body").item(0);
		var objplatform = document.createElement("div");
		objplatform.setAttribute('id', 'top_start_menu');
		objplatform.setAttribute('align', 'left');
		objplatform.style.position = 'absolute';
		objplatform.style.zindex = '2147483647';//设为最大值
		if (objBody) {
			objBody.appendChild(objplatform);
		}
		
		if (!document.all) {
			window.document.addEventListener("click", this.remove_startmenu, false);
		} else {
			window.document.attachEvent("onclick", this.remove_startmenu);
		}
		
	};
	
	/************************************************************************************************/
	// 函数功能：隐藏开始菜单
	this.hidden_startmenu = function(event) {
		if (event.target)
			targ = event.target;
		else if (event.srcElement)
			targ = event.srcElement;
		if (targ.tagName != 'LI' && targ.tagName != 'A') {
			if(startmenu.btn_status == 1) {
				document.getElementById("top_start_menu").style.visibility = "hidden";
				startmenu.btn_status = 0;
			}
		}
	};
	
	/************************************************************************************************/
	// 函数功能：删除开始菜单
	this.remove_startmenu = function(event) {
		if (event.target)
			targ = event.target;
		else if (event.srcElement)
			targ = event.srcElement;
		
		// 判断是否点在了开始菜单区域
		var isClickOnStartMenu = false;
		var aTag = targ;
		do {
			aTag = aTag.offsetParent;
			if(aTag.id == "top_start_menu") {
				isClickOnStartMenu = true;
				break;	
			}
		} while (aTag.tagName != "BODY" && aTag.tagName != "HTML");
		
		if (!isClickOnStartMenu && targ.tagName != 'LI' && targ.tagName != 'A') {
			var top_start_menu = document.getElementById("top_start_menu");
			if(top_start_menu) {
				var objBody = document.getElementsByTagName("body").item(0);
				objBody.removeChild(top_start_menu);
				startmenu.btn_status = 0;
			}
		}
	};
	
	this.remove_startmenu_adjust = function() {
		var top_start_menu = document.getElementById("top_start_menu");
		if(top_start_menu) {
			var objBody = document.getElementsByTagName("body").item(0);
			objBody.removeChild(top_start_menu);
			startmenu.btn_status = 0;
		}
	};
	
	
	/************************************************************************************************/
	// 函数功能：隐藏开始菜单
	this.hidden = function() {
		if (document.getElementById("top_start_menu")) {
			if(startmenu.btn_status == 1) {
				document.getElementById("top_start_menu").style.visibility = "hidden";
				startmenu.btn_status = 0;
			}
		}
	};
	
	/************************************************************************************************/
	// 函数功能：显示开始菜单
	this.show_startmenu = function() {
		if(startmenu.btn_status == 0) {
			document.getElementById("top_start_menu").style.visibility = "visible";
			startmenu.btn_status = 1;
		}
	};
	
	/** **********************************************************************************************/
	// 函数功能：判断开始菜单是否显示
	this.is_showstartmenu = function() {
		var top_start_menu = document.getElementById("top_start_menu");
		if (top_start_menu == null) 
			return false;
		if (document.getElementById("top_start_menu").style.visibility == "visible") {
			return true;
		} else {
			return false;
		}
	};
	
	/************************************************************************************************/
	// 函数功能：动态填充div的内容，该div显示所有的开始菜单内容
	this.fill_div = function() {

		var _html = new StringBuilder;
		_html.append('<div class="startmenu">');
		_html.append('<div class="space"></div>');
		_html.append('<div class="header">');
		_html.append('<div class="title"></div>');
		_html.append("</div>");
		
		_html.append('<div class="content">');
		_html.append('<div class="r1_space"></div>');
		_html.append('<div id="menu_start_r1" class="r_start_menu_normal" onclick="dt.add_window(\'9001\', \'help\', \'控制面板\', \'controlpanel.html\', event);" onmouseover=\"startmenu.start_menu_mouse_over(this);\" onmouseout=\"startmenu.start_menu_mouse_out(this);\" >');
		_html.append('<img src="./images/menu_start_controlpannel.png"/>');
		_html.append("</div>");
		_html.append('<div class="r2_space"></div>');
		_html.append('<div id="menu_start_r2" class="r_start_menu_normal" onclick="dt.add_window(\'9002\', \'help\', \'工具\', \'tools.html\', event);" onmouseover=\"startmenu.start_menu_mouse_over(this);\" onmouseout=\"startmenu.start_menu_mouse_out(this);\" >');
		_html.append('<img src="./images/menu_start_tool.png"/>');
		_html.append("</div>");
		_html.append('<div class="r3_space"></div>');
		_html.append('<div id="menu_start_r3" class="r_start_menu_normal" onclick="dt.add_window(\'9003\', \'help\', \'帮助\', \'help.html\', event);" onmouseover=\"startmenu.start_menu_mouse_over(this);\" onmouseout=\"startmenu.start_menu_mouse_out(this);\" >');
		_html.append('<img src="./images/menu_start_help.png"/>');
		_html.append("</div>");
		_html.append('<div class="r4_space"></div>');
		_html.append('<div class="">');
		_html.append('');
		_html.append("</div>");
		_html.append("</div>");
		
		_html.append('<div class="footer">');
		_html.append('<div id="btn_quit" class="btn_quit_normal" onclick="window.location.href=\'index.html\'" onmousemove="startmenu.btn_quit_onmouseover();" onmouseout="startmenu.btn_quit_onmouseout();"></div>');
		_html.append("</div>");
		_html.append("</div>");
		
		var menuplat = _html.toString();

		var el = document.getElementById("top_start_menu");

		window.setTimeout(function() {
			replaceHtml(el, menuplat);
		}, 10);
	};
	
	this.start_menu_mouse_over = function(o) {
		// 浏览器判断
		var isIE = false;
		try {
			doc = new ActiveXObject("MSXML2.DOMDocument");
			isIE = true;
		} catch (e) {
			
		} 
		// 判断是否IE6
		var isIE6 = false;
		if(isIE) {
			var browser = navigator.appName
			var b_version = navigator.appVersion
			var version = b_version.split(";");
			var trim_Version = version[1].replace(/[ ]/g,"");
			
			if(browser == "Microsoft Internet Explorer" && trim_Version == "MSIE6.0") {
	    		isIE6 = true;
	    	}
 	 	}
		
		if(isIE6) {
			o.setAttribute('className', 'r_start_menu_mouseover');
		}else {
			o.setAttribute('class', 'r_start_menu_mouseover');
		}
	};
	
	this.start_menu_mouse_out = function(o) {
		// 浏览器判断
		var isIE = false;
		try {
			doc = new ActiveXObject("MSXML2.DOMDocument");
			isIE = true;
		} catch (e) {
			
		} 
		// 判断是否IE6
		var isIE6 = false;
		if(isIE) {
			var browser = navigator.appName
			var b_version = navigator.appVersion
			var version = b_version.split(";");
			var trim_Version = version[1].replace(/[ ]/g,"");
			
			if(browser == "Microsoft Internet Explorer" && trim_Version == "MSIE6.0") {
	    		isIE6 = true;
	    	}
 	 	}
		
		if(isIE6) {
			o.setAttribute('className', 'r_start_menu_normal');
		}else {
			o.setAttribute('class', 'r_start_menu_normal');
		}
	};
	
	/************************************************************************************************/
	// 函数功能：控制提示div的位置，使之刚好出现在开始按钮的上面
	this.fix_div_coordinate = function() {
		var leftpos = 0;
		var toppos = 0;

		var fix_div_width = 272;
		var fix_div_height = 409;
		
		var aTag = this.object;
		do {
			aTag = aTag.offsetParent;
			leftpos += aTag.offsetLeft;
			toppos += aTag.offsetTop;
		} while (aTag.tagName != "BODY" && aTag.tagName != "HTML");

		if (document.layers) {
			document.getElementById("top_start_menu").style.left = leftpos + this.object.offsetLeft + "px";
			document.getElementById("top_start_menu").style.top = toppos + this.object.offsetTop - fix_div_height - 2 + "px";
		} else {
			document.getElementById("top_start_menu").style.left = leftpos + this.object.offsetLeft + "px";
			document.getElementById("top_start_menu").style.top = toppos + this.object.offsetTop - fix_div_height + 'px';
		}
	};

	
	this.sleep = function(n) {
		var start = new Date().getTime(); // for opera only
		while (true)
			if (new Date().getTime() - start > n)
				break;
	};
	
	/************************************************************************************************/
	// 函数功能：trim字符串左边空格
	this.ltrim = function(strtext) {
		return strtext.replace(/[\$&\|\^*%#@! ]+/, '');
	};
	
	/************************************************************************************************/
	// 函数功能：获取键盘keycode
	this.ajaxac_getkeycode = function(e) {
		var code;
		if (!e)
			var e = window.event;
		if (e.keyCode)
			code = e.keyCode;
		else if (e.which)
			code = e.which;
		return code;
	};
	
	/************************************************************************************************/
	// 函数功能：入口函数，将开始菜单层div显示出来
	// 输入参数：object 当前输入所在的对象，如开始按钮
	// 输入参数：e IE事件对象
	this.menu_display = function(object, id2, e) {
		if(document.getElementById("top_start_menu") && startmenu.btn_status == 1) {
			this.hidden();
			$("#start_btn").attr("class", "start_btn_onmouseover");
			return;
		}
		this.id2 = id2;
		if (!document.getElementById("top_start_menu"))
			this.init_startmenu();
		if (!e)
			e = window.event;
		e.stopPropagation;
		e.cancelBubble = true;
		if (e.target)
			targ = e.target;
		else if (e.srcElement)
			targ = e.srcElement;
		if (targ.nodeType == 3)
			targ = targ.parentNode;

		this.object = object;

		if (window.opera)
			this.sleep(100);// 延迟0.1秒
		parentbject = this;
		if (this.taskid)
			window.clearTimeout(this.taskid);
		this.taskid = setTimeout("parentbject.fill_startmenu();", this.delaySec);
		
		// 改变开始菜单式样
		this.btn_onmousedown();
	};
	
	this.fill_startmenu = function() {
		parentbject.show_startmenu();
		parentbject.fill_div('');
		parentbject.fix_div_coordinate();
	};
	
	this.btn_onmouseover = function() {
		var start_btn = document.getElementById("start_btn");
		if(start_btn && startmenu.btn_status == 0) {
			//start_btn.className = "start_btn_onmouseover";
			$("#start_btn").attr("class", "start_btn_onmouseover");
		}
		
	};
	
	this.btn_onmouseout = function() {
		var start_btn = document.getElementById("start_btn");
		if(start_btn && startmenu.btn_status == 0) {
			//start_btn.className = "start_btn_normal";
			$("#start_btn").attr("class", "start_btn_normal");
		}
		if(start_btn && startmenu.btn_status == 1) {
			start_btn.className = "start_btn_onpressed";
			$("#start_btn").attr("class", "start_btn_onpressed");
		}
		
	};
	
	this.btn_onmousedown = function() {
		var start_btn = document.getElementById("start_btn");
		if(start_btn) {
			//start_btn.className = "start_btn_onpressed";
			$("#start_btn").attr("class", "start_btn_onpressed");
		}
	};
	
	this.btn_quit_onmouseover = function() {
		var quit_btn = document.getElementById("btn_quit");
		if(quit_btn) {
			$("#btn_quit").attr("class", "btn_quit_pressed");
		}
	};
	
	this.btn_quit_onmouseout = function() {
		var quit_btn = document.getElementById("btn_quit");
		if(quit_btn) {
			$("#btn_quit").attr("class", "btn_quit_normal");
		}
	}
};

var startmenu = new start_menu();