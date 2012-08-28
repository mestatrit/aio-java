package com.cdpc.aio.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * 页面数据工具类
 * 
 * @author evin.liu
 *
 */
public class PageDataUtils {

	/**
	 * 保存数据到请求对象中
	 * @param request
	 * @param dataName
	 * @param data
	 */
	public static void saveData2Request(HttpServletRequest request, String dataName, Object data) {
		request.setAttribute(dataName, data);
	}
}
