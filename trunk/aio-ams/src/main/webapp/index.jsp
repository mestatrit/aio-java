<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
	String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>影像流历史库查询系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/default_style.css" />
<script type="text/javascript" src="js/jquery_1.6.4/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/client.js"></script>
<script type="text/javascript" src="js/EventUtil.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>

<body class="login_body">
	<div class="login">
		<div class="header">
			<div class="logo">
				<img src="images/logo.png" />
			</div>
			<div class="center"></div>
			<div class="sub_system_logo">
				<img src="images/sub_system_logo.png" />
			</div>
		</div>
		<!-- the end of //header// -->

		<div class="middle">
			<div class="middle_left"></div>
			<div class="middle_middle">
				<div class="login_box">
					<form id="login_form" action="<%=contextPath%>/f9901.do" method="post">
						<div class="user_name">
							<input type="text" id="j_username" name="j_username" onkeydown="if (event.keyCode==13){document.getElementById('j_password').select();}" style="width: 288px; height: 29px; border: none; background: #dcdcdc; font-size: 18px; font-family: 黑体;" />
						</div>
						<div class="password">
							<input type="password" id="j_password" name="j_password" onkeydown="if (event.keyCode==13){login_submit();}" style="width: 288px; height: 29px; border: none; background: #dcdcdc; font-size: 18px; font-family: 黑体;" />
						</div>
						<div class="login_error_msg">
							<span id="login_error_msg" style="color: red;">${errorMessage}${loginTwiceErrorMessage}</span>
						</div>
						<div class="login_btns">
							<img id="img_btn_login" alt="登录" src="images/btn_login.png" onclick="login_submit();" /> 
							<img id="btn_reset" alt="重置" src="images/btn_reset.png" style="margin-left: 157px" onclick="login_reset();" />
						</div>
					</form>
				</div>
			</div>
			<div class="middle_right"></div>
		</div>
		<!--the end of //middle//-->
		<div id="adjust_login_height_bottom" class="adjust_login_height"></div>
		<div class="bottom"></div>
		<!--the end of //bottom//-->
		<div class="footer">
			<div class="copyright"></div>
		</div>
		<!-- the end of //footer//-->
	</div>
	<!-- the end of //login// -->
</body>
</html>