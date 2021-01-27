<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaBean Param 예제</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<jsp:useBean id="beantest" class="test.BeanTest" scope="page"/>
	<!-- 
		param은 입력창에서 입력받은 name이라는 매개변수의 값을 setProperty
		를 통해 멤버변수 name에 값을 대입처리 
	 -->
	<jsp:setProperty property="name" name="beantest" param="name"/>
	<b>JavaBean Test</b>
	<h3><%=beantest.getName()%></h3>
</body>
</html>




