<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>단일 파일 업로드 테스트</h1>
	
	<form action="partUploadPro1" 
	      method="post" enctype="multipart/form-data">
		
		<label for="writer">작성자:</label>
		<input type="text" name="writer" id="writer">
		
		<label for="partFile1">업로드파일:</label>
		<input type="file" name="partFile1" id="partFile1">
	
		<input type="submit" value="단일 업로드"/>
		
	</form>
</body>
</html>



