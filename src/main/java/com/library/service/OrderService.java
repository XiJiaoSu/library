package com.library.service;

import java.util.List;

import com.library.pojo.Order;

public interface OrderService {

	/**
	 * 添加订单
	 * @return
	 * @throws Exception
	 */
	public Order insertOrder()throws Exception;
	
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
	
}
