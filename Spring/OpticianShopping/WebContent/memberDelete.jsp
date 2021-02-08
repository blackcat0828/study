<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
<%
session.invalidate();
%>
alert('회원 탈퇴 완료');
window.location.href = 'glassesList.glasses';
</script>
</body>
</html>