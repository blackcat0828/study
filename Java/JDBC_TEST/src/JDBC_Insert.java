import java.io.IOException;
import java.sql.*;

public class JDBC_Insert {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        Connection con = null;
        PreparedStatement pstmt= null;

        String sql; //SQL문을 저장할 변수 선언
        try{

            con = DriverManager.getConnection(url, "scott", "1234" );
            sql = "INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?,?,?,?,?,?,?,?)" ;
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,1234);
            pstmt.setString(2,"Jeff");
            pstmt.setString(3,"Sales");
            pstmt.setInt(4,7902);
            pstmt.setDate(5, Date.valueOf("1988-11-06"));
            pstmt.setInt(6,3000);
            pstmt.setInt(7,300);
            pstmt.setInt(8,20);
            pstmt.executeUpdate();



        } catch(SQLException e){
            System.out.println( e.getMessage() );
        } finally{
            try{
                if( pstmt != null ) pstmt.close();   //PrepareStatement 객체를 메모리에서 해제
                if( con != null )  con.close();
            }
            catch(Exception e){
                System.out.println("test");
                System.out.println( e.getMessage());
            }
        }
    }
}
