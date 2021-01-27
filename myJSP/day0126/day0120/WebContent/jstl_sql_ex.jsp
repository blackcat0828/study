<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL sql 라이브러리 예제</title>
</head>
<body>

	<%-- 데이터베이스 연결 설정 --%>
	<sql:setDataSource
			var="conn"
			driver="oracle.jdbc.OracleDriver"
			url="jdbc:oracle:thin:@localhost:1521:orcl"
			user="fadmin"
			password="fadmin1234"/>
			
	<%-- 
		insert,update,delete 명령문 사용 => <sql:update> 사용
		select 명령문 사용 => <sql:query> 사용 
	--%>		
	<sql:update dataSource="${conn}">
		insert into test(num,name) values (5,'홍길동')
	</sql:update>
	
	<sql:update dataSource="${conn}">
		insert into test(num,name) values (6,'이순신')
	</sql:update>	
	
	<sql:update dataSource="${conn}">
		insert into test(num,name) values (7,'강감찬')
	</sql:update>
	
	<sql:update dataSource="${conn}">
		insert into test(num,name) values (8,'신사임당')
	</sql:update>			
	
	<%-- 
		test 테이블의 자료를 가져온다
		var로 선언한 rs변수에 실행결과값이 저장된다.
	 --%>		
	<sql:query var="rs" dataSource="${conn}">
		select * from test where num between ? and ? order by num
		<sql:param>1</sql:param>
		<sql:param>10</sql:param>
	</sql:query>
	
	<c:forEach var="data" items="${rs.rows}">
		<c:out value="${data.num}"/>
		<c:out value="${data.name}"/><br>
	</c:forEach>
</body>
</html>