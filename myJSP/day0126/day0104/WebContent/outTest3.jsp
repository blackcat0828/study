<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page autoFlush="true" buffer="8kb" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>버퍼 Out 테스트</title>
</head>
<body>
	<h2>Out테스트</h2>
	<table border="1">
		<tr>
			<td>autoFlush 여부</td>
			<td><%=out.isAutoFlush()%></td>
		</tr>
		
		<tr>
			<td>출력 버퍼 크기</td>
			<td><%=out.getBufferSize()%></td>
		</tr>

		<tr>
			<td>출력 버퍼 남은 양</td>
			<td><%=out.getRemaining()%>Bytes</td>
		</tr>		
		
	</table>
</body>
</html>



