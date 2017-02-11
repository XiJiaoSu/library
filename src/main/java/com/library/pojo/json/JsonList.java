package com.library.pojo.json;

import java.util.ArrayList;
import java.util.List;

import com.library.pojo.PTResult;

public class JsonList {

	private int code=1;//返回结果码，1表示成功，-1表示失败，此时需要完善msg提示
	private String msg;
	
	private List<PTResult> result=null;

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

	public List<PTResult> getResult() {
		if (this.result==null) {
			result=new ArrayList<PTResult>();
		}
		return result;
	}

	public void setResult(List<PTResult> list) {
		this.result = list;
	}
	
}
