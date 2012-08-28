<%@ include file="/WEB-INF/jsp/include/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>上海银行信用卡</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" type="image/x-icon" href="images/aio.ico" />
<link rel="stylesheet" href="css/default_style.css" />
<script type="text/javascript" src="js/jquery_1.6.4/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="js/client.js"></script>
<script type="text/javascript" src="js/EventUtil.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/startmenu.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/desktop.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
</head>

<body class="main_body" oncontextmenu="return false">
<div id="desktop" class="desktop">
	<div id="desktop_content_and_windows" class="desktop_content_and_windows">
        <div class="desktop_content">
            <div class="desktop_header">
                <div class="left">
                    <div class="calendar">
                    	<div class="months">
                        	<div class="months_n_1"><img id="months_n_1" src="images/n_0.png" /></div>
                            <div class="months_n_2"><img id="months_n_2" src="images/n_0.png" /></div>
                        </div>
                        <div class="days">
                        	<div class="days_n_1"><img id="days_n_1" src="images/n_0.png" /></div>
                            <div class="days_n_2"><img id="days_n_2" src="images/n_0.png" /></div>
                        </div>
                    </div>
                </div>
                <div class="center">
                    <div class="navigator">
                        <div class="c0"><div id="btn_c0_bg" class="btn_c0_bg" style="background:url(images/btn_c_bg.jpg) repeat-x;"><img id="btn_c0" src="images/pressed_btn_c0.png" onclick="switch_content_panel(event);" /></div></div>
                        <div class="c1"><div id="btn_c1_bg" class="btn_c1_bg"><img id="btn_c1" src="images/btn_c1.png" onclick="switch_content_panel(event);" /></div></div>
                        <div class="c2"><div id="btn_c2_bg" class="btn_c2_bg"><img id="btn_c2" src="images/btn_c2.png" onclick="switch_content_panel(event);" /></div></div>
                        <div class="c3"><div id="btn_c3_bg" class="btn_c3_bg"><img id="btn_c3" src="images/btn_c3.png" onclick="switch_content_panel(event);" /></div></div>
                        <div class="c4"><div id="btn_c4_bg" class="btn_c4_bg"><img id="btn_c4" src="images/btn_c4.png" onclick="switch_content_panel(event);" /></div></div>
                    </div>
                </div>
                <div class="right">
                    <div class="clcok">
                   		<div class="minutes">
                        	<div class="minutes_n_1"><img id="minutes_n_1" src="images/n_0.png" /></div>
                            <div class="minutes_n_2"><img id="minutes_n_2" src="images/n_0.png" /></div>
                        </div>
                    	<div class="hours">
                        	<div class="hours_n_1"><img id="hours_n_1" src="images/n_0.png" /></div>
                            <div class="hours_n_2"><img id="hours_n_2" src="images/n_0.png" /></div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="adjust_desktop_height_top" class="adjust_desktop_height"></div>
            <div class="desktop_platforms">
                <div class="top">
                    
                </div>
                <div class="middle">
                    <div class="left">
                        
                    </div>
                    <div class="center">
                      <div id="content_panel_0" class="content_panel_0" style="display:block;"">
                        <div class="header">
                            <div class="office">所属科室: 授权科</div> <div class="employee">员工: Stephen Wang </div>
                        </div>
                        <div class="body">
                            <div class="left"></div>
                            <div class="right">
                                <div class="news">
                                    <a href="http://war.163.com/12/0726/15/87BOET8O00014J0G.html">美部署"鱼鹰"并非只为争夺钓鱼岛<a><br/>
                                    <a href="http://war.163.com/12/0727/09/87DM1FGM00011MTO.html">日本首相公开称必要时出动自卫队保卫钓鱼岛</a><br/>
                                    <a href="http://war.163.com/12/0727/10/87DOCKA500011MTO.html">人民日报：美国插手中国领海争端勿走火入魔</a><br/>
                                    <a href="http://war.163.com/12/0727/10/87DPAFGK00011MTO.html">台湾称日本若"国有化钓鱼岛"将采取必要措施</a><br/>
                                    <a href="http://war.163.com/12/0727/10/87DN70DS00011MTO.html">中国印尼海军将建对话机制 印尼影响力加大</a><br/>
                                    <a href="http://war.163.com/12/0727/09/87DMQ5UP00011MTO.html">国防部：武直10发动机具有完全自主知识产权</a><br/>
                                    <div class="more"><a>更多...</a></div>
                                </div>
                            </div>
                        </div>
                        <div class="footer">
                        
                        </div>
                      </div>
                      <div id="content_panel_1" class="content_panel_1" style="display:none;">
                        <div class="header">
                            <div class="platform_name">营销管理平台</div>
                        </div>
                        <div class="body">
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/database.png" onclick="dt.add_window('1001', 'datawarehouse', '数据仓库', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>数据仓库</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/mis.png" onclick="dt.add_window('1002', 'mis', 'MIS系统', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>MIS</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/direct_selling.png" onclick="dt.add_window('1003', 'directsales', '直销管理', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>直销管理</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                        </div>
                        <div class="footer">
                        
                        </div>
                      </div>
                      <div id="content_panel_2" class="content_panel_2" style="display:none;">
                        <div class="header">
                            <div class="platform_name">交易管理平台</div>
                        </div>
                        <div class="body">
                             <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/pre_trans.png" onclick="dt.add_window('2001', 'frontend', '前置交易管理', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>前置交易管理</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/topcard.png" onclick="dt.add_window('2002', 'core_tp', '核心交易处理', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>核心交易处理</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/middle_business.png" onclick="dt.add_window('2003', 'middle_bs', '中间业务', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>中间业务</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/ic_card.png" onclick="dt.add_window('2004', 'app_ic', '行业应用IC卡', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>行业应用IC卡</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/code_management.png" onclick="dt.add_window('2005', 'app_key_mgt', '密钥管理', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>密钥管理</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/personal_sys.png" onclick="dt.add_window('2006', 'app_personal', '个人化系统', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>个人化系统</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/data_prepare.png" onclick="dt.add_window('2007', 'app_data_prepare', '数据准备', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>数据准备</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/test_msg_management.png" onclick="dt.add_window('2008', 'app_chanel_msg', '短信渠道管理', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>短信渠道管理</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/e_bank.png" onclick="dt.add_window('2009', 'app_chanel_nb', '网银渠道管理', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>网银渠道管理</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/phone_management.png" onclick="dt.add_window('2010', 'app_chanel_cc', '电话渠道管理', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>电话渠道管理</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                        </div>
                        <div class="footer">
                        
                        </div>
                      </div>
                      <div id="content_panel_3" class="content_panel_3" style="display:none;">
                        <div class="header">
                            <div class="platform_name">作业管理平台</div>
                        </div>
                        <div class="body">
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/iams.png" onclick="dt.add_window('3101', 'app_ams', '影像工作流', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>影像工作流</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/shou xin.png" onclick="dt.add_window('3102', 'app_sx', '授信系统', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>授信系统</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/history.png" onclick="dt.add_window('3103', 'queryams', '影像流历史库', 'http://10.168.2.208:8080/aio-ams/f9901.do?j_username=sa&j_password=111111', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>影像流历史库</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div style="clear:left;"></div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/app_j_icon.png" onclick="dt.add_window('3201', 'authsystem', '授权系统', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>授权系统</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/code_management.png" onclick="dt.add_window('3202', 'tp_cs', '客服系统', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>客服系统</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/anti_cheating.png" onclick="dt.add_window('3203', 'anti_cheating', '交易反欺诈', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>交易反欺诈</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div style="clear:left;"></div>
                           <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/cuishou_sys.png" onclick="dt.add_window('3301', 'cuishou', '催收系统', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>催收系统</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/dead_bills.png" onclick="dt.add_window('3302', 'daihuaizhang', '呆坏账管理', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>呆坏账管理</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                            <div style="clear:left;"></div>
                        </div>
                        <div class="footer">
                        
                        </div>
                      </div>
                      <div id="content_panel_4" class="content_panel_4" style="display:none;">
                        <div class="header">
                            <div class="platform_name">企业文化平台</div>
                        </div>
                        <div class="body">
                           	<div class="appButton">
                                <div class="appButton_appIcon">
                                    <img class="appButton_appIconImg" src="images/icons/forum.png" onclick="dt.add_window('4001', 'forum', '员工论坛', '', event);" />
                                </div>
                                <div class="appButton_appName">
                                    <div class="appButton_appName_inner"><a>员工论坛</a></div>
                                    <div class="appButton_appName_inner_right"></div>
                                </div>
                            </div>
                        </div>
                        <div class="footer">
                        
                        </div>
                      </div>
                </div>
                    <div class="right">
                        
                    </div>
                </div>
                <div class="bottom">
                
                </div>
            </div>
            <div id="adjust_desktop_height_bottom" class="adjust_desktop_height"></div>
            <div class="desktop_slogan">
                <div class="left">
                    
                </div>
                <div class="center">
                    
                </div>
                <div class="right">
                    <div class="slogan"></div>
                </div>
            </div>
        </div>
    </div>
	<div class="desktop_taskbar">
		<div class="left">
             <div id="start_btn" class="start_btn_normal" onclick="startmenu.menu_display(this,'',event);"></div>
        </div>
        <div id="taskbar_container" class="center">
        	
        </div>
        <div class="right">
        	<div class="btn_task_bar_email" onclick="dt.add_window('7', 'queryshmail', '上海银行邮件系统', 'http://mail.bankofshanghai.com/', event);"></div>
        </div>
	</div>
</div>
<script type="text/javascript">
	webapp_contextPath = '<%=contextPath%>';
	EventUtil.addHandler(document.getElementById("start_btn"),"mouseover",startmenu.btn_onmouseover);
	EventUtil.addHandler(document.getElementById("start_btn"),"mouseout",startmenu.btn_onmouseout);
</script>
</body>
</html>