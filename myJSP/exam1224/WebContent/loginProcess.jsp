<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<%
		
		String id;
		String pass;
		
	
		if(session.getAttribute("id")!=null){
			id = (String)session.getAttribute("id");
			pass = (String)session.getAttribute("passwd");
			System.out.println("테스트1");
		
		}else{
		
		id = request.getParameter("id");
		pass = request.getParameter("pass");
		}
	%>
	
	<c:set var="id" value="<%=id%>" scope="page" />
	<c:set var="pass" value="<%=pass%>" scope="page" />

	

	<c:if test="${(id=='admin')&&(pass=='admin1234')}">
	
		<%
			session.setAttribute("id",id);
			session.setAttribute("passwd",pass);
		%>
	
		<button type="button" 
		        class="button" onclick="location.href='logout.jsp'">
			로그아웃			
		</button>
	</c:if>
	

	<c:if test="${(id!='admin') || (pass!='admin1234')}">
	
		아이디나 비밀번호 오류발생
	</c:if>
	
</body>
</html>