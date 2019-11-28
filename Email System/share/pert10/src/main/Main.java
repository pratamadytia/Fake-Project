package main;

import java.util.Date;

import view.LoginView;

import controller.MailController;
import controller.UserController;

public class Main {
	
	public static void main(String [] args){
		
		UserController uc = new UserController();
		
		uc.create("admin", "admin", "admin");
		
		MailController mc = new MailController();
		
		mc.create("Christmas", "A party invitation", 
				"guest", "admin", new Date());
		mc.create("Holiday", "I need holiday",
				"guest", "admin", new Date());
		mc.create("Replacement", "Jass gntiin gw ngajar",
				"guest", "admin", new Date());
		
		new LoginView();
	}
	
}
