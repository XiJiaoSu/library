package com.library.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.library.dao.OrderDao;
import com.library.pojo.Order;
import com.library.service.OrderService;

@Service("orderService")
public class OrderServiceImp implements OrderService {

	@Autowired
	@Qualifier("orderDao")
	private OrderDao orderDao;

	@Override
	public Order insertOrder(Order order) throws Exception {
		orderDao.insertOrder(order);
		System.out.println(order);
		return orderDao.selectOrder(order);
	}

	@Override
	public List<Order> queryOrdersByUId(String uid) throws Exception {
		return orderDao.queryOrdersByUId(uid);
	}

	@Override
	public Order selectOrderById(String id) throws Exception {
		return orderDao.selectOrderById(id);
	}

	@Override
	public List<Order> queryOrders() throws Exception {
		return orderDao.queryAll();
	}
	
	public Order confirmOrder(Map<String,String> param)throws Exception{
		Order order=orderDao.selectOrderById(param.get("oid"));
		order.setConfirmTime(new Date(System.currentTimeMillis()));
		orderDao.updateConfirmTime(order);
		return order;
	}
}
