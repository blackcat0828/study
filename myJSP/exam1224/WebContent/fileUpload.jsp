<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드 폼</h1>
	
	<form action="fileUploadProcess.jsp" 
	      method="post" enctype="multipart/form-data">
		
		<label for="name">이름:</label>
		<input type="text" name="name" id="name">
		<br>
		<label for="subject">제목:</label>
		<input type="text" name="subject" id="subject">
		<br>
		<label for="file1">파일명:</label>
		<input type="file" name="file1" id="file1">
		<br>
		<input type="submit" value="업로드"/>
		
	</form>
</body>
</html>