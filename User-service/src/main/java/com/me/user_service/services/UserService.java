package com.me.user_service.services;

import java.util.List;

import com.me.user_service.entities.User;

public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String user_id);
	
	
	
	
	
}
