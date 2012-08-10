package com.cdpc.aio.ams.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdpc.aio.ams.common.exception.AppException;
import com.cdpc.aio.ams.common.interfaces.BaseController;
import com.cdpc.aio.ams.common.util.SystemUtils;
import com.cdpc.aio.ams.web.po.TblSysUsrinf;
import com.cdpc.aio.ams.web.service.SysUserService;
import com.cdpc.aio.ams.web.vo.F9902InObject;
import com.cdpc.aio.ams.web.vo.F9902OutObject;

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
	public String gotoChangepwd(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9902Controller------------------------");
		log.debug("-----------------Method-gotoSystemUser------------------------");
		
		// 跳转到修改密码首页
		return "pages/f9902-j-0";
	}
	@RequestMapping("/f9902-s-1.do")
	public void changeUserPassword(F9902InObject f9902InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9902Controller------------------------");
		log.debug("-----------------Method-changeUserPassword------------------------");
		log.debug("修改用户密码操作");
		
		F9902OutObject f9902OutObject = new F9902OutObject();
		
		TblSysUsrinf tblSysUsrinf = sysUserService.loadUserByUsername(SystemUtils.getCurrentUserId(request));
		
		String encodedPassword = tblSysUsrinf.getUiUserPwd();
		if(StringUtils.isNotEmpty(encodedPassword)) {
			if(!StringUtils.equals(encodedPassword, f9902InObject.getOldUserPwd())) {
				log.warn("old password is not correct");
				f9902OutObject.setEditSuccess(false);
				f9902OutObject.setErrorMessage("当前密码输入错误.");
				super.ajaxOutJson(f9902OutObject, response);
				return;
			}
		}
		
		if(!f9902InObject.getNewUserPwd().equals(f9902InObject.getNewUserPwd2())) {
			log.warn("new password is not the same twice");
			f9902OutObject.setEditSuccess(false);
			f9902OutObject.setErrorMessage("新密码两次输入不一致.");
			super.ajaxOutJson(f9902OutObject, response);
			return;
		}
		
		tblSysUsrinf.setUiUserPwd(f9902InObject.getNewUserPwd());
		sysUserService.changeUserPasswd(tblSysUsrinf);
		
		f9902OutObject.setEditSuccess(true);
		super.ajaxOutJson(f9902OutObject, response);
	}
}
