package com.library.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.library.dao.OrderDao;
import com.library.exception.entity.BaseException;
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
	
	public Order confirmOrder(Order order)throws Exception{
		order=orderDao.selectOrderByUidAndSid(order);
		if (order==null) {
			throw new BaseException("您未预定/超时");
		}
		System.out.println(order);
//		order.setConfirmTime(new Date(System.currentTimeMillis()));
		orderDao.updateConfirmTime(order);
		order.setState(1);
		return order;
	}
}
