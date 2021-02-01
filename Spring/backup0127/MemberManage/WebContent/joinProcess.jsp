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

	<%-- 폼에서 입력받은 값들을 테이블에 저장 --%>
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
	
	<script>
		alert("정상적으로 저장되었습니다!");
		location.href="memberList.jsp";
	</script>

</body>
</html>