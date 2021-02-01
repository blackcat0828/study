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
		//세션 속성값을 삭제
		session.invalidate();
	    out.print("정상적으로 로그아웃 되었습니다.");
	    response.sendRedirect("login.jsp");
	
	%>
</body>
</html>





