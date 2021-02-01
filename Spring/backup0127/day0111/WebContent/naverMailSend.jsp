<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.mail.*" %>
<%@ page import="javax.mail.internet.InternetAddress" %>
<%@ page import="javax.mail.internet.MimeMessage" %>
<%@ page import="java.util.Properties" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="mailtest.SMTPAuthenticator"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String sender = request.getParameter("sender");
		String receiver = request.getParameter("receiver");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		Properties p = new Properties();
		
		p.put("mail.smtp.user","yshan5670");
		p.put("mail.smtp.host","smtp.naver.com");
		p.put("mail.smtp.port","465");
		p.put("mail.smtp.starttls.enable","true");
		p.put("mail.smtp.auth","true");
		p.put("mail.smtp.debug","true");
		p.put("mail.smtp.socketFactory.port","465");
		p.put("mail.smtp.socketFactory.class",
			  "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback","false");
		
		try{
			Authenticator auth = new SMTPAuthenticator();
			
			Session ses = Session.getInstance(p,auth);
			
			//메일을 전송할 때 진행상황을 콘솔에 출력
			ses.setDebug(true);
			
			//메일의 내용을 관리하기 위한 객체
			MimeMessage msg = new MimeMessage(ses);
			
			//제목 설정
			msg.setSubject(subject);
			
			//보내는이 메일주소
			Address fromAddr = new InternetAddress(sender);
			msg.setFrom(fromAddr);
			
			//받는이 메일주소
			Address toAddr = new InternetAddress(receiver);
			msg.addRecipient(Message.RecipientType.TO,toAddr);
			
			//메시지 본문의 내용과 형식,캐릭터셋 설정
			msg.setContent(content,"text/html;charset=UTF-8");
			
			//발송하기
			Transport.send(msg);
			
		}catch(Exception e){
			e.printStackTrace();
			
			String msg = "<script>\n";
			
			msg += "alert('메일발송에 실패하였습니다!');\n";
			msg += "history.back();\n";
			msg += "</script>";
			
			out.print(msg);
			return;
		}
	
		String msg = "<script>\n";
		
		msg += "alert('메일발송 성공!');\n";
		msg += "</script>";
		msg += 
		"<meta http-equiv='refresh' content='0;url=navermailForm.jsp'/>";
		
		out.print(msg);
		
	%>
</body>
</html>







