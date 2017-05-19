package com.library.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.library.dao.MessageDao;
import com.library.exception.entity.BaseException;
import com.library.pojo.Message;
import com.library.service.MessageService;

@Service("messageService")
public class MessageServiceImp implements MessageService {

	@Autowired
	@Qualifier("messageDao")
	private MessageDao messageDao;

	@Override
	public Message selectMessageById(String id) throws Exception {
		return messageDao.selectMessageById(id);
	}

	@Override
	public List<Message> queryAll() throws Exception {
		return messageDao.queryAll();
	}

	public Message insertMessage(Message message) throws Exception {
		messageDao.insertMessage(message);
		return message;
	}

	@Override
	public void deleteMessage(String id) throws Exception {
		int a=messageDao.deleteMessage(id);
		if (a<1) {
			throw new BaseException("您删除的信息不存在");
		}
	}

	@Override
	public void updateMessage(Message message) throws Exception {
		int a=messageDao.updateMessage(message);
		if (a<1) {
			throw new BaseException("您要更改的信息不存在");
		}
	}

}
