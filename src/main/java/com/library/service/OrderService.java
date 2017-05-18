package com.library.service;

import java.util.List;
import java.util.Map;

import com.library.pojo.Order;

public interface OrderService {

	/**
	 * 添加订单
	 * @return
	 * @throws Exception
	 */
	public Order insertOrder(Order order)throws Exception;
	
	/**
	 * 查询某人预定记录
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public List<Order> queryOrdersByUId(String uid)throws Exception;
	
	/**
	 * 查询订单
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Order selectOrderById(String id)throws Exception;
	
	public List<Order> queryOrders()throws Exception;

	public Order confirmOrder(Order order)throws Exception;
	
	
	public void checkOrders()throws Exception;
	
	public void checkOrders2() throws Exception ;
	
	
	public List<Integer> statisticsOrder(int num)throws Exception;

	public void cancleOrder(String oid,String sid)throws Exception;

	void saveOrdersInit() throws Exception;
	
}
