package swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
 
public class UserDefaultJTableDAO {

    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
 
    public UserDefaultJTableDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:fintech";
            String userid = "fintech";
            String passwd = "1234";
            con = DriverManager.getConnection(url,userid,passwd);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
 
    //데이타베이스 종료 메서드
    public void dbClose() {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (ps != null) ps.close();
        } catch (Exception e) {
            System.out.println(e + "=> dbClose fail");
        }
    }
 
    //id 중복여부(true =사용가능 , false = 중복)
    public boolean getIdByCheck(String id) {
        boolean result = true;
 
        try {
            ps = con.prepareStatement("SELECT * FROM TB_USERLIST WHERE id=?");
            ps.setString(1, id.trim());
            rs = ps.executeQuery();
            if (rs.next()) result = false; //레코드가 존재하면 false
        } catch (SQLException e) {
            System.out.println("getIdByCheck() 오류:" + e);
        } finally {
            dbClose();
        }
 
        return result;
 
    }
 
    //회원가입
    public int userListInsert(UserJDailogGUI user) {
        int result = 0;
        try {

            ps = con.prepareStatement("insert into TB_USERLIST values(?,?,?,?)");
            
            ps.setString(1, user.id.getText());//문자열 읽어오기
            ps.setString(2, user.name.getText());
            ps.setInt(3, Integer.parseInt(user.age.getText()));
            ps.setString(4, user.addr.getText());
 
            result = ps.executeUpdate();//쿼리 반영 rowcount 리턴
 
        } catch (SQLException e) {
            System.out.println("userListInsert() 오류" + e);
        } finally {
            dbClose();
        }
 
        return result;
 
    }
 
    //회원 조회
    public void userSelectAll(DefaultTableModel tmodel) {
        try {
        	
            st = con.createStatement();
            rs = st.executeQuery("select * from TB_USERLIST order by id");
 
            // DefaultTableModel에 있는 기존 데이터 지우기
            tmodel.setNumRows(0);
           
            //데이터베이스를 Table 형태로 출력하기위해
            //model에 데이터를 담고      JTable을 사용하여 출력합니다

            while (rs.next()) {
            	
            	Object  data[] = { rs.getString(1), 
                		          rs.getString(2),
                                  rs.getInt(3),
                                  rs.getString(4) 
                                };
 
            	//모델의 끝 위치에 자료 추가
                tmodel.addRow(data);

            }

        } catch (SQLException e) {
            System.out.println("userSelectAll() 오류" + e);
        } finally {
            dbClose();
        }
    }
 
    //특정 id 삭제
    public int userDelete(String id) {
        int result = 0;
        try {
            ps = con.prepareStatement("delete from TB_USERLIST where id = ? ");
            ps.setString(1, id.trim());
            result = ps.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println("userDelete()" + e);
        }finally {
            dbClose();
        }
 
        return result;
    }
 
    //회원수정
    public int userUpdate(UserJDailogGUI user) {
        int result = 0;
        String sql = "UPDATE TB_USERLIST " +
                     "   SET NAME=?, age=? , addr=?" +
        		     " WHERE id=?";
 
        try {
        	
            ps = con.prepareStatement(sql);

            ps.setString(1, user.name.getText());
            ps.setString(2, user.age.getText());
            ps.setString(3, user.addr.getText());
            ps.setString(4, user.id.getText().trim());
 
            result = ps.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println("userUpdate() 오류:" + e);
        } finally {
            dbClose();
        }
 
        return result;
    }
 
    //조건 검색처리
    public void getUserSearch(DefaultTableModel dt, String fieldName,String word) {
        String sql = "SELECT * FROM TB_USERLIST WHERE " + 
                      fieldName.trim() + " LIKE '%" + word.trim() + "%'";
 
        try {
        	
            st = con.createStatement();
            rs = st.executeQuery(sql);

            // DefaultTableModel에 있는 기존 데이터 지우기
            dt.setNumRows(0);
 
            while (rs.next()) {
                Object data[] = { rs.getString(1), 
                		          rs.getString(2),
                                  rs.getInt(3), 
                                  rs.getString(4) };
 
                dt.addRow(data);
            }
 
        } catch (SQLException e) {
            System.out.println("getUserSearch() 오류:" + e);
        } finally {
            dbClose();
        }
 
    }
 
}
