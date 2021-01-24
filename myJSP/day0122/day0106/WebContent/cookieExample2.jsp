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
		//쿠키 생성
		Cookie cookie = 
		   new Cookie("language",request.getParameter("language"));
	
		//쿠키 유효 시간을 24시간 지정
		cookie.setMaxAge(60*60*24);
		//서버에서 클라이언트로 쿠키 전송
		response.addCookie(cookie);
	%>
	
	<script>
		location.href = "cookieExample1.jsp";
	</script>
</body>
</html>



