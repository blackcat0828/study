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
	
	<%
		String id = request.getParameter("id");
		String password = request.getParameter("password"); 
	%>
	
	<sql:query var="resultSet" dataSource="${dataSource }">
		select * from member where id = ? and password = ?
		<sql:param value="<%=id%>"/>
		<sql:param value="<%=password%>"/>
	</sql:query>
	
	<c:if test="${resultSet.rowCount > 0}">
		<%
			session.setAttribute("sessionId", id);		
		%>
		
		<c:redirect url="menu.jsp"/>
	</c:if>
	
	<c:if test="${resultSet.rowCount == 0}">
		<c:redirect url="resultMember.jsp?gubun=LoginError"/>
	
	</c:if>
</body>
</html>