package com.dukan.customer.customer_service.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dukan.customer.customer_service.dto.UserDTO;
import com.dukan.customer.customer_service.entity.Address;
import com.dukan.customer.customer_service.entity.UsersData;
import com.dukan.customer.customer_service.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService 
{
	UserRepository userRepository = null;
	ModelMapper modelMapper = null;
	
	@Autowired
	UserService(UserRepository userRepository, ModelMapper modelMapper)
	{
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}
	
	
	@Transactional
	public String save(UserDTO userDTO)
	{
		UsersData userData = new UsersData();
		modelMapper.map(userDTO, userData);
		List<Address> address = userData.getAddress();
		address.forEach( (x) -> {
			x.setUsersData(userData);
		});
		UsersData a = userRepository.save(userData);
		if(a.getUserId() == null)
		{
			return "error";
		}
		else
		{
			return a.getFirstName();
		}

	}
}
