// JavaScript Document

function show_date_time() {
	var current_date = new Date();
	var yea = current_date.getYear();
	var mon = current_date.getMonth() + 1;
	var day = current_date.getDate();
	
	var hour = current_date.getHours();
	var minu = current_date.getMinutes();
	var seco = current_date.getSeconds();
	
	// 日期
	if(mon <= 9) {
		$("#months_n_1").attr("src", "images/n_0.png");
		$("#months_n_2").attr("src", "images/n_" + mon + ".png");
	} else {
		$("#months_n_1").attr("src", "images/n_" + Math.floor(mon / 10) + ".png");
		$("#months_n_2").attr("src", "images/n_" + (mon % 10) + ".png");
	}
	
	if(day <= 9) {
		$("#days_n_1").attr("src", "images/n_0.png");
		$("#days_n_2").attr("src", "images/n_" + day + ".png");
	} else {
		$("#days_n_1").attr("src", "images/n_" + Math.floor(day / 10) + ".png");
		$("#days_n_2").attr("src", "images/n_" + (day % 10) + ".png");
	}
	
	// 时间
	if(hour <= 9) {
		$("#hours_n_1").attr("src", "images/n_0.png");
		$("#hours_n_2").attr("src", "images/n_" + hour + ".png");
	} else {
		$("#hours_n_1").attr("src", "images/n_" + Math.floor(hour / 10) + ".png");
		$("#hours_n_2").attr("src", "images/n_" + (hour % 10) + ".png");
	}
	
	if(minu <= 9) {
		$("#minutes_n_1").attr("src", "images/n_0.png");
		$("#minutes_n_2").attr("src", "images/n_" + minu + ".png");
	} else {
		$("#minutes_n_1").attr("src", "images/n_" + Math.floor(minu / 10) + ".png");
		$("#minutes_n_2").attr("src", "images/n_" + (minu % 10) + ".png");
	}
	
	setTimeout("show_date_time()", 1000);
}

setTimeout("show_date_time()", 1);