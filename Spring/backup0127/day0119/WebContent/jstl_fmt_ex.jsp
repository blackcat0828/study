<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
	   자바빈즈를 사용하겠다는 선언
	   id : 식별자  
	   class : 사용하려는 클래스의 위치
	--%>
	<jsp:useBean id="date" class="java.util.Date"/>
	
	<%-- <fmt:setLocale : 로케일 정보를 특정국가로 세팅 --%>
	<fmt:setLocale value="en_US"/>
	
	<%-- 문자열을 숫자형태로 변환 --%>
	<fmt:formatNumber value="50000" type="currency"/><br>
	<fmt:formatNumber value="0.15" type="percent"/><br>
	<fmt:formatNumber value="500567300" pattern="###,###,###"/><br>
	
	<%--현재일시 중에서 날짜만 표시 --%>
	<fmt:formatDate value="${date}" type="date"/><br>
	<%--현재일시 중에서 시간만 표시 --%>
	<fmt:formatDate value="${date}" type="time"/><br>
	<%--현재일시 중에서 날짜와 시간모두 표시 --%>
	<fmt:formatDate value="${date}" type="both"/><br>
	
	<fmt:formatDate value="${date}" 
	                type="both"
	                timeStyle="short"
				    dateStyle="short"/><br>
	<fmt:formatDate value="${date}" 
	                type="both"
	                timeStyle="medium"
				    dateStyle="medium"/><br>				    
	<fmt:formatDate value="${date}" 
	                type="both"
	                timeStyle="long"
				    dateStyle="long"/><br>				    
				    
	
</body>
</html>




