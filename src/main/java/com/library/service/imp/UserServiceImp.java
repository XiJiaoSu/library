package com.library.service.imp;

import java.util.List;

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


	@Override
	public List<User> getAllUsers() throws Exception {
		return userDao.selectAllUser();
	}


	@Override
	public User addUser(User user) throws Exception{
		try{
		userDao.insertUser(user);
		user=userDao.selectUser(user);
		}catch(Exception e){
			throw new BaseException("用户名/或邮箱已被使用");
		}
		return user;
	}
}
