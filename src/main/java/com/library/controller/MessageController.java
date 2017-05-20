package com.library.controller;

import java.util.Date;
import java.util.Map;

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
	public JsonObject getMessageById(@RequestBody Map<String, String> params) throws Exception {
		String id=params.get("id");
		System.out.println(id);
		return new JsonObject(messageService.selectMessageById(id));
	}

	@RequestMapping("add")
	public JsonObject addMessage(@RequestBody Message message) throws Exception {
		message.setTime(new Date(System.currentTimeMillis()));
		messageService.insertMessage(message);
		return new JsonObject();
	}

	@RequestMapping("list")
	public JsonList<Message> getMessages() throws Exception {
		return new JsonList<Message>(messageService.queryAll());
	}

	@RequestMapping("update")
	public JsonObject updateMessage(@RequestBody Message message) throws Exception {
		message.setTime(new Date(System.currentTimeMillis()));
		messageService.updateMessage(message);
		return new JsonObject();
	}
	
	@RequestMapping("delete")
	public JsonObject deleteMesssage(@RequestBody Map<String, String> params)throws Exception{
		String id=params.get("id");
		messageService.deleteMessage(id);
		return new JsonObject();
	}
	
}
