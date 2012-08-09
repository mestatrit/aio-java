package com.cdpc.aio.ams.web.controller;

import java.util.List;

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
import com.cdpc.aio.ams.web.po.TblSysSysfun;
import com.cdpc.aio.ams.web.service.SysFuncService;

/**
 * 
 * 功能点9903控制器
 * 
 * @author evin.liu
 *
 */
@Controller
public class F9903Controller extends BaseController {

	private static Logger log = LoggerFactory.getLogger(F9903Controller.class);
	
	@Autowired
	private SysFuncService sysFuncService;
	
	@RequestMapping("/f9903.do")
	public void get2LevelMenu(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9903Controller------------------------");
		log.debug("-----------------Method-get2LevelMenu------------------------");
		
		log.debug(SystemUtils.getCurrentUser(request).getUsername() + ":获取下级菜单数据");
		
		SystemUser sysuser = (SystemUser)request.getSession().getAttribute("sysuser");
		String functionId = request.getParameter("functionId");
		String menuXml = sysFuncService.selectMenuXml(sysuser, functionId);
		super.ajaxOutString(menuXml, response);
	}
	
	/**
	 * 非主体功能
	 * 为9903下属的子功能
	 * 提供验证功能代码是否可执行
	 * @param request
	 * @param response
	 * @throws AppException
	 */
	@RequestMapping("/f9903-s-1.do")
	public void validateFunctionid(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9903Controller------------------------");
		log.debug("-----------------Method-validateFunctionid------------------------");
		
		SystemUser sysuser = (SystemUser)request.getSession().getAttribute("sysuser");
		List<TblSysSysfun> userfuns = sysuser.getUserfuns();
		String functionId = request.getParameter("functionId");
		if(userfuns == null || userfuns.size() == 0) {
			super.ajaxOutString("NOTPASS", response);
			return;
		}
		
		for(TblSysSysfun userfun : userfuns) {
			String funid = userfun.getSfFunctionId();
			if(funid != null && funid.equals(functionId)) {
				if("1".equals(userfun.getSfExecutbale())) {
					super.ajaxOutString("PASS", response);
					return;
				}
			}
		}
		
		super.ajaxOutString("NOTPASS", response);
	}
	
}
