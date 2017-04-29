package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.controller.validation.LoginValidator;
import com.library.exception.entity.BaseException;
import com.library.pojo.User;
import com.library.pojo.json.JsonList;
import com.library.pojo.json.JsonObject;
import com.library.service.UserService;

/**
 * 当前Controller是用于后天管理员进行登陆使用
 *
 */

@Controller
@RequestMapping(value = "/admin/", // 访问路径
		method = RequestMethod.POST, // 访问的方式
		consumes = "application/json", // 传递的数据必须是JOSN
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

	@RequestMapping("login")
	@ResponseBody
	public JsonObject adminLogin(@Validated(value = LoginValidator.class) // 使用HIbernate-Validator进行验证，详情看User 对象
	@RequestBody User user, // 将传递的额JSON对象传入，并自动转为user对象
			BindingResult bindingResult// 如果Hibernate-validator验证出现问题，将会获取User对象中的出错信息，并保存到当前对象中
	) throws Exception {
		System.out.println("admin_login"+user);
		if (bindingResult.hasErrors()) {
			String msg = bindingResult.getAllErrors().get(0).getDefaultMessage();
			System.out.println(msg);
			throw new BaseException(msg);
		}
		System.out.println("admin_login");
		return new JsonObject(userService.login(user));
	}
	
	@RequestMapping("login2")
	@ResponseBody
	public JsonObject adminLogin(@RequestBody User user) throws Exception {
		System.out.println(user);
		System.out.println("admin_login");
		return new JsonObject(userService.login(user));
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
