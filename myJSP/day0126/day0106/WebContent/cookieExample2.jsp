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
	
		
		cookie.setMaxAge(60*60*3);
		
		response.addCookie(cookie);
	%>
	
	<script>
		location.href = "cookieExample1.jsp";
	</script>
</body>
</html>



