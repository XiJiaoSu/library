package com.library.service.imp;

import java.util.List;

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
	public Order insertOrder() throws Exception {
		return null;
	}

	@Override
	public List<Order> queryOrdersByUId(String uid) throws Exception {
		return null;
	}

	@Override
	public Order selectOrderById(String id) throws Exception {
		return null;
	}
	
}
