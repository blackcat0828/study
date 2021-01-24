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

		/*1. ResultSet.TYPE_SCROLL_SENSITIVE
		   - Application에 의해 데이터베이스의 내용이 변경될경우
		     ResultSet에 포함된 데이터에는 변경사항이 반영이 안되는데
		     이 옵션을 사용하면 즉시 반영된다.
		   - 커서 이동 허용
		 
		  2. ResultSet.TYPE_SCROLL_INSENSITIVE
		     - 커서 이동은 허용
		     - 데이터베이스 변경사항을 ResultSet에는 반영을 하지 않는다.

		  3. ResultSet.TYPE_FORWARD_ONLY
		     - 커서를 다음 레코드로 이동하는 것만 허용

		   CONCUR : Concurrency(동시성)
		   
		   ResultSet.CONCUR_UPDATABLE
		   - 현재 커서의 위치에 있는 정보를 변경가능

		   ResultSet.CONCUR_READ_ONLY
		   - 현재 커서 위치의 정보를 읽기만 가능	 */	
		
		try{
			
			Context init = new InitialContext();
			DataSource ds = 
					(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(
					   sql,
					   ResultSet.TYPE_SCROLL_SENSITIVE,
					   ResultSet.CONCUR_UPDATABLE);
			
			rs = pstmt.executeQuery();
			
			//커서의 위치를 마지막으로 이동
			rs.last();
			out.println(rs.getInt(1) + "," + rs.getString(2) + "<br>");
			
			//커서의 위치를 맨처음으로 이동
			rs.first();
			out.println(rs.getInt(1) + "," + rs.getString(2) + "<br>");
			
			//커서를 3번째 위치로 이동
			rs.absolute(3);
			out.println(rs.getInt(1) + "," + rs.getString(2) + "<br>");
			
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