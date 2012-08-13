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
<script type="text/javascript" src="js/pages/f9905-j-7.js"></script>
<script type="text/javascript" src="js/dtree_checkbox/dtree.js"></script>
<script type="text/javascript">
	var baseUrl = '<%=basePath%>';
	$(document).ready(function() {
		// binds form submission and fields to the validation engine
		$("#f9905-f-3").validationEngine();
	});
</script>
</head>

<body class="main_body">
	<div class="main">
		<j:PageHeader contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageMenu contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageSpace contextPath="<%=contextPath%>" basePath="<%=basePath%>" />

		<div class=content>
			<form id="f9905-f-7" action="f9905-s-8.do" method="post">
			<input type="hidden" id="srId" name="srId" value="${f9905OutObject.tblSysSysrol.srId }" />
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="edit_table">
				<tbody>
					<tr>
						<th width="35%">角色代码</th>
						<td><input type="text" id="srRoleId" name="srRoleId" class="validate[required,minSize[1],maxSize[10]]" size="10" value="${f9905OutObject.tblSysSysrol.srRoleId }" /> <span><font color="red">*</font></span></td>
					</tr>
					<tr>
						<th>角色名称</th>
						<td><input type="text" id="srRoleName" name="srRoleName" class="validate[required,minSize[1],maxSize[20]]" size="20" value="${f9905OutObject.tblSysSysrol.srRoleName }" /> <span><font color="red">*</font></span></td>
					</tr>
					<tr>
						<th>角色权限</th>
						<td><j:SystemRightTree checkName="checkedRights" isEdit="true" roleId="${f9905OutObject.tblSysSysrol.srRoleId }" basePath="<%=basePath%>" contextPath="<%=contextPath%>" /></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" name="button" value="修改 " onclick="if(jQuery('#f9905-f-7').validationEngine('validate')){save('');};" style="cursor:pointer;" /> 
							<input type="button" name="button" value="返回" onclick="window.history.go(-1);" style="cursor:pointer;" />
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