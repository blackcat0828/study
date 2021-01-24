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
		//한글깨짐 방지
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		if(id.equals("fintech") && passwd.equals("fintech1234")){
			
			//세션 속성 지정
			session.setAttribute("id",id);
			session.setAttribute("passwd",passwd);
	%>
			
			<button onclick="location.href='logout.jsp'">로그아웃</button>
	<%		
		}else{
			out.print("아이디나 비밀번호 오류발생");
		}
	
	%>

</body>
</html>








