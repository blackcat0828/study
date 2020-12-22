package dbPrac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class empManageMain {
	 
	 public static void main(String[] args) {
		 	PreparedStatement pstmt=null; 
			Connection con=null;
			ResultSet rs=null;
			 String driver="oracle.jdbc.driver.OracleDriver";
			 String url="jdbc:oracle:thin:@localhost:1521:orcl";
			 String user="fintech";
			 String password="fintech1234";
			 Scanner sc = new Scanner(System.in);
		 
		 
		 try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
				System.out.println("DB접속 성공");
				while(true) {
					System.out.println("메뉴 선택");
					System.out.println("1.부서 등록  2.부서 수정  3.부서 삭제");
					System.out.println("4.사원 등록  5.사원 수정  6.사원 삭제  7.사원 조회  8.종료");
					System.out.print("입력> ");
					int menu = sc.nextInt();
					
					
					if(menu==1) {
						System.out.println("부서 등록");
						System.out.print("부서 번호 입력 > ");
						int deptno = sc.nextInt();
						sc.nextLine();
						System.out.println("부서 이름 입력 > ");
						String dname = sc.nextLine();
						String sql = "insert into dept values(?,?)";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, deptno);
						pstmt.setString(2, dname);
						pstmt.executeUpdate();
					}else if(menu==2) {
						System.out.println("부서 수정");
						System.out.print("수정할 부서 번호 입력 > ");
						int deptno = sc.nextInt();
						System.out.print("새로운 부서 번호 입력 > ");
						int newDeptno = sc.nextInt();
						sc.nextLine();
						System.out.println("새로운 부서 이름 입력 > ");
						String dname = sc.nextLine();
						String sql = "UPDATE dept SET deptno = ?, dname = ? WHERE deptno = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, newDeptno);
						pstmt.setString(2, dname);
						pstmt.setInt(3, deptno);
						pstmt.executeUpdate();
					}else if(menu == 3) {
						
						System.out.println("부서 삭제");
						System.out.print("삭제할 부서 번호 입력 > ");
						int deptno = sc.nextInt();
						String sql = "DELETE FROM dept WHERE deptno = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, deptno);
						pstmt.executeUpdate();
					}else if(menu == 4) {
						sc.nextLine();
						System.out.println("사원 등록");
						System.out.print("사원 번호 입력 > ");
						String empno = sc.nextLine();
						
						System.out.println("사원 이름 입력 > ");
						String ename = sc.nextLine();
						System.out.print("부서 번호 입력 > ");
						int deptno = sc.nextInt();
						System.out.print("급여 입력 > ");
						int payamt = sc.nextInt();
						System.out.print("보너스 입력 > ");
						int bonusamt = sc.nextInt();
						String sql = "insert into emp values(?,?,?,?,?)";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, empno);
						pstmt.setString(2, ename);
						pstmt.setInt(3, deptno);
						pstmt.setInt(4, payamt);
						pstmt.setInt(5, bonusamt);
						pstmt.executeUpdate();
					}else if(menu == 5) {
						sc.nextLine();
						System.out.println("사원 수정");
						System.out.print("수정할 사원 번호 입력 > ");
						String empno = sc.nextLine();
						System.out.print("급여 입력 > ");
						int payamt = sc.nextInt();
						System.out.print("보너스 입력 > ");
						int bonusamt = sc.nextInt();
						String sql = "update emp set payamt = ?, bonusamt = ?"
									+"where empno = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, payamt);
						pstmt.setInt(2, bonusamt);
						pstmt.setString(3, empno);
						
						pstmt.executeUpdate();
					}else if(menu == 6) {
						System.out.println("사원 삭제");
						System.out.print("삭제할 사원 번호 입력 > ");
						int empno = sc.nextInt();
						String sql = "DELETE FROM emp WHERE empno = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, empno);
						pstmt.executeUpdate();
					}else if(menu == 7) {
						System.out.println("사원 조회");
						String sql = "SELECT dname, empno, ename, payamt, bonusamt, payamt+bonusamt AS total "
								+ "FROM emp e, dept d WHERE e.deptno = d.deptno ORDER BY e.deptno, total DESC";
								
								
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
						while(rs.next()) {
							System.out.println(
									"부서 이름: " + rs.getString("dname")+"    "+
									"사원 번호: " + rs.getString("empno")+"    "+
									"사원 이름: " + rs.getString("ename")+"    "+
									
									"연봉: " + rs.getInt("payamt")+"    "+
									"보너스: " + rs.getInt("bonusamt")+"    "+
									"총액 : " + rs.getInt("total")
									
									);
						}
					}else {
						System.out.println("종료 합니다.");
						break;
					}
				}
				
				
				
			} catch (Exception e) {
				System.out.println("문제 발생 : "+e);
			}finally {
				try {
				if(con != null) con.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
				sc.close();
				
				}catch(Exception e){
					System.out.println("클로즈 실패 : " + e.getMessage());
				}
			}
	}
	 
}
