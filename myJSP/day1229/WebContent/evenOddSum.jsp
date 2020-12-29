<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.text.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		int evenSum=0, oddSum=0, totalSum=0;

		for(int i=1; i<=100; i++){
			if(i%2==0){
				evenSum += i;
			}else{
				oddSum += i;
			}
		}
		totalSum = evenSum+oddSum;
		//변수값 천단위 콤마 추가
		DecimalFormat df = new DecimalFormat("###,###");
		
		//DecimalFormat 의 format 메서드를 이용하여 원하는 형태로 출력
		out.print("짝수합:" + df.format(evenSum) + "<br>");
		out.print("홀수합:" + df.format(oddSum) + "<br>");
		out.print("총합계:" + df.format(totalSum) + "<br>");
		
%>
	짝수합:<%=evenSum %>
	홀수합:<%=oddSum %>
	총합계:<%=totalSum %>

</body>
</html>