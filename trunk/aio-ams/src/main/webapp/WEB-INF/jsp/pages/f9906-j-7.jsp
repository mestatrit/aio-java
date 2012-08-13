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
<script type="text/javascript" src="js/pages/f9906-j-7.js"></script>
<script type="text/javascript">
	var baseUrl = '<%=basePath%>';
	$(document).ready(function() {
		// binds form submission and fields to the validation engine
		$("#f9906-f-7").validationEngine();
	});
</script>
</head>

<body class="main_body">
	<div class="main">
		<j:PageHeader contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageMenu contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageSpace contextPath="<%=contextPath%>" basePath="<%=basePath%>" />

		<div class=content>
		<form id="f9906-f-7" action="f9906-s-8.do" method="post">
		<input type="hidden" id="uiId" name="uiId" value="${f9906OutObject.tblSysUsrinf.uiId }" />
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<th nowrap="nowrap">用户ID</th>
					<td nowrap="nowrap"><input type="text" id="uiUserId" name="uiUserId" size="20" value="${f9906OutObject.tblSysUsrinf.uiUserId }" readonly="readonly" /></td>
				</tr>
				<tr>
					<th nowrap="nowrap">用户密码</th>
					<td nowrap="nowrap"><input type="text" id="uiUserPwd" name="uiUserPwd" class="validate[required,custom[onlyNumberSp],minSize[1],maxSize[8]]" value="${f9906OutObject.tblSysUsrinf.uiUserPwd }" size="8" readonly="readonly"/></td>
				</tr>
				<tr>
					<th nowrap="nowrap">用户角色</th>
					<td nowrap="nowrap"><j:PageSelectAnywhere id="userRoleId" name="userRoleId" dataService="sysRoleService" labelColumn="srRoleName" valueColumn="srRoleId" initValue="${f9906OutObject.userRole }" /> <span><font color="red">*</font></span></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2"><a onclick="if(jQuery('#f9906-f-7').validationEngine('validate')){save('');};" style="cursor:pointer;">修改</a>  <a onclick="window.history.go(-1);" style="cursor:pointer;">返回</a></th>
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