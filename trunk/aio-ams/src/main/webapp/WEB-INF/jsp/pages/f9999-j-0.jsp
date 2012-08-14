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
<script type="text/javascript" src="js/pages/f9999-j-0.js"></script>
<script type="text/javascript">
	var baseUrl = '<%=basePath%>';
	$(document).ready(function() {
		// binds form submission and fields to the validation engine
		$("#f9999-f-0").validationEngine();
	});
</script>
</head>

<body class="main_body">
	<div class="main">
		<j:PageHeader contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageMenu contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageSpace contextPath="<%=contextPath%>" basePath="<%=basePath%>" />

		<div class=content>
		<form id="f9999-f-0" action="f9999-s-1.do" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="edit_table">
			<tbody>
				<tr>
					<th>当前密码</th>
					<td><input type="password" id="oldUserPwd" name="oldUserPwd" class="validate[required,custom[onlyNumberSp],minSize[1],maxSize[8]]" size="20" /> <span><font color="red">*</font></span></td>
				</tr>
				<tr>
					<th>新密码</th>
					<td><input type="password" id="newUserPwd" name="newUserPwd" class="validate[required,custom[onlyNumberSp],minSize[1],maxSize[8]]" size="20" /> <span><font color="red">*</font></span></td>
				</tr>
				<tr>
					<th>新密码(再次输入)</th>
					<td><input type="password" id="newUserPwd2" name="newUserPwd2" class="validate[required,custom[onlyNumberSp],minSize[1],maxSize[8]]" size="20" /> <span><font color="red">*</font></span></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="button" name="button" value="修改 " onclick="if(jQuery('#f9999-f-0').validationEngine('validate')){save('');};" />
						<input type="button" name="button" value="返回 " onclick="window.history.go(-1);" />
					</td>
				</tr>
			</tfoot>
		</table>
		</form>
		</div>
		<j:PageBottomAndCopyright contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageTips />
	</div>
</body>
</html>