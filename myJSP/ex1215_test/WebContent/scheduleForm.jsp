<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 스케쥴 등록</title>
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
	<form name="scheduleForm" action="scheduleProcess.jsp" 
	      method="post">
		<table border="1">
			<tr>
				<td colspan="2" class="td_title">
					스케줄등록 페이지
				</td>
			</tr>
			<tr>
				<td><label for="sdate">회의일자:</label></td>
				<td><input type="text" name="sdate" id="sdate"/></td>
			</tr>
			<tr>
				<td><label for="title">제목:</label></td>
				<td><input type="text" name="title" id="title"/></td>
			</tr>
			<tr>
				<td><label for="content">내용:</label></td>
				<td><input type="text" name="content" id="content"/></td>
			</tr>
			<tr>
				<td><label for="location">장소:</label></td>
				<td><input type="text" name="location" id="location"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="javascript:scheduleForm.submit()">등록</a>
					&nbsp;&nbsp;
					<a href="javascript:scheduleForm.reset()">다시작성</a>					
				</td>
			</tr>							
									
		</table>
	</form>
</body>
</html>