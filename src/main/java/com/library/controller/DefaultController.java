package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

	@RequestMapping(value="/login")
	public String loign() throws Exception{
		System.out.println("Index");
		return "login";
	}
	
	@RequestMapping(value="/main")
	public String main() throws Exception{
		System.out.println("Index");
		return "main";
	}
}
