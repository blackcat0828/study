<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.io.*,java.text.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));
int even = 0;
int odd = 0;
int total = 0;

for(int i=num1; i<=num2; i++){
	if(i%2==0){
		even += i;
	}else{
		odd += i;
	}
}

total = even + odd;


//문자단위 출력 스트림
PrintWriter ot = response.getWriter();

DecimalFormat df = new DecimalFormat("###,###");

ot.print("짝수합 : " +  df.format(even) + "<br>");
ot.print("홀수합 : " +  df.format(odd) + "<br>");
ot.print("총합계 : " +  df.format(total));
%>

</body>
</html>