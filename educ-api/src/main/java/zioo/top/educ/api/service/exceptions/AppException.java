package zioo.top.educ.api.service.exceptions;

import java.io.Serializable;

public class AppException extends Exception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Error UNKNOW_EXCEPTION = e(10000, "unknow exception");

	public static final Error AUTH_FAILED = e(20000, "username or password error");

	public static final Error PARAMS_ERROR = e(30000, "params error: %s");
	
	private int code;
	private String msg;
	
	@SuppressWarnings("unused")
	private AppException() {
	}

	public AppException(Error code) {
		code = code == null ? UNKNOW_EXCEPTION : code;
		this.code = code.getCode();
		this.msg = code.getMsg();
	}
	
	public AppException(Error code, String exMsg) {
		this(code);
		this.msg = String.format(code.getMsg(), exMsg);
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
	
	public int getCode() {
		return code;
	}
	
	
	private static Error e(int code, String msg) {
		return new Error(code, msg);
	}
	
	static class Error implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 5994181263578404551L;
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
