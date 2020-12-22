package sec01.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDAO {
//	private Statement stmt; // �Ϲ� Statement ���, �Ϲ� ���ڿ��̶� DBMS�� ��û�� ���������� �������� �Ź� �ؾ���.
	private PreparedStatement pstmt; // Statement�ʹ޸� �̸� DBMS�� �����Ҽ� �ֵ��� ������������ ���� ���.
	private Connection con;
	 String driver="oracle.jdbc.driver.OracleDriver";
	 String url="jdbc:oracle:thin:@localhost:1521:orcl";
	 String user="scott";
	 String psword="1234";
	
	public List<MemberVO> listMember() throws SQLException{
		List<MemberVO> list = new ArrayList<>();
		try {
			connDB();
			String query = "select * from t_member ";
			System.out.println(query);
//			ResultSet rs = stmt.executeQuery(query);
			pstmt = con.prepareStatement(query); //prepareStatement() �޼��忡 SQL�����Ͽ� PreparedStatement ��ü ����
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
			System.out.println("Oracle ����̹� �ε� ����");
			con = DriverManager.getConnection(url, user, psword);
			System.out.println("Connection ���� ����");
//			stmt = con.createStatement(); �Ϲ� Statement ������
//			System.out.println("Statement ���� ����");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
