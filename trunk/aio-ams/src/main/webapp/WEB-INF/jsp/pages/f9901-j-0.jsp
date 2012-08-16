<%@ include file="/WEB-INF/jsp/include/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>影像流历史库查询系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" type="image/x-icon" href="images/history_query.ico" />
<link rel="stylesheet" href="css/default_style.css" />
<script type="text/javascript" src="js/jquery_1.6.4/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/client.js"></script>
<script type="text/javascript" src="js/EventUtil.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript">
	var baseUrl = '<%=basePath %>';
</script>
</head>

<body class="main_body">
<div class="main">
	<j:PageHeader contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
	<j:PageMenu contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
	<j:PageSpace contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
  	 	
    <div class="middle">
        <div class="middle_left">
            <div class="middle_left_top">
            	<div class="dashboardpanel">
                    <h3><img width="16" height="15" src="images/ico_1.gif" />用户信息</h3>
                    <div class="dashboardpanelcontent">
                        <span>用户姓名: ${sysuser.username}</span><br/>
                        <span>登录时间: ${loginTime}</span><br/>
                        <div class="clear"></div>
                    </div>
            	</div>
            </div>
            <div class="middle_left_bottom">
            	<div class="dashboardpanel">
                    <h3><img width="16" height="15" src="images/ico_2.gif" />任务提醒</h3>
                    <div class="dashboardpanelcontent">
                        <br/><br/><br/><br/><br/><br/><br/><br/>
                        <div class="clear"></div>
                    </div>
            	</div>
            </div>
            
        </div><!--end of middle_left-->
        <div class="middle_right">
        	<div class="dashboardpanel">
                <h3><img width="16" height="15" src="images/ico_3.gif" />系统公告</h3>
                <div class="dashboardpanelcontent">
                	<br/><br/><br/><br/><br/><br/><br/><br/>
             		<div class="clear"></div>
             	</div>
            </div>
        </div><!--end of middle_right-->
     </div><!--end of //middle//-->
	
	<j:PageBottomAndCopyright contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
</div>
 </body>
</html>