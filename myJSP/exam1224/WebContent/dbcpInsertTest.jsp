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
		String sql = "insert into student(studno,name,addr,phone) values (?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleTest");

			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"1000");
			pstmt.setString(2,"홍길동");
			pstmt.setString(3,"부산시 동래구 온천1동");
			pstmt.setString(4,"010-1234-5678");

			pstmt.executeUpdate();
			out.println("자료 등록 성공");
			
			
		}catch(Exception e){
			out.println("<h3>자료등록 실패</h3>");
			e.printStackTrace();
		}finally{
			try{
				pstmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	%>
</body>
</html>