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
	<%-- 로그인창에서 입력받은 아이디,비밀번호를 가진 멤버가 있는지 체크 --%>
	<sql:query var="rs" dataSource="${conn}">
		select * 
		  from member 
		 where id = ? and password = ?
		<sql:param value="${param.id}"/>  	
		<sql:param value="${param.pass}"/>
	</sql:query>
	
	<c:if test="${rs.rowCount > 0}">
	
		<%
			//브라우저를 닫기 전까지 sessionId값은 유효함.
			session.setAttribute("sessionId",id);
		%>
	
		<c:redirect url="menu.jsp"/>
	</c:if>
	
	<%-- 비정상 로그인 --%>
	<c:if test="${rs.rowCount == 0}">
		<script>
			alert("아이디나 비밀번호를 확인하세요");
			location.href="loginForm.jsp";
		</script>
	</c:if>
	
</body>
</html>







