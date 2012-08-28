package com.cdpc.aio.common.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 
 * 管理应用全局使用的url路径信息
 * @author evin.liu
 *
 */
public class PathManager {

	private static Logger log = Logger.getLogger(PathManager.class);

	private static Map<String, String> pathMaps = new HashMap<String, String>();

	/**
	 * 保存url路径信息
	 * @param pathName
	 * @param pathValue
	 */
	public synchronized static void put(String pathName, String pathValue) {
		if (pathName == null || "".equals(pathName)) {
			// throw new
			// IllegalArgumentException("pathName can not be null or ''...");
			log.error("pathName can not be null or ''...");
			return;
		}
		if (pathValue == null) {
			// throw new
			// IllegalArgumentException("pathValue can not be null...");
			log.error("pathValue can not be null...");
			return;
		}

		String existPath = get(pathName);
		if (existPath == null) {
			pathMaps.put(pathName, pathValue);
		} else {
			remove(pathName);
			pathMaps.put(pathName, pathValue);
		}
	}

	/**
	 * 获取url路径信息
	 * @param pathName
	 */
	public synchronized static String get(String pathName) {
		if (pathName == null || "".equals(pathName)) {
			// throw new
			// IllegalArgumentException("pathName can not be null or ''...");
			log.error("pathName can not be null or ''...");
			return null;
		}
		String existPath = pathMaps.get(pathName);
		if (existPath == null) {
			return null;
		} else {
			return existPath;
		}
	}

	/**
	 * 删除url路径信息
	 * @param pathName
	 */
	public synchronized static void remove(String pathName) {
		if (pathName == null || "".equals(pathName)) {
			// throw new
			// IllegalArgumentException("pathName can not be null or ''...");
			log.error("pathName can not be null or ''...");
			return;
		}
		String existPath = get(pathName);
		if (existPath == null) {
			// do nothing
		} else {
			pathMaps.remove(pathName);
		}
	}

}
