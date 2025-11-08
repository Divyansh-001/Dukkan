package com.dukan.customer.customer_service.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String , String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach( (error) -> {
			errorMap.put(error.getField(), error.getDefaultMessage()+", "+"rejected value is "+error.getRejectedValue());
			
		});
		return new ResponseEntity<Object>(errorMap, HttpStatus.BAD_REQUEST);
	}
}
