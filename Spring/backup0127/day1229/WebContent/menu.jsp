<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- 스크립틀릿 태그 -->
	<%
	    //세션 속성값 id 에 대한 값을 가져온다.
		String id = (String)session.getAttribute("id");
	
		if(id == null){
	%>
		<a href="login.jsp">로그인</a>
	<%
		}else{
	%>
		<!-- 표현문을 이용하여 변수값을 출력 -->
			<%=id%> 님 환영합니다.
			
			<!-- 로그아웃 버튼 -->
			<button type="button" onclick="location.href='logout.jsp'">
				로그아웃
			</button>
			
			
	<%
	
		}
	%>		
</body>
</html>




