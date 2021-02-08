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
	body { 
		padding-bottom: 70px;
		padding-top: 70px;
	 }

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
<script>

function checkAll(theForm){
		if(theForm.remove.length == undefined){
			theForm.remove.checked = theForm.allCheck.checked;
		}else{
			for(var i=0;i<theForm.remove.length;i++){
				theForm.remove[i].checked = theForm.allCheck.checked;
				
			}
			
		}
		
	}
	
function checkConfirm(theForm){
		var confirmed = false;	
		
		if(theForm.remove.length == undefined){
			if(theForm.remove.checked == true){
			theForm.action = "glassesCartRemove.glasses"
			theForm.submit();
			return
			}
		}else{
		
			for(var i=0;i<theForm.remove.length;i++){
				if(theForm.remove[i].checked == true){
					confirmed = true;
				}	
			}
		}
		
		if(confirmed==false){
			
			alert("적어도 1개의 아이템을 선택해주세요.")
		}else{
			theForm.action = "glassesCartRemove.glasses"
			theForm.submit();
		}
		
	}
	
function orderConfirm(theForm){
	var confirmed = false;	
	
	if(theForm.remove.length == undefined){
		theForm.remove.checked = true;
		theForm.action = "glassesOrder.glasses"
		theForm.submit();
		return
	}else{
	
		for(var i=0;i<theForm.remove.length;i++){
			if(theForm.remove[i].checked == true){
				confirmed = true;
			}	
		}
	}
	
	if(confirmed==false){
		
		alert("적어도 1개의 아이템을 선택해주세요.")
	}else{
		theForm.action = "glassesOrder.glasses"
		theForm.submit();
	}
	
}
	
function checkQty(id, qty){
		if(qty != 1){
			location.href="glassesCartQtyDown.glasses?id="+id;
		}
	}


</script>

</head>
<body>
<%@ include file="header.jsp" %>
<section id="listForm">
	<c:if test="${cartList !=null&&cartList.size()>0 }">
	<h2>장바구니 목록</h2>
	<form name="listCart" method="post" action="addOrder.order">
	<table class="table table_bordered table-striped">
	<tr class="info">
		<td>상품 아이디</td>
		<td>상품 이미지</td>
		<td>상품명</td>
		<td>가격</td>
		<td>수량</td>
	</tr>
	
	<c:forEach var="orderedItem" items="${cartList }" varStatus="status">
	
	<tr>
		<td>
			${orderedItem.id }
		</td>
		<td>
			<img src = "resources/images/${orderedItem.image }"
				id="cartImage"/>
		</td>
		<td>
			${orderedItem.kind}
		</td>
		<td>
			${orderedItem.price }
		</td>
		<td>
			
			${orderedItem.qty }
			
		</td>
	</tr>
	</c:forEach>
	
	<tr>
		<td colspan="6" style="text-align:center;">
			총 금액 : ${totalMoney }원
		</td>
	</tr>
	<tr>
		<td colspan="6" style="text-align:center;">
			배송주소 : ${addr }
		</td>
	</tr>
	<c:if test="${userId=='admin' }">
	<tr>
		<td colspan="6" style="text-align:center;">
			<a href="updateOrderStatus.order?orderId=${orderId }" class="btn btn-primary" role="button">배송 완료</a>
			<a href="glassesList.glasses" class="btn btn-primary" role="button">쇼핑계속하기</a>
		</td>
	</tr>
	</c:if>
	<c:if test="${userId !='admin' }">
	<tr>
		<td colspan="6" style="text-align:center;">
			<a href="glassesList.glasses" class="btn btn-primary" role="button">쇼핑계속하기</a>
		</td>
	</tr>
	</c:if>
	</table>
	</form>
	</c:if>
	
</section>
<%@ include file="footer.jsp" %>
</body>
</html>