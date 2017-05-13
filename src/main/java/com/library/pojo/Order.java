package com.library.pojo;

import java.util.Date;

import org.apache.ibatis.type.Alias;
@Alias("OrderBean")
public class Order implements PTResult{

	private String id;//订单id
	private String name;
	private Date orderTime;//下单时间
	private Date confirmTime;//确定时间
	
	private String uid;//用户id
	private String sid;//座位id
	private int state=0;//预定状态,0 未确认,1确认
	
//	private User user;//用户
	
	private String description;//描述信息

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

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	
	public String getDescription() {
		return description;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", orderTime=" + orderTime.getTime()+":"+orderTime + ", confirmTime=" + confirmTime
				+ ", uid=" + uid + ", sid=" + sid + ", description=" + description + "]";
	}

}
