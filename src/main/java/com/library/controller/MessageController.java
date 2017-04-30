package com.library.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.pojo.Message;
import com.library.pojo.json.JsonList;
import com.library.pojo.json.JsonObject;
import com.library.service.MessageService;

@Controller
@RequestMapping(value = "/msg/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json;charset=utf-8")
@ResponseBody
public class MessageController {

	@Autowired
	@Qualifier("messageService")
	private MessageService messageService;

	@RequestMapping(value="get")
	public JsonObject getMessageById(@RequestBody String id) throws Exception {
		System.out.println(id);
		return new JsonObject(messageService.selectMessageById(id));
	}

	@RequestMapping("add")
	public JsonObject addMessage(@RequestBody Message message) throws Exception {
		message.setTime(new Date(System.currentTimeMillis()));
		return new JsonObject(messageService.insertMessage(message));
	}

	@RequestMapping("list")
	public JsonList<Message> getMessages() throws Exception {
		return new JsonList<Message>(messageService.queryAll());
	}

}
