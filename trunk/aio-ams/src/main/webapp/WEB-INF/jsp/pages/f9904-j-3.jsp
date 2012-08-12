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
<script type="text/javascript" src="js/pages/f9904-j-3.js"></script>
<script type="text/javascript">
	var baseUrl = '<%=basePath%>';
	$(document).ready(function() {
		// binds form submission and fields to the validation engine
		$("#f9904-f-3").validationEngine();
	});
</script>
</head>

<body class="main_body">
	<div class="main">
		<j:PageHeader contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageMenu contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
		<j:PageSpace contextPath="<%=contextPath%>" basePath="<%=basePath%>" />

		<div class=content>
			<form id="f9904-f-3" action="f9904-s-4.do" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<th width="40%">功能代码</th>
						<td><input type="text" id="sfFunctionId" name="sfFunctionId" class="validate[required,custom[onlyNumberSp],minSize[1],maxSize[20]]" size="20" /> <span><font color="red">*</font></span></td>
					</tr>
					<tr>
						<th>功能名称</th>
						<td><input type="text" id="sfFunctionName" name="sfFunctionName" class="validate[required,maxSize[25]]" size="50" /> <span><font color="red">*</font></span></td>
					</tr>
					<tr>
						<th>上级功能</th>
						<td><input type="text" id="sfParentId" name="sfParentId" class="validate[required,custom[onlyNumberSp],minSize[1],maxSize[20]]" size="20" /> <span><font color="red">*</font></span></td>
					</tr>
					<tr>
						<th>功能链接</th>
						<td><input type="text" id="sfTargetUrl" name="sfTargetUrl" class="validate[minSize[1],maxSize[500]]" size="50" /></td>
					</tr>
					<tr>
						<th>按钮链接</th>
						<td><input type="text" id="sfBtnUrl" name="sfBtnUrl" class="validate[minSize[1],maxSize[500]]" size="50" /></td>
					</tr>
					<tr>
						<th>显示序号</th>
						<td><input type="text" id="sfSortFlag" name="sfSortFlag" class="validate[required,custom[onlyNumberSp],minSize[1],maxSize[3]]" size="5" /> <span><font color="red">*</font></span></td>
					</tr>
					<tr>
						<th>功能描述</th>
						<td><input type="text" id="sfDescription" name="sfDescription" class="validate[maxSize[100]]" size="50" /></td>
					</tr>
					<tr>
						<th>是否导航菜单</th>
						<td><j:PageSelect id="sfMenuFlag" name="sfMenuFlag" table="tbl_sys_sysfun" column="SF_MENU_FLAG" initValue="0" /></td>
					</tr>
					<tr>
						<th>是否页面按钮</th>
						<td><j:PageSelect id="sfBtnFlag" name="sfBtnFlag" table="tbl_sys_sysfun" column="SF_BTN_FLAG" initValue="0" /></td>
					</tr>
					<tr>
						<th>支持快捷执行</th>
						<td><j:PageSelect id="sfExecutbale" name="sfExecutbale" table="tbl_sys_sysfun" column="SF_EXECUTBALE" initValue="0" /></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th colspan="2"><a onclick="if(jQuery('#f9904-f-3').validationEngine('validate')){save('');};" style="cursor:pointer;">保存</a> <a onclick="window.history.go(-1);" style="cursor:pointer;">返回</a></th>
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