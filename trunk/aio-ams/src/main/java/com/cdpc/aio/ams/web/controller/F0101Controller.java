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
 * 功能点0101控制器
 * 
 * @author evin.liu
 *
 */
@Controller
public class F0101Controller extends BaseController {

	private Logger log = LoggerFactory.getLogger(F0101Controller.class);
	
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/f0101.do")
	public String gotoChangepwd(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9902Controller------------------------");
		log.debug("-----------------Method-gotoSystemUser------------------------");
		
		// 跳转到修改密码首页
		return "pages/f9999-j-0";
	}
	
}
