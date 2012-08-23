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
<script type="text/javascript" src="js/tips.js"></script>
<script type="text/javascript" src="js/pageQuery.js"></script>
<script type="text/javascript" src="js/pages/f9908-j-1.js"></script>
<script type="text/javascript">
	var baseUrl = '<%=basePath%>';
	$(document).ready(function() {
		// binds form submission and fields to the validation engine
		$("#f9908-f-0").validationEngine();
	});
</script>
</head>

<body class="main_body">
	<div class="main">
		<j:PageHeader contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageMenu contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageSpace contextPath="<%=contextPath%>" basePath="<%=basePath%>" />

		<div class=content>
			<form id="f9908-f-0" action="f9908-s-1.do" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="query_criterion">
				<tbody>
					<tr>
						<th width="20%">标题</th>
						<td><input type="text" id="btTitle" name="btTitle" class="validate[maxSize[100]]" size="25" /></td>
						<th width="20%"></th>
						<td></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4" align="right">
							<input type="button" name="button" value="查找 " onclick="if(jQuery('#f9908-f-0').validationEngine('validate')){submitByFormId('f9908-f-0')};" />
						</td>
					</tr>
				</tfoot>
			</table>
			</form>
			<hr />
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><j:PageButton pageFunctionId="9908" basePath="<%=basePath %>" contextPath="<%=contextPath %>"/></td>
				</tr>
			</table>
			<hr />
			<form id="f9908-f-1" action="" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="query_result">
			<thead>
				<tr>
					<th><a href="#" target="_self" class="underlined" id="checkAll" onclick="checkAllOrCheckNone();">全选</a></th>
					<th>发布时间</th>
					<th>标题</th>
					<th>内容</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${pageQuery.totalSize == 0}">
					<tr>
						<td colspan="4">查询无记录.</td>
					</tr>
				</c:if>
				<c:if test="${pageQuery != null}">
					<c:if test="${pageQuery.totalSize != 0}">
						<c:forEach items="${pageQuery.pagedata}" var="sysbull" varStatus="status">
							<tr <c:if test="${status.index % 2 == 0}">class="even"</c:if><c:if test="${status.index % 2 != 0}">class="odd"</c:if>>
								<td><input name="mid" type="checkbox" value="${sysbull.btId }" /></td>
								<td>${sysbull.btCreateDate }</td>
								<td>${sysbull.btTitle }</td>
								<td>${sysbull.btContent }</td>
							</tr>
						</c:forEach>
					</c:if>
				</c:if>
			</tbody>
			</table>
			</form>
		</div>
		<j:PageQuery pageURL="f9908-s-2.do" basePath="<%=basePath%>" contextPath="<%=contextPath%>" />
		<j:PageBottomAndCopyright contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageTips />
	</div>
</body>
</html>