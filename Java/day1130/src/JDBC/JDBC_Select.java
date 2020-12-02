package JDBC;

import java.sql.*;

public class JDBC_Select {
    static {
        try {
            System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        try {
            String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
            con = DriverManager.getConnection(dbUrl, "scott", "tiger");
            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT ename FROM emp");

            while(rs.next()) {
                System.out.println(rs.getString("ename"));
            }
        } catch (SQLException e) {

        } finally {

            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
