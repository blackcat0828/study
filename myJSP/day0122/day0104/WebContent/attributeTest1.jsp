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
		//요청자료의 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
	
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		//이름과 id 값이 존재하면
		if(name != null && id != null){
			//setAttribute:속성을 지정
			//영역을 application으로 지정했기 때문에
			//웹 애플리케이션이 실행되고 있는 동안에는 값이 유효
			application.setAttribute("name",name);
			application.setAttribute("id",id);
		}
	%>
	
	<h3>
		<%=name%>님 반갑습니다.<br>
		<%=name%>님의 아이디는 <%=id%> 입니다.
	</h3>
	
	<form action="attributeTest2.jsp" method="post">
		<table border="1">
			<tr>
				<td colspan="2">Session 영역에 저장할 내용들</td>
			</tr>
			<tr>
				<td>E-Mail 주소</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>집주소</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel"></td>
			</tr>			
			
			<tr>
				<td colspan="2"><input type="submit" name="전송"></td>
			</tr>			
		</table>
	</form>
</body>
</html>




