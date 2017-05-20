package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	
}
