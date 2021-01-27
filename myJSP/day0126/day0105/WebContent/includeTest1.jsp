<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include Action Tag</title>
</head>
<body>
	<h2>Include Action Tag</h2>
	<jsp:include page="includeTest2.jsp">
		<jsp:param name="name" value="홍길동"/>
	</jsp:include>
	<%
		out.print("제어권 넘어옴");
	%>
	
</body>
</html>