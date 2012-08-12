function save(baseUrl) {
$.ajax (
	{
		type : "POST",
		async: false,
		url : "f9907-s-8.do",
		dataType : "json",
		data : $("#f9907-f-7").serialize(),
		success : function(f9907OutObject) {
			if (f9907OutObject.editSuccess) {
				tipsInfoByJquery(["系统选项框信息修改成功."]);
			} else {
				tipsInfoByJquery(["出错了:" + f9907OutObject.errorMessage]);
			}
		}
	}
);
}