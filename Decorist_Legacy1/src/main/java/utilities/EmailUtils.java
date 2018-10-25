package utilities;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

import BusinessRules.Log;
import junit.framework.Assert;

public class EmailUtils {
	
	/*For Outlook
    host="outlook.office365.com";
    expFrom="Decorist <yourteam@decorist.com>";
    expEmailSubject="Thanks for Your Decorist Room Design Purchase!";*/
	public static void verifyReceivedEmail(String host,final String userName,final String pwd,String expFrom,String expEmailSubject) {
		Log.info("Verifying received email");
		int count=0;
		Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.port", "587");
	    Session session = Session.getInstance(props,new javax.mail.Authenticator() {
	              protected PasswordAuthentication getPasswordAuthentication() {
	                  return new PasswordAuthentication(userName, pwd);
	              }
	            });
	    Store store;
		try {
			store = session.getStore("imaps");
			store.connect(host, userName, pwd);
			Folder emailFolder = store.getFolder("INBOX");  
			emailFolder.open(Folder.READ_WRITE); 
			Message[] messages = emailFolder.getMessages();  
			   for (int i = 0; i < messages.length; i++) {  
			    Message message = messages[i];
			    String emailSubject=message.getSubject();
			    Address From=message.getFrom()[0];
			    String actFrom=message.getFrom()[0].toString();
			    for (int j=1;j<300000;j++) {
			    	try {
			    		if (actFrom.equals(expFrom)) {
			    			if (emailSubject.contains(expEmailSubject)) {
						    	Log.info("Pass:Email Received from:"+actFrom);
						    	count++;
						    	Log.info("Email number:"+i+1);
						    	Log.info("Received Date:"+message.getReceivedDate());
						    	Log.info("Subject:"+emailSubject);
						    	Log.info("From:"+message.getFrom()[0]);
						    	Log.info("Text:"+message.getContent().toString());
						    	Log.info("======================");
						    	//Below 3 statements will delete the mail
                                message.setFlag(Flags.Flag.DELETED, true);
                                emailFolder.close(true);
       		    	            store.close();
                                break;
						      }
			    		}
			    		
			    	}
			    	catch(Exception e) {
			    		try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			    	}
			    }
			    
			   
			    }
			   if (count<1) {
				   Log.info("Fail:No Email Received within 5 minutes From:"+expFrom+" with subject:"+expEmailSubject);
				   Assert.fail();
			   }
			   
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
	}
}
