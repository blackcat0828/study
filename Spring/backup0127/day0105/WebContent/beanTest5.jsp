<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="beantest" class="test.BeanTest" scope="page"/>
	<b>Java Bean 사용 예제</b>
	<h3><%=beantest.getName()%></h3>
	<h3><jsp:setProperty property="name" name="beantest" value="이순신"/></h3>
	<h3><jsp:getProperty property="name" name="beantest"/></h3>
	
</body>
</html>


