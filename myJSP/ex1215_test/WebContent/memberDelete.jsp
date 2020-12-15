<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="dbconn.jsp" %>
	
	<sql:update dataSource="${conn}">
		delete from member where id = ?
		<sql:param value="${param.id}"/>
	</sql:update>
	
	<%
		session.invalidate();
	    response.sendRedirect("loginForm.jsp");
	%>
		
	<script>
		alert("정상적으로 삭제되었습니다!");
		location.href="loginForm.jsp";
	</script>
</body>
</html>



