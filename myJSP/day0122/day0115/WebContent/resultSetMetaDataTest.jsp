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
		String sql = "select * from student";
		PreparedStatement pstmt = null;
		//select문을 실행한후 데이터를 배열형태로 가지는 객체
		ResultSet rs = null;
		//메타정보를 사용하기 위한 선언
		ResultSetMetaData rsmd = null;
		
		try{
			Context init = new InitialContext();
			DataSource ds = 
					(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//모든 메타정보를 가져올수 있다.
			rsmd = rs.getMetaData();
			
			out.println("컬럼수:" + rsmd.getColumnCount()+"<br>");
			
			for(int i=1;i<=rsmd.getColumnCount();i++){
				out.println(i+"번째 컬럼의 이름:" + rsmd.getColumnName(i)+":");
				out.println(i+"번째 컬럼의 타입:" + rsmd.getColumnTypeName(i)+"<br>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	%>
	
	
</body>
</html>