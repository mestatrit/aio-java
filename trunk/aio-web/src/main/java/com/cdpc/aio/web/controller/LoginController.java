package com.cdpc.aio.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdpc.aio.common.exception.AppException;
import com.cdpc.aio.common.interfaces.BaseController;
import com.cdpc.aio.common.session.SessionManager;
import com.cdpc.aio.common.util.SystemUser;
import com.cdpc.aio.common.util.SystemUtils;
import com.cdpc.aio.web.dao.TblSysUsrinfDAO;
import com.cdpc.aio.web.po.TblSysUsrinf;
import com.cdpc.aio.web.service.SysUserService;
import com.cdpc.common.codec.EncryptUtils;

/**
 * 
 * 用户登录
 * 
 * @author evin.liu
 * 
 */
@Controller
public class LoginController extends BaseController {

	private Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private TblSysUsrinfDAO tblSysUsrinfDAO;

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("/login.do")
	public String userlogin(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9901Controller------------------------");
		log.debug("-----------------Method-userlogin------------------------");
		log.debug("登录操作");

		String username = request.getParameter("j_username");
		String password = request.getParameter("j_password");

		log.debug(username + " is logging.");

		// ===========================================================================================
		// 处理额外错误,防止用户绕过前台JS验证,确保系统万无一失
		// 1、用户名为空
		if (StringUtils.isEmpty(username)) {
			log.info(username + "username is empty");
			request.setAttribute("errorMessage", "username is empty");
			return "forward:index.jsp";
		}

		// 2、密码为空
		if (StringUtils.isEmpty(password)) {
			log.info(username + "password is empty");
			request.setAttribute("errorMessage", "password is empty");
			return "forward:index.jsp";
		}

		// ===========================================================================================
		// 加载用户数据,以便进行验证
		TblSysUsrinf tblSysUsrinf = sysUserService.loadUserByUsername(username);

		// ===========================================================================================
		// 处理登陆错误

		// 1.用户不存在
		if (tblSysUsrinf == null) {
			log.info(username + "username is not exist");
			request.setAttribute("errorMessage", "username is not exist");
			return "forward:index.jsp";
		}

		// 2.用户密码不正确
		String encodedPassword = tblSysUsrinf.getUiUserPwd();
		String encodedInputPassword = new String(EncryptUtils.passwordMd52Hex(password));

		if (StringUtils.isNotEmpty(encodedInputPassword)) {
			if (!StringUtils.equals(encodedPassword, encodedInputPassword)) {
				log.info("password is not correct");
				request.setAttribute("errorMessage", "password is not correct");
				return "forward:index.jsp";
			}
		}

		// ===========================================================================================
		// 加载用户菜单、权限等信息
		SystemUser systemUser = new SystemUser();
		systemUser.setUsername(username);

		request.getSession().setAttribute("sysuser", systemUser);
		// ===========================================================================================
		// 修改用户登录标记,记录日志
		sysUserService.changeUserStatus(systemUser, request, Constants.LOGIN_FLAG);
		log.info("[" + username + "] from [" + request.getRemoteAddr() + "]-->login successfully.");

		// 记录登录日志
		String loginTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		sysUserService.saveLoginLog(username + "from aio", loginTime, request.getRemoteAddr());

		HttpSession session = SystemUtils.getSession(request);

		// 限制用户重复登录
		// add by evin.liu
		String userId4Session = systemUser.getUsername().trim();
		HttpSession existSession = SessionManager.getSession(userId4Session);
		if (existSession != null) {
			// 如用户目前已经登录,则关闭先前登录的会话,将新的会话信息保存到会话管理器中
			// 用户会话因为登录时间太长而失效时,则会被com.huateng.topafs.comm.session.SessionListener清除掉,执行不到此处代码
			if (!existSession.getId().equals(session.getId())) {
				try {
					existSession.invalidate();
				} catch (Throwable t) {
					// 捕获所有异常,防止抛出java.lang.IllegalStateException异常
					t.printStackTrace();
				}
			}

			SessionManager.removeSession(userId4Session);
			SessionManager.putSession(userId4Session, session);
		} else {
			// 如用户目前未登录,则将新的会话信息保存到会话管理器中
			SessionManager.putSession(userId4Session, session);
		}

		// ===========================================================================================

		String contextPath = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
		String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";

		systemUser.setContextPath(contextPath);
		systemUser.setBasePath(basePath);
		systemUser.setServerPath(serverPath);

		String uri = request.getRequestURI();
		String url = uri.substring(uri.indexOf("/", 2)).substring(1);

		String fid = url.substring(1, 5);
		systemUser.setCurrentRequestFunctionId(fid);

		// ===========================================================================================

		return "pages/main";
	}

	public TblSysUsrinfDAO getTblSysUsrinfDAO() {
		return tblSysUsrinfDAO;
	}

	public void setTblSysUsrinfDAO(TblSysUsrinfDAO tblSysUsrinfDAO) {
		this.tblSysUsrinfDAO = tblSysUsrinfDAO;
	}

}
