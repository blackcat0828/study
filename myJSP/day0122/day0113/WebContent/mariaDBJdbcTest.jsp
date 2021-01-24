<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection conn = null;
		Boolean connect = false;
	
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3307/jdbcMaria";
		String userid="jsp";
		String userpw="jsp1234";

		try{
	
			Class.forName(driver);
			conn = DriverManager.getConnection(url,userid,userpw);
			
			connect = true;
			conn.close();
			
		}catch(Exception e){
			connect = false;
			e.printStackTrace();
		}
	
	%>
	
	<h3>
		<%
			if(connect){
		%>
				mariaDB 연결 성공		
		<%		
			}else{
		%>
		 		mariaDB연결 실패
		<%
			}
		%>
	
	</h3>
</body>
</html>




