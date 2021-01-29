<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name = "loginForm" 
	      action="cookieLoginProcess.jsp" method="post">
		<table>
			<tr>
				<td><label for="id">아이디:</label></td>
				<td><input type="text" name="id" id="id"/></td>
			</tr>
			<tr>
				<td><label for="pass">비밀번호:</label></td>
				<td><input type="password" name="pass" id="pass"/></td>
			</tr>
		</table>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>