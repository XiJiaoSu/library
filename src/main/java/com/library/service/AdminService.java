package com.library.service;

import com.library.pojo.User;

public interface AdminService {

	/**
	 * 用户登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(User user) throws Exception;
	
}
