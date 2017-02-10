package com.library.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.library.dao.UserDao;
import com.library.pojo.User;
import com.library.service.*;

@Service("userService")
public class UserServiceImp implements UserService {
	@Resource
	private UserDao userDao;
	@Override
	public User getUserById(String userId){
		return this.userDao.selectByPrimaryKey(userId);
	}
}
