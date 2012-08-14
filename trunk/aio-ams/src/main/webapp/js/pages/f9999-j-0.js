function save(baseUrl) {
	$.ajax (
		{
			type : "POST",
			async: false,
			url : "f9999-s-1.do",
			dataType : "json",
			data : $("#f9999-f-0").serialize(),
			success : function(f9999OutObject) {
				if (f9999OutObject.editSuccess) {
					tipsInfoByJquery(["用户密码修改成功."]);
				} else {
					tipsInfoByJquery(["出错了:" + f9999OutObject.errorMessage]);
				}
			}
		}
	);
}