<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	table {
		text-align:center;	
	}
	
	.button {
		margin-bottom:10px;
		font:12px 맑은고딕;
		color:blue;
		width:100px;
		height:20px;	
	}
	
</style>
</head>
<body>
	
	<h3>회원리스트</h3>
	<div align="left">
		<button type="button" 
		        class="button" onclick="location.href='joinForm.jsp'">
			회원가입			
		</button>
		
		<button type="button" 
		        class="button" onclick="location.href='logout.jsp'">
			로그아웃			
		</button>
		
		<button type="button" 
		        class="button" onclick="location.href='menu.jsp'">
			메인메뉴			
		</button>
	</div>
	
	<%@ include file="dbconn.jsp"%>
	
	<%--select문을 실행하여 결과값을 rs에 저장 --%>
	<sql:query var="rs" dataSource="${conn}">
		select * from member order by id
	</sql:query>
	
	<table border="1" style="border-collapse:collapse;width=600px">
		<tr>
			<th width="10%">아이디</th>
			<th width="10%">비밀번호</th>
			<th width="10%">이름</th>
			<th width="10%">나이</th>
			<th width="10%">성별</th>
			<th width="10%">이메일</th>
			<th width="20%">수정</th>
			<th width="20%">삭제</th>
		</tr>
		
		<c:forEach var="row" items="${rs.rows}">
			<tr>
				<td><c:out value="${row.id}"/></td>
				<td><c:out value="${row.password}"/></td>
				<td><c:out value="${row.name}"/></td>
				<td><c:out value="${row.age}"/></td>
				<td><c:out value="${row.gender}"/></td>
				<td><c:out value="${row.email}"/></td>
				
				<td>
					<a href="memberUpdate.jsp?id=<c:out value='${row.id}'/>">
						수정
					</a>
				</td>
				
				<td>
					<a href="memberDelete.jsp?id=<c:out value='${row.id}'/>">
						삭제
					</a>
				</td>

			</tr>
		
		
		</c:forEach>
		
		
	</table>

</body>
</html>









