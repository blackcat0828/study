<%@page import="com.sun.org.apache.bcel.internal.generic.Select" %>
<%@page import="vo.Cart" %>
<%@page import="vo.Glasses" %>
<%@page import="dao.GlassesDAO" %>
<%@page import="java.util.List" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#listForm{
	width: 640px;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	width: 550px;
	margin: auto;
}



.div_empty {
	text-align: center;
	background-color;
}

.td_command {
	text-align: right;
}


#todayImageList {
	text-align: center;
}

#productImage{
	width:150px;
	height:150px;
	border:none:
}

#cartImage{
	width:70px;
	height:70px;
	border:none;
}

#select {
	text-align: right;
}

#commandList {
	text-align: center;
}

#upImage{
	width: 15px;
}

#downImage{
	width: 15px;
}

</style>

</head>
<body>
<%@ include file="header.jsp" %>
<section id="listForm">
	<c:if test="${orderList !=null&&orderList.size()>0 }">
	<h2>주문 목록</h2>
	<table class="table table_bordered table-striped">
	<tr class="info">
		<td>주문 번호</td>
		<td>주문 날짜</td>
		<td>주문인 ID</td>
		<td>주문 상태</td>
		<td>주문 상세</td>
		<td>주문 삭제</td>
	</tr>
	
	<c:forEach var="order" items="${orderList }" varStatus="status">
	
	<tr>
		<td>
			${order.id }
		</td>	
		<td>
			${order.orderDate }
		</td>
		<td>
			${order.customer}
		</td>
		<td>
			${order.status }
		</td>
		<td>
			<a href="orderDetail.order?id=${order.id }&addr=${order.addr}" class="btn btn-danger" role="button">주문 상세보기</a>
		</td>
		<td>
			<a href="orderDelete.order?id=${order.id }" class="btn btn-danger" role="button">주문 삭제</a>
		</td>
	</tr>
	</c:forEach>
	</table>
	</c:if>
	<c:if test="${orderList==null }">
		<sction class="div_empty">
		주문 정보가 없습니다.
		</sction>
	</c:if>
	<nav id="commandList">
		<a href="glassesList.glasses" class="btn btn-primary" role="button">쇼핑계속하기</a>
	</nav>
</section>

</body>
</html>