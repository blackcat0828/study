<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attribute 테스트</title>
</head>
<body>
	<h2>영역과 속성 테스트</h2>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		//속성값이 세션이 유지되는 동안만 유효함
		//만약 실행되고 있는 웹브라우저를 닫으면 세션도 끊김
		session.setAttribute("email",email);
		session.setAttribute("address",address);
		session.setAttribute("tel",tel);
		
		String name = (String)application.getAttribute("name");

	%>
	
	<h3><%=name%>님의 정보가 모두 저장되었습니다.</h3>
	
	<a href="attributeTest3.jsp">111</a>
	
</body>
</html>



