package controller;

import java.util.ArrayList;

import model.User;

public class UserController {
	
	public static ArrayList<User> users
					= new ArrayList<User>();
	//index, show, create, update, delete, store
	//get, post, put, patch 
	public boolean authenticate(String username,
						String password){
		for (User user : users) {
			if(user.getUsername().equals(username)
				&& user.getPassword().equals(password)){
					return true;
			}
		}
		return false;
	}
	
	public User show(String username){
		
		for (User user : users) {
			if(user.getUsername().equals(username)){
				return user;
			}
		}
		
		return null;
	}
	
	public void create(String username, String password,
			String name){
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		
		users.add(user);
	}
	
}
