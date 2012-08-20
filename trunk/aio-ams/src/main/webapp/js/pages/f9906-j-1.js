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
		tipsInfoByJquery(["请选择要查看的用户."]);
		return;
	}
	if(count > 1) {
		tipsInfoByJquery(["一次只能查看一个用户."]);
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
		tipsInfoByJquery(["请选择要删除的用户."]);
		return;
	}

	if(confirm("确信要删除选定用户?")) {
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
		tipsInfoByJquery(["请选择要修改角色的用户."]);
		return;
	}
	if(count > 1) {
		tipsInfoByJquery(["一次只能修改一个用户的角色."]);
		return;
	}
	if(count == 1) {
		var queryForm = document.getElementById("f9906-f-1");
		queryForm.action = "f9906-s-7.do";
		queryForm.submit();
	}
}

function resetpwd(baseUrl) {
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
		tipsInfoByJquery(["请选择要重置密码的用户."]);
		return;
	}
	if(count > 1) {
		tipsInfoByJquery(["一次只能重置一个用户的密码."]);
		return;
	}
	if(count == 1) {
		var queryForm = document.getElementById("f9906-f-1");
		queryForm.action = "f9906-s-9.do";
		queryForm.submit();
	}
}

