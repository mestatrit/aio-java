package com.cdpc.aio.ams.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdpc.aio.ams.common.exception.AppException;
import com.cdpc.aio.ams.common.interfaces.BaseController;
import com.cdpc.aio.ams.common.util.SystemUser;
import com.cdpc.aio.ams.common.util.SystemUtils;
import com.cdpc.aio.ams.web.service.SysUserService;

/**
 * 
 * 功能点9902控制器
 * 
 * @author evin.liu
 *
 */
@Controller
public class F9902Controller extends BaseController {

	private Logger log = LoggerFactory.getLogger(F9902Controller.class);

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("/f9902.do")
	public String userlogout(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9902Controller------------------------");
		log.debug("-----------------Method-userlogout------------------------");
		
		log.debug(SystemUtils.getCurrentUser(request).getUsername() + "退出操作");
		
		SystemUser systemUser = SystemUtils.getCurrentUser(request);
		sysUserService.changeUserStatus(systemUser, request, Constants.LOGOUT_FLAG);
		return "pages/f9902-j-0";
	}
}
