package com.library.service;

import java.util.List;

import com.library.pojo.Message;

public interface MessageService {

	/**
	 * 根据message的id,获取指定的id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Message selectMessageById(String id) throws Exception;

	/**
	 * 获取所有的额资讯
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Message> queryAll() throws Exception;

	/**
	 * 添加一条资讯
	 * 
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public Message insertMessage(Message message) throws Exception;

	public void deleteMessage(String id)throws Exception;

	public void updateMessage(Message message)throws Exception;

}
