package com.cdpc.aio.common.session;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.cdpc.aio.common.util.SystemUser;

/**
 * 会话监听器,监听整个web应用范围
 * 内所有的session的销毁事件,在会
 * 话失效的时候,将会话从会话管理器
 * 中删除掉
 * @author evin.liu
 * @date   2011-12-28
 */
public class SessionListener implements HttpSessionListener {

	private static Logger log = Logger.getLogger(SessionListener.class);
	
	public void sessionCreated(HttpSessionEvent event) {
		// no deal with this situation
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession currentSession = event.getSession();
		SystemUser systemUser = (SystemUser)currentSession.getAttribute("sysuser");
		if(systemUser == null) {
			log.error("systemUser can not be found in currentSession...");
		} else {
			// 在用户会话因超时失效时，从在线用户列表中删除会话信息
			String userId = systemUser.getUsername().trim();
			SessionManager.removeSession(userId);
		}
	}

}
