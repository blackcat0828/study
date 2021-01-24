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
		String name="",value="";
		//헤더 정보중에서 쿠키관련 정보를 가져온다.
		String cookie = request.getHeader("Cookie");
		
		//쿠키가 존재하면
		if(cookie != null){
			//헤더에서 쿠키 값들을 가져와서 Cookie 형태의 배열에
			//자료를 대입한다.
			Cookie cookies[] = request.getCookies();
			
			//length : 배열의 크기
			//ArrayList 의 배열 크기 : size()
			for(int i=0;i<cookies.length;i++){
				//getName() : 쿠키이름
				if(cookies[i].getName().equals("name")){
					name = cookies[i].getName();
					//쿠키에 있는 값
					value = cookies[i].getValue();
				}
			}
		}
	
	%>
	
	<h2>쿠키이름:<%=name%></h2>
	<h2>쿠키값:<%=value%></h2>
</body>
</html>




