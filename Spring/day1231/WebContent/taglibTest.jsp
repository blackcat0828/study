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
		<h2>JSTL 테스트</h2>
		<c:set var="ir" value="홍길동" />
		
		<c:out value="${ir}" />
		
		<c:set var="num1" value="10"/>
		<c:set var="num2" value="${20 }"/>
		<c:set var="num3">30</c:set>
		
		더하기 테스트 : ${num1+num2+num3} 입니다.
		
		<c:choose>
			<c:when test="${num1==10 }">
				<br>맞습니다.
			</c:when>
			<c:otherwise>
				<br>아닙니다.
			</c:otherwise>
		</c:choose>
</body>
</html>