<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>import 속성 테스트</title>
</head>
<body>
    <!-- new Date() : 현재 일시 -->
	<h1>현재시간은 <%=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a E요일")
	                 .format(new Date())%>입니다.</h1>
</body>
</html>





