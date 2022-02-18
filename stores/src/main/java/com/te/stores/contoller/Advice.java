package com.te.stores.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.stores.bean.UserResponse;
import com.te.stores.customexception.CustomException;

@RestControllerAdvice
public class Advice {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<UserResponse>  dataIsNull(CustomException exception){
		UserResponse response = new UserResponse(true, exception.getMessage());
		return new ResponseEntity<UserResponse>(response, HttpStatus.NOT_FOUND);
		
	}
}
