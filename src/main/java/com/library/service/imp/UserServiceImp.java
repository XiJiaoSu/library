package com.library.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.library.dao.UserDao;
import com.library.exception.entity.BaseException;
import com.library.pojo.User;
import com.library.service.UserService;

@Service("userService")
public class UserServiceImp implements UserService {
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Override
	public User getUserById(String userId) throws Exception{
		return this.userDao.selectByPrimaryKey(userId);
	}
	
	
	@Override
	public User login(User user) throws Exception {
		user=userDao.login(user);
		if (user==null) {
			System.out.println("ERROR");
			throw new BaseException("用户名或者密码错误");
		}
		return user;
	}
}
