<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jstl XML Library 예제</title>
</head>

<%--
	XML : Extensible MarkUp Language
	문서의 구조와 기타 기능을 설명하는 일반 텍스트 파일
	
 --%>
<body>
	<x:parse var="xmlData">
		<students>
			<student>
				<name>홍길동</name>
				<age>18</age>
				<gender>남</gender>
				<phone>010-1234-5678</phone>
			</student>
			<student>
				<name>김길동</name>
				<age>19</age>
				<gender>남</gender>
				<phone>010-5678-2345</phone>
			</student>
			<student>
				<name>홍길순</name>
				<age>28</age>
				<gender>여</gender>
				<phone>없음</phone>
			</student>			
			<student>
				<name>신사임당</name>
				<age>58</age>
				<gender>여</gender>
				<phone>010-8989-7777</phone>
			</student>			
		</students>	
	</x:parse>
	
	<%-- 
		xml 반복문
		// : 모든 영역에서 해당 Element(엘리먼트)를 선택하게 된다 
	--%>
	<x:forEach select="$xmlData//student">
		<x:if select="./name != '홍길순'">
			<x:out select="./name"/>
			<x:set select="./age" var="age"/>
			<x:out select="$age"/>
			<x:out select="./gender"/>
			
			<x:choose>
				<x:when select="./phone !='없음'">
					[전화번호:<x:out select="./phone"/>]
				</x:when>
				<x:otherwise>
					[전화없음]
				</x:otherwise>
			</x:choose>
			<br>
		</x:if>
	</x:forEach>
</body>
</html>