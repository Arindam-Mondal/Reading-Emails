package email.read;

import java.util.*;

import javax.mail.*;

public class ReadingEmail {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap-mail.outlook.com", "uname", "pass");//Enter your uname and pass
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            /*Changes Starts*/
            int no_of_msg = inbox.getMessageCount();
            System.out.println("No of msg = "+inbox.getMessageCount());
            
            for (int i = 1 ; i <= no_of_msg; i++){
            	Message msg = inbox.getMessage(i);
            	Address[] in = msg.getFrom();
                for (Address address : in) {
                    System.out.println("FROM:" + address.toString());
                }
    
            	System.out.println("SENT DATE:" + msg.getSentDate());
                System.out.println("SUBJECT:" + msg.getSubject());
                System.out.println("**************************************************");
                /*System.out.println("CONTENT:" + msg.getContent());*/
            }
            
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
}
