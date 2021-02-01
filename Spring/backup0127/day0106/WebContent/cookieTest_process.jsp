<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		if(id.equals("fintech") && passwd.equals("fintech1234")){
			//쿠키생성
			Cookie cookie_id = new Cookie("cookie_id",id);
			Cookie cookie_passwd = new Cookie("cookie_passwd",passwd);
			
			//쿠키의 유효시간을 24시간으로 지정
			cookie_id.setMaxAge(60*60*24);
			cookie_passwd.setMaxAge(60*60*24);
			
			//쿠키정보를 서버에서 클라이언트 전송
			response.addCookie(cookie_id);
			response.addCookie(cookie_passwd);
			
			out.print("쿠키 생성 성공"+"<br>");
			
			out.print("아이디 쿠키이름:" + cookie_id.getName());
			out.print("  아이디 쿠키값:" + cookie_id.getValue()+"<br>");
			out.print("비밀번호 쿠키이름:" + cookie_passwd.getName());
			out.print("  비밀번호 쿠키값:" + cookie_passwd.getValue());

		}else{
			out.print("아이디 혹은 비밀번호 오류");
		}
	
	%>
</body>
</html>












