package com.cdpc.aio.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * 整个web系统级别的工具类
 * @author evin.liu
 *
 */
public class SystemUtils {

	/**
	 * 获取当前请求的会话
	 * @param request
	 * @return
	 */
	public static HttpSession getSession(HttpServletRequest request) {
		HttpSession session = null;
		if(request != null) {
			session = request.getSession();
		}
		return session;
	}
	
	/**
	 * 获取当前请求的用户
	 * @param request
	 * @return
	 */
	public static SystemUser getCurrentUser(HttpServletRequest request) {
		SystemUser systemUser = null;
		HttpSession session = null;
		session = getSession(request);
		if(session != null) {
			systemUser = (SystemUser)session.getAttribute("sysuser");
		}
		return systemUser;
	}
	
	/**
	 * 获取当前请求的用户ID
	 * @param request
	 * @return
	 */
	public static String getCurrentUserId(HttpServletRequest request) {
		SystemUser systemUser = getCurrentUser(request);
		return systemUser.getTblSysUsrinf().getUiUserId();
	}
	
	//===================================================================================
	// 处理重复登录用代码
	public static final String INTERCEPTTIMES = "interceptTimes";
	
	public static void incrementInterceptTimes4Session(HttpServletRequest request) {
		Integer interceptTimes = getInterceptTimes4Session(request);
		interceptTimes ++;
		HttpSession session = getSession(request);
		session.setAttribute(INTERCEPTTIMES, interceptTimes);
	}
	
	public static Integer getInterceptTimes4Session(HttpServletRequest request) {
		Integer interceptTimes = 0;
		if(request != null) {
			HttpSession session = getSession(request);
			Object o = session.getAttribute(INTERCEPTTIMES);
			if(o != null) {
				interceptTimes = (Integer)o;
			}
		}
		return interceptTimes;
	}
	
	public static boolean isLoginFirstTime(HttpServletRequest request) {
		Integer interceptTimes = getInterceptTimes4Session(request);
		if(interceptTimes == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//===================================================================================

}
