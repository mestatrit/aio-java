package com.cdpc.aio.ams.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdpc.aio.ams.common.exception.AppException;
import com.cdpc.aio.ams.common.interfaces.BaseController;

/**
 * 
 * 功能代码：9902
 * 功能名称：系统全局跳转
 * 
 * @author evin.liu
 *
 */
@Controller
public class F9902Controller extends BaseController {

	private Logger log = LoggerFactory.getLogger(F9902Controller.class);

	@RequestMapping("/f9902.do")
	public String gotoMainPage(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9902Controller------------------------");
		log.debug("-----------------Method-gotoSystemUser------------------------");
		
		// 跳转到系统首页
		return "pages/f9901-j-0";
	}
	
	@RequestMapping("/f9902-s-1.do")
	public String gotoQuitSystemPage(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9902Controller------------------------");
		log.debug("-----------------Method-gotoQuitSystemPage------------------------");
		
		// 跳转到退出系统页面
		return "pages/f9902-j-0";
	}
	
}
