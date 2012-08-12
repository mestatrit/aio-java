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
<script type="text/javascript" src="js/pages/f9904-j-5.js"></script>
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
			<table width="100%" border="1" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th colspan="2">系统功能详细信息</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th width="50%">功能代码</th>
					<td>${f9904OutObject.tblSysSysfun.sfFunctionId }</td>
				</tr>
				<tr>
					<th>功能名称</th>
					<td>${f9904OutObject.tblSysSysfun.sfFunctionName }</td>
				</tr>
				<tr>
					<th>上级功能</th>
					<td>${f9904OutObject.tblSysSysfun.sfParentId }</td>
				</tr>
				<tr>
					<th>功能链接</th>
					<td>${f9904OutObject.tblSysSysfun.sfTargetUrl }</td>
				</tr>
				<tr>
					<th>按钮链接</th>
					<td>${f9904OutObject.tblSysSysfun.sfBtnUrl }</td>
				</tr>
				<tr>
					<th>显示序号</th>
					<td>${f9904OutObject.tblSysSysfun.sfSortFlag }</td>
				</tr>
				<tr>
					<th>功能描述</th>
					<td>${f9904OutObject.tblSysSysfun.sfDescription }</td>
				</tr>
				<tr>
					<th>是否导航菜单</th>
					<td><j:PageTranslate table="tbl_sys_sysfun" column="SF_MENU_FLAG" initValue="${f9904OutObject.tblSysSysfun.sfMenuFlag }" /></td>
				</tr>
				<tr>
					<th>是否页面按钮</th>
					<td><j:PageTranslate table="tbl_sys_sysfun" column="SF_BTN_FLAG" initValue="${f9904OutObject.tblSysSysfun.sfBtnFlag }" /></td>
				</tr>
				<tr>
					<th>支持快捷执行</th>
					<td><j:PageTranslate table="tbl_sys_sysfun" column="SF_EXECUTBALE" initValue="${f9904OutObject.tblSysSysfun.sfExecutbale }" /></td>
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