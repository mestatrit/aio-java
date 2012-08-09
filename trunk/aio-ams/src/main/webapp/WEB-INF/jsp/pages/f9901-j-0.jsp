<%@ include file="/WEB-INF/jsp/include/common.jsp"%>
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
<script type="text/javascript" src="js/main.js"></script>
</head>

<body class="main_body">
   <div class="main">  
     <div class="header">
          <div class="right">
              <div class="logo"></div>
          </div>
     	<div class="center"></div>
         <div class="left">
              <div class="sub_system_logo">
                   <img src="images/sub_system_logo_1.png" style="float:right; margin-right:10px;" />
              </div>
              <div class="exit_btn">
                   <img src="images/exit_btn.png" />
              </div>
         </div><!-- end of //sub_system_logo//-->
     </div><!--end of //header//--> 
		
     <div class="navigator">
     	<div id="Menu1" class="first_level">
            <a id="menu1_1" class="menu1_on"  onclick="m1('1');">系统配置</a>
            <a id="menu1_2" class="menu1_off" onclick="m1('2');">历史件查询</a>
            <a id="menu1_3" class="menu1_off" onclick="m1('3');">信用卡</a>
            <a id="menu1_4" class="menu1_off" onclick="m1('4');">个人贷款</a>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
        <div id="Menu2">
            <div id="menu2_1" class="second_level">
                <a id="m2_11" class="menu2_on"  onclick="m2('11', '1');">功能管理1</a>
                <a id="m2_12" class="menu2_off" onclick="m2('12', '1');">角色管理1</a>
                <a id="m2_13" class="menu2_off" onclick="m2('13', '1');">用户管理1</a>
                <a id="m2_14" class="menu2_off" onclick="m2('14', '1');">选项框管理1</a>
                <div class="clear"></div>
            </div>
            <div id="menu2_2" class="second_level" style="display:none;">
                <a id="m2_21" class="menu2_on"  onclick="m2('21', '2');">功能管理2</a>
                <a id="m2_22" class="menu2_off" onclick="m2('22', '2');">角色管理2</a>
                <a id="m2_23" class="menu2_off" onclick="m2('23', '2');">用户管理2</a>
                <a id="m2_24" class="menu2_off" onclick="m2('24', '2');">选项框管理2</a>
                <div class="clear"></div>
            </div>
            <div id="menu2_3" class="second_level" style="display:none;">
                <a id="m2_31" class="menu2_on"  onclick="m2('31', '3');">功能管理3</a>
                <a id="m2_32" class="menu2_off" onclick="m2('32', '3');">角色管理3</a>
                <a id="m2_33" class="menu2_off" onclick="m2('33', '3');">用户管理3</a>
                <a id="m2_34" class="menu2_off" onclick="m2('34', '3');">选项框管理3</a>
                <div class="clear"></div>
            </div>
            <div id="menu2_4" class="second_level" style="display:none;">
                <a id="m2_41" class="menu2_on"  onclick="m2('41', '4');">功能管理4</a>
                <a id="m2_42" class="menu2_off" onclick="m2('42', '4');">角色管理4</a>
                <a id="m2_43" class="menu2_off" onclick="m2('43', '4');">用户管理4</a>
                <a id="m2_44" class="menu2_off" onclick="m2('44', '4');">选项框管理4</a>
                <div class="clear"></div>
            </div>
        </div>
     </div><!--end of //navigator//-->
    
     <div class="space"></div>
    
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
    
    
     <div class="bottom">
     
     </div><!--end of //bottom//-->
     
     <div class="footer">
         <div class="copyright"></div>
     </div><!--end of //footer//--> 
   </div><!--end of //main//-->
 </body><!-- end of //main_body//-->
</html>