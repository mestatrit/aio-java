package com.cdpc.aio.common.util;

import com.cdpc.aio.web.po.TblSysUsrinf;

/**
 * 
 * 系统级别封装好的用户信息类 
 * 所有用户需要缓存的信息均保存至此类中 
 * 供全局使用
 * 
 * @author evin.liu
 * 
 */
public class SystemUser {

	private String username;
	private TblSysUsrinf tblSysUsrinf;
	
	private String contextPath;
	private String basePath;
	private String serverPath;
	
	private String currentRequestFunctionId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TblSysUsrinf getTblSysUsrinf() {
		return tblSysUsrinf;
	}

	public void setTblSysUsrinf(TblSysUsrinf tblSysUsrinf) {
		this.tblSysUsrinf = tblSysUsrinf;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getServerPath() {
		return serverPath;
	}

	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}

	public String getCurrentRequestFunctionId() {
		return currentRequestFunctionId;
	}

	public void setCurrentRequestFunctionId(String currentRequestFunctionId) {
		this.currentRequestFunctionId = currentRequestFunctionId;
	}

}
