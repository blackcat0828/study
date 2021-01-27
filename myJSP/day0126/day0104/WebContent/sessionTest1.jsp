<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Test</title>
</head>
<body>
	<%
		SimpleDateFormat sf = 
		         new  SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E요일");
	
		//클라이언트 요청이 지정된 시간만큼 세션이 유지되고
		//만약 클라이언트 요청이 없다가 지정된 시간을 넘으면
		//새로운 세션값이 생성된다.
		//10초 ?
		//세션 유지시간 : 초단위로 선언(기본 세션유지시간은 30분=1800초)		
		session.setMaxInactiveInterval(10);
	%>
	<h2>세션테스트</h2>
	isNew(): <%=session.isNew()%><br>
	
	세션최초 생성시간:
	  <%=sf.format(new Date(session.getCreationTime()))%><br>
	  
	최종 접속시간:
	  <%=sf.format(new Date(session.getLastAccessedTime()))%><br>
	
	세션ID:<%=session.getId()%>
</body>
</html>




