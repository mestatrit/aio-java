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
	
	/************************************************************************************************/
	// 函数功能：初始化类库
	this.init_startmenu = function() {
		var objBody = document.getElementsByTagName("body").item(0);
		var objplatform = document.createElement("div");
		objplatform.setAttribute('id', 'top_getplatform');
		objplatform.setAttribute('align', 'left');
		objplatform.style.position = 'absolute';
		objplatform.style.zindex = '2147483647';//设为最大值
		objplatform.style.background = '#ffffff';
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
			document.getElementById("top_getplatform").style.visibility = "hidden";
		}
	};
	
	/************************************************************************************************/
	// 函数功能：删除开始菜单
	this.remove_startmenu = function(event) {
		if (event.target)
			targ = event.target;
		else if (event.srcElement)
			targ = event.srcElement;
		if (targ.tagName != 'LI' && targ.tagName != 'A') {
			var top_getplatform = document.getElementById("top_getplatform");
			if(top_getplatform) {
				var objBody = document.getElementsByTagName("body").item(0);
				objBody.removeChild(top_getplatform);
			}
		}
	};
	
	/************************************************************************************************/
	// 函数功能：隐藏开始菜单
	this.hidden = function() {
		if (document.getElementById("top_getplatform")) {
			document.getElementById("top_getplatform").style.visibility = "hidden";
		}
	};
	
	/************************************************************************************************/
	// 函数功能：显示开始菜单
	this.show_startmenu = function() {
		document.getElementById("top_getplatform").style.visibility = "visible";
	};
	
	/** **********************************************************************************************/
	// 函数功能：判断开始菜单是否显示
	this.is_showstartmenu = function() {
		if (document.getElementById("top_getplatform").style.visibility == "visible")
			return true;
		else
			return false;
	};
	
	/************************************************************************************************/
	// 函数功能：动态填充div的内容，该div显示所有的开始菜单内容
	this.fill_div = function() {

		var _html = new StringBuilder;
		_html.append('<div class="taskbar_startmenu">');
		_html.append("<br/>");
		_html.append("<br/>");
		_html.append("<br/>");
		_html.append("<br/>");
		_html.append("<br/>");
		_html.append("<center>开始菜单</center>");
		_html.append("<br/>");
		_html.append("<br/>");
		_html.append("<br/>");
		_html.append("<br/>");
		_html.append("<br/>");
		_html.append("<br/>");
		_html.append("</div>");
		
		var menuplat = _html.toString();

		var el = document.getElementById("top_getplatform");

		window.setTimeout(function() {
			replaceHtml(el, menuplat);
		}, 10);

	};
	
	/************************************************************************************************/
	// 函数功能：控制提示div的位置，使之刚好出现在开始按钮的上面
	this.fix_div_coordinate = function() {
		var leftpos = 0;
		var toppos = 0;

		var fix_div_width = 197;
		var fix_div_height = 320;
		
		var aTag = this.object;
		do {
			aTag = aTag.offsetParent;
			leftpos += aTag.offsetLeft;
			toppos += aTag.offsetTop;
		} while (aTag.tagName != "BODY" && aTag.tagName != "HTML");

		if (document.layers) {
			document.getElementById("top_getplatform").style.left = leftpos + this.object.offsetLeft + "px";
			document.getElementById("top_getplatform").style.top = toppos + this.object.offsetTop - fix_div_height - 2 + "px";
		} else {
			document.getElementById("top_getplatform").style.left = leftpos + this.object.offsetLeft + "px";
			document.getElementById("top_getplatform").style.top = toppos + this.object.offsetTop - fix_div_height + 'px';
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
		
		this.id2 = id2;
		if (!document.getElementById("top_getplatform"))
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
	};
	
	this.fill_startmenu = function() {
		parentbject.show_startmenu();
		parentbject.fill_div('');
		parentbject.fix_div_coordinate();
	};
};

var startmenu = new start_menu();