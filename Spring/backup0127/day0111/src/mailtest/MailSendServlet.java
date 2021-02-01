package mailtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mailSend")
public class MailSendServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public MailSendServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sender = request.getParameter("sender");
		String receiver = request.getParameter("receiver");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			
			
			Properties properties = System.getProperties();

//			mail.smtp.starttls.enable이 Starttls를 이용한 메일 보내기의 핵심이다. 
//			Starttls는 JavaMail에 TLS모드를 시작하라고 명시적으로 요청한다. 
//			즉 Starttls을 확인하기 전까지 JavaMail API는 해당 메일을 암호화되지 않은 
//			평문으로 보낸다고 가정한다. 
//			Starttls 설정을 확인하면 보안 관련 채널을 생성하여 인증서 확인 등의 작업을 거친다.
//			위의 props 설정 중 props.put("mail.smtp.ssl.trust", host); 를 
//			제거하면 인증서 관련 오류가 발생한다. 
//			이를 해결하기 위해서는 인증서 정보를 로컬에 저장해야 하는데 
//			이메일에서 이러한 작업까지는 필요없을 듯 하다.			
			properties.put("mail.smtp.starttls.enable", "true");
			
			//네이버로 전송시
			//properties.put("mail.smtp.host", "smtp.naver.com")
			
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.port", "465");
			
			//네이버로 전송시
			properties.put("mail.smtp.user", "blueangel8989@gmail.com");
			
			properties.put("mail.smtp.debug", "true");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.socketFactory.fallback", "false");

			Authenticator auth = new GoogleAuthentication();
			// Properties에 저장디어있는 설정 값을 getDefaultInstance()
			//메소드로 설정값을 저장하여 세션 생성 
			Session s = Session.getDefaultInstance(properties, auth);

			Message message = new MimeMessage(s);
			Address sender_address = new InternetAddress(sender);
			Address receiver_address = new InternetAddress(receiver);
			
			message.setHeader("content-type", "text/html;charset=UTF-8");
			message.setFrom(sender_address);
			message.addRecipient(Message.RecipientType.TO, receiver_address);
			message.setSubject(subject);
			message.setContent(content, "text/html;charset=UTF-8");
			message.setSentDate(new java.util.Date());
			
			Transport.send(message);
			out.println("<h3>메일이 정상적으로 전송되었습니다.</h3>");
		} catch (Exception e) {
			out.println("SMTP 서버가 잘못 설정되었거나 서비스에 문제가 있습니다.");
			e.printStackTrace();
		}
	}

}
