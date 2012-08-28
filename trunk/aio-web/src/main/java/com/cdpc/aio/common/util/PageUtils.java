package com.cdpc.aio.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.cdpc.aio.common.interfaces.PageQuery;

/**
 * 
 * 分面工具类
 * 
 * @author evin.liu
 *
 * @param <T>
 */
public class PageUtils<T> {

	public void setPageQuery(HttpServletRequest request, Object pageQuery) {
		HttpSession session = request.getSession();
		session.setAttribute("pageQuery", pageQuery);
	}
	
	public PageQuery<T> getPageQuery(HttpServletRequest request) {
		HttpSession session = request.getSession();
		PageQuery<T> pageQuery = (PageQuery<T>)session.getAttribute("pageQuery");
		String currentPageStr = request.getParameter("currentPage");
		int currentPage = 1;
		if(StringUtils.isNotEmpty(currentPageStr)) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		pageQuery.setCurrentPage(currentPage);
		return pageQuery;
	}
	
}
