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
import com.cdpc.aio.ams.web.vo.F9999InObject;
import com.cdpc.aio.ams.web.vo.F9999OutObject;
import com.cdpc.common.codec.EncryptUtils;

/**
 * 
 * 功能点9999控制器
 * 
 * @author evin.liu
 *
 */
@Controller
public class F9999Controller extends BaseController {

	private Logger log = LoggerFactory.getLogger(F9999Controller.class);
	
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/f9999.do")
	public String gotoChangepwd(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9999Controller------------------------");
		log.debug("-----------------Method-gotoChangepwd------------------------");
		
		// 跳转到修改密码首页
		return "pages/f9999-j-0";
	}
	
	@RequestMapping("/f9999-s-1.do")
	public void changeUserPassword(F9999InObject f9999InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9999Controller------------------------");
		log.debug("-----------------Method-changeUserPassword------------------------");
		log.debug("修改用户密码操作");
		
		F9999OutObject f9999OutObject = new F9999OutObject();
		
		TblSysUsrinf tblSysUsrinf = sysUserService.loadUserByUsername(SystemUtils.getCurrentUserId(request));
		
		String encodePassword = EncryptUtils.passwordMd52Hex(f9999InObject.getOldUserPwd());
		String rightPassword = tblSysUsrinf.getUiUserPwd();
		if(StringUtils.isNotEmpty(rightPassword)) {
			if(!StringUtils.equals(rightPassword, encodePassword)) {
				log.warn("old password is not correct");
				f9999OutObject.setEditSuccess(false);
				f9999OutObject.setErrorMessage("当前密码输入错误.");
				super.ajaxOutJson(f9999OutObject, response);
				return;
			}
		}
		
		if(!f9999InObject.getNewUserPwd().equals(f9999InObject.getNewUserPwd2())) {
			log.warn("new password is not the same twice");
			f9999OutObject.setEditSuccess(false);
			f9999OutObject.setErrorMessage("新密码两次输入不一致.");
			super.ajaxOutJson(f9999OutObject, response);
			return;
		}
		
		// 加密保存新密码
		String md5pwd = EncryptUtils.passwordMd52Hex(f9999InObject.getNewUserPwd());
		tblSysUsrinf.setUiUserPwd(md5pwd);
		sysUserService.changeUserPasswd(tblSysUsrinf);
		
		f9999OutObject.setEditSuccess(true);
		super.ajaxOutJson(f9999OutObject, response);
	}
}
