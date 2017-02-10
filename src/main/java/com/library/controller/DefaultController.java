package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

	@RequestMapping(value="/test")
	public String index() throws Exception{
		System.out.println("Index");
		return "index";
	}
}
