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
	
	<%-- 반복문 --%>	
	<c:forEach var="test" begin="1" end="10" step="2">
		<b>${test}</b>&nbsp;
	</c:forEach>
	
	<br>
	
	<%-- 
	   items 의 자료를 delims에서 정의한 문자로 쪼개서
	   변수 alphabet에 반복적으로 대입한다. 
	   
	   자바에서 split 
	   
	   String str = "서울,대전,대구,부산";
	   String[] array = str.split(",");
	   //array[0] = 서울
	   //array[1] = 대전
	   //array[2] = 대구
	   //array[3] = 부산
	   
	   for(String a:array){
	   	  System.out.println(a);
	   }
	   
	   
	--%>
	<c:forTokens var="alphabet" items="a,b,c,d,e,f" 
	             delims=",">
		<b>${alphabet}</b>
	</c:forTokens>	
	
	<br>
	
	<%-- 변수 선언 --%>
	<c:set var="data" value="홍길동,이순신,강감찬"/>
	
	<c:forTokens var="varData" items="${data}" delims=",">
		<b>${varData}</b>
	</c:forTokens>
</body>
</html>



