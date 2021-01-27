<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//쿠키 클래스 인스턴스 생성
		Cookie cookie = new Cookie("name","홍길동");
		//쿠키의 유효시간 선언(600초 지정=10분)
		cookie.setMaxAge(600);
		//생성된 쿠키를 클라이언트로 전송
		response.addCookie(cookie);
	%>
	
	<%-- 쿠키 이름 가져온다 --%>
	<h2><%=cookie.getName()%></h2>
	<%-- 쿠키값을 가져온다 --%>
	<h2><%=cookie.getValue()%></h2>
	<%-- 쿠키 유효시간을 가져온다 --%>
	<h2><%=cookie.getMaxAge()%></h2>
	
	<a href="cookieTest2.jsp">쿠키값 불러오기</a>
</body>
</html>




