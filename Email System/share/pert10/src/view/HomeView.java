package view;

import java.util.Scanner;

import util.Session;
import controller.UserController;
import model.User;

public class HomeView {
	
	Scanner scan = new Scanner(System.in);
	
	public void showUserData(){
		UserController uc = new UserController();
		User user = uc.show(Session.username);
		
		System.out.println("Username	: " + user.getUsername());
		System.out.println("Name		: " + user.getName());
	}
	
	public void showMenu(){
		System.out.println("====================");
		System.out.println("1. Inbox");
		System.out.println("2. Outbox");
		System.out.println("3. Create new mail");
	}
	
	public HomeView() {
		int chooseMenu = 0;
		
		System.out.println("Home");
		System.out.println("====================");
		showUserData();
		showMenu();
		
		do{
			System.out.print("Choose >> ");
			chooseMenu = scan.nextInt();
			scan.nextLine();
		}while(chooseMenu < 1 || chooseMenu > 3);
		
		switch (chooseMenu) {
		case 1: new InboxView(); break;
		case 2:break;
		case 3:break;		
		default:
			break;
		}
				
	}
	
}
