<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("utf-8");
	int num1 = 0;
	int num2 = 0;
	String test = request.getParameter("num1");
	
	if(test != null){
	num1 = Integer.parseInt((String)request.getParameter("num1"));
	num2 = Integer.parseInt((String)request.getParameter("num2"));
	};
%>

<%!
	int num3 = 100;
	int num4 = 200;
	private int add(){
		return num3+num4;
	}
	
	
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="CalculatorTest.jsp" method="get" >
		숫자1 : <input type="text" name="num1">
		숫자2 : <input type="text" name="num2">
		<input type="submit" value="계산">
	</form>
	
	<h1>계산 결과</h1>
	숫자1 + 숫자2 = <%=num1 + num2 %><br>
	태스트 : <%=add() %>
	
</body>
</html>