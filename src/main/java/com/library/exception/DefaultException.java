package com.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.library.exception.entity.BaseException;
import com.library.pojo.json.JsonObject;
 

@ControllerAdvice
public class DefaultException{

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<JsonObject> expection(BaseException e) {
		ResponseEntity<JsonObject> entity = new ResponseEntity<JsonObject>(e.productJsonObject(),
				HttpStatus.OK);
		return entity;
	}
	
}
