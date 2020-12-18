<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name = "듀크";
	public String getName(){ return name;}
	//선언문을 이용해 맴버 변수 name과 맴버 메서드 getName()을 선언
%>
<% 
	String age=request.getParameter("age"); 
	//스크립트릿을 이용해 자바 코드를 작성
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 안녕하세요 <%=name %>님!!</h1>
	<h1> 나이는 <%=age %>살 입니다.</h1>
	<h1> 키는 <%=180  %>입니다.</h1>
	<h1> 나이+10은 <%=Integer.parseInt(age)+10 %>살입니다.</h1>
</body>
</html>