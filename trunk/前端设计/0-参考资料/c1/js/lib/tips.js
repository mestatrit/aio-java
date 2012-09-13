function tipsInfoByJquery(infos) {
	
	// 浏览器判断
	var isIE = false;
	try {
		doc = new ActiveXObject("MSXML2.DOMDocument");
		isIE = true;
	} catch (e) {
		
	} 
	
	var textBoxHtml = " ";
	if(isIE){
		$("div").remove(".firstLevelDivClass4IE");
		textBoxHtml += "<div class=\"firstLevelDivClass4IE\">";
	} else {
		$("div").remove(".firstLevelDivClass");
		textBoxHtml += "<div class=\"firstLevelDivClass\">";
	}
	textBoxHtml += "<div class=\"secondLevelDivClass1\">";
	textBoxHtml += "<span class=\"thirdLevelSpanClass\" ";
	textBoxHtml += "onclick=\"this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);\" ";
	textBoxHtml += "onmouseout=\"this.style.backgroundPosition='0 0';\" ";
	textBoxHtml += "onmouseover=\"this.style.backgroundPosition='0 -20px';\"> ";
	textBoxHtml += "</span></div>";
	textBoxHtml += "<div class=\"secondLevelDivClass2\">";
	textBoxHtml += "<br><br><br><br>";
	textBoxHtml += "<ul>";
	for(var i=0; i<infos.length; i++) {
		textBoxHtml += "<li>" + infos[i] + "</li>";
	}
	textBoxHtml += "</ul>";
	textBoxHtml += "</div>";
	textBoxHtml += "</div>";
	
	$("#tips").after(textBoxHtml); 
}