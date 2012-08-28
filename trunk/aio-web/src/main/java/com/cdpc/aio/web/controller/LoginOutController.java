package com.cdpc.aio.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdpc.aio.common.exception.AppException;
import com.cdpc.aio.common.interfaces.BaseController;
import com.cdpc.aio.common.util.SystemUser;
import com.cdpc.aio.common.util.SystemUtils;
import com.cdpc.aio.web.service.SysUserService;

/**
 * 
 * 用户退出
 * 
 * @author evin.liu
 *
 */
@Controller
public class LoginOutController extends BaseController {

	private Logger log = LoggerFactory.getLogger(LoginOutController.class);

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("/logout.do")
	public String userlogout(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9902Controller------------------------");
		log.debug("-----------------Method-userlogout------------------------");
		
		SystemUser systemUser = SystemUtils.getCurrentUser(request);
		
		log.debug("用户:" + systemUser.getUsername() + "退出...");
		
		sysUserService.changeUserStatus(systemUser, request, Constants.LOGOUT_FLAG);
		return "redirect:index.jsp";
	}
}
