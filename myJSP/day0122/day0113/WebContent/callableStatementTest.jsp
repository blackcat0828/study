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
		CallableStatement cs = null;
		
		try {
			
			Context init = new InitialContext();
			DataSource ds = 
				(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			conn = ds.getConnection();
			
			//prepareCall? 
			//CallableStatement 문을 이용하여 프로시저 호출
			//첫번째 ? => 연봉을 알고 싶은 사원명
			//두번째 ? => 프로시져에서 계산된 연봉
			cs = conn.prepareCall("{call GET_ANNUAL_INCOME(?,?)}");
			
			cs.setString(1,"강감찬");
			//GET_ANNUAL_INCOME 프로시저에서 계산된 연봉을 리턴받는다.
			//java.sql.Types.INTEGER :리턴되는 연봉의 형태를 선언
			cs.registerOutParameter(2,java.sql.Types.INTEGER);
			
			//CallableStatement 실행
			cs.execute();
			
			out.println("<h3>" + cs.getInt(2) + "</h3");
					
			
		}catch(Exception e){
			out.println("<h3>연봉가져오기에 실패하였습니다.</h3>");
			e.printStackTrace();
		}finally{
			try{
				cs.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	%>
</body>
</html>




