<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">강아지 리스트</h1>
		</div>
	</div>
	
	<div class="container">
		<div>
			<%-- 
				table-bordered : 테이블 테두리를 실선처리 
				table-striped : 짝수행마다 색상을 달리 표현				
			--%>
			<table class="table table_bordered table-striped">
				<tr class="danger">
					<th>강아지 아이디</th>				
					<th>이미지</th>				
					<th>상품명</th>				
					<th>가격</th>				
				</tr>
				<tr>
					<c:forEach var="dog" items="${dogList}">
						
					
					</c:forEach>
				</tr>
			</table>		
		</div>
	</div>
</body>
</html>