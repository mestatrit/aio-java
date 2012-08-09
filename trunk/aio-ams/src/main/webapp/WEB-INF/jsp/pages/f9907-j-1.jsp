<%@ include file="/WEB-INF/jsp/include/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>影像流历史库查询系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="Fri, 12 Jan 2001 18:18:18 GMT" />

<link rel="stylesheet" href="css/lib/style_default.css" media="screen" />
<link href="js/lib/jquery_1.6.4/validationEngine.jquery.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/lib/jquery_1.6.4/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="js/lib/jquery_1.6.4/jquery.validationEngine.js"></script>
<script type="text/javascript" src="js/lib/jquery_1.6.4/languages/jquery.validationEngine-zh_CN.js"></script>
<script type="text/javascript" src="js/lib/menu.js"></script>
<script type="text/javascript" src="js/lib/common.js"></script>
<script type="text/javascript" src="js/lib/tips.js"></script>
<script type="text/javascript" src="js/pages/f9907-j-1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
</head>

<body>
	<div class="content">
		<div class="header">
			<j:PageHeader contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		</div>
		<div class="menubar">
			<j:PageMenu contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		</div>
		<div class="outer">
			<j:PageStart contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
			<div class="box_form">
				<form id="f9907-f-0" action="f9907-s-1.do" method="post" class="niceform">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<th width="16%">选项表名</th>
							<td><input type="text" id="ovTblName" name="ovTblName" class="validate[maxSize[100]]" size="25" /></td>
						</tr>
						<tr>
							<th width="16%">选项列名</th>
							<td><input type="text" id="ovColName" name="ovColName" class="validate[maxSize[100]]" size="25" /></td>
						</tr>
						<tr>
							<th width="16%">选项标签</th>
							<td><input type="text" id="ovOptLabel" name="ovOptLabel" class="validate[maxSize[100]]" size="25" /></td>
						</tr>
						<tr>
							<th width="16%">选项值</th>
							<td><input type="text" id="ovOptValue" name="ovOptValue" class="validate[maxSize[100]]" size="25" /></td>
						</tr>
					</table>
					<div class="button_mun2">
						<input type="button" name="button" id="button" value="搜索 " onclick="if(jQuery('#f9907-f-0').validationEngine('validate')){submitByFormId('f9907-f-0');}" />
					</div>
				</form>
			</div>
			<br />
			<div class="box_table">
				<form id="f9907-f-1" action="" method="post" class="niceform">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<th><a href="#" target="_self" class="underlined" id="checkAll" onclick="checkAllOrCheckNone();">全选</a></th>
							<th>选项表名</th>
							<th>选项列名</th>
							<th>选项标签</th>
							<th>选项值</th>
						</tr>
						<c:if test="${pageQuery.totalSize == 0}">
							<tr>
								<td colspan="5">查询无记录.</td>
							</tr>
						</c:if>
						<c:if test="${pageQuery != null}">
							<c:if test="${pageQuery.totalSize != 0}">
								<c:forEach items="${pageQuery.pagedata}" var="sysopt">
									<tr>
										<td><input name="mid" type="checkbox" value="${sysopt.ovId }" /></td>
										<td>${sysopt.ovTblName }</td>
										<td>${sysopt.ovColName }</td>
										<td>${sysopt.ovOptLabel }</td>
										<td>${sysopt.ovOptValue }</td>
									</tr>
								</c:forEach>
							</c:if>
						</c:if>
					</table>
				</form>
			</div>

			<j:PageQuery pageURL="f9907-s-2.do" contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
			<j:PageButton pageFunctionId="9907" contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
			<j:PageTips />
		</div>
		<div class="foot">Copyright &copy;2012 Shanghai cdpc Software System Co., Ltd.All Rights Reserved.</div>
	</div>
</body>
</html>