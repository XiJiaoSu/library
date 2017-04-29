package com.library.pojo;

/**
 * 座位
 *
 */
public class Seat implements PTResult{

	private String id;//座位id
	private String name;//座位名
	private int state;//当前座位状态
	private String lId;//图书馆
	private int level;//所在楼层
	
	private String description;//描述

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getlId() {
		return lId;
	}

	public void setlId(String lId) {
		this.lId = lId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
