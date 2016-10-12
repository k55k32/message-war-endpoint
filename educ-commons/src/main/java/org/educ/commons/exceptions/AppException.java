package org.educ.commons.exceptions;

import org.educ.commons.exceptions.AppException.Error;

public class AppException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Error UNKNOW_EXCEPTION = e(10000, "unknow exception");

	public static final Error AUTH_FAILED = e(20000, "username or passwor error");
	
	private Error error;
	
	@SuppressWarnings("unused")
	private AppException() {
	}

	public AppException(Error code) {
		this.error = code == null ? UNKNOW_EXCEPTION : code; 
	}
	
	public AppException(Error code, String exMsg) {
		this(code);
		this.error.setMsg(String.format(code.getMsg(), exMsg));
	}
	
	@Override
	public String getMessage() {
		return error.getMsg();
	}
	
	
	private static Error e(int code, String msg) {
		return new Error(code, msg);
	}
	
	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
	
	static class Error {
			private int code;
			private String msg;
			public Error(int code2, String msg2) {
				this.code = code2;
				this.msg = msg2;
			}
			public int getCode() {
				return code;
			}
			public void setCode(int code) {
				this.code = code;
			}
			public String getMsg() {
				return msg;
			}
			public void setMsg(String msg) {
				this.msg = msg;
			}
		}


}
