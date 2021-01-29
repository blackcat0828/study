<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.io.*,java.text.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="cal" class="fintech.calculator" />

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



//문자단위 출력 스트림
PrintWriter ot = response.getWriter();

DecimalFormat df = new DecimalFormat("###,###");

ot.print("두수 "+num1+", "+num2+" 처리결과 <br>");
ot.print(num1 + " + " + num2 + " = " +  df.format(cal.plus(num1, num2)) + "<br>");
ot.print(num1 + " - " + num2 + " = " +   df.format(cal.minus(num1, num2)) + "<br>");
ot.print(num1 + " * " + num2 + " = " +  df.format(cal.multi(num1, num2)) + "<br>");
ot.print(num1 + " / " + num2 + " = " +   df.format(cal.div(num1, num2)));
%>

</body>
</html>