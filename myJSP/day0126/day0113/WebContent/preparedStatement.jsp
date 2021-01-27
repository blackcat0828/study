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
		String sql = "insert into student(num,name) values (?,'홍길동')";
		PreparedStatement pstmt = null;
		
		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");

			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			for(int i=8;i<=11;i++){
				pstmt.setInt(1,i);
				
				if(pstmt.executeUpdate() != 0){
					out.println("<h3>" + i + "번째 자료를 등록하였습니다.</h3>");
				}
			}
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


