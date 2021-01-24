<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Test</title>
<style>
	h1{
		text-align:center;
	}
	
	table{
		margin:auto;
		width:400px;
		border:1px solid red;
	}
</style>
</head>
<body>
	<%
		//한글깨짐 방지
		request.setCharacterEncoding("UTF-8");	
	%>
	<h1>Request 예제입니다.</h1>
	<table>
		<tr>
			<td>이름</td>
			<td><%=request.getParameter("name")%></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
			   <%
			   		if(request.getParameter("gender").equals("male")){
			   %>
			        	남자
			   <%
			   		}else{
			   %>     
			   			여자
			   <%
			   		}
			   %>			
			</td>
		</tr>
		
		<tr>
			<td>취미</td>
			<td>
				<%
					//getParameterValues()
					//체크박스에서 선택한 값들을 문자열 배열에 대입처리
					String[] hobby = request.getParameterValues("hobby");
				
					for(int i=0;i<hobby.length;i++){
				%>
				<!-- 표현문을 이용해 배열에 있는 취미를 출력 
				    &nbsp;-> 한개의 공백처리
				-->
					<%=hobby[i]%>&nbsp;&nbsp;
				<%
					}
				%>	
			</td>
		</tr>
				
		
	</table>
</body>
</html>