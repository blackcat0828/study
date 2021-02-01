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
		//세션에 지정된 모든 속성을 삭제
		session.invalidate();
	%>
</body>
</html>



