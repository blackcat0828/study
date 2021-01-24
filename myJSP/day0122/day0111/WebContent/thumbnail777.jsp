<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>thumnailForm</title>
</head>
<body>
    <!-- <form> 태그의 enctype 속성을 통해 대용량 파일을 업로드 가능하게 했습니다. -->
    <form action="thumnailAction.jsp" method="post" enctype="multipart/form-data">
	<table>
	    <caption>썸네일 폼</caption>
		<tr>
		    <th>이미지 파일 : </th>
		    <td><input type="file" name="filename"></td>
		</tr>
		<tr>
	            <td colspan="2"><input type="submit" value="전송"/></td>
		</tr>
	</table>
    </form>
</body>
</html>