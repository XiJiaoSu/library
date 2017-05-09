package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

	@RequestMapping(value = "/")
	public String toIndex() {
		return "login";
	}
	@RequestMapping(value="/login")
	public String loign() throws Exception{
		return "index";
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
