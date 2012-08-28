package com.cdpc.aio.common.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cdpc.aio.common.exception.AppException;
import com.cdpc.aio.common.util.PathManager;
import com.cdpc.aio.common.util.SystemUser;
import com.cdpc.aio.common.util.SystemUtils;
import com.cdpc.aio.common.util.URLUtils;

/**
 * 
 * 拦截所有请求,踢掉失效用户
 * @author evin.liu
 */
public class HandlerInterceptor extends HandlerInterceptorAdapter {

	private Logger log = LoggerFactory.getLogger(HandlerInterceptor.class);
	
	/**
	 * 处理逻辑描述：
	 * 1、如果用户Session中没有SystemUser对象
	 * 2、如果请求的url中不包含f9901,即不是用户在登录系统
	 * 则踢掉用户的请求
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		handlePath(request);
		handleUrl(request);
		
		String requestUrl = request.getRequestURL().toString();
		SystemUser systemUser = SystemUtils.getCurrentUser(request);
		if(systemUser == null) {
			if(StringUtils.isNotBlank(requestUrl)) {
				if(requestUrl.indexOf("login") == -1) {
					if(requestUrl.indexOf("logout")!= -1) {
						outString(Constants.SESSION_OUT_FLAG, response);
						return false;
					} else {
						response.sendRedirect(URLUtils.getContextTimeout(request));
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * 输出内容到response对象中
	 * 
	 * @param content
	 * @param response
	 * @throws AppException
	 */
	public void outString(String content, HttpServletResponse response) throws AppException {
		if(StringUtils.isEmpty(content)) {
			content = "";
		}
		
		if(response == null) {
			log.debug("response is null");
			throw new AppException("response is null, cannot finish Method outString");
		}
		
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache_Control", "no-cache");

		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(content.trim());
			out.flush();
		} catch (IOException e) {
			log.error("ajaxOutString error:", e);
			throw new AppException("AjaxFunction.setResponse:" + e.getMessage());
		}
	}
	
	/**
	 * 保存应用全局使用的Path
	 * @param request
	 */
	public void handlePath(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
		String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
		
		PathManager.put("contextPath", contextPath);
		PathManager.put("basePath", basePath);
		PathManager.put("serverPath", serverPath);
		
		SystemUser systemUser = null;
		HttpSession session = request.getSession();
		systemUser = (SystemUser) session.getAttribute("sysuser");
		if(systemUser != null) {
			systemUser.setContextPath(contextPath);
			systemUser.setBasePath(basePath);
			systemUser.setServerPath(serverPath);
		}
	}
	
	/**
	 * 保存应用全局使用的当前请求的功能id
	 * @param request
	 */
	public void handleUrl(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String url = uri.substring(uri.indexOf("/", 2)).substring(1);
		
		String fid = url.substring(1, 5);
		log.debug("fid=" + fid);
		SystemUser systemUser = null;
		HttpSession session = request.getSession();
		systemUser = (SystemUser) session.getAttribute("sysuser");
		if(systemUser != null) {
			systemUser.setCurrentRequestFunctionId(fid);
		}
	}

}
