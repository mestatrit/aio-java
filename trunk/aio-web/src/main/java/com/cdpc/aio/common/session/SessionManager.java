package com.cdpc.aio.common.session;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * 会话管理器,保存整个web应用范围 内所有已经录用户的session信息
 * 
 * @author evin.liu
 * @date 2011-12-28
 */
public class SessionManager {

	private static Logger log = Logger.getLogger(SessionManager.class);

	private static Map<String, HttpSession> sessions = new HashMap<String, HttpSession>();

	/**
	 * 保存用户会话信息
	 * 
	 * @param userId
	 * @param newSession
	 */
	public synchronized static void putSession(String userId, HttpSession newSession) {
		if (userId == null || "".equals(userId)) {
			// throw new
			// IllegalArgumentException("userId can not be null or ''...");
			log.error("userId can not be null or ''...");
			return;
		}
		if (newSession == null) {
			// throw new
			// IllegalArgumentException("newSession can not be null...");
			log.error("newSession can not be null...");
			return;
		}
		HttpSession existSession = sessions.get(userId);
		if (existSession == null) {
			sessions.put(userId, newSession);
		}
	}

	/**
	 * 删除指定用户会话信息
	 * 
	 * @param userId
	 */
	public synchronized static void removeSession(String userId) {
		if (userId == null || "".equals(userId)) {
			// throw new
			// IllegalArgumentException("userId can not be null or ''...");
			log.error("userId can not be null or ''...");
			return;
		}
		HttpSession existSession = sessions.get(userId);
		if (existSession == null) {
		} else {
			sessions.remove(userId);
		}
	}

	/**
	 * 获取指定用户会话信息
	 * 
	 * @param userId
	 */
	public synchronized static HttpSession getSession(String userId) {
		if (userId == null || "".equals(userId)) {
			// throw new
			// IllegalArgumentException("userId can not be null or ''...");
			log.error("userId can not be null or ''...");
			return null;
		}
		HttpSession existSession = sessions.get(userId);
		if (existSession == null) {
			return null;
		} else {
			return existSession;
		}
	}
}
