package com.library.service;

import java.util.List;

import com.library.pojo.Library;
import com.library.pojo.User;

public interface LibraryService {

	/**
	 * 添加一条图书馆记录
	 * @param library
	 * @return
	 * @throws Exception
	 */
	public Library addLibrary(Library library)throws Exception;
	
	
	/**
	 * 根据id查询图书馆一条记录
	 * @param id
	 * @return 
	 * @throws Exception
	 */
	public Library selectLibraryById(String id)throws Exception;
	
	
	public List<Library> getLibrarys()throws Exception;
	
}
