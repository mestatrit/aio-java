<%@ include file="/WEB-INF/jsp/include/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>影像流历史库查询系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<div>
		<h1>系统出错：</h1>
		<hr />
		<%
			Exception e = (Exception) request.getAttribute("exception");
			// 显示系统错误码
			if(e instanceof AppException) {
				out.print(((AppException)e).getErrorCode());
			}
			// 显示错误信息
			if(e != null) {
				out.print(e.getMessage());
			}
		%>
		<hr />
		如错误影响到您的进一步操作,请及时联系技术人员解决问题,电话：021-66666666。
		<hr />
		<input type="button" value="返回" onclick="window.history.go(-1);" style="cursor:pointer;" />
	</div>
</body>
</html>