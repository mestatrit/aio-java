function save(baseUrl) {
$.ajax (
	{
		type : "POST",
		async: false,
		url : "f9905-s-4.do",
		dataType : "json",
		data : $("#f9905-f-3").serialize(),
		success : function(f9905OutObject) {
			if (f9905OutObject.saveSuccess) {
				tipsInfoByJquery(["系统角色信息保存成功."]);
			} else {
				tipsInfoByJquery(["出错了:" + f9905OutObject.errorMessage]);
			}
		}
	}
);
}