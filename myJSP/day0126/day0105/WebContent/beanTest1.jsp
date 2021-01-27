<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Bean 테스트</title>
</head>
<body>
	<jsp:useBean id="beantest" class="test.BeanTest" scope="page"/>    
	<%--
		<jsp:useBean> : 자바빈을 사용한다는 선언
		id : 변수
		class : 자바프로그램 위치
		scope : 유효범위(page,request,session,application) 
	--%>
	<b>Java Bean 예제</b>
	<%
		beantest.setName("이순신");
	%>
	
	<!-- name : Bean id 값 
		 property : 멤버변수명
	-->
	<jsp:setProperty property="name" name="beantest" value="강감찬"/>
	
	<h3><%=beantest.getName()%></h3>
</body>
</html>






