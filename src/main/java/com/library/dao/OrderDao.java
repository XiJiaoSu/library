package com.library.dao;

import java.util.List;
import java.util.Map;

import com.library.pojo.Order;

public interface OrderDao {

	public Order selectOrderById(String id) throws Exception;

	
	public List<Order> queryAll() throws Exception;

	
	public void insertOrder(Order order) throws Exception;

	public Order selectOrder(Order order) throws Exception;
	
	public List<Order> queryOrdersByUId(String uid)throws Exception;
	
	public void updateConfirmTime(Order order)throws Exception;
	
	public Order selectOrderByUidAndSid(Order order)throws Exception;
	
	public List<Order> selectInvalidateOrders()throws Exception;
	public List<Integer> selectInvalidateTest()throws Exception;
	
}
