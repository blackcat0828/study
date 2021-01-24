<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection conn = null;
	
		try{
			
			//애플리케이션이 처음으로 실행될때 모든 설정에 관련되는 사항은
			//java:comp/env 부분에 설정된다.
			Context init = new InitialContext();
			
		    //데이터베이스 연결 객체
		    //jdbc/OracleDB 명칭은 context.xml 의 
		    //Resouce name을 그대로 선언하면 된다
			DataSource ds = 
			(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
		    //톰캣서버에서 제공하는 Connection 객체를 얻어온다.
			conn = ds.getConnection();
			
			out.println("<h3>연결되었습니다.</h3>");
			
		}catch(Exception e){
			out.println("<h3>연결에 실패하였습니다.</h3>");
			e.printStackTrace();
		}
	
	%>
</body>
</html>




