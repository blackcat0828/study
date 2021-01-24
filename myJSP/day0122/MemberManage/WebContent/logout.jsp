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
		//세션에 있는 모든 속성값을 삭제하고
		//다시 로그인 화면으로 간다.
		session.invalidate();
	    response.sendRedirect("loginForm.jsp");
	%>
</body>
</html>




