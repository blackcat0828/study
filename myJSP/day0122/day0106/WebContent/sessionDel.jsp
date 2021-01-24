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
		//세션의 특정 속성값을 삭제
		session.removeAttribute("name");
	%>
</body>
</html>




