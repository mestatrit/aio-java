function tipsInfo(info) {
	var tips = document.getElementById("tips");
	var firstLevelDiv = document.createElement("div");
	var secondLevelDiv1 = document.createElement("div");// 关闭按钮
	var secondLevelDiv2 = document.createElement("div"); //内容
	var thirdLevelSpan = document.createElement("span");
	
	firstLevelDiv.className = "firstLevelDivClass";
	secondLevelDiv1.className = "secondLevelDivClass1";
	secondLevelDiv2.className = "secondLevelDivClass2";
	thirdLevelSpan.className = "thirdLevelSpanClass";
	thirdLevelSpan.onclick = "this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);";
	thirdLevelSpan.onmouseout = "this.style.backgroundPosition='0 0';";
	thirdLevelSpan.onmouseover = "this.style.backgroundPosition='0 -20px';";
	
	var textNode = document.createTextNode("  " + info);
	secondLevelDiv2.appendChild(textNode);
	secondLevelDiv1.appendChild(thirdLevelSpan);
	firstLevelDiv.appendChild(secondLevelDiv1);
	firstLevelDiv.appendChild(secondLevelDiv2);
	tips.appendChild(firstLevelDiv);
}

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