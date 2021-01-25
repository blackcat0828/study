<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 스케쥴 수정</title>
<style type="text/css">
	table{
		margin:auto;
		width:400px;
		border:1px solid gray;
		text-align:center;
	}
	
	.td_title{
		font-weight:bold;
		<%-- 
		   xx-small : 9px
		   x-small: 10px;
		   small : 13px
		   medium : 16px=12pt=1em
		   large : 18px
		   x-large : 24px=1.5em
		   xx-large : 32px=2em
		 --%>
		font-size:x-large;
	}
</style>
</head>
<body>
		
	<%@ include file = "dbconn.jsp"%>	
	

	<sql:query var="rs" dataSource="${conn}">
		select * from schedule where sdate = ?
		<sql:param value="${param.sdate}"/>
	</sql:query>
		
	<c:forEach var="row" items="${rs.rows}">
	
		<form name="scheduleform" action="scheduleUpdateProcess.jsp" 
		      method="post">
			<table border="1">
				<tr>
					<td colspan="2" class="td_title">
						스케줄수정 페이지
					</td>
				</tr>
				<tr>
					<td><label for="sdate">회의일자:</label></td>
					<td>
						<input type="text" name="sdate" id="sdate"
							   value="<c:out value='${row.sdate}'/>"/>
					</td>
				</tr>
				<tr>
					<td><label for="title">제목:</label></td>
					<td><input type="text" name="title" id="title" value="<c:out value='${row.title}'/>"/></td>
				</tr>
				<tr>
					<td><label for="content">내용:</label></td>
					<td><input type="text" name="content" id="content" value="<c:out value='${row.content}'/>"/></td>
				</tr>
				<tr>
					<td><label for="location">장소:</label></td>
					<td><input type="text" name="location" id="location" value="<c:out value='${row.location}'/>"/></td>
				</tr>
				
				<tr>
					<td colspan="2">
						<a href="javascript:scheduleform.submit()">수정</a>
						&nbsp;&nbsp;
						<a href="scheduleList.jsp">목록</a>					
					</td>
				</tr>							
										
			</table>
		</form>
	</c:forEach>	
</body>
</html>