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
		update member
		   set password = ?,
		       name = ?,
		       age = ?,
		       gender = ?,
		       email = ?,
		       updatedate = now()
		 where id = ?
		 <sql:param value="${param.pass}"/>
		 <sql:param value="${param.name}"/> 
		 <sql:param value="${param.age}"/> 
		 <sql:param value="${param.gender}"/> 
		 <sql:param value="${param.email}"/> 
		 <sql:param value="${param.id}"/>       	
	</sql:update>
	
	<c:if test="${sessionId == 'admin'}">			
		<script>
			alert("정상적으로 수정되었습니다!");
			location.href="memberList.jsp";
		</script>
	</c:if>
			
	<c:if test="${sessionId != 'admin'}">
		<script>
			alert("정상적으로 수정되었습니다!");
			location.href="menu.jsp";
		</script>
	</c:if>	
	
</body>
</html>




