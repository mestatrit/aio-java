function save(baseUrl) {
$.ajax (
	{
		type : "POST",
		async: false,
		url : "f9906-s-4.do",
		dataType : "json",
		data : $("#f9906-f-3").serialize(),
		success : function(f9906OutObject) {
			if (f9906OutObject.saveSuccess) {
				tipsInfoByJquery(["系统用户信息新增成功."]);
			} else {
				tipsInfoByJquery(["出错了:" + f9906OutObject.errorMessage]);
			}
		}
	}
);
}