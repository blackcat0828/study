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
		String language = "korea";//기본값
		//헤더정보중 쿠키정보를 가져온다.
		String cookie = request.getHeader("Cookie");
		
		if(cookie != null){
			Cookie cookies[] = request.getCookies();
			
			for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().equals("language")){
					language = cookies[i].getValue(); 
				}
			}
		}
	%>
	
	<%
		if(language.equals("korea")){
	%>		
			<h3>안녕하세요 이것은 쿠키 예제입니다.!!!</h3>
	<%
		}else{
	%>
			<h3>Hello.This is Cookie Example !!!</h3>
	<%		
		}
	%>		
	
	<form action="cookieExample2.jsp" method="post">
		<input type="radio" name="language" value="korea"
		<%
			if(language.equals("korea")){
		%>
				checked
		<%				
			}
		%>				
		>한국어 페이지 보기

		<input type="radio" name="language" value="english"
		<%
			if(language.equals("english")){
		%>
				checked
		<%				
			}
		%>				
		>영어 페이지 보기
		
		<input type="submit" value="설정">
	</form>
</body>
</html>





