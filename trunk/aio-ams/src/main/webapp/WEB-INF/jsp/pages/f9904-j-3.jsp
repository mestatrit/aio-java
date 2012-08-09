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
<script type="text/javascript" src="js/pages/f9904-j-3.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// binds form submission and fields to the validation engine
		$("#f9904-f-3").validationEngine();
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
				<form id="f9904-f-3" action="f9904-s-4.do" method="post" class="niceform">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<th>功能代码</th>
							<td width="33%"><input type="text" id="sfFunctionId" name="sfFunctionId" class="validate[required,custom[onlyNumberSp],minSize[1],maxSize[20]]" size="20" /> <span><font color="red">*</font></span></td>
							<th width="17%">功能名称</th>
							<td width="34%"><input type="text" id="sfFunctionName" name="sfFunctionName" class="validate[required,maxSize[25]]" size="50" /> <span><font color="red">*</font></span></td>
						</tr>
						<tr>
							<th>上级功能</th>
							<td width="33%"><input type="text" id="sfParentId" name="sfParentId" class="validate[required,custom[onlyNumberSp],minSize[1],maxSize[20]]" size="20" /> <span><font color="red">*</font></span></td>
							<th width="17%">功能链接</th>
							<td width="34%"><input type="text" id="sfTargetUrl" name="sfTargetUrl" class="validate[minSize[1],maxSize[500]]" size="50" /></td>
						</tr>
						<tr>
							<th>按钮链接</th>
							<td width="33%"><input type="text" id="sfBtnUrl" name="sfBtnUrl" class="validate[minSize[1],maxSize[500]]" size="50" /></td>
							<th width="17%">显示序号</th>
							<td width="34%"><input type="text" id="sfSortFlag" name="sfSortFlag" class="validate[required,custom[onlyNumberSp],minSize[1],maxSize[3]]" size="5" /> <span><font color="red">*</font></span></td>
						</tr>
						<tr>
							<th>功能描述</th>
							<td width="33%"><input type="text" id="sfDescription" name="sfDescription" class="validate[maxSize[100]]" size="50" /></td>
							<th width="17%">是否导航菜单</th>
							<td width="34%"><j:PageSelect id="sfMenuFlag" name="sfMenuFlag" table="tbl_sys_sysfun" column="SF_MENU_FLAG" initValue="0" /></td>
						</tr>
						<tr>
							<th>是否页面按钮</th>
							<td width="33%"><j:PageSelect id="sfBtnFlag" name="sfBtnFlag" table="tbl_sys_sysfun" column="SF_BTN_FLAG" initValue="0" /></td>
							<th width="17%">支持快捷执行</th>
							<td width="34%"><j:PageSelect id="sfExecutbale" name="sfExecutbale" table="tbl_sys_sysfun" column="SF_EXECUTBALE" initValue="0" /></td>
						</tr>
					</table>
					<div class="button_mun">
						<ul>
							<li><a href="##" onclick="if(jQuery('#f9904-f-3').validationEngine('validate')){save('<%=basePath%>');};"><span>提交添加</span></a></li>
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