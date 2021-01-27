<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 회원가입</title>
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
	
	<%--
	   conn 설정은 dbconn.jsp 에 있다
	   수정하려는 회원정보를 가져오기 위해 select 수행 
	--%>
	<sql:query var="rs" dataSource="${conn}">
		select * from member where id = ?
		<sql:param value="${param.id}"/>
	</sql:query>
		
	<c:forEach var="row" items="${rs.rows}">
	
		<form name="joinform" action="memberUpdateProcess.jsp" 
		      method="post">
			<table border="1">
				<tr>
					<td colspan="2" class="td_title">
						회원가입 페이지
					</td>
				</tr>
				<tr>
					<td><label for="id">아이디:</label></td>
					<td>
						<input type="text" name="id" id="id"
							   value="<c:out value='${row.id}'/>"/>
					</td>
				</tr>
				<tr>
					<td><label for="pass">비밀번호:</label></td>
					<td><input type="password" name="pass" id="pass" value="<c:out value='${row.password}'/>"/></td>
				</tr>
				<tr>
					<td><label for="name">이름:</label></td>
					<td><input type="text" name="name" id="name" value="<c:out value='${row.name}'/>"/></td>
				</tr>
				<tr>
					<td><label for="age">나이:</label></td>
					<td><input type="text" name="age" id="age" value="<c:out value='${row.age}'/>"/></td>
				</tr>
				<tr>
					<td><label for="gender1">성별:</label></td>
					<td>
						<input type="radio" name="gender" value="남" id="gender1" <c:if test="${row.gender == '남'}"> checked </c:if>>남자
						<input type="radio" name="gender" value="여" id="gender2" <c:if test="${row.gender == '여'}"> checked </c:if>>여자					
					</td>
				</tr>
				<tr>
					<td><label for="email">이메일주소:</label></td>
					<td><input type="text" name="email" id="email" value="<c:out value='${row.email}'/>"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="javascript:joinform.submit()">수정</a>
						&nbsp;&nbsp;
						<a href="memberList.jsp">목록</a>					
					</td>
				</tr>							
										
			</table>
		</form>
	</c:forEach>	
</body>
</html>