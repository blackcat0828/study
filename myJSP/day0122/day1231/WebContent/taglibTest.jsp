<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- prefix : 접두사 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>JSTL 테스트</h2><br>
	<!-- 변수선언 var는 변수명 value는 변수에 대입할 값-->
	<c:set var="ir" value="홍길동"/>
	
	<%-- 변수 출력
	   ${변수,수식} => EL(Expression Language):표현언어
	 --%>
	<c:out value="${ir}"/>
	<br>
	<!-- 변수의 값을 삭제 -->
	<c:remove var="ir"/>

	<c:out value="${ir}"/>
	<br>
	
	<%--숫자 3개 더하기 --%>
	<c:set var="num1" value="10"/>
	<c:set var="num2" value="${20}"/>
	<c:set var="num3">30</c:set>
	
	숫자 3개의 합: ${num1+num2+num3} 입니다.
	
	<%-- 조건문 --%>
	<c:choose>
		<%-- 입력창에서 name이라는 속성의 값이 없으면 --%>
		<c:when test="${empty param.name}">
			<form>
				<p>이름:<input type="text" name="name">
				<p><input type="submit" value="확인">			
			</form>
		</c:when>
		<c:when test="${param.name == 'admin'}">
				관리자 메뉴
		</c:when>		
		<c:when test="${param.name == 'member'}">
				고객 메뉴
		</c:when>
		<c:otherwise>
				입력 오류 다시 입력하세요!!!!
		</c:otherwise>	
	</c:choose>
	
	<%-- 반복문 --%>
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i}"/><br>	
	</c:forEach>
	
	<c:forEach var="i" begin="1" end="9">
		3 * ${i} = ${3*i}<br>	
	</c:forEach>

</body>
</html>













