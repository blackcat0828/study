<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core Library Test</title>
</head>
<body>


	<%--변수 선언 --%>
	<c:set var="test" value="Hello JSTL"/>
	<%-- < : &lt; > : &gt;--%>
	<h3>&lt;c:set&gt;사용후:</h3><c:out value="${test}"/>
	
	<%-- 변수값 삭제 --%>
	<c:remove var="test"/>
	<h3>&lt;c:remove&gt;사용후:</h3><c:out value="${test}"/>
	
	<%-- 
	   예외처리
	   분모를 0으로 나누면 ArithmeticException 이 발생한다. 
	--%>
	<c:catch var="err">
		<%=10/0%>
	</c:catch>
	<h3>&lt;c:catch&gt; 예외처리:</h3><c:out value="${err}"/>
	
	<%-- 조건문 --%>
	<c:if test="${5<10}">
		<h3>5는 10보다 작다</h3>
	</c:if>
	
	<c:if test="${6+3==9}">
		<h3>6+3은 9이다.</h3>
	</c:if>
	
	<c:choose>
		<c:when test="${5+10 == 50}">
			<h3>5+10은 50이다.</h3>
		</c:when>
		<c:otherwise>
			<h3>5+10은 50이 아니다.</h3>
		</c:otherwise>
	</c:choose>

</body>
</html>