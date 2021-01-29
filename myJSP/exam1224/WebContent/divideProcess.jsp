<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.io.*,java.util.*"
	errorPage='exceptionProcess.jsp'
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));



PrintWriter ot = response.getWriter();



ot.print("처리결과 <br>");
ot.print(num1 + " / " + num2 + " = " +  num1/num2);
%>
</body>
</html>