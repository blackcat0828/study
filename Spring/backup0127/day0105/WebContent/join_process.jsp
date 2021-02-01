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
		request.setCharacterEncoding("UTF-8");
	
		//request.getParameter() 리턴값은 문자열 형태
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String memberNo = request.getParameter("memberNo");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
	%>
	
	<h1>회원번호:<%=id%></h1>
	<h1>이름:<%=name%></h1>
	<h1>연락처:<%=phone%></h1>
</body>
</html>




