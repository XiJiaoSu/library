package com.library.service;

import java.util.List;
import java.util.Map;

import com.library.pojo.Seat;

/**
 * 座位Service
 *
 */
public interface SeatService {

	public Seat getSeatById(String id)throws Exception;
	
	public Seat addSeat(Seat seat)throws Exception;
	
	public List<Seat> getSeats()throws Exception;
	
	public List<Seat> getLevleSeats(Map<String,String> param)throws Exception;
}
