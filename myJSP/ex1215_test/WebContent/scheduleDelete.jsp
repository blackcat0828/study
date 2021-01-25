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
		delete from schedule where sdate = ?
		<sql:param value="${param.sdate}"/>
	</sql:update>

	<script>
		alert("정상적으로 스케줄을 삭제하였습니다.");
		location.href="scheduleList.jsp";
	</script>
</body>
</html>



