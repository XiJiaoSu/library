package com.library.dao;

import java.util.List;
import java.util.Map;

import com.library.pojo.Seat;

public interface SeatDao {

	public Seat selectOrderById(String id) throws Exception;

	public List<Seat> queryAll() throws Exception;

	public void insertSeat(Seat seat) throws Exception;

	public Seat selectSeat(Seat seat) throws Exception;
	
	public List<Seat> selectLevleSeats(Map<String,String> param)throws Exception;
}
