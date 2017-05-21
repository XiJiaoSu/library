package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.pojo.User;
import com.library.service.AdminService;
import com.library.service.UserService;

@Controller
public class DefaultController {

	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	@RequestMapping(value = "/")
	public String toIndex() {
		return "login";
	}
	
	@RequestMapping(value = "/index")
	public String toIndex2() {
		return "index";
	}
	
	@RequestMapping("login")
	public String adminLogin(@RequestParam(required=true,value="username")String name, @RequestParam(required=true,value="password")String password){
		User user=new User();
		user.setUsername(name);
		user.setPassword(password);
		System.out.println(user);
		try {
			user=adminService.login(user);
		} catch (Exception e) {
			return "redirect:/";
		}
		System.out.println(user);
		return "redirect:/index";
	}
	@RequestMapping(value = "/home")
	public String atoIndex() {
		return "home";
	}
	@RequestMapping(value = "/showUser")
	public String btoIndex() {
		return "showUser";
	}
	@RequestMapping(value = "/showSeat")
	public String ctoIndex() {
		return "showSeat";
	}
	@RequestMapping(value = "/showMsg")
	public String dtoIndex() {
		return "showMsg";
	}
	@RequestMapping(value = "/book")
	public String etoIndex() {
		return "book";
	}
	@RequestMapping(value = "/admin")
	public String ftoIndex() {
		return "admin";
	}
	@RequestMapping(value = "/showLibrary")
	public String gtoIndex() {
		return "showLibrary";
	}
	@RequestMapping(value = "/showChart")
	public String htoIndex() {
		return "showChart";
	}
	@RequestMapping(value="/main")
	public String main() throws Exception{
		return "main";
	}
}
