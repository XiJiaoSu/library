package com.library.pojo;

import org.apache.ibatis.type.Alias;

/**
 * 座位
 *
 */
@Alias("SeatBean")
public class Seat implements PTResult{

	private String id;//座位id
	private String name;//座位名
	private int state;//当前座位状态
	private String pid;//图书馆
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

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", name=" + name + ", state=" + state + ", pid=" + pid + ", level=" + level
				+ ", description=" + description + "]";
	}

	
	
	
}
