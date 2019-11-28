package view;

import model.Mail;
import util.Session;
import controller.MailController;

public class InboxView {
	
	public void showInbox(){
		MailController mc = new MailController();
		int i=0;
		for(Mail mail : mc.showInbox(Session.username)){
			System.out.println("[" + (++i) + "]========================");
			System.out.println("Title    :" + mail.getTitle());
			System.out.println("Content  :" + mail.getContent());
			System.out.println("Receiver :" + mail.getReceiver());
			System.out.println("Date     :" + mail.getTimestamp());
		}
	}
	
	public InboxView() {
		System.out.println("Inbox");
		System.out.println("====================");
		showInbox();
	}
}
