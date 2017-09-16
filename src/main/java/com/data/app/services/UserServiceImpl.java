package com.data.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.app.model.User;
import com.data.app.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService{
	UserRepo userrepository;
	
	@Autowired
    public void setUserRepository(UserRepo repo) {
        this.userrepository = repo;
    }
	
	@Override
	public User saveUser(User user) {
		System.out.println("user saving ");
		return userrepository.save(user);
		
	}
	
	@Override
    public Iterable<User> listAllUsers() {
        return userrepository.findAll();
    }
	@Override
    public User findOne(Integer id) {
        return userrepository.findOne(id);
    }
	
	@Override
	public User findByemail(String email) {
		//User user= new User();
		return userrepository.findByemail(email);
	}

}
