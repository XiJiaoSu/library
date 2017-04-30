package com.library.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.pojo.Order;
import com.library.pojo.json.JsonList;
import com.library.pojo.json.JsonObject;

@Controller
@RequestMapping(value="/order/",consumes="application/json",produces="application/json;charset=utf-8",method=RequestMethod.POST)
@ResponseBody
public class OrderController {

	@RequestMapping("get")
	public JsonObject getOrderById(@RequestBody String id)throws Exception{
		
		return new JsonObject();
		
	}
	
	@RequestMapping("list")
	public JsonList<Order> getOrders(@RequestBody String uId)throws Exception{
		
		return new JsonList<Order>();
	}
	
	@RequestMapping("add")
	public JsonObject addOrder(@RequestBody Map<String,String> param)throws Exception{
		Order order=new Order();
		order.setOrderTime(new Date(System.currentTimeMillis()));
		order.setsId(param.get("sId"));
		order.setuId(param.get("uId"));
		return new JsonObject();
	}
	
	@RequestMapping("confirm")
	public JsonObject confirmOrder(@RequestBody Map<String,String> param)throws Exception{
		
		return new JsonObject();
	}
	
}
