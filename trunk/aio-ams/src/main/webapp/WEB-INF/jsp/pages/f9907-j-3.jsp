<%@ include file="/WEB-INF/jsp/include/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ams管理系统</title>
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
<script type="text/javascript" src="js/pages/f9907-j-3.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// binds form submission and fields to the validation engine
		$("#f9907-f-3").validationEngine();
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
				<form id="f9907-f-3" action="f9907-s-4.do" method="post" class="niceform">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<th>选项表名</th>
							<td width="33%"><input type="text" id="ovTblName" name="ovTblName" class="validate[required,minSize[1],maxSize[100]]" size="50" /> <span><font color="red">*</font></span></td>
							<th width="17%">选项列名</th>
							<td width="34%"><input type="text" id="ovColName" name="ovColName" class="validate[required,minSize[1],maxSize[100]]" size="50" /> <span><font color="red">*</font></span></td>
						</tr>
						<tr>
							<th>选项标签</th>
							<td width="33%"><input type="text" id="ovOptLabel" name="ovOptLabel" class="validate[required,minSize[1],maxSize[100]]" size="50" /> <span><font color="red">*</font></span></td>
							<th width="17%">选项值</th>
							<td width="34%"><input type="text" id="ovOptValue" name="ovOptValue" class="validate[required,minSize[1],maxSize[100]]" size="50" /> <span><font color="red">*</font></span></td>
						</tr>
					</table>
					<div class="button_mun">
						<ul>
							<li><a href="##" onclick="if(jQuery('#f9907-f-3').validationEngine('validate')){save('<%=basePath%>');};"><span>提交添加</span></a></li>
							<li><a href="##" onclick="history.go(-1);"><span>返回</span></a></li>
						</ul>
					</div>
				</form>
			</div>
			<j:PageTips />
		</div>
		<div class="foot">Copyright &copy;2012 Shanghai cdpc Software System Co., Ltd.All Rights Reserved.</div>
	</div>
</body>
</html>