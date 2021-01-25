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

	<sql:update dataSource="${conn}">
		insert into schedule(sdate, title, content, location, regdate)
		values(?,?,?,?,SYSDATE)
		<sql:param value="${param.sdate}"/>	
		<sql:param value="${param.title}"/>
		<sql:param value="${param.content}"/>
		<sql:param value="${param.location}"/>
	</sql:update>
	
	<script>
		alert("정상적으로 스케줄이 저장되었습니다!");
		location.href="scheduleList.jsp";
	</script>

</body>
</html>