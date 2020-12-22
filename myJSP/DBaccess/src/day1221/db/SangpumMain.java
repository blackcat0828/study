package day1221.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SangpumMain{
	public static void main(String[] args) {

		//데이터베이스 연동시 반드시 필요한 4가지 정보
		String driver = 
			"oracle.jdbc.driver.OracleDriver";
		//접속정보
		//1521(오라클 접속 포트)
		//orcl : SID 이름
		String url = 
			"jdbc:oracle:thin:@localhost:1521:orcl";
		//사용자 아이디
		String user = "fintech";
		//비밀번호
		String pwd = "fintech1234";
		
		//데이터베이스 연결하기 위한 선언
		Connection con = null;
		//쿼리결과를 리턴받아 관리하는 배열 형태
		ResultSet rs = null;
		//PreparedStatement 를 사용하여
		//데이터베이스에 접근한다는 선언
		PreparedStatement pstmt = null;
		
		try {
			
			//괄호안에 클래스 파일명을 매개변수로 지정하면
			//이 클래스를 반환처리 해준다.
			//클래스 존재여부를 체크하기 위해 사용
			Class.forName(driver);
			
			//getConnection()
			//싱글톤(Singleton) 패턴
			//메모리힙에 인스턴스가 없으면 한번만 생성한후
			//이후에는 이 인스턴스를 공유하여 사용한다.
			//이는 메모리 효율을 높이기 위함
			con = 
			DriverManager.getConnection(url,user,pwd);
			
			System.out.println("데이터베이스 성공");
			
			
		}catch(Exception e) {
			System.out.println("데이터베이스 접속 오류");
		}
				
		

	}

}






