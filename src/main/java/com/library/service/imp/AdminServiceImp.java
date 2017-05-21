package com.library.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.library.dao.AdminDao;
import com.library.exception.entity.BaseException;
import com.library.pojo.User;
import com.library.service.AdminService;

@Service("adminService")
public class AdminServiceImp implements AdminService{

	@Autowired
	@Qualifier("adminDao")
	private AdminDao adminDao;
	
	@Override
	public User login(User user) throws Exception {
		user=adminDao.login(user);
		if (user==null) {
			throw new BaseException("用户名/密码错误");
		}
		return user;
	}

}
