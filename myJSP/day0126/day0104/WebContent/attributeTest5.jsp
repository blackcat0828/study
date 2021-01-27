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
		pageContext.setAttribute("pageScope","pageValue");
		request.setAttribute("requestScope","requestValue");
	%>

	<%-- 
	<jsp:forward ? 
	  특정페이지로 제어권을 넘기는데 request의 속성값은 공유할수 있다.
	--%> 
	<jsp:forward page="attributeTest5Result.jsp"/>
</body>
</html>







