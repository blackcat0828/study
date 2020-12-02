package JDBC;
import java.sql.*;

public class JDBC_test {

        public static void main(String[] args) {
            //String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
//Oracle
            String driver="oracle.jdbc.driver.OracleDriver";
//Mysql
// String driver="com.mysql.jdbc.Driver";
            try{
                Class.forName(driver);
                System.out.println("데이터베이스 연결 성공!");
            }
            catch(Exception e){
                System.out.println("데이터베이스 연결 실패!");
            }
        }
    }

