package com.cdpc.aio.common.exception;

/**
 * 
 * 持久化异常
 * 一般在DAO层面产生
 * 
 * @author evin.liu
 *
 */
public class PersistenceException extends Exception {
	
	private static final long serialVersionUID = -1023350688303192409L;

	public PersistenceException() {
		super();
	}

	public PersistenceException(String message) {
		super(message);
	}

	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersistenceException(Throwable cause) {
		super(cause);
	}
}
