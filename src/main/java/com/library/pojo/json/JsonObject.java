package com.library.pojo.json;

import com.library.pojo.PTResult;

public class JsonObject {

	private int code=200;//返回结果码，200表示成功，500表示失败，此时需要完善msg提示
	private String msg;
	
	private PTResult result;

	public int getCode() {
		return code;
	}

	public JsonObject setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public PTResult getResult() {
		return result;
	}

	public JsonObject setResult(PTResult result) {
		this.result = result;
		return this;
	}

	
}
