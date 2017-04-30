package com.library.pojo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("MessageBean")
public class Message implements PTResult {

	private String id;
	private String title;
	private String message;
	private Date time;
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
