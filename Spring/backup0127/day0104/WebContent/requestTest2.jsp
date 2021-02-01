<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1 {
		text-align:center;
	}
	
	table {
		margin:auto;
		width:400px;
		border:1px solid red;
	}
</style>
</head>
<body>
	<h1>헤더정보예제</h1>
	<table>
		<tr>
			<td>헤더이름</td>
			<td>헤더값</td>
		</tr>
		
		<%
			//헤더의 정보를 모두 가져와 배열형태로 저장
			Enumeration e = request.getHeaderNames();
		
			//다음에 가져올 정보가 있는지 체크
			while(e.hasMoreElements()){
				//데이터를 하나씩 가져온다.
				String headerName = (String)e.nextElement();
		%>
		
			<tr>
				<td><%=headerName%></td>
				<!-- 헤더에 대한 값을 가져온다. -->
				<td><%=request.getHeader(headerName)%></td>
			</tr>
		<%		
			}
		%>
	</table>
</body>
</html>