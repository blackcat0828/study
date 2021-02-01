<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<%
		//세션에 있는 모든 속성값을 삭제처리
		session.invalidate();
	
	    //login.jsp 화면 실행
	    //out.println("<script>location.href='login.jsp'</script>");
	    response.sendRedirect("login.jsp");
	
	%>
	
</body>
</html>









