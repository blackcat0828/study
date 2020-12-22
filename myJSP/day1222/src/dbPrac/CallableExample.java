package dbPrac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class CallableExample {

	public static void main(String[] args) {
		CallableStatement cstmt=null; 
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
			 
			 //변수 선언
			 String id,name;
			 int kor=0,eng=0,math=0,tot=0,rank=0;
			 double avg=0.0;
			 
			 while(true) {
				 System.out.println("1.성적등록 2.성적수정 3.성적삭제 4.성적리스트 5.종료");
				 System.out.println("선택>>>");
				 int menu = sc.nextInt();
				 
				 if(menu==1) {
					 System.out.println("학번입력: ");
					 id = sc.next();
					 
					 System.out.println("이름입력:");
					 name = sc.next();
					 
					 System.out.println("국어성적입력:");
					 kor = sc.nextInt();
					 
					 System.out.println("수학성적입력");
					 math = sc.nextInt();
					 
					 System.out.println("영어성적입력");
					 eng = sc.nextInt();
					 
					 cstmt = con.prepareCall("{call insertscore(?,?,?,?,?,?)}");
					 cstmt.setString(1, id);
					 cstmt.setString(2, name);
					 cstmt.setInt(3, kor);
					 cstmt.setInt(4, math);
					 cstmt.setInt(5, eng);
					 
					 //프로시저에서 선언된 out 변수처리
					 //성적입력시 정상처리되면 0 값이
					 //비정상처리되면 -1 값이 리턴
					 cstmt.registerOutParameter(6, java.sql.Types.NUMERIC);
					 cstmt.execute();
					 
					 //리턴값 가져오기
					 int result = cstmt.getInt(6);
					 if(result==0) {
						 System.out.println("정상적으로 입력 성공");
					 }else {
						 System.out.println("이미 성적자료가 존재");
					 }
					 
				 }else if(menu==2) {
					 System.out.println("학번입력: ");
					 id = sc.next();
					 
					 System.out.println("국어성적입력:");
					 kor = sc.nextInt();
					 
					 System.out.println("수학성적입력");
 					 math = sc.nextInt();
					 
					 System.out.println("영어성적입력");
					 eng = sc.nextInt();
					 
					 cstmt = con.prepareCall("{call updatescore(?,?,?,?,?)}");
					 cstmt.setString(1, id);
					 
					 cstmt.setInt(2, kor);
					 cstmt.setInt(3, math);
					 cstmt.setInt(4, eng);
					 
					 //프로시저에서 선언된 out 변수처리
					 //성적입력시 정상처리되면 0 값이
					 //비정상처리되면 -1 값이 리턴
					 cstmt.registerOutParameter(5, java.sql.Types.NUMERIC);
					 cstmt.execute();
					 
					 //리턴값 가져오기
					 int result = cstmt.getInt(5);
					 if(result==0) {
						 System.out.println("정상적으로 입력 성공");
					 }else {
						 System.out.println("학생이 등록되지 않았음");
					 }
					 
				 }
				 
			 }
			 
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
		 }finally {
			 try {
			 if(con != null) con.close();
			 if(rs != null) rs.close();
			 if(cstmt != null) cstmt.close();
			 }catch(Exception e) {
				 System.out.println(e.getMessage());
			 }
		 }
	}

}
