import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcTest {
    public static void main(String[] args) {
        String driver = "org.mariadb.jdbc.Driver";
        String url = "jdbc:mariadb://jeffworld.iptime.org:33060/portfolio1";
        Connection con = null;
        Statement stmt = null ;
        //---JDBC_Select 추가된 내용 -------
        ResultSet rs = null;
        
        String title; //데이터베이스에서 얻어온 필드값 저장할 변수 선언
        String sql; //SQL문을 저장할 변수 선언
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, "pfuser1", "1234" );
            stmt= con.createStatement();
            //---JDBC_Select 추가된 내용 -------
            sql = "select * from book";
            System.out.print("번호 ₩t 이름 ₩t₩t 이메일 ₩t₩t 전화번호 ₩n");
            System.out.print("------------------------------------------------₩n");
            rs = stmt.executeQuery(sql); //얻어진 레코드를 가져옴
            while( rs.next() ){
                
                title = rs.getString("title");

                System.out.println("title : "+title);
            }
        }
        catch(Exception e){
            System.out.println(e);
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
