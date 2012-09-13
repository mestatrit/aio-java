var parentbject;

window.desktop = function() {
	this.windows = [];
	this.taskbars = [];
	
	this.currentid = '';
	this.currentshortcut = '';
	this.currenturl = '';
	
	this.init_zindex = 60000;
	this.taskid = 0;
	this.delaySec = 10; // 默认延迟多少毫秒出现提示框
	this.description = '';
	
	// 初始化window
	this.init_window = function() {
		var objBody = document.getElementsByTagName("body").item(0);
		if (objBody) {
			//objBody.appendChild(objplatform);
		}
		
		var desktop_content_and_windows = document.getElementById("desktop_content_and_windows");
		var objplatform = document.createElement("div");
		objplatform.style.zindex = this.init_zindex ++;
		objplatform.setAttribute('id', 'window_platform' + this.currentid);
		objplatform.setAttribute('align', 'left');
		objplatform.setAttribute("class", "window_platform");
		
		desktop_content_and_windows.appendChild(objplatform);
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
		_html.append("<span class=\"window_thirdLevelSpanClass1\">");
		_html.append("<a>" + this.description + "</a>");
		_html.append("</span>");
		_html.append("<span class=\"window_thirdLevelSpanClass2\" >");
		_html.append("<img src=\"images/btn_minsize_normal.png\" style=\"cursor:pointer;\" onclick=\"dt.minsize_window('" + this.currentid + "');\" onmouseover=\"dt.minsize_onmouseover(this)\" onmouseout=\"dt.minsize_onmouseout(this)\" onmousedown=\"dt.minsize_onmousedown(this)\" />");
		_html.append("<img src=\"images/btn_close_normal.png\" style=\"cursor:pointer;\" onclick=\"dt.remove_window('" + this.currentid + "');\" onmouseover=\"dt.close_onmouseover(this)\" onmouseout=\"dt.close_onmouseout(this)\" onmousedown=\"dt.close_onmousedown(this)\" />");
		_html.append("</span>");
		_html.append("</div>");
		_html.append("<div class=\"window_secondLevelDivClass2\">");
		_html.append('<iframe width="100%" height="100%" scrolling="auto" frameborder="0" src="' + this.currenturl + '"></iframe>');
		_html.append("</div>");
		_html.append("</div>");
		_html.append("</div>");
		
		var winplat = _html.toString();
		var el = document.getElementById("window_platform" + this.currentid);
		window.setTimeout(function() {
			replaceHtml(el, winplat);
		}, 10);
	};
	
	this.minsize_onmouseover = function(o) {
		if(o) {
			o.src = "images/btn_minsize_mouseover.png";	
		}
	}
	
	this.minsize_onmouseout = function(o) {
		if(o) {
			o.src = "images/btn_minsize_normal.png";	
		}
	}
	
	this.minsize_onmousedown = function(o) {
		if(o) {
			o.src = "images/btn_minsize_mousedown.png";	
		}
	}
	
	this.close_onmouseover = function(o) {
		if(o) {
			o.src = "images/btn_close_mouseover.png";	
		}
	}
	
	this.close_onmouseout = function(o) {
		if(o) {
			o.src = "images/btn_close_normal.png";	
		}
	}
	
	this.close_onmousedown = function(o) {
		if(o) {
			o.src = "images/btn_close_mousedown.png";	
		}
	}
	
	// 定位当前窗口
	this.fix_window_coordinate = function() {
		var leftpos = 0;
		var toppos = 0;
		
		var desktop = document.getElementById("desktop");
		if (document.layers) {
			document.getElementById("window_platform" + this.currentid).style.left = leftpos + desktop.offsetLeft + "px";
			document.getElementById("window_platform" + this.currentid).style.top = toppos + 2 + desktop.offsetTop + "px";
		} else {
			document.getElementById("window_platform" + this.currentid).style.left = leftpos + desktop.offsetLeft + "px";
			document.getElementById("window_platform" + this.currentid).style.top = toppos + desktop.offsetTop + 'px';
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
			var browser = navigator.appName
			var b_version = navigator.appVersion
			var version = b_version.split(";");
			var trim_Version = version[1].replace(/[ ]/g,"");
			
			if(browser == "Microsoft Internet Explorer" && trim_Version == "MSIE6.0") {
	    		isIE6 = true;
	    	}
 	 	}

		var taskbars = document.getElementById("taskbar_container");
		var objplatform = document.createElement("div");
		
		objplatform.setAttribute('id', 'taskbar' + this.currentid);
		objplatform.setAttribute('align', 'center');
		
		if(isIE6) {
			objplatform.setAttribute('className', 'taskbar_bg_normal');
		}else {
			objplatform.setAttribute('class', 'taskbar_bg_normal');
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
			objplatform.setAttribute('onmouseover', 'dt.switch_taskbar_status_onmouseover(this);');
			objplatform.setAttribute('onmousedown', 'dt.switch_taskbar_status_onmousedown(this);');
			objplatform.setAttribute('onmouseout', 'dt.switch_taskbar_status_onmouseout(this);');
		}
		
		$("#taskbar" + this.currentid).click(function(e) {
			if (event.target) {
				targ = event.target;
			} else if (event.srcElement) {
				targ = event.srcElement;
			}
			
			var idstr = targ.id;
			var windowid = idstr.substr(7,4);
			
			dt.switch_window_status(windowid);
		});
		
		$("#taskbar" + this.currentid).mouseover(function(e) {
			if (event.target) {
				targ = event.target;
			} else if (event.srcElement) {
				targ = event.srcElement;
			}

			if(targ) {
				dt.	switch_taskbar_status_onmouseover(targ);
			}
		});
		
		$("#taskbar" + this.currentid).mousedown(function(e) {
			if (event.target) {
				targ = event.target;
			} else if (event.srcElement) {
				targ = event.srcElement;
			}

			if(targ) {
				dt.	switch_taskbar_status_onmousedown(targ);
			}
		});
		
		$("#taskbar" + this.currentid).mouseout(function(e) {
			if (event.target) {
				targ = event.target;
			} else if (event.srcElement) {
				targ = event.srcElement;
			}

			if(targ) {
				dt.	switch_taskbar_status_onmouseout(targ);
			}
		});
	};
	
	this.switch_taskbar_status_onmouseover = function(o) {
		if(o) {
			if(dt.is_ie_6()) {
				o.setAttribute('className', 'taskbar_bg_onmouseover');
			}else {
				o.setAttribute('class', 'taskbar_bg_onmouseover');
			}	
		}
	}
	
	this.switch_taskbar_status_onmousedown = function(o) {
		if(o) {
			if(dt.is_ie_6()) {
				o.setAttribute('className', 'taskbar_bg_onmousedown');
			}else {
				o.setAttribute('class', 'taskbar_bg_onmousedown');
			}	
		}
	}
	
	this.switch_taskbar_status_onmouseout = function(o) {
		if(o) {
			if(dt.is_ie_6()) {
				o.setAttribute('className', 'taskbar_bg_normal');
			}else {
				o.setAttribute('class', 'taskbar_bg_normal');
			}	
		}	
	}
	
	this.is_ie = function() {
		// 浏览器判断
		var isIE = false;
		try {
			doc = new ActiveXObject("MSXML2.DOMDocument");
			isIE = true;
		} catch (e) {
			
		} 
		return isIE;
	};
	
	this.is_ie_6 = function() {
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
		
		return isIE6;
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
		var desktop_content_and_windows = document.getElementById("desktop_content_and_windows");
		var taskbars = document.getElementById("taskbar_container");
		desktop_content_and_windows.removeChild(w_platform);
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
		if(startmenu.is_showstartmenu()) {
			startmenu.hidden();
		}
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
		
		if (!document.getElementById("window_platform" + this.currentid)) {
			this.init_window();
		}
		if (!document.getElementById("taskbar" + this.currentid)) {
			this.init_taskbar();
		}
			
		if (!e) {
			e = window.event;
		}
		
		e.stopPropagation;
		e.cancelBubble = true;
		
		if (window.opera) {
			this.sleep(100);// 延迟0.1秒
		}
		
		currentwindow = this;
		
		if (this.taskid) {
			window.clearTimeout(this.taskid);
		}
		
		this.taskid = setTimeout("currentwindow.fill_window();", this.delaySec);
		
		this.windows.push(currentid);
	};
	
	// 添加任务栏图标
	this.add_taskbar = function(currentid, currentshortcut, e) {
		
	};
	
	this.sleep = function(n) {
		var start = new Date().getTime(); // for opera only
		while (true) {
			if (new Date().getTime() - start > n) {
				break;
			}
		}
	};
};

var dt = new desktop();