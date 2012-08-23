function save(baseUrl) {
	show_screen_shade();
	
	$.ajax (
		{
			type : "POST",
			async: false,
			url : "f9908-s-4.do",
			dataType : "json",
			data : $("#f9908-f-3").serialize(),
			success : function(f9908OutObject) {
				if (f9908OutObject.saveSuccess) {
					tipsInfoByJquery(["系统公告信息新增成功."]);
				} else {
					tipsInfoByJquery(["出错了:" + f9908OutObject.errorMessage]);
				}
			}
		}
	);
}