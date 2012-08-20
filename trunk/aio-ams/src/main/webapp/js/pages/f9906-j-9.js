function save(baseUrl) {
	show_screen_shade();
	
	$.ajax (
	   {
			type : "POST",
			async: false,
			url : "f9906-s-10.do",
			dataType : "json",
			data : $("#f9906-f-9").serialize(),
			success : function(f9906OutObject) {
				if (f9906OutObject.editSuccess) {
					tipsInfoByJquery(["用户密码重置成功."]);
				} else {
					tipsInfoByJquery(["出错了:" + f9906OutObject.errorMessage]);
				}
			}
		}
	);
}