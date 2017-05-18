package com.library.dao;

import java.util.List;

import com.library.pojo.User;

/**
 * 用户Dao层
 *
 */
public interface UserDao {

	/**
	 * 根据用户id进行删除
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteByPrimaryKey(Integer id) throws Exception;

	/**
	 * 用户注册
	 * 
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public int insert(User record) throws Exception;

	public int insertSelective(User record) throws Exception;

	/**
	 * 根据用户Id进行查询
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User selectByPrimaryKey(String id) throws Exception;
	public List<User> selectAllUser() throws Exception;

	public int updateByPrimaryKeySelective(User record) throws Exception;

	/**
	 * 修改用户信息
	 * 
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public int updateByPrimaryKey(User record) throws Exception;

	/**
	 * 用户的登陆
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(User user) throws Exception;

	public void insertUser(User user) throws Exception;
	
	public User selectUser(User user) throws Exception;
}
