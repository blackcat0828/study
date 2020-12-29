<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>좋아하는 과목 선택</h1>
	<form action="program" method="get">
		<input type="checkbox" name="subject" value="HTML" />HTML<br>
		<input type="checkbox" name="subject" value="자바" />자바<br>
		<input type="checkbox" name="subject" value="JSP" />JSP<br>
		<input type="checkbox" name="subject" value="스프링" />스프링<br>
		<input type="checkbox" name="subject" value="안드로이드" />안드로이드<br>
		<input type="submit" value="선택">
	</form>
</body>
</html>