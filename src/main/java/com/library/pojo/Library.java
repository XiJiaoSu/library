package com.library.pojo;

public class Library implements PTResult{
	private String id;
	private String name;//名字
	private String address;//地址
	private String start;//结束时间
	private String end;//关门时间
	private String description;//描述
	private boolean idOpen;//是否开放
	private int level;//图书馆的层数
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isIdOpen() {
		return idOpen;
	}
	public void setIdOpen(boolean idOpen) {
		this.idOpen = idOpen;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
