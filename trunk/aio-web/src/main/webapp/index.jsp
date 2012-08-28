<% 
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
	String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>上海银行信用卡</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" type="image/x-icon" href="images/aio.ico" />
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
	<div class="logo"></div>
</div>

<div id="adjust_login_height_top" class="adjust_login_height"></div>

<div class="middle">
    <div class="login_box">
        <form id="login_form" action="<%=contextPath%>/login.do" method="post">
        <table width="100%" cellspacing="0" cellpadding="0" border="0">
            <tr height="130">
                <td width="100"></td>
                <td width="100"></td>
                <td width="100"></td>
                <td width="100"></td>
            </tr>
            <tr height="34">
                <td colspan="2"></td>
                <td colspan="2">
                <input type="text" id="j_username" name="j_username" onkeydown="if (event.keyCode==13){document.getElementById('j_password').select();}" size="18" />
                </td>
            </tr>
            <tr height="15">
                <td colspan="4"></td>
            </tr>
            <tr height="34">
                <td colspan="2"></td>
                <td colspan="2">
                <input type="password" id="j_password" name="j_password" onkeydown="if (event.keyCode==13){login_submit();}" size="18" />
                </td>
            </tr>
            <tr height="30">
                <td colspan="4" align="center">
                <span id="login_error_msg" style="color:#D7D7D7;">${errorMessage}${loginTwiceErrorMessage}</span>   
                </td>
            </tr>
            <tr height="40">
                <td></td>
                <td align="right">
                <img id="img_btn_login" alt="登录" src="images/btn_login.jpg"/>
                </td>
                <td align="right">
                <img id="img_btn_reset" alt="重置" src="images/btn_reset.jpg" />
                </td>
                <td></td>
            </tr>
            <tr height="30">
                <td colspan="4" align="right">
                <span id="browser_tools_tips_info"></span> IE8,IE9,Chrome,Firefox(推荐)
                </td>
            </tr>
        </table>
        </form>
    </div>
</div>

<div id="adjust_login_height_bottom" class="adjust_login_height"></div>

<div class="bottom">
    <div class="slogan"></div>
</div>

<div class="footer">
	<div class="copyright"></div>
</div>

</div>
</body>
</html>