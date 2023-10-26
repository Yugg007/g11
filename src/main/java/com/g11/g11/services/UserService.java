package com.g11.g11.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g11.g11.model.User;
import com.g11.g11.repository.UserRepository;

@Service
public class UserService {	
	@Autowired
	private UserRepository ur;
	public Boolean handleRegister(User _user) {
	    User existingUser = ur.findByusername(_user.getUsername());
	    if (existingUser != null) {
	        return false;
	    }
	    ur.save(_user);
	    return true;
	}

	public Boolean handleLogin(User _user) {
	    User existingUser = ur.findByusername(_user.getUsername());
	    return _user.getPassword().equals(existingUser.getPassword());	    		
	}

}
