package com.library.pojo.json;

import java.util.ArrayList;
import java.util.List;

import com.library.pojo.PTResult;

public class JsonList {

	private int code;//返回结果码，200表示成功，500表示失败，此时需要完善msg提示
	private String msg;
	
	private List<PTResult> list=null;

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

	public List<PTResult> getList() {
		if (list==null) {
			list=new ArrayList<PTResult>();
		}
		return list;
	}

	public void setList(List<PTResult> list) {
		this.list = list;
	}
	
}
