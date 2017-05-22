package com.library.service.imp;

import java.util.ArrayList;
import java.util.Date;
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
		if (seat!=null&&seat.getState()==1) {
			throw new BaseException("座位等待确认中");
		}else if(seat!=null&&seat.getState()==2){
			throw new BaseException("座位已经被预定");
		}
		System.out.println(seat);
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
		List<Order> orders=orderDao.queryAll();
		for (Order order : orders) {
			order.resetInfo();
		}
		return orders;
	}
	
	public Order confirmOrder(Order order)throws Exception{
		List<Order> lists=orderDao.selectOrderByUidAndSid(order);
		if (lists==null||lists.size()==0) {
			throw new BaseException("您未预定/超时");
		}
		order=lists.get(0);
		System.out.println(order);
		if (order!=null&&order.getState()==1) {
			System.out.println(123);
			order.setState(2);
			return order;
		}
		order.setConfirmTime(new Date(System.currentTimeMillis()));
		orderDao.updateConfirmTime(order);
		order.setState(1);
		Seat seat=new Seat();
		seat.setId(order.getSid());
		seat.setState(2);
		seatDao.updateSeatState(seat);
		return order;
	}

	
	/**
	 * 用于检测已经失效的order
	 */
	@Override
	public void checkOrders() throws Exception {
		List<Order> orders=orderDao.selectInvalidateOrders();
		for (Order order : orders) {
			Seat seat=new Seat();
			seat.setId(order.getSid());
			seat.setState(0);
			seatDao.updateSeatState(seat);
			System.out.println(order);
		}
	}

	@Override
	public void checkOrders2() throws Exception {
		List<Integer> orders=orderDao.selectInvalidateTest();//获取实现的order
		for (Integer order : orders) {
			System.out.println(order);
		}
	}

	@Override
	public List<Integer> statisticsOrder(int num) throws Exception {
		List<Integer> lists=orderDao.countOrders(num);
		List<Integer> res=new ArrayList<Integer>();
		if (lists==null) {
			lists=new ArrayList<Integer>();
		}
		int size=num-lists.size();
		for (int i = 0; i < size; i++) {
			res.add(0);
		}
		res.addAll(lists);
		return res;
	}

	@Override
	public void cancleOrder(String oid,String sid)throws Exception {
		Seat seat=new Seat();
		seat.setId(sid);
		seat.setState(0);
		seatDao.updateSeatState(seat);
		orderDao.cancleOrder(oid);
	}

	@Override
	public void saveOrdersInit() throws Exception {
		seatDao.updateAllSeat();
	}
}
