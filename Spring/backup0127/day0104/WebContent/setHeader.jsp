<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//현재일자 
		Date now = new Date();
	
		SimpleDateFormat sf = 
			new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E요일");
		
		//Date 형태를 문자열 형태로 변환
		String today = sf.format(now);
		
		//헤더정보 수정
		//5초후 네이버 페이지로 이동처리
		response.setHeader("Refresh","5;URL=http://m.naver.com");
		
	%>
	
	현재일시 : <%=today%>
	
</body>
</html>












