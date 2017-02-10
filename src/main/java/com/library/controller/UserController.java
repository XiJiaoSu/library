package com.library.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.pojo.User;
import com.library.service.UserService;


@Controller
@RequestMapping(value = "/user/", // 访问路径
method = RequestMethod.GET, // 访问的方式
produces = "application/json;charset=UTF-8"// 返回数据的格式
)
//将ModelMap中名为user的属性放到Session中，以便这个属性可以跨请求访问
//@SessionAttributes("user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("showUser")
	@ResponseBody
	public User toIndex()throws Exception{
//		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById("123123123");
		return user;
	}
}
