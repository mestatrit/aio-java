function save(baseUrl) {
	show_screen_shade();
	
	$.ajax (
		{
			type : "POST",
			async: false,
			url : "f9905-s-8.do",
			dataType : "json",
			data : $("#f9905-f-7").serialize(),
			success : function(f9905OutObject) {
				if (f9905OutObject.editSuccess) {
					tipsInfoByJquery(["系统角色信息修改成功."]);
				} else {
					tipsInfoByJquery(["出错了:" + f9905OutObject.errorMessage]);
				}
			}
		}
	);
}