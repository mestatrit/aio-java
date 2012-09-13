var parentbject;

window.desktop = function() {
	this.windows = [];
	this.taskbars = [];
	
	this.currentid = '';
	this.currentshortcut = '';
	this.currenturl = '';
	
	this.init_zindex = 10000;
	
	this.taskid = 0;
	
	this.delaySec = 10; // 默认延迟多少毫秒出现提示框
	
	this.description = '';
	
	// 初始化window
	this.init_window = function() {
		var objBody = document.getElementsByTagName("body").item(0);
		var objplatform = document.createElement("div");
		objplatform.setAttribute('id', 'window_platform' + this.currentid);
		objplatform.setAttribute('align', 'left');
		objplatform.style.position = 'absolute';
		objplatform.style.zindex = this.init_zindex ++;
		objplatform.style.border = 'solid 1px #7f9db9';
		objplatform.style.background = '#ffffff';
		objplatform.style.width = '1022px';
		objplatform.style.margin = '0 0';
		if (objBody) {
			objBody.appendChild(objplatform);
		}
	};
	
	// 填充window内容
	this.fill_window = function() {
		currentwindow.show_window(this.currentid);
		currentwindow.fill_content('');
		currentwindow.fix_window_coordinate();
	};
	
	// 填充div内容
	this.fill_content = function() {
		// 浏览器判断
		var isIE = false;
		try {
			doc = new ActiveXObject("MSXML2.DOMDocument");
			isIE = true;
		} catch (e) {
			
		} 
		
		var _html = new StringBuilder;
		_html.append('<div class="window_content">');
		
		if(isIE){
			_html.append("<div class=\"window_firstLevelDivClass4IE\">");
		} else {
			_html.append("<div class=\"window_firstLevelDivClass\">");
		}
		_html.append("<div class=\"window_secondLevelDivClass1\">");
		_html.append("<span class=\"window_thirdLevelSpanClass1\">&nbsp;&nbsp;");
		_html.append(this.description);
		_html.append("</span>");
		_html.append("<span class=\"window_thirdLevelSpanClass2\" >");
		_html.append("<img src=\"images/window_minsize.jpg\" onclick=\"dt.minsize_window('" + this.currentid + "');\" />");
		_html.append("<img src=\"images/window_close.jpg\" onclick=\"dt.remove_window('" + this.currentid + "');\" />");
		_html.append("</span>");
		_html.append("</div>");
		_html.append("<div class=\"window_secondLevelDivClass2\">");
		_html.append('<iframe width="1024" height="100%" scrolling="auto" frameborder="0" src="' + this.currenturl + '"></iframe>');
		_html.append("</div>");
		_html.append("<div class=\"window_secondLevelDivClass3\">");
		_html.append("</div>");
		_html.append("</div>");
		
		_html.append("</div>");
		
		var winplat = _html.toString();

		var el = document.getElementById("window_platform" + this.currentid);

		window.setTimeout(function() {
			replaceHtml(el, winplat);
		}, 10);
	};
	
	// 定位当前窗口
	this.fix_window_coordinate = function() {
		var leftpos = 0;
		var toppos = 0;

		var desktop = document.getElementById("desktop");
		
		if (document.layers) {
			document.getElementById("window_platform" + this.currentid).style.left = desktop.offsetLeft + leftpos + "px";
			document.getElementById("window_platform" + this.currentid).style.top = desktop.offsetTop + toppos + 2 + "px";
		} else {
			document.getElementById("window_platform" + this.currentid).style.left = desktop.offsetLeft + leftpos + "px";
			document.getElementById("window_platform" + this.currentid).style.top = desktop.offsetTop + toppos + 'px';
		}
	};
	
	// 初始化任务栏图标
	this.init_taskbar = function() {
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
			var browser=navigator.appName
			var b_version=navigator.appVersion
			var version=b_version.split(";");
			var trim_Version=version[1].replace(/[ ]/g,"");
			
			if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE6.0") {
	    	isIE6 = true;
	    }
 	 	}

		var taskbars = document.getElementById("taskbar_container");
		var objplatform = document.createElement("div");
		objplatform.setAttribute('id', 'taskbar' + this.currentid);
		objplatform.setAttribute('align', 'center');
		
		if(isIE6) {
			objplatform.setAttribute('className', 'tasjbar_bg');
		}else {
			objplatform.setAttribute('class', 'tasjbar_bg');
		}
		
		if (taskbars) {
			taskbars.appendChild(objplatform);
			this.fill_taskbar();
		}
		
		if(isIE) {
			// do nothing
		} else {
			// 此种注册onclick事件的方法在ie浏览器中无效
			objplatform.setAttribute('onclick', 'dt.switch_window_status(\'' + this.currentid + '\');');	
		}
		
		$("#taskbar" + this.currentid).click(function(e) {
			if (event.target)
				targ = event.target;
			else if (event.srcElement)
				targ = event.srcElement;

			var idstr = targ.id;
			var windowid = idstr.substr(7,1);
			
			dt.switch_window_status(windowid);
		});
	};
	
	// 填充taskbar内容
	this.fill_taskbar = function() {
		var _html = new StringBuilder;
		_html.append(this.description);
		
		var barplat = _html.toString();

		var el = document.getElementById("taskbar" + this.currentid);

		window.setTimeout(function() {
			replaceHtml(el, barplat);
		}, 10);
	};
	
	// 删除窗口
	this.remove_window = function(windowid) {
		var w_platform = document.getElementById("window_platform" + windowid);
		var w_taskbar = document.getElementById("taskbar" + windowid);
		var objBody = document.getElementsByTagName("body").item(0);
		var taskbars = document.getElementById("taskbar_container");
		objBody.removeChild(w_platform);
		taskbars.removeChild(w_taskbar);
		
		for ( var i=0 ; i < this.windows.length ; ++i ) {
			if(this.windows[i] == windowid) {
				delete this.windows[i];
			}
		}
	};
	
	this.minsize_window = function(windowid) {
		var w_platform = document.getElementById("window_platform" + windowid);
		if(w_platform) {
			document.getElementById("window_platform" + windowid).style.visibility = "hidden";
		}
	};
	
	this.maxsize_window = function(windowid) {
		for ( var i=0 ; i < this.windows.length ; ++i ) {
			var win = document.getElementById("window_platform" + this.windows[i]);
			if(win) {
				document.getElementById("window_platform" + this.windows[i]).style.visibility = "hidden";
			}
		}
		
		var w_platform = document.getElementById("window_platform" + windowid);
		if(w_platform) {
			document.getElementById("window_platform" + windowid).style.visibility = "visible";
		}
	};
	
	this.switch_window_status = function(windowid) {
		var window_visible = document.getElementById("window_platform" + windowid).style.visibility;
		if(window_visible == 'hidden') {
			dt.maxsize_window(windowid);
		} else if(window_visible == 'visible') {
			dt.minsize_window(windowid);
		}
	};
	
	// 隐藏窗口
	this.hide_window = function(windowid) {
		
	};
	
	// 显示窗口
	this.show_window = function(windowid) {
		document.getElementById("window_platform" + windowid).style.visibility = "visible";
	};
	
	// 切换任务栏图标状态
	this.swtich_task_status = function(taskid) {
		
	};
	
	// 添加窗口
	this.add_window = function(currentid, currentshortcut, description, currenturl, e) {
		this.currentid = currentid;
		this.currentshortcut = currentshortcut;
		this.currenturl = currenturl;
		this.description = description;
		
		if (!document.getElementById("window_platform" + this.currentid))
			this.init_window();
		if (!document.getElementById("taskbar" + this.currentid))
			this.init_taskbar();
			
		if (!e)
			e = window.event;
		
		e.stopPropagation;
		e.cancelBubble = true;
		
		if (window.opera)
			this.sleep(100);// 延迟0.1秒
		
		currentwindow = this;
		
		if (this.taskid)
			window.clearTimeout(this.taskid);
		this.taskid = setTimeout("currentwindow.fill_window();", this.delaySec);
		
		this.windows.push(currentid);
	};
	
	// 添加任务栏图标
	this.add_taskbar = function(currentid, currentshortcut, e) {
		
	};
	
	this.sleep = function(n) {
		var start = new Date().getTime(); // for opera only
		while (true)
			if (new Date().getTime() - start > n)
				break;
	};
};

var dt = new desktop();