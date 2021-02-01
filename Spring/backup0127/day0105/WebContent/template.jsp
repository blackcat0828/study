<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>template test</title>
<style type="text/css">
	table {
		margin:auto;
		width:960px;<!--가로 -->
		color:gray;
		border:1px solid gray;
	}
</style>
</head>
<body>
	<%
		//신상품 혹은 인기상품클릭시 매개변수 값을 가져옴
		String pagefile = request.getParameter("page");
		
	    //미선택시 신상품을 기본값으로 한다.
		if(pagefile == null){
			pagefile = "newitem";
		}
	%>
	
	<table>
		<tr>
			<td height="43px" colspan="3" align="left">
				<jsp:include page="top.jsp"/>
			</td>
		</tr>
		
		<tr>
			<td width="15%" align="right" valign="top">
				<jsp:include page="left.jsp"/>
			</td>
		</tr>
		
		<tr>
		<!-- 
			<jsp:include page="newitem.jsp"/>
			<jsp:include page="bestitem.jsp"/>
		 -->
			<td colspan="2" align="center">
				<jsp:include page='<%=pagefile+".jsp" %>'/>
			</td>
		</tr>			
			
		<tr>
			<td width="100%" height="40px" colspan="3">
				<jsp:include page="bottom.jsp"/>
			</td>
		</tr>					
		
	</table>
</body>
</html>






