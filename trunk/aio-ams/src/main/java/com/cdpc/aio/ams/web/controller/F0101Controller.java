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
 * 功能代码：0101
 * 功能名称：影像流历史件查询
 * 
 * @author evin.liu
 *
 */
@Controller
public class F0101Controller extends BaseController {

	private Logger log = LoggerFactory.getLogger(F0101Controller.class);
	
	@RequestMapping("/f0101.do")
	public String gotoAmsHistoryQuery(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F0101Controller------------------------");
		log.debug("-----------------Method-gotoAmsHistoryQuery------------------------");
		
		// 跳转到历史件查询首页
		return "pages/f0101-j-0";
	}
	
}
