<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체크박스 예제</title>
</head>
<body>
	<h1>당신이 좋아하는 강아지를 선택하세요</h1>
	
	<form action="choiceDog" method="post">

		<input type="checkBox" name="dog" value="pu.jpg"/>푸들
		<input type="checkBox" name="dog" value="jin.jpg"/>진돗개
		<input type="checkBox" name="dog" value="pung.jpg"/>풍산개
		<input type="checkBox" name="dog" value="sap.jpg"/>삽살개
		<input type="submit" value="선택">
	
	</form>
</body>
</html>



