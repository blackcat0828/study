<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Test3</title>
<style type="text/css">
	h1{
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
<!-- 1.URL(Uniform Resource Locator)
  - 웹 상에서 서비스를 제공하는 각 서버들에 있는 파일들의
    위치를 표시하기 위한 것으로 접속할 서비스의 종류,도메인명,
    파일의 위치를 포함
예) http://localhost:8080/member/insert.jsp    
 
2.URI (Uniform Resource Identifier)
    - 웹 상에서 자원식별을 위한 것으로 URL에서 프로토콜,호스트명,
      포트등이 제외된 파일의 위치
예) /member/insert.jsp  -->   

	<h1>쿠키,URL/URI 요청방식에 관련된 정보 예제</h1>
	<table border="1">
		<tr>
			<td>쿠키정보</td>
		<%
			//request.getCookies()?
			//모든 쿠키정보를 가져온다		
			Cookie[] cookie = request.getCookies();
		
			if(cookie == null){
		%>
				<td>쿠키가 존재하지 않습니다.</td>
		<%		
			}else{
				
				//cookie는 배열이므로 반드시 인덱스가 0로 부터 시작
				for(int i=0;i<cookie.length;i++){
		%>
					<td>
						<!-- cookie[i].getName() : 쿠키이름 
						     cookie[i].getValue() : 쿠키값
						-->
						<%=cookie[i].getName()%>(<%=cookie[i].getValue() %>)&nbsp;&nbsp;
					</td>
		<%			
				}
			}
		%>	
		</tr>
		
		<tr>
			<td>서버 도메인명</td>
			<td><%=request.getServerName()%></td>
		</tr>
		
		<tr>
			<td>서버 포트번호</td>
			<td><%=request.getServerPort()%></td>
		</tr>
		
		<tr>
			<td>요청 URL</td>
			<td><%=request.getRequestURL()%></td>
		</tr>
		
		<tr>
			<td>요청 URI</td>
			<td><%=request.getRequestURI()%></td>
		</tr>
		
		<tr>
			<td>요청 쿼리</td>
			<td><%=request.getQueryString()%></td>
		</tr>
		
		<tr>
			<td>클라이언트 호스트명</td>
			<td><%=request.getRemoteHost()%></td>
		</tr>				
	
		<tr>
			<td>클라이언트 IP주소</td>
			<td><%=request.getRemoteAddr()%></td>
		</tr>
		
		<tr>
			<td>프로토콜</td>
			<td><%=request.getProtocol()%></td>
		</tr>
		
		<tr>
			<td>요청방식</td>
			<td><%=request.getMethod()%></td>
		</tr>
		
		<tr>
			<td>Context 경로</td>
			<td><%=request.getContextPath()%></td>
		</tr>													
			
	</table>
</body>
</html>




