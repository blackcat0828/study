<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>autoFlush 예제</title>
</head>
<body>
	<%@ page info = "이 프로그램은 autoFlush를 이용합니다." %>
	<!-- autoFlush?
	     버퍼에 있는 내용을 출력하고 버퍼을 비우겠느냐 여부 지정
	     false 인 경우 버퍼가 가득찬 경우 내용을 출력하고 버퍼를 비우는게 아니라
	     예외발생된다.
	     true인경우 버퍼가 가득찬 경우 자동으로 버퍼의 내용을 출력하고 버퍼를 비움
	     buffer는 기본값이 8kb
	     
	     errorPage?
	     jsp 실행시 오류가 발생하면 해당 페이지로 제어권이 넘어감
	 -->
	<%@ page autoFlush = "true" buffer="1kb" errorPage="error.jsp" %>
	
	<!-- 자바 소스는 스크립틀릿 태그 안에 설정 -->
	<%
		for(int i=1;i<=1000;i++){
	%>
	 	1234
	<%
		}
	%> 	

</body>
</html>








