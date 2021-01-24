<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>forward 된 Page</h2>
	<table>
		<tr>
			<td>이름</td>
			<td><%=request.getParameter("name") %></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><%=request.getParameter("age") %></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=request.getParameter("address") %></td>
		</tr>
		<!-- 전화번호인 경우 forwardTest1.jsp에서 forward처리를
		     했으므로 forwardTest1.jsp 의 request,response 속성값을
		     forwardTest2.jsp와 공유 할수 있다.
		 -->
		<tr>
			<td>전화번호</td>
			<td><%=request.getParameter("tel") %></td>
		</tr>		
		
	</table>
</body>
</html>