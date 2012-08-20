function save(baseUrl) {
	show_screen_shade();
	
	$.ajax (
		{
			type : "POST",
			async: false,
			url : "f9999-s-1.do",
			dataType : "json",
			data : $("#f9999-f-0").serialize(),
			success : function(f9999OutObject) {
				if (f9999OutObject.editSuccess) {
					tipsInfoByJquery(["您的登录密码修改成功."]);
				} else {
					tipsInfoByJquery(["出错了:" + f9999OutObject.errorMessage]);
				}
			}
		}
	);
}