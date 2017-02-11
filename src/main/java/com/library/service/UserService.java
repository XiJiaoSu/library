package com.library.service;

import com.library.pojo.User;
/**
 * 用户Service层
 *
 */
public interface UserService {
	/**
	 * 根据当前用户的的Id 查询当前用户的信息
	 * @param userId
	 * @return
	 */
	public User getUserById(String userId)throws Exception;
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(User user) throws Exception;
}
