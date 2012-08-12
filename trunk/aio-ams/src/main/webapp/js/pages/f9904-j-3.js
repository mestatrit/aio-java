function save(baseUrl) {
$.ajax (
	{
		type : "POST",
		async: false,
		url : "f9904-s-4.do",
		dataType : "json",
		data : $("#f9904-f-3").serialize(),
		success : function(f9904OutObject) {
			if (f9904OutObject.saveSuccess) {
				tipsInfoByJquery(["系统功能保存成功."]);
			} else {
				tipsInfoByJquery(["出错了:" + f9904OutObject.errorMessage]);
			}
		}
	}
);
}