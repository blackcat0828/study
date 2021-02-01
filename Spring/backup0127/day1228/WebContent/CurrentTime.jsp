<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!-- 
 import ?
  사용될 객체 클래스를 import문을 이용하여 가져온다.
  -->   
    
<%@ page import="java.util.Calendar" %>
    
<!-- html 형식: html 5  -->    
<!DOCTYPE html>
<html>
<head>

<%
    //getInstance();싱글톤 패턴
    //인스턴스가 존재하지 않으면 인스턴스를 한번만 생성하고
    //이후에는 생성된 인스턴스를 공유해서 사용함으로써 메모리 
    //효율을 높인다.
	Calendar c= Calendar.getInstance();

	int hour = c.get(Calendar.HOUR_OF_DAY);
	int minute = c.get(Calendar.MINUTE);
	int second = c.get(Calendar.SECOND);

%>
<meta charset="UTF-8">
<title>현재 일자</title>
</head>
<body>
	<font color="blue">오늘 날짜:</font> 
	
	<%=hour%>시 <%=minute%>분 <%=second%>초 입니다.
</body>
</html>




