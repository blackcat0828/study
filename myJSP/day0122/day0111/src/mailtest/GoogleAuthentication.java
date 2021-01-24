package mailtest;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator{

    PasswordAuthentication passAuth;

    public GoogleAuthentication() {
   
    	//PasswordAuthentication(구글id,앱비밀번호)
        passAuth = 
        	new PasswordAuthentication("blueangel8989","jlznxxdnaefswdta");

    }

    public PasswordAuthentication getPasswordAuthentication() {
        return passAuth;
    }

}