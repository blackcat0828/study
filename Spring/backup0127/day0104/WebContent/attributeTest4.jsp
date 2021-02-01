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
		//현재 페이지에서만 적용
		pageContext.setAttribute("pageScope","pageValue");
	    //클라이언트 요청에 의해서 서버가 응답처리 할때까지 유효
		request.setAttribute("requestScope","requestValue");
	%>
	
	pageValue = <%=pageContext.getAttribute("pageScope")%><br>
	requestValue = <%=request.getAttribute("requestScope")%>
</body>
</html>




