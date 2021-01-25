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
	
	<h3>스케줄 리스트</h3>
	<div align="left">
		<button type="button" 
		        class="button" onclick="location.href='scheduleForm.jsp'">
			스케줄등록			
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
	

	<sql:query var="rs" dataSource="${conn}">
		select * from schedule order by sdate
	</sql:query>
	
	<table border="1" style="border-collapse:collapse;width=600px">
		<tr>
			<th width="10%">일자</th>
			<th width="20%">제목</th>
			<th width="20%">내용</th>
			<th width="20%">장소</th>
			<th width="10%">수정</th>
			<th width="10%">삭제</th>
		</tr>
		
		<c:forEach var="row" items="${rs.rows}">
			<tr>
				<td><c:out value="${row.sdate}"/></td>
				<td><c:out value="${row.title}"/></td>
				<td><c:out value="${row.content}"/></td>
				<td><c:out value="${row.location}"/></td>
				
				
				<td>
					<a href="scheduleUpdate.jsp?sdate=<c:out value='${row.sdate}'/>">
						수정
					</a>
				</td>
				
				<td>
					<a href="scheduleDelete.jsp?sdate=<c:out value='${row.sdate}'/>">
						삭제
					</a>
				</td>

			</tr>
		
		
		</c:forEach>
		
		
	</table>

</body>
</html>








