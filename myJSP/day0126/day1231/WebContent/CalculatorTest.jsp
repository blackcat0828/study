<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!
		public int num1 = 100,num2=50;
	
		public int add(int num1,int num2){
			return num1 + num2;
		}
		
		public int minus(int num1,int num2){
			return num1 - num2;
		}
		
		public int mul(int num1,int num2){
			return num1 * num2;
		}
		
		public int div(int num1,int num2){
			return num1 / num2;
		}
	
	%>
	
	<%
		out.print(num1 + "+" + num2 + "=" + add(num1,num2)+"<br>");
		out.print(num1 + "-" + num2 + "=" + minus(num1,num2)+"<br>");
		out.print(num1 + "*" + num2 + "=" + mul(num1,num2)+"<br>");
		out.print(num1 + "/" + num2 + "=" + div(num1,num2));
	%>
	
	
</body>
</html>








