function save(baseUrl) {
	show_screen_shade();
	
	$.ajax (
		{
			type : "POST",
			async: false,
			url : "f9907-s-4.do",
			dataType : "json",
			data : $("#f9907-f-3").serialize(),
			success : function(f9907OutObject) {
				if (f9907OutObject.saveSuccess) {
					tipsInfoByJquery(["系统选项框信息新增成功."]);
				} else {
					tipsInfoByJquery(["出错了:" + f9907OutObject.errorMessage]);
				}
			}
		}
	);
}