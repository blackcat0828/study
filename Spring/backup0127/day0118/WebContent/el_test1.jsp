<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		width:400px;
		margin:auto;
		border:1px solid gray;
		text-align:center;
	}
</style>
</head>
<body>
	<%
		//test 라는 속성 지정
		session.setAttribute("test","Session Test");
	%>
	
	<form action="el_test2.jsp" method="post">
		<table>
			<tr>
				<td>이름:</td>
				<td>
					<input type="text" name="name" value="홍길동">
				</td>
			</tr>
			<tr>
				<td>주소:</td>
				<td>
					<input type="text" name="addr" value="부산시 동래구">
				</td>
			</tr>			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>




