package com.data.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.data.app.model.User;
import com.data.app.services.UserService;

@RestController
@RequestMapping("/api")
public class DataController {
	
	private Logger log = Logger.getLogger(this.getClass());
	UserService userservice;
	Logger logger = Logger.getLogger(DataController.class.getName());
	@Autowired
	
	public void setUserService(UserService us) {
	    this.userservice = us;
	}
	
	@RequestMapping("/")
    String index(Model model){
		 model.addAttribute("user", new User());
        return "welcome";
    }
	@RequestMapping(value = "/form", method = RequestMethod.GET)
    public String viewForm(Model model){
		System.out.println("in controller view");
        model.addAttribute("user", new User());
        return "form";
    }
	
	/*@RequestMapping(value="/save", method = RequestMethod.POST,consumes="application/json")
	
    public User submitForm(@RequestBody User user) throws Exception{
		try {
			System.out.println(user.getEmail());
			userservice.saveUser(user);
			return user;
		}catch(Exception e) {
			System.out.println("exception caught---- "+e.getMessage());
			System.out.println("exception root cause---- "+e.getCause());
			throw e;
		}
       // return user;
     }
	*/
	/*@RequestMapping("/allresult")
    public String getForm(Model model){
      
		model.addAttribute("users", userservice.listAllUsers());
        
        System.out.println("in all");
        return "allresult";
        
    }*/
	
	
	@RequestMapping(value="/save", method = RequestMethod.POST,consumes="application/json")
    public Map submitForm(@RequestBody User user){
		System.out.println(user.getEmail());
		HashMap map = new HashMap<>();
		if(userservice.findByemail(user.getEmail())!=null) {
			 map.put("err_msg", "This e-mail is duplicate.");
		}
		else {
			userservice.saveUser(user);
			map.put("succ_msg", "Form submitted successfully.");
		}
		return map;
     }
	
	
	@RequestMapping("/allresult")
    public Iterable<User> getForm(){
		
		System.out.println(userservice.listAllUsers());
        return userservice.listAllUsers();
        
    }
}
