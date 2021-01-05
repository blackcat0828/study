<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.*,fintech.*"
    %>
 <%
 	request.setCharacterEncoding("UTF-8");
 %>
 
<jsp:useBean id="cal" class="fintech.Calculator" scope="page" />
<jsp:setProperty name="cal" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=cal.getNum1() %> + <%=cal.getNum2() %> = <%=cal.add() %> <br>
	<%=cal.getNum1() %> - <%=cal.getNum2() %> = <%=cal.minus() %> <br>
	<%=cal.getNum1() %> * <%=cal.getNum2() %> = <%=cal.mul() %> <br>
	<%=cal.getNum1() %> / <%=cal.getNum2() %> = <%=cal.div() %> <br>
</body>
</html>