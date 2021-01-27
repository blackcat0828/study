<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리시스템 메인 페이지</title>
</head>
<body>
	<%
		String id = null;
		
		//session.setAttribute : 세션에 속성값을 지정
		//session.getAttribute : 세션 속성값을 가져온다.		
		if(session.getAttribute("id") != null){
			//session 의 리턴값은 Object 이므로
			//String으로 캐스팅(형변환) 해야 한다.
			id = (String)session.getAttribute("id");
		}else{
			//세션 id 값이 없으면
			//강제로 jsp 이동
			//response.sendRedirect("loginForm.jsp");
			out.println("<script>");
			out.println("locaton.href='loginForm.jsp'");
			out.println("</script>");
		}
	
	%>
	
	<h3><%=id%>님 로그인 하셨습니다.</h3>
	<%
		if(id.equals("admin")){
	%>
			<a href="member_list.jsp">관리자 모드 접속(회원목록 보기)</a>
	<%		
		}
	%>
</body>
</html>