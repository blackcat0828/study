<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="dbconn.jsp"%>
	
	<%
		String id = request.getParameter("id");
	%>
	
	<sql:query var="rs" dataSource="${conn}">
		select * 
		  from member 
		 where id = ? and password = ?
		<sql:param value="${param.id}"/>  	
		<sql:param value="${param.pass}"/>
	</sql:query>
	
	<c:if test="${rs.rowCount > 0}">
	
		<%
			session.setAttribute("sessionId",id);
		%>
	
		<c:redirect url="menu.jsp"/>
	</c:if>
	

	<c:if test="${rs.rowCount == 0}">
		<script>
			alert("아이디나 비밀번호를 확인하세요");
			location.href="loginForm.jsp";
		</script>
	</c:if>
	
</body>
</html>







