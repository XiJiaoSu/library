package com.library.exception.entity;

/** 
* @version 创建时间：2016年6月29日 下午1:48:10 
*
*/
public class BaseException extends RuntimeException{

	private int code=-100;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public BaseException(String message) {
		super(message, null);
	}

	public BaseException(String message ,Throwable throwable) {
		super(message, throwable);
	}

	public int getErrorCode() {
		return code;
	}

	public void setErrorCode(int errorCode) {
		this.code = errorCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public  Message productMessage() {
		return new Message(this);
	}
	
}
