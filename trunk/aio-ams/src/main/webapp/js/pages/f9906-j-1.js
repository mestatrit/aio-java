function insert(baseUrl) {
	window.location.href = "f9906-s-3.do";
}

function detail(baseUrl) {
	var mids = document.getElementsByName("mid");
	var count = 0;
	for(var i=0; i<mids.length; i++) {
		if(mids[i].checked) {
			count ++;
		}else{
			// do nothing
		}
	}
	if(count == 0) {
		tipsInfoByJquery(["请选择要查看的项目."]);
		return;
	}
	if(count > 1) {
		tipsInfoByJquery(["一次只能查看一个项目."]);
		return;
	}
	if(count == 1) {
		var queryForm = document.getElementById("f9906-f-1");
		queryForm.action = "f9906-s-5.do";
		queryForm.submit();
	}
}

function del(baseUrl) {
	var mids = document.getElementsByName("mid");
	var count = 0;
	for(var i=0; i<mids.length; i++) {
		if(mids[i].checked) {
			count ++;
		}else{
			// do nothing
		}
	}
	if(count == 0) {
		tipsInfoByJquery(["请选择要删除的项目."]);
		return;
	}

	if(confirm("确信要删除选定记录?")) {
		var queryForm = document.getElementById("f9906-f-1");
		queryForm.action = "f9906-s-6.do";
		queryForm.submit();
	}
}

function edit(baseUrl) {
	var mids = document.getElementsByName("mid");
	var count = 0;
	for(var i=0; i<mids.length; i++) {
		if(mids[i].checked) {
			count ++;
		}else{
			// do nothing
		}
	}
	if(count == 0) {
		tipsInfoByJquery(["请选择要编辑的项目."]);
		return;
	}
	if(count > 1) {
		tipsInfoByJquery(["一次只能编辑一个项目."]);
		return;
	}
	if(count == 1) {
		var queryForm = document.getElementById("f9906-f-1");
		queryForm.action = "f9906-s-7.do";
		queryForm.submit();
	}
}

