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
		request.setCharacterEncoding("UTF-8");
	%>
	<h3>아이디:${param.id}</h3><br>
	<h3>비밀번호:${param.passwd}</h3><br>
	<h3>이름:${param.name}</h3><br>
</body>
</html>



