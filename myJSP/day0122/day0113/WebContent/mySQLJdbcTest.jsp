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
	
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul";
		String userid="java";
		String userpw="java1234";

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
				mysql 연결 성공		
		<%		
			}else{
		%>
		 		연결 실패
		<%
			}
		%>
	
	</h3>
</body>
</html>



