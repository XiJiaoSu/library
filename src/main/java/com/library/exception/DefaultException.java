package com.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.library.exception.entity.BaseException;
import com.library.exception.entity.Message;
 

@ControllerAdvice
public class DefaultException{

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<Message> expection(BaseException e) {
		ResponseEntity<Message> entity = new ResponseEntity<Message>(e.productMessage(),
				HttpStatus.OK);
		return entity;
	}
	
}
