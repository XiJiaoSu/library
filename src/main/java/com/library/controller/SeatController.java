package com.library.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.pojo.Seat;
import com.library.pojo.json.JsonList;
import com.library.pojo.json.JsonObject;
import com.library.service.SeatService;

@Controller
@RequestMapping(value = "/seat/", consumes = "application/json", produces = "application/json;charset=utf-8")
@ResponseBody
public class SeatController {

	@Autowired
	@Qualifier("seatService")
	private SeatService seatService;
	
	@RequestMapping("add")
	public JsonObject addSeat(@RequestBody Seat seat)throws Exception{
		seat.setState(0);
		System.out.println(seat);
		return new JsonObject(seatService.addSeat(seat));
	}
	
	@RequestMapping("get")
	public JsonObject getSeat(@RequestBody String id)throws Exception{
		
		return new JsonObject(seatService.getSeatById(id));
	}
	
	@RequestMapping("list")
	public JsonList<Seat> getSeats()throws Exception{
		return new JsonList<Seat>(seatService.getSeats());
	}
	
	
	@RequestMapping("level")
	public JsonList<Seat> getLevelSeats(@RequestBody Map<String,String> param)throws Exception{
		return new JsonList<Seat>(seatService.getLevleSeats(param));
	}
}
