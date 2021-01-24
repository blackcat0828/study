<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 로그인</title>
<style type="text/css">
	table{
		margin:auto;
		width:400px;
		border:1px solid gray;
		text-align:center;
	}
	
	.td_title{
		font-weight:bold;
		<%-- 
		   xx-small : 9px
		   x-small: 10px;
		   small : 13px
		   medium : 16px=12pt=1em
		   large : 18px
		   x-large : 24px=1.5em
		   xx-large : 32px=2em
		 --%>
		font-size:x-large;
	}
</style>
</head>
<body>
	<form name = "loginForm" 
	      action="loginProcess.jsp" method="post">
		<table>
			<tr>
				<td colspan="2" class="td_title">로그인 페이지</td>
			</tr>
			<tr>
				<td><label for="id">아이디:</label></td>
				<td><input type="text" name="id" id="id"/></td>
			</tr>
			<tr>
				<td><label for="pass">비밀번호:</label></td>
				<td><input type="password" name="pass" id="pass"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="javascript:loginForm.submit()">로그인</a>
					&nbsp;&nbsp;
					<a href="joinForm.jsp">회원가입</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>