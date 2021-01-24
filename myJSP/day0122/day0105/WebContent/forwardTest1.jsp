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
		//입력 데이터 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
	%>
	
	<!-- forwardTest2.jsp -->
	<jsp:forward page='<%=request.getParameter("forwardPage") %>'>
		<jsp:param name="tel" value="010-1234-5678"/>
	</jsp:forward>

</body>
</html>



