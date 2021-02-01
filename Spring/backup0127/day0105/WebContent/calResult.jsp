<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="cal" class="fintech.Calculator" scope="request"/>
	
	<%
		//문자열을 숫자로 변환
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		PrintWriter pw = new PrintWriter(out);
		
		pw.printf("%d + %d = %,d<br>",num1,num2,cal.add(num1, num2));
		pw.printf("%d - %d = %,d<br>",num1,num2,cal.minus(num1, num2));
		pw.printf("%d * %d = %,d<br>",num1,num2,cal.mul(num1, num2));
		pw.printf("%d / %d = %,d<br>",num1,num2,cal.div(num1, num2));
		
		
	
	%>

</body>
</html>






