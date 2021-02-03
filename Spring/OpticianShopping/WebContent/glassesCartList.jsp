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
	border: 1px red solid;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	width: 550px;
	margin: auto;
}

.tr_top {
	background-color: lime;
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

<section id="listForm">
	<c:if test="${cartList !=null&&cartList.size()>0 }">
	<h2>장바구니 목록</h2>
	<form name="listCart" method="post">
	<table>
	<tr class="tr_top">
		<td><input type="checkbox" id="allCheck" name="allCheck" onclick="checkAll(this.form)"/></td>
		<td>번호</td>
		<td>상품이미지</td>
		<td>상품명</td>
		<td>가격</td>
		<td>수량</td>
	</tr>
	
	<c:forEach var="cart" items="${cartList }" varStatus="status">
	
	<tr>
		<td>
			<input type="checkbox" id="remove" name="remove" value="${cart.id }"/>
		</td>	
		<td>
		${status.index+1 }
		</td>
		<td>
			<img src = "resources/images/${cart.image }"
				id="cartImage"/>
		</td>
		<td>
			${cart.kind}
		</td>
		<td>
			${cart.price }
		</td>
		<td>
			<a href="glassesCartQtyUp.glasses?id=${cart.id }">
				<img src= "resources/images/up.jpg" id = "upImage"
				border=0/>
			</a><br>
			${cart.qty }<br>
			<a href="javascript:checkQty('${cart.id }', ${cart.qty })">
				<img src= "resources/images/down.jpg" id = "downImage"
				border=0/>
			</a>
			</td>
	</tr>
	</c:forEach>
	
	<tr>
		<td colspan="5" style="text-align:center;">
			총 금액 : ${totalMoney }원
		</td>
	</tr>
	<tr>
		<td colspan="5" style="text-align:center;">
			<input type="submit" value="주문" onclick="orderConfirm(this.form)" />
			<input type="submit" value="선택 삭제" onclick="checkConfirm(this.form)" />
		</td>
	</tr>
	</table>
	</form>
	</c:if>
	<c:if test="${cartList==null }">
		<sction class="div_empty">
		상품 정보가 없습니다.
		</sction>
	</c:if>
	<nav id="commandList">
		<a href="glassesList.glasses">쇼핑 계속하기</a>
	</nav>
</section>

</body>
</html>