function save(baseUrl) {
	show_screen_shade();
	
	$.ajax (
		{
			type : "POST",
			async: false,
			url : "f9904-s-8.do",
			dataType : "json",
			data : $("#f9904-f-7").serialize(),
			success : function(f9904OutObject) {
				if (f9904OutObject.editSuccess) {
					tipsInfoByJquery(["系统功能修改成功."]);
				} else {
					tipsInfoByJquery(["出错了:" + f9904OutObject.errorMessage]);
				}
			}
		}
	);
}