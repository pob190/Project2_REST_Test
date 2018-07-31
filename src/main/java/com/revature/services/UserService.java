package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.daos.UserDaoImpl;
import com.revature.pojos.User;

@Service("UserService")
public class UserService {

	UserDaoImpl UDI = new UserDaoImpl();
	
	public User getUser (String username) {
		List<User> users = UDI.getAllUsers();
		for(User u : users) {
			if(username.equals(u.getUsername())) {
				return u;
			}
		}
		return null;

	}
	
	public List<User> getAllUsers(){
		System.out.println("GET ALL USERS SERVICE");
		return UDI.getAllUsers();
	}
	
	public User validateUser(String username, String password) {
		List<User> users = UDI.getAllUsers();
		for(User u : users) {
			if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
				return u;
			}
		}
		return null;
	}

	public void addUser(User u) {
		UDI.addUser(u);
	}
	
}
