package com.dukan.customer.customer_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dukan.customer.customer_service.dto.UserDTO;
import com.dukan.customer.customer_service.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserProfileController 
{
	UserService userService = null;
	
	@Autowired
	UserProfileController(UserService userService)
	{
		this.userService = userService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO userDTO)
	{
		return new ResponseEntity<Object>(userService.save(userDTO) , HttpStatus.OK);
	}
}
