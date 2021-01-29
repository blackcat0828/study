<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="evenSum" value="0"/>
	<c:set var="oddSum" value="0"/>
	<c:set var="totalSum" value="0"/>
	
	<c:forEach var="i" begin="${param.num1}" end="${param.num2}">
	    
		<c:if test="${i%2==0}">
			<c:set var="evenSum" value="${evenSum+i}"/>
		</c:if>
		
		<c:if test="${i%2==1}">
			<c:set var="oddSum" value="${oddSum+i}"/>
		</c:if>
		
		
		<c:set var="totalSum" value="${totalSum+i}"/>
		
	</c:forEach>
	
	<p>${param.num1} 부터 ${param.num2} 처리결과<br>
	

	
	<p>짝수합:<fmt:formatNumber value="${evenSum}" pattern="#,##0"/><br>
	<p>홀수합:<fmt:formatNumber value="${oddSum}" pattern="#,##0"/><br>
	<p>총합계:<fmt:formatNumber value="${totalSum}" pattern="#,##0"/>
	
</body>
</html>