package com.library.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.pojo.Order;
import com.library.pojo.json.JsonList;
import com.library.pojo.json.JsonObject;
import com.library.service.OrderService;

@Controller
@RequestMapping(value="/order/",consumes="application/json",produces="application/json;charset=utf-8",method=RequestMethod.POST)
@ResponseBody
public class OrderController {

	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	
	
	@RequestMapping("get")
	public JsonObject getOrderById(@RequestBody String id)throws Exception{
		return new JsonObject(orderService.selectOrderById(id));
		
	}
	
	@RequestMapping("lists")
	public JsonList<Order> getAllOrders()throws Exception{
		return new JsonList<Order>(orderService.queryOrders());
	}
	
	@RequestMapping("list")
	public JsonList<Order> getOrders(@RequestBody String uid)throws Exception{
		List<Order> orders=orderService.queryOrdersByUId(uid);
		for (Order o:orders) {
			System.out.println(o);
		}
		return new JsonList<Order>(orders);
	}
	
	@RequestMapping("add")
	public JsonObject addOrder(@RequestBody Map<String,String> param)throws Exception{
		Order order=new Order();
		order.setOrderTime(new Date(System.currentTimeMillis()));
		order.setConfirmTime(new Date(System.currentTimeMillis()-10*1000));
		order.setSid(param.get("sid"));
		order.setUid(param.get("uid"));
		order.setName(System.currentTimeMillis()+"");
		return new JsonObject(orderService.insertOrder(order));
	}
	
	@RequestMapping("confirm")
	public JsonObject confirmOrder(@RequestBody Map<String,String> param)throws Exception{
		Order order=new Order();
		order.setSid(param.get("sid"));
		order.setUid(param.get("uid"));
		order.setConfirmTime(new Date(System.currentTimeMillis()));
		return new JsonObject(orderService.confirmOrder(order));
	}
	
	@RequestMapping("check")
	public JsonObject check()throws Exception{
		orderService.checkOrders();
		orderService.checkOrders2();
		return new JsonObject();
	}
	
	@RequestMapping("onums")
	public JsonList<Integer> getOrderNumbers(@RequestBody Integer num)throws Exception{
		return new JsonList<Integer>(orderService.statisticsOrder(num));
	}
}
