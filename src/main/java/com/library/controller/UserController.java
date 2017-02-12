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

@Controller
@RequestMapping(value = "/user/", // 访问路径
		method = RequestMethod.POST, // 访问的方式
		consumes = "application/json", // 传递的数据必须是JOSN
		produces = "application/json;charset=UTF-8"// 返回数据的格式
)
// 将ModelMap中名为user的属性放到Session中，以便这个属性可以跨请求访问
// @SessionAttributes("user")
public class UserController {
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

	/**
	 * 用户的登陆接口
	 * 
	 * @param user
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("login")
	@ResponseBody
	public JsonObject userLogin(@Validated(value = LoginValidator.class) // 使用HIbernate-Validator进行验证，详情看User 对象
	@RequestBody User user, // 将传递的额JSON对象传入，并自动转为user对象
			BindingResult bindingResult// 如果Hibernate-validator验证出现问题，将会获取User对象中的出错信息，并保存到当前对象中
	) throws Exception {
		if (bindingResult.hasErrors()) {
			String msg = bindingResult.getAllErrors().get(0).getDefaultMessage();
			System.out.println(msg);
			throw new BaseException(msg);
		}
		return new JsonObject(userService.login(user));
	}

	/**
	 * 用于测试
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryUsers")
	@ResponseBody
	public JsonList queryUsersTest() throws Exception {
		if (true)
			throw new BaseException("异常测试");
		return null;
	}

}
