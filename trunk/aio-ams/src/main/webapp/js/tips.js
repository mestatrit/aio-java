function tipsInfoByJquery(infos) {
	show_screen_shade();
	// 浏览器判断
	var isIE = false;
	try {
		doc = new ActiveXObject("MSXML2.DOMDocument");
		isIE = true;
	} catch (e) {
		
	} 
	
	var textBoxHtml = " ";
	if(isIE){
		$("div").remove(".dialog_box4ie");
		textBoxHtml += "<div class=\"dialog_box4ie\">";
	} else {
		$("div").remove(".dialog_box");
		textBoxHtml += "<div class=\"dialog_box\">";
	}
	textBoxHtml += "<div class=\"dialog_box_title\">";
	textBoxHtml += "<span class=\"dialog_box_close\" ";
	textBoxHtml += "onclick=\"closetipsInfo(this);\" ";
	textBoxHtml += "onmouseout=\"this.style.backgroundPosition='0 0';\" ";
	textBoxHtml += "onmouseover=\"this.style.backgroundPosition='0 -20px';\"> ";
	textBoxHtml += "</span></div>";
	textBoxHtml += "<div class=\"dialog_box_content\">";
	textBoxHtml += "<br>";
	textBoxHtml += "<ul>";
	for(var i=0; i<infos.length; i++) {
		textBoxHtml += "<li>" + infos[i] + "</li>";
	}
	textBoxHtml += "</ul>";
	textBoxHtml += "<br>";
	textBoxHtml += "</div>";
	textBoxHtml += "</div>";
	
	$("#tips").after(textBoxHtml); 
}

function closetipsInfo(o) {
	if(o) {
		hide_screen_shade();
		o.parentNode.parentNode.parentNode.removeChild(o.parentNode.parentNode);
	}
}

function show_screen_shade() {
	$("div").remove(".screen_shade");
	var screenShadeHtml = " ";
	screenShadeHtml += "<div class=\"screen_shade\">";
	screenShadeHtml += "</div>";
	$("#tips").after(screenShadeHtml); 
}

function hide_screen_shade() {
	$("div").remove(".screen_shade");
}