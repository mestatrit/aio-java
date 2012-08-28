package com.cdpc.aio.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * 处理web url相关工具方法
 * 
 * @author lenovo
 * 
 */
public class URLUtils {

	public static final String INDEX_URL = "/index.jsp";
	public static final String TIMEOUT_URL = "/timeout.jsp";

	/**
	 * 获取请求的上下文
	 * 
	 * @param request
	 * @return
	 */
	public static String getContextPath(HttpServletRequest request) {
		String contextPath = null;
		if (request != null) {
			contextPath = request.getContextPath();
		}
		return contextPath;
	}

	/**
	 * 获取请求的上下文的首页
	 * 
	 * @param request
	 * @return
	 */
	public static String getContextIndex(HttpServletRequest request) {
		String contextIndex = null;
		contextIndex = getContextPath(request);
		if (contextIndex != null) {
			contextIndex += INDEX_URL;
		}
		return contextIndex;
	}
	
	/**
	 * 获取请求的上下文的超时页面
	 * 
	 * @param request
	 * @return
	 */
	public static String getContextTimeout(HttpServletRequest request) {
		String contextTimeout = null;
		contextTimeout = getContextPath(request);
		if(contextTimeout != null) {
			contextTimeout += TIMEOUT_URL;
		}
		return contextTimeout;
	}

}
