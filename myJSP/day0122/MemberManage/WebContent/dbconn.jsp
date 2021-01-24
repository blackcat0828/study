<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");	
	%>
	
	<sql:setDataSource
		var="conn"
		driver="org.mariadb.jdbc.Driver"
		url="jdbc:mariadb://jeffworld.iptime.org:33060/exam"
		user="pig88dog"
		password="110628"/>
	
</body>
</html>




