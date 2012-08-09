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
		<h1>出错了</h1>
		<h2>
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
		</h2>
	</div>
</body>
</html>