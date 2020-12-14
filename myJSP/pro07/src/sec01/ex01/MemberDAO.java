package sec01.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDAO {
//	private Statement stmt; // 일반 Statement 사용, 일반 문자열이라서 DBMS가 요청이 있을때마다 컴파일을 매번 해야함.
	private PreparedStatement pstmt; // Statement와달리 미리 DBMS가 이해할수 있도록 컴파일함으로 성능 향상.
	private Connection con;
	 String driver="oracle.jdbc.driver.OracleDriver";
	 String url="jdbc:oracle:thin:@localhost:1521:orcl";
	 String user="scott";
	 String psword="1234";
	
	public List<MemberVO> listMember(){
		List<MemberVO> list = new ArrayList<>();
		try {
			connDB();
			String query = "select * from t_member ";
			System.out.println(query);
//			ResultSet rs = stmt.executeQuery(query);
			pstmt = con.prepareStatement(query); //prepareStatement() 메서드에 SQL전달하여 PreparedStatement 객체 생성
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, psword);
			System.out.println("Connection 생성 성공");
//			stmt = con.createStatement(); 일반 Statement 생성시
//			System.out.println("Statement 생성 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
