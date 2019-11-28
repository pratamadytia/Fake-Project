package controller;

import java.util.ArrayList;
import java.util.Date;

import model.Mail;
import model.User;

public class MailController {
	public static ArrayList<Mail> mails = new ArrayList<Mail>();
	
	public void create(String title, String content, String sender, String receiver, Date timestamp){
		Mail mail = new Mail();
		mail.setTitle(title);
		mail.setContent(content);
		mail.setSender(sender);
		mail.setReceiver(receiver);
		mail.setTimestamp(timestamp);
		
		mails.add(mail);
	}
	
	public ArrayList<Mail> showInbox(String username){
		ArrayList<Mail> inbox = new ArrayList<Mail>();
		
		for(Mail mail : mails){
			if(mail.getReceiver().equals(username)){
				inbox.add(mail);
			}
		}
		return inbox;
	}
}
