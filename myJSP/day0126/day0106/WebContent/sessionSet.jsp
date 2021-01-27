<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	location.href="sessionTest.jsp";
</script>
</head>
<body>
	<%
		//세션 속성을 지정
		session.setAttribute("name","홍길동");
	%>
</body>
</html>



