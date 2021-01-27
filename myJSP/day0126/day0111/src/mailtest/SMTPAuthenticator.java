package mailtest;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("yshan5670","fintech1234");
	}
	
}





