package com.cdpc.aio.common.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 
 * 管理用户上下文信息
 * @author evin.liu
 *
 */
public class UserContext {

	private static Logger log = Logger.getLogger(UserContext.class);

	private static Map<String, Map<String, Object>> dataMaps = new HashMap<String, Map<String, Object>>();

	/**
	 * 保存用户数据信息
	 * @param username
	 * @param pathValue
	 */
	public synchronized static void put(String username, String dataName, Object dataValue) {
		if (username == null || "".equals(username)) {
			log.error("username can not be null or ''...");
			throw new IllegalArgumentException("username can not be null or ''...");
		}
		if (dataName == null) {
			log.error("dataName can not be null...");
			throw new IllegalArgumentException("dataName can not be null...");
		}
		if (dataValue == null) {
			log.error("dataValue can not be null...");
			throw new IllegalArgumentException("dataValue can not be null...");
		}

		Map<String, Object> existData = get(username);
		if (existData == null) {
			existData = new HashMap<String, Object>();
			existData.put(dataName, dataValue);
			dataMaps.put(username, existData);
		} else {
			Object existDataValue = existData.get(dataName);
			if(existDataValue == null) {
			} else {
				existData.remove(dataName);
			}
			existData.put(dataName, dataValue);
			dataMaps.put(username, existData);
		}
	}

	/**
	 * 获取全部用户数据信息
	 * @param username
	 */
	public synchronized static Map<String, Object> get(String username) {
		if (username == null || "".equals(username)) {
			log.error("username can not be null or ''...");
			throw new IllegalArgumentException("username can not be null or ''...");
		}
		Map<String, Object> existData = dataMaps.get(username);
		if (existData == null) {
			return null;
		} else {
			return existData;
		}
	}
	
	/**
	 * 获取特定用户数据信息
	 * @param username
	 */
	public synchronized static Object get(String username, String dataName) {
		if (username == null || "".equals(username)) {
			log.error("username can not be null or ''...");
			throw new IllegalArgumentException("username can not be null or ''...");
		}
		Map<String, Object> existData = dataMaps.get(username);
		if (existData == null) {
			return null;
		} else {
			Object o = existData.get(dataName);
			if(o == null) {
				return null;
			} else {
				return o;
			}
		}
	}

	/**
	 * 删除全部用户数据信息
	 * @param username
	 */
	public synchronized static void remove(String username) {
		if (username == null || "".equals(username)) {
			log.error("username can not be null or ''...");
			throw new IllegalArgumentException("username can not be null or ''...");
		}
		Map<String, Object> existData = get(username);
		if (existData == null) {
			// do nothing
		} else {
			dataMaps.remove(username);
		}
	}
	
	/**
	 * 删除特定用户数据信息
	 * @param username
	 */
	public synchronized static void remove(String username, String dataName) {
		if (username == null || "".equals(username)) {
			log.error("username can not be null or ''...");
			throw new IllegalArgumentException("username can not be null or ''...");
		}
		if (dataName == null || "".equals(dataName)) {
			log.error("username can not be null or ''...");
			throw new IllegalArgumentException("dataName can not be null or ''...");
		}
		Map<String, Object> existData = get(username);
		if (existData == null) {
			// do nothing
		} else {
			Object o = existData.get(dataName);
			if(o == null) {
				return;
			} else {
				existData.remove(dataName);	
			}
		}
	}

}
