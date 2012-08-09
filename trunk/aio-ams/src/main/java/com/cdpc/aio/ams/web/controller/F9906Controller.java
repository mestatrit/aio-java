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
 * 功能点9906控制器
 * 
 * @author evin.liu
 *
 */
@Controller
public class F9906Controller extends BaseController {

	private static Logger log = LoggerFactory.getLogger(F9906Controller.class);
	
	@RequestMapping("/f9906.do")
	public String gotoSystemUser(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9905Controller------------------------");
		log.debug("-----------------Method-gotoSystemUser------------------------");
		
		// 跳转到系统用户首页
		return "pages/f9906-j-0";
	}
}
