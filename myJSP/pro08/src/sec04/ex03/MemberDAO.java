package sec04.ex03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
//	private Statement stmt; // 일반 Statement 사용, 일반 문자열이라서 DBMS가 요청이 있을때마다 컴파일을 매번 해야함.
	private PreparedStatement pstmt; // Statement와달리 미리 DBMS가 이해할수 있도록 컴파일함으로 성능 향상.
	private DataSource dataFactory;
	private Connection con;
//	 String driver="oracle.jdbc.driver.OracleDriver";
//	 String url="jdbc:oracle:thin:@localhost:1521:orcl";
//	 String user="scott";
//	 String psword="1234";
	
	public MemberDAO() {
		try {
			//JNDI에 접근한기 위해 기본 경로(java:/comp/env)를 지정
			Context ctx = new InitialContext();
			javax.naming.Context envContext = (Context) ctx.lookup("java:/comp/env");
			//톰캣 context.xml에 설정한 name 값인 jdbc/oracle을 이용해 톰캣이 미리 연결한 DataSource를 받아옴
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMember(){
		List<MemberVO> list = new ArrayList<>();
		try {
//			connDB();
			con = dataFactory.getConnection(); // DataSource를 이용해 데이터베이스에 연결
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
	
	public void addMember(MemberVO memberVO) {
		try {
			con = dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			String query = "insert into t_member";
			query += " (id,pwd,name,email)";
			query += " values(?,?,?,?)";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();
			String query = "delete from t_member" + " where id=?";
			System.out.println("prepareStatememt:" + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	private void connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("Oracle 드라이버 로딩 성공");
//			con = DriverManager.getConnection(url, user, psword);
//			System.out.println("Connection 생성 성공");
////			stmt = con.createStatement(); 일반 Statement 생성시
////			System.out.println("Statement 생성 성공");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
