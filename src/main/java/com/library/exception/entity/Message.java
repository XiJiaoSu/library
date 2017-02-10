package com.library.exception.entity;

/**
 * @version 创建时间：2016年6月29日 下午1:44:02
 *
 */
public class Message {

	private Integer code;
	private String msg;

	public Message(BaseException e) {
		this.code=e.getErrorCode();
		this.msg=e.getMessage();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
