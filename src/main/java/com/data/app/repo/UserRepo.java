package com.data.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.data.app.model.User;



public interface UserRepo extends CrudRepository<User, Integer>{
	User findByemail(String email);
	
}
