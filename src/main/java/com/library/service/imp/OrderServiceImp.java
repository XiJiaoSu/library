package com.library.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.library.dao.OrderDao;
import com.library.dao.SeatDao;
import com.library.exception.entity.BaseException;
import com.library.pojo.Order;
import com.library.pojo.Seat;
import com.library.service.OrderService;

@Service("orderService")
public class OrderServiceImp implements OrderService {

	@Autowired
	@Qualifier("orderDao")
	private OrderDao orderDao;
	
	@Autowired
	@Qualifier("seatDao")
	private SeatDao seatDao;
	
	@Override
	public Order insertOrder(Order order) throws Exception {
		Seat seat=seatDao.selectSeatById(order.getSid());
		if (seat==null) {
			throw new BaseException("座位不存在");
		}
		if (seat.getState()==1) {
			throw new BaseException("座位等待确认中");
		}else if(seat.getState()==2){
			throw new BaseException("座位已经被预定");
		}
		orderDao.insertOrder(order);
		System.out.println(order);
//		Seat seat=new Seat();
		seat.setId(order.getSid());
		seat.setState(1);
		seatDao.updateSeatState(seat);
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
		Seat seat=new Seat();
		seat.setId(order.getSid());
		seat.setState(2);
		seatDao.updateSeatState(seat);
		return order;
	}
}
