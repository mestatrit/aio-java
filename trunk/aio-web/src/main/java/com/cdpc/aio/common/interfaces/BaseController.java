package com.cdpc.aio.common.interfaces;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdpc.aio.common.exception.AppException;

/**
 * 
 * Controller基础类
 * 
 * @author evin.liu
 *
 */
public abstract class BaseController {

	private Logger log = LoggerFactory.getLogger(BaseController.class);
	
	public void ajaxOutString(String str, HttpServletResponse response) throws AppException {
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache_Control", "no-cache");

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(str.trim());
			out.flush();
		} catch (IOException e) {
			log.error("ajaxOutString error:", e);
			throw new AppException("AjaxFunction.setResponse:" + e.getMessage());
		}
	}
	
	public void ajaxOutJson(Object obj, HttpServletResponse response) throws AppException {
		if(obj == null) {
			log.error("ajaxOutJson error: obj is null");
			throw new AppException("ajaxOutJson error");
		}
		JSONObject jobj = new JSONObject(obj);
		ajaxOutString(jobj.toString(), response);
	}
}
