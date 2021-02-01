<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#formArea {
		margin:auto;
		width:400px;
		border:1px solid black;
	}
	
	h1,fieldset {
		text-align:center;
	}
</style>
</head>
<body>
	<section id="formArea">
		<h1>property="*" 테스트</h1>
		<form action="beanTest4.jsp" method="post">
			<fieldset>
				<label for="name">이름:</label>
				<input type="text" name="name" id="name"/><br>
				<label for="addr">주소:</label>
				<input type="text" name="addr" id="addr"/><br>
				<label for="email">이메일주소:</label>
				<input type="text" name="email" id="email"/><br>
				<label for="birthday">생년월일:</label>
				<input type="date" name="birthday" id="birthday">
				<br>
				<input type="submit" value="전송">
			</fieldset>		
		</form>
				
	</section>
</body>
</html>




