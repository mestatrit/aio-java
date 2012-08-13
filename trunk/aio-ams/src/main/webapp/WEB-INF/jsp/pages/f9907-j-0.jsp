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
<script type="text/javascript" src="js/pages/f9907-j-1.js"></script>
<script type="text/javascript">
	var baseUrl = '<%=basePath%>';
	$(document).ready(function() {
		// binds form submission and fields to the validation engine
		$("#f9907-f-0").validationEngine();
	});
</script>
</head>

<body class="main_body">
	<div class="main">
		<j:PageHeader contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageMenu contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageSpace contextPath="<%=contextPath%>" basePath="<%=basePath%>" />

		<div class=content>
			<form id="f9907-f-0" action="f9907-s-1.do" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="query_criterion">
				<tbody>
					<tr>
						<th width="20%">选项表名</th>
						<td><input type="text" id="ovTblName" name="ovTblName" class="validate[maxSize[100]]" size="25" /></td>
						<th width="20%">选项列名</th>
						<td><input type="text" id="ovColName" name="ovColName" class="validate[maxSize[100]]" size="25" /></td>
					</tr>
					<tr>
						<th width="20%">选项标签</th>
						<td><input type="text" id="ovOptLabel" name="ovOptLabel" class="validate[maxSize[100]]" size="25" /></td>
						<th width="20%">选项值</th>
						<td><input type="text" id="ovOptValue" name="ovOptValue" class="validate[maxSize[100]]" size="25" /></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4" align="right">
							<input type="button" name="button" id="button" value="搜索 " onclick="if(jQuery('#f9907-f-0').validationEngine('validate')){submitByFormId('f9907-f-0')};" />
						</td>
					</tr>
				</tfoot>
			</table>
			</form>
			<hr />
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><j:PageButton pageFunctionId="9907" basePath="<%=basePath %>" contextPath="<%=contextPath %>"/></td>
				</tr>
			</table>
			<hr />
			<form id="f9907-f-1" action="" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="query_result">
			<thead>
				<tr>
					<th><a href="#" target="_self" class="underlined" id="checkAll" onclick="checkAllOrCheckNone();">全选</a></th>
					<th>选项表名</th>
					<th>选项列名</th>
					<th>选项标签</th>
					<th>选项值</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${pageQuery.totalSize == 0}">
					<tr>
						<td colspan="5">查询无记录.</td>
					</tr>
				</c:if>
				<c:if test="${pageQuery != null}">
					<c:if test="${pageQuery.totalSize != 0}">
						<c:forEach items="${pageQuery.pagedata}" var="sysopt" varStatus="status">
							<tr <c:if test="${status.index % 2 == 0}">class="even"</c:if><c:if test="${status.index % 2 != 0}">class="odd"</c:if>>
								<td><input name="mid" type="checkbox" value="${sysopt.ovId }" /></td>
								<td>${sysopt.ovTblName }</td>
								<td>${sysopt.ovColName }</td>
								<td>${sysopt.ovOptLabel }</td>
								<td>${sysopt.ovOptValue }</td>
							</tr>
						</c:forEach>
					</c:if>
				</c:if>
			</tbody>
			</table>
			</form>
		</div>
		<j:PageQuery pageURL="f9907-s-2.do" basePath="<%=basePath%>" contextPath="<%=contextPath%>" />
		<j:PageBottomAndCopyright contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageTips />
	</div>
</body>
</html>