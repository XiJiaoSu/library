package com.library.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.library.dao.LibraryDao;
import com.library.pojo.Library;
import com.library.service.LibraryService;

@Service("libraryService")
public class LibraryServiceImp implements LibraryService {

	@Autowired
	@Qualifier("libraryDao")
	private LibraryDao libraryDao;
	
	@Override
	public Library addLibrary(Library library) throws Exception {
		library.setOpen(true);
		libraryDao.insertLibrary(library);
		library=libraryDao.selectLibrary(library);
		return library;
	}

	@Override
	public Library selectLibraryById(String id) throws Exception {
		Library library=libraryDao.selectLibraryById(id);
		return library;
	}

	@Override
	public List<Library> getLibrarys() throws Exception {
		return libraryDao.selectLibrarys();
	}


}
