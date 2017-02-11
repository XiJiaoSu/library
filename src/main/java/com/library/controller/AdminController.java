package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.exception.entity.BaseException;
import com.library.pojo.User;
import com.library.pojo.json.JsonList;
import com.library.service.UserService;

/**
 * 当前Controller是用于后天管理员进行登陆使用
 *
 */

@Controller
@RequestMapping(value = "/admin/", // 访问路径
		method = RequestMethod.GET, // 访问的方式
		produces = "application/json;charset=UTF-8"// 返回数据的格式
)
public class AdminController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping("showUser")
	@ResponseBody
	public User toIndex() throws Exception {
		// int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById("123123123");
		return user;
	}

	@RequestMapping("queryUsers")
	@ResponseBody
	public JsonList queryUsers() throws Exception {
		User user = this.userService.getUserById("123123123");
		JsonList jsonList = new JsonList();
		jsonList.getResult().add(user);
		return jsonList;
	}

	@RequestMapping("queryUserstest")
	@ResponseBody
	public JsonList queryUsersTest() throws Exception {
		if (true)
			throw new BaseException("异常测试");
		User user = this.userService.getUserById("123123123");
		JsonList jsonList = new JsonList();
		jsonList.getResult().add(user);
		return jsonList;
	}
}
