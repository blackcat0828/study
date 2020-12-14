package sec02.ex1;

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
//	private Statement stmt; // �Ϲ� Statement ���, �Ϲ� ���ڿ��̶� DBMS�� ��û�� ���������� �������� �Ź� �ؾ���.
	private PreparedStatement pstmt; // Statement�ʹ޸� �̸� DBMS�� �����Ҽ� �ֵ��� ������������ ���� ���.
	private DataSource dataFactory;
	private Connection con;
//	 String driver="oracle.jdbc.driver.OracleDriver";
//	 String url="jdbc:oracle:thin:@localhost:1521:orcl";
//	 String user="scott";
//	 String psword="1234";
	
	public MemberDAO() {
		try {
			//JNDI�� �����ѱ� ���� �⺻ ���(java:/comp/env)�� ����
			Context ctx = new InitialContext();
			javax.naming.Context envContext = (Context) ctx.lookup("java:/comp/env");
			//��Ĺ context.xml�� ������ name ���� jdbc/oracle�� �̿��� ��Ĺ�� �̸� ������ DataSource�� �޾ƿ�
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMember(){
		List<MemberVO> list = new ArrayList<>();
		try {
//			connDB();
			con = dataFactory.getConnection(); // DataSource�� �̿��� �����ͺ��̽��� ����
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
	
//	private void connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("Oracle ����̹� �ε� ����");
//			con = DriverManager.getConnection(url, user, psword);
//			System.out.println("Connection ���� ����");
////			stmt = con.createStatement(); �Ϲ� Statement ������
////			System.out.println("Statement ���� ����");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
