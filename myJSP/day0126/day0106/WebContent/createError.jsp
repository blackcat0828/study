<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- <%@ page errorPage="errorProcessing.jsp"%> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외처리</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
	
		if(name == null){
			//예외를 강제로 발생시킨다.
			throw new NullPointerException();
		}
	%>
</body>
</html>



