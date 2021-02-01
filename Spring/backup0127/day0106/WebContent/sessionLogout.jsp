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
		//특정 세션 속성값을 삭제
		session.removeAttribute("id");
		
		//세션속성이 여러개 인 경우 사용
		//session.invalidate();
	%>
	<h3>정상적으로 로그아웃 되었습니다.</h3>
	<%
		response.sendRedirect("sessionLogin1.jsp");
	%>
	<!-- <a href="sessionLogin1.jsp">로그인 페이지로 이동</a> -->
</body>
</html>



