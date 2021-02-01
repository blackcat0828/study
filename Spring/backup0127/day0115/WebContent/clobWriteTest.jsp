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
		PreparedStatement pstmt = null;
		StringBuffer sb = null;
		
		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			conn = ds.getConnection();
			
			String sql = 
			"insert into clobtable(num,content) values(1,?)";
			
			sb = new StringBuffer();
			
			//문자열 버퍼에 홍길동을 만번 추가
			for(int i=0;i<10000;i++){
				sb.append("홍길동");
			}
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sb.toString());
			pstmt.executeUpdate();
			
			out.println("데이터를 저장하였습니다.");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	%>
</body>
</html>