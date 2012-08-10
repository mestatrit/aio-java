<%@ include file="/WEB-INF/jsp/include/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>影像流历史库查询系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" type="image/x-icon" href="images/history_query.ico" />
<link rel="stylesheet" href="css/default_style.css" type="text/css" />
<link rel="stylesheet" href="js/jquery_1.6.4/validationEngine.jquery.css" type="text/css" />
<script type="text/javascript" src="js/jquery_1.6.4/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="js/jquery_1.6.4/jquery.validationEngine.js"></script>
<script type="text/javascript" src="js/jquery_1.6.4/languages/jquery.validationEngine-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/client.js"></script>
<script type="text/javascript" src="js/EventUtil.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript">
	var baseUrl = '<%=basePath%>';
	$(document).ready(function() {
		// binds form submission and fields to the validation engine
		$("#f9904-f-0").validationEngine();
		//submitByFormId('f9904-f-0');
	});
</script>
</head>

<body class="main_body">
	<div class="main">
		<j:PageHeader contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageMenu contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageSpace contextPath="<%=contextPath%>" basePath="<%=basePath%>" />

		<div class="middle">
			<form id="f9904-f-0" action="f9904-s-1.do" method="post" class="niceform">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th width="16%">功能代码</th>
						<td><input type="text" id="sfFunctionId" name="sfFunctionId" class="validate[custom[onlyNumberSp],minSize[1],maxSize[20]]" size="25" /></td>
					</tr>
					<tr>
						<th width="16%">功能名称</th>
						<td><input type="text" id="sfFunctionName" name="sfFunctionName" class="validate[maxSize[50]]" size="25" /></td>
					</tr>
				</table>
				<div class="button_mun2">
					<input type="button" name="button" id="button" value="搜索 " onclick="if(jQuery('#f9904-f-0').validationEngine('validate')){submitByFormId('f9904-f-0')};" />
				</div>
			</form>
			<hr />
			<form id="f9904-f-1" action="f9904-s-2.do" method="post">
				<table class="queryResult">
					<thead>
						<tr>
							<td colspan="3"></td>
						</tr>
						<tr>
							<th><a href="#" target="_self" class="underlined" id="checkAll" onclick="checkAllOrCheckNone();">全选</a></th>
							<th>功能代码</th>
							<th>功能名称</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${pageQuery.totalSize == 0}">
							<tr>
								<td colspan="3" nowrap="nowrap">查询无记录.</td>
							</tr>
						</c:if>
						<c:if test="${pageQuery != null}">
							<c:if test="${pageQuery.totalSize != 0}">
								<c:forEach items="${pageQuery.pagedata}" var="sysfunc">
									<tr>
										<td nowrap="nowrap" width="10%"><input name="mid" type="checkbox" value="${sysfunc.sfId }" /></td>
										<td nowrap="nowrap">${sysfunc.sfFunctionId }</td>
										<td nowrap="nowrap">${sysfunc.sfFunctionName }</td>
									</tr>
								</c:forEach>
							</c:if>
						</c:if>
					</tbody>
				</table>
			</form>
		</div>
		<j:PageBottomAndCopyright contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
	</div>
</body>
</html>