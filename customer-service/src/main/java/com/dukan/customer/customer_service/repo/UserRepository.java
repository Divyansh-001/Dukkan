package com.dukan.customer.customer_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dukan.customer.customer_service.entity.UsersData;

@Repository
public interface UserRepository extends JpaRepository <UsersData, Long>
{
	
}
