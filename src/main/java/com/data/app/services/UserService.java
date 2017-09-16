package com.data.app.services;

import org.springframework.stereotype.Service;

import com.data.app.model.User;




public interface UserService {
	 User saveUser(User user);
	 Iterable<User> listAllUsers();
	 User findOne(Integer id);
	 User findByemail(String email);
}
