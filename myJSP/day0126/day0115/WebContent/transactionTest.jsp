<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction 예제</title>
</head>
<body>
	<%
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "insert into student(num,name) values (13,'홍길동')";
		String sql2 = "select * from student where num = 12";
		
		try {
			
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			conn = ds.getConnection();
			
			//데이터베이스에 반영을 자동으로 하지 않겠다는 선언
			conn.setAutoCommit(false);
			
			//Transaction 포함된 2개의 작업을 수행
			//첫번째 작업은 정상수행(insert)
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
			//두번째 작업은 12번 학생 정보를 가져오는 select문인데
			//12번 학생은 없으므로 오류 발생
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			
			//가져올 데이터가 없으면 Rollback 처리
			if(!rs.next()){
				conn.rollback();
				out.println("<h3>데이터 추가에 문제가 발생하여 롤백하였습니다.</h3>");
			}else{
				//가져올 데이터가 있으면 Commit 처리
				conn.commit();
				out.println("<h3>데이터 추가 완료</h3>");
			}
			
			conn.setAutoCommit(true);
			
		}catch(Exception e){
			out.println("<h3>transaction.jsp 데이터 추가에 실패하였습니다.</h3>");
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