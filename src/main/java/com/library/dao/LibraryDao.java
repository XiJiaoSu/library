package com.library.dao;

import java.util.List;

import com.library.pojo.Library;
import com.library.pojo.User;

public interface LibraryDao {

	/**
	 * 添加一条图书馆记录
	 * @param library
	 * @throws Exception
	 */
	public void insertLibrary(Library library)throws Exception;
	
	/**
	 * 根据添加的一条图书馆记录,获取数据库记录(主要是id)
	 * @param library
	 * @throws Exception
	 */
	public Library selectLibrary(Library library)throws Exception;
	
	/**
	 * 根据id挑选一条图书馆记录
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Library selectLibraryById(String id)throws Exception;
	
	/**
	 * 查询多个图书馆
	 * @return
	 * @throws Exception
	 */
	public List<Library> selectLibrarys()throws Exception;
	
	
	public String getLibraryName(String id)throws Exception;
	
}
