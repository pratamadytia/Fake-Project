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
		
		mc.create("Natal", "Undangan natalan", "guest", "admin", new Date());
		mc.create("Tahun baruan", "izin libur", "guest", "admin", new Date());
		mc.create("Replacement", "aslab ga bisa masuk", "guest", "admin", new Date());
		
		new LoginView();
	}
}
