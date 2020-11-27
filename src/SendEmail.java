import java.util.*;
import javax.mail.*;  
import javax.mail.internet.*;

public class SendEmail {  
	public static void sender(String recipient) throws AddressException, Exception {
		System.out.println("Start");
		Properties properties = new Properties();    
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.startls.enable", true);
		properties.put("mail.smtp.hots", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String email = "notifications.system.module@gmail.com";
		String pass = "notsys2020";

		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, pass);
			}
		});

		Message messagge = prepareMessage(session, email, recipient);
		Transport.send(messagge);
		System.out.println("Success");
	}
	private static Message prepareMessage(Session session, String email, String recipient) throws AddressException, MessagingException {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("Confirmation");
			message.setText("Confiemed");
			return message;
		} catch (Exception e) {
			System.out.println(e);
			//Logger.getLogger(JavaMailUtil.class.getName().log(Level.SEVERE, null, e));
		}
		return null;
		
	}
	public static void main(String[] args) throws MessagingException {
		System.out.println("test");
		try {
			SendEmail.sender("abdelhadioumar@gmail.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
