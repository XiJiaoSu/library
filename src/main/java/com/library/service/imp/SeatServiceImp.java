package com.library.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.library.dao.SeatDao;
import com.library.pojo.Seat;
import com.library.service.SeatService;

@Service("seatService")
public class SeatServiceImp implements SeatService {

	@Autowired
	@Qualifier("seatDao")
	private SeatDao seatDao;
	
	@Override
	public Seat getSeatById(String id) throws Exception {
		return seatDao.selectSeatById(id);
	}

	@Override
	public Seat addSeat(Seat seat) throws Exception {
		seatDao.insertSeat(seat);
		return seatDao.selectSeat(seat);
	}

	@Override
	public List<Seat> getSeats() throws Exception {
		return seatDao.queryAll();
	}

	public List<Seat> getLevleSeats(Map<String,String> param)throws Exception{
		return seatDao.selectLevleSeats(param);
	}
	
}
