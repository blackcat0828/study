<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	
	<sql:update dataSource="${conn}">
		insert into member(id,password,name,age,gender,email,regdate) 
		values(?,?,?,?,?,?,SYSDATE)
		<sql:param value="${param.id}"/>	
		<sql:param value="${param.pass}"/>
		<sql:param value="${param.name}"/>
		<sql:param value="${param.age}"/>
		<sql:param value="${param.gender}"/>
		<sql:param value="${param.email}"/>
	</sql:update>
	
	<%
			session.setAttribute("sessionId",id);
	%>
	
	<script>
		alert("정상적으로 저장되었습니다!");
		location.href="menu.jsp";
	</script>

</body>
</html>