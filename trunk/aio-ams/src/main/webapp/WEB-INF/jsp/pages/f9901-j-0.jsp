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
                        <span>用户姓名: Stephen wang</span><br/>
                        <span>所属科室: 授权科</span><br/>
                        <span>登录时间: 2012-7-18 12:23:10</span><br/>
                        <div class="clear"></div>
                    </div>
            	</div>
            </div>
            <div class="middle_left_bottom">
            	<div class="dashboardpanel">
                    <h3><img width="16" height="15" src="images/ico_2.gif" />任务提醒</h3>
                    <div class="dashboardpanelcontent">
                        <a>2012-07-20 完成任务A</a><br/>
                        <a>2012-07-21 完成任务B</a><br/>
                        <a>2012-07-22 完成任务C</a><br/>
                        <a>2012-07-22 完成任务D</a><br/>
                        <a>2012-07-22 完成任务E</a><br/>
                        <a>2012-07-22 完成任务F</a><br/>
                        <a>2012-07-22 完成任务G</a><br/>
                        <a>2012-07-22 完成任务H</a><br/>
                        <a>2012-07-22 完成任务I</a><br/>
                        <div class="clear"></div>
                    </div>
            	</div>
            </div>
            
        </div><!--end of middle_left-->
        <div class="middle_right">
        	<div class="dashboardpanel">
                <h3><img width="16" height="15" src="images/ico_3.gif" />系统公告</h3>
                <div class="dashboardpanelcontent">
                	<a>远离非法集资 建设美好生活</a><br/>
                    <a>上海银行拟推出为百岁老人免费送养老金等服务</a><br/>
                    <a>1亿元财政资金撬动30亿元“外贸通”</a><br/>
                    <a>上海银行打造6家养老金特色支行</a><br/>
                    <a>五项举措打造养老金融服务上海银行创建“敬老文明号”</a><br/>
                    <a>上海银行30亿专项额度助中小外贸企业融资</a><br/>
                    <a>惠誉近期确认上海银行评级</a><br/>
                    <a>老人遗忘借记卡  银行员工送上门</a><br/>
                    <a>上海银行-苏州乐园“尚乐”信用卡面世</a><br/>
                    <a>上海银行天津塘沽支行对外营业</a><br/>
             		<div class="clear"></div>
             	</div>
            </div>
        </div><!--end of middle_right-->
     </div><!--end of //middle//-->
	
	<j:PageBottomAndCopyright contextPath="<%=contextPath%>" basePath="<%=basePath%>" />
</div>
 </body>
</html>