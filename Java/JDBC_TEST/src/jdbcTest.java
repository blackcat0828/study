import java.sql.*;

public class jdbcTest {

    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        Connection con = null;
        Statement stmt = null ;
        //---JDBC_Select 추가된 내용 -------
        ResultSet rs = null;
        int empno = 0;
        String name; //데이터베이스에서 얻어온 필드값 저장할 변수 선언
        String sql; //SQL문을 저장할 변수 선언
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, "scott", "tiger" );
            stmt= con.createStatement();
            //---JDBC_Select 추가된 내용 -------
            sql = "SELECT * FROM emp";
            System.out.printf("번호 ₩t 이름 ₩t₩t 이메일 ₩t₩t 전화번호 ₩n");
            System.out.printf("------------------------------------------------₩n");
            rs = stmt.executeQuery(sql); //얻어진 레코드를 가져옴
            while( rs.next() ){
                empno = rs.getInt("empno");
                name = rs.getString("ename");

                System.out.println(empno +" : "+name);
            }
        }
        catch(Exception e){
            System.out.println("데이터베이스 연결 실패!");
        }
        finally{
            try{//rs, stmt, con 객체를 close() 메서드를 호출해 해제
                if( rs != null ) rs.close();
                if( stmt != null ) stmt.close();
                if( con != null ) con.close();
            }
            catch(Exception e){
                System.out.println( e.getMessage( ));
            }
        }
    }
}
