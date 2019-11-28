package view;

import java.util.Scanner;

import util.Session;

import controller.UserController;

public class LoginView {
	
	Scanner scan = new Scanner(System.in);
	
	public void authenticate(){
		String username, password;
		UserController uc = new UserController();
		Boolean authenticateResult = false;
		do{
			System.out.print("Username: ");
			username = scan.nextLine();
			System.out.print("Password: ");
			password = scan.nextLine();
			
			authenticateResult = uc.authenticate(username, password);
		}while(!authenticateResult);
		
		Session.username = username;
		new HomeView();
	}
	
	public LoginView() {
		System.out.println("Binus Mail");
		System.out.println("========================");
		authenticate();
	}
}
