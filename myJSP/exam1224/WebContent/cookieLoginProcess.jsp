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
	
	String id = (String)request.getParameter("id");
	String pass = (String)request.getParameter("pass");
	
	if(id.equals("test") && pass.equals("test1234")){
		//쿠키 생성
		Cookie idCookie = 
		   new Cookie("idCookie",request.getParameter("id"));
		Cookie pwCookie = 
			   new Cookie("pwCookie",request.getParameter("pass"));
		
		idCookie.setMaxAge(60*60*3);
		pwCookie.setMaxAge(60*60*3);
		
		response.addCookie(idCookie);
		response.addCookie(pwCookie);
		
		out.print("쿠키 생성 성공"+"<br>");
		out.print("아이디 쿠키이름:" + idCookie.getName());
		out.print("  아이디 쿠키값:" + idCookie.getValue()+"<br>");
		out.print("비밀번호 쿠키이름:" + pwCookie.getName());
		out.print("  비밀번호 쿠키값:" + pwCookie.getValue());
		
	}else{
		out.print("아이디 혹은 비밀번호 오류");
	}
	%>
	

</body>
</html>