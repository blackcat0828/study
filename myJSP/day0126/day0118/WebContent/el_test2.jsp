<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 내장객체 활용하기</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	
	<%--
	   sessionScope ?
	   Session 영역에 존재하는 객체 참조
	 --%>
	<h3>${sessionScope.test}</h3>
	
	<!-- 
	   param 내장객체?
	   클라이언트의 폼에서 전송되어 오는 파라메터 값들을 파라메터
	   이름과 값으로 저장하고 있는 Collection 형태의 객체 
	-->
	이름:<h3>${param.name}</h3>
	주소:<h3>${param.addr}</h3>
</body>
</html>




