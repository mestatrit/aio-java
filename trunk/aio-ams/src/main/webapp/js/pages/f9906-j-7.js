function save(baseUrl) {
$.ajax (
	{
		type : "POST",
		async: false,
		url : "f9906-s-8.do",
		dataType : "json",
		data : $("#f9906-f-7").serialize(),
		success : function(f9906OutObject) {
			if (f9906OutObject.editSuccess) {
				tipsInfoByJquery(["系统用户信息修改成功."]);
			} else {
				tipsInfoByJquery(["出错了:" + f9906OutObject.errorMessage]);
			}
		}
	}
);
}