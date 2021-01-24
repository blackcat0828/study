<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.text.*"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//스크립틀릿 태그(자바 프로그램 작성)
	int evenSum=0,oddSum=0,totalSum=0;
	
	for(int i=1;i<=100;i++){
		
		if(i%2==0){//짝수
			evenSum += i;
		}else{//홀수
			oddSum += i;
		}
		
		totalSum += i;//총계
	}

	//변수값 천단위 콤마 추가
	DecimalFormat df = new DecimalFormat("###,###");
	
	//DecimalFormat 의 format 메서드를 이용하여 원하는 형태로 출력
	out.print("짝수합:" + df.format(evenSum) + "<br>");
	out.print("홀수합:" + df.format(oddSum) + "<br>");
	out.print("총합계:" + df.format(totalSum) + "<br>");
	
%>
	<!-- 표현문을 이용하여 변수값 출력 -->
	짝수합:<%=evenSum%><br>
	홀수합:<%=oddSum%><br>
	총합계:<%=totalSum%>

</body>
</html>







