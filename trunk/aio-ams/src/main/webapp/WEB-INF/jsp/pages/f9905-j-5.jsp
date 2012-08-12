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
<script type="text/javascript" src="js/pages/f9905-j-5.js"></script>
<script type="text/javascript" src="js/dtree_checkbox/dtree.js"></script>
<script type="text/javascript">
	var baseUrl = '<%=basePath%>';
</script>
</head>

<body class="main_body">
	<div class="main">
		<j:PageHeader contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageMenu contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageSpace contextPath="<%=contextPath%>" basePath="<%=basePath%>" />

		<div class=content>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tbody>
			<tr>
				<th>角色代码</th>
				<td>${f9905OutObject.tblSysSysrol.srRoleId }</td>
			</tr>
			<tr>
				<th>角色名称</th>
				<td>${f9905OutObject.tblSysSysrol.srRoleName }</td>
			</tr>
			<tr>
				<th>角色权限</th>
				<td><j:SystemRightTree checkName="checkedRights" isEdit="true" roleId="${f9905OutObject.tblSysSysrol.srRoleId }" basePath="<%=basePath%>" contextPath="<%=contextPath%>" /></td>
			</tr>
			<tr>
				<th>上次修改用户</th>
				<td>${f9905OutObject.tblSysSysrol.srLstModiUserId }</td>
			</tr>
			<tr>
				<th>上次修改时间</th>
				<td>${f9905OutObject.tblSysSysrol.srLstModiDate }</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="2"><a onclick="window.history.go(-1);" style="cursor:pointer;">返回</a></th>
			</tr>
		</tfoot>
		</table>
		</div>
		<j:PageBottomAndCopyright contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageTips />
	</div>
</body>
</html>