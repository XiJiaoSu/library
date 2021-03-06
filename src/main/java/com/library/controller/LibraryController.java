package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.pojo.Library;
import com.library.pojo.User;
import com.library.pojo.json.JsonList;
import com.library.pojo.json.JsonObject;
import com.library.service.LibraryService;

/**
 * 图书馆相关
 *
 */
@Controller
@RequestMapping(value = "/library/",
	consumes = "application/json", 
	produces = "application/json;charset=utf-8",
	method=RequestMethod.POST
		)
@ResponseBody
public class LibraryController {

	@Autowired
	@Qualifier("libraryService")
	private LibraryService libraryService;
	
	
	@RequestMapping(value="add")
	public JsonObject addLibrary(@RequestBody Library library)throws Exception{
		library=libraryService.addLibrary(library);
		return new JsonObject(library);
	}
	@RequestMapping(value="get")
	public JsonObject getLibraryById(@RequestBody String id)throws Exception{
		String[] result = id.split("\"");
		Library library=libraryService.selectLibraryById(result[3]);
		return new JsonObject(library);
	}
	
	@RequestMapping(value="list")
	public JsonList<Library> getLibrarys()throws Exception{
		
		return new JsonList<Library>(libraryService.getLibrarys());
	}
	
}
