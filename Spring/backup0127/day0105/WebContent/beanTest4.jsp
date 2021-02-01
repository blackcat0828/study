<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	
	<jsp:useBean id="beantest" class="test.BeanTest2" scope="page"/>
	
	<!-- 
		property="*"
		자바 프로그램의 멤버변수 이름과 입력창의 매겨변수 이름이 동일한 경우
		property="*" 이렇게 선언하면 입력창에서 입력받은 값들이 자동적으로
		같은 이름의 멤버변수에 대입된다.
	 -->
	<jsp:setProperty property="*" name="beantest"/>
	
	<h1>JavaBean 속성값 출력</h1>
	
	<b>이름:</b><%=beantest.getName()%><br>
	<b>주소:</b><%=beantest.getAddr()%><br>
	<b>이메일:</b><%=beantest.getEmail()%><br>
	<b>생년월일:</b><%=beantest.getBirthday()%>
</body>
</html>




