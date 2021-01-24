<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- getStr() 메서드 리턴값을 표현문을 통해 출력 -->
	
	
	<!-- 선언문을 통해 메서드 선언 -->
	<%!
	
		private String str = "선언문";
	
		private String getStr(){
		
		str += "테스트입니다.";
		return str;
	}
	
	%>
	
	<h1><%=getStr()%></h1>
</body>
</html>