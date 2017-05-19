package com.library.dao;

import java.util.List;

import com.library.pojo.Message;

public interface MessageDao {

	/**
	 * 根据指定的id,获取指定的Message
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Message selectMessageById(String id) throws Exception;

	/**
	 * 查询多个message
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Message> queryAll() throws Exception;

	/**
	 * 添加一条资讯信息
	 * 
	 * @param message
	 * @throws Exception
	 */
	public void insertMessage(Message message) throws Exception;

	/**
	 * 根据添加的信息获取id
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public Message selectMessage(Message message) throws Exception;

	public int deleteMessage(String id)throws Exception;

	public int updateMessage(Message message)throws Exception;

}
