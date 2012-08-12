String.prototype.trim = function() {
	return this.replace(/(^\s+)|(\s+$)/g, "");
};

String.prototype.format = function() {
	var a = arguments;
	return this.replace(/\{(\d+)\}/g, function(c, b) {
		return a[b];
	});
};

function StringBuilder() {
	this.arr = [];
}

StringBuilder.prototype.append = function(a) {
	this.arr.push(a);
};

StringBuilder.prototype.appendFormat = function() {
	for ( var a = arguments[0], c = 0; c < arguments.length - 1; c++)
		a = a.replace(new RegExp("\\{" + c + "\\}"), arguments[c + 1]);
	this.arr.push(a);
};

StringBuilder.prototype.toString = function() {
	return this.arr.join("");
};

function max_window(){
	window.moveTo(0, 0);
	window.resizeTo(screen.availWidth, screen.availHeight);
}

// 获取窗口可视区域的宽度
function getWindowWidth(){
	if (window.innerWidth){
		return window.innerWidth;
	} else if (document.documentElement.clientWidth){
		return document.documentElement.clientWidth;
	} else if (document.body.clientWidth){
		return document.body.clientWidth;
	}
}
//获取窗口可视区域的高度
function getWindowHeight(){
	if (window.innerHeight){
		return window.innerHeight;
	} else if (document.documentElement.clientHeight){
		return document.documentElement.clientHeight;
	} else if (document.body.clientHeight){
		return document.body.clientHeight;
	}
}

//获得网页内容高度
function getContentHeight() {
	//可见高
	var ContentHeight=document.body.scrollHeight;//其它浏览器默认值
	if(navigator.userAgent.indexOf("Chrome")!=-1) {
		ContentHeight= document.body.clientHeight;
	}

	if(navigator.userAgent.indexOf("Firefox")!=-1) {
		ContentHeight=document.body.offsetHeight;
	}
	return ContentHeight;
}

function submitByFormId(formid) {
	var form = $("#" + formid);
	form.submit();
}

//全选或全不选
function checkAllOrCheckNone() {
	var checkAllAStr = $("#checkAll").html();
	if(checkAllAStr == '全选') {
		$("#checkAll").html('全不选');
		var mids = document.getElementsByName("mid");
		for(var i=0; i<mids.length; i++) {
			if(mids[i].checked) {
				//do nothing
			}else{
				mids[i].checked = "checked";
			}
		}
	}
	
	if(checkAllAStr == '全不选') {
		$("#checkAll").html('全选');
		var mids = document.getElementsByName("mid");
		for(var i=0; i<mids.length; i++) {
			if(mids[i].checked) {
				mids[i].checked = "";
				
			}else{
				//do nothing
			}
		}
	}
}
