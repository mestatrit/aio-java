function gotoPage(nPage, currentPage, totalPage, url) {
	// 首页
	if (nPage == 1) {
		if (currentPage != 1) {
			currentPage = 1;
		} else {
			tipsInfoByJquery(["已是首页"]);
			return false;
		}
	}
	// 上一页
	if (nPage == 2) {
		currentPage = currentPage - 1;
	}
	// 下一页
	if (nPage == 3) {
		currentPage = currentPage + 1;
	}
	// 尾页
	if (nPage == 4) {
		if (currentPage != totalPage) {
			currentPage = totalPage;
		} else {
			tipsInfoByJquery(["已是尾页"]);
			return false;
		}
	}
	if (currentPage > totalPage) {
		tipsInfoByJquery(["已是尾页"]);
		return false;
	}
	if (currentPage < 1) {
		tipsInfoByJquery(["已是首页"]);
		return false;
	}
	window.location.href = url + "?currentPage=" + currentPage;
	return true;
}

function gotonPage(totalPage, url) {
	var nPage = document.all('currentPage').value;
	if (nPage > totalPage || nPage < 1) {
		tipsInfoByJquery(["对不起，页数输入不正确!"]);
		return false;
	}
	window.location.href = url + "?currentPage=" + nPage;
}