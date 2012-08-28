package com.cdpc.aio.common.exception;

/**
 * 
 * 应用异常
 * 一般在Service层面及Controller层面产生
 * 
 * @author evin.liu
 *
 */
public class AppException extends Exception {
	private static final long serialVersionUID = -4293350551340978522L;
	
	// 系统错误码
	private String errorCode = null;
	
	public AppException() {
		super();
	}

	public AppException(String message) {
		super(message);
	}
	
	public AppException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(Throwable cause) {
		super(cause);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
