// JavaScript Document
function m1(fid) {
	$("#Menu1 > a").attr("class", "menu1_off");
	var firstLevelMenuId = 'menu1_' + fid;
	$("#" + firstLevelMenuId).attr("class", "menu1_on");
	
	$("#Menu2 > div").attr("style", "");
	$("#Menu2 > div").attr("style", "display:none;");
	var secondLevelMenuId = 'menu2_' + fid;
	$("#" + secondLevelMenuId).attr("style", "display:block;");
}

function m2(fid, pfid) {
	$("#menu2_" + pfid + " > a").attr("class", "menu2_off");
	var secondLevelMenuId = 'm2_' + fid;
	$("#" + secondLevelMenuId).attr("class", "menu2_on");
}

//退出应用
function logout() {
	if(client.browser.chrome != 0) {
		window.location.href = baseUrl + "f9902-s-1.do";
	} else {
		if (confirm("您确定要离开影像流历史库查询系统？")) {
			window.location.href = baseUrl + "f9902-s-1.do";
		}
	}
}