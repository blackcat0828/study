package project01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
 
public class libraryDAO {

    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
 
    public libraryDAO() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://jeffworld.iptime.org:33060/portfolio1";
            String userid = "pfuser1";
            String passwd = "1234";
            con = DriverManager.getConnection(url,userid,passwd);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
 
    
    public void dbClose() {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (ps != null) ps.close();
        } catch (Exception e) {
            System.out.println(e + "=> dbClose fail");
        }
    }
 
    
    //책 대여
    public int rentBook(Book book) throws ParseException {
        int result = 0;
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = fm.parse(book.getRentDate());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        try {

            ps = con.prepareStatement("update book set rent = ?, contact=?, rentDate = ? where id = ?");
            
            ps.setString(1, book.getRent());
            ps.setString(2, book.getContact());
            ps.setDate(3, sqlDate);
            ps.setInt(4, book.getId());
            
 
            result = ps.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println("addBook() �삤瑜�" + e);
        } finally {
            dbClose();
        }
        
        return result;
 
    }
 
    //책 반환
    public int returnBook(String id){
        int result = 0;
        int intId = Integer.parseInt(id);
        try {

            ps = con.prepareStatement("update book set rent = ?, contact=?, rentDate = ? where id = ?");
            
            ps.setString(1, "대여가능");
            ps.setString(2, null);
            ps.setDate(3, null);
            ps.setInt(4, intId);
            
 
            result = ps.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println("addBook() �삤瑜�" + e);
        } finally {
            dbClose();
        }
        
        return result;
 
    }
    
    //책추가
    public int addBook(String title) {
        int result = 0;
        try {

            ps = con.prepareStatement("insert into book (title) values(?)");
            
            ps.setString(1, title);//臾몄옄�뿴 �씫�뼱�삤湲�
            
 
            result = ps.executeUpdate();//荑쇰━ 諛섏쁺 rowcount 由ы꽩
 
        } catch (SQLException e) {
            System.out.println("addBook() �삤瑜�" + e);
        } finally {
            dbClose();
        }
        
        return result;
 
    }
 
    //모든 책 리스트 반환
    public ObservableList<Book> bookSelectAll() {
    	
    	ObservableList<Book> list = FXCollections.observableArrayList();
    	int id;
    	String title;
    	String rent;
    	String contact;
    	String rentDate;
    	int overDate;
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    	try {
        	
            st = con.createStatement();
            rs = st.executeQuery("select id, title, rent, ifnull(contact, '대여가능') as contact, IFNULL(rentDate, '대여가능') "
            		+ "					as rentDate, IFNULL(DATEDIFF(curDate(), rentDate), 0) as overDate from book; ");
 
            while (rs.next()) {
            	
            	id = rs.getInt("id");
            	title = rs.getString("title");
            	rent = rs.getString("rent");
            	contact = rs.getString("contact");
            	if(rs.getString("rentDate").equals("대여가능")) {
            	
            	rentDate = rs.getString("rentDate");
            	}else {
            		rentDate = dateFormat.format((rs.getDate("rentDate")));
            	}
            	overDate = rs.getInt("overDate");
            	
            	
            	
            	list.add(new Book(id,title,rent,contact,rentDate,overDate));
            	

            }
            
            
        } catch (SQLException e) {
            System.out.println("userSelectAll() �삤瑜�" + e);
        } finally {
            dbClose();
        }
    	
    	return list;
    }

    //책 id로 해당 책 삭제
    public int bookDelete(String id) {
        int result = 0;
        try {
            ps = con.prepareStatement("delete from book where id = ? ");
            ps.setString(1, id);
            result = ps.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println("userDelete()" + e);
        }finally {
            dbClose();
        }
 
        return result;
    }
    
    
  //책이름으로 검색
    public ObservableList<Book> bookSearch(String bookTitle) {
        String sql = "SELECT id, title, rent, ifnull(contact, '대여가능') as contact, "
        		+ "IFNULL(rentDate, '대여가능') as rentDate, "
        		+ "IFNULL(DATEDIFF(curDate(), rentDate), 0) as overDate "
        		+ "FROM book WHERE title "+ " LIKE '%" + bookTitle.trim() + "%'";
        
        ObservableList<Book> list = FXCollections.observableArrayList();
    	int id;
    	String title;
    	String rent;
    	String contact;
    	String rentDate;
    	int overDate;
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    	try {
        	
            st = con.createStatement();
            rs = st.executeQuery("SELECT id, title, rent, ifnull(contact, '대여가능') as contact, "
            		+ "IFNULL(rentDate, '대여가능') as rentDate, "
            		+ "IFNULL(DATEDIFF(curDate(), rentDate), 0) as overDate "
            		+ "FROM book WHERE title "+ " LIKE '%" + bookTitle.trim() + "%'");
 
            while (rs.next()) {
            	
            	id = rs.getInt("id");
            	title = rs.getString("title");
            	rent = rs.getString("rent");
            	contact = rs.getString("contact");
            	if(rs.getString("rentDate").equals("대여가능")) {
            	
            	rentDate = rs.getString("rentDate");
            	}else {
            		rentDate = dateFormat.format((rs.getDate("rentDate")));
            	}
            	overDate = rs.getInt("overDate");
            	
            	
            	
            	list.add(new Book(id,title,rent,contact,rentDate,overDate));
            	

            }
            
            
        } catch (SQLException e) {
            System.out.println("userSelectAll() �삤瑜�" + e);
        } finally {
            dbClose();
        }
    	
    	return list;
    }

    //화면 갱신을위해 마지막에 추가된 목록 반환
    public Book searchLastAdd() {
        String sql = "select id, title, rent, ifnull(contact, '대여가능') as contact, IFNULL(rentDate, '대여가능') as rentDate, " 
        		+"IFNULL(DATEDIFF(curDate(), rentDate), 0) as overDate from book"
        		+" where id = (select MAX(id) from book)" ;
        Book book = null;
        int id;
    	String title;
    	String rent;
    	String contact;
    	String rentDate;
    	int overDate;
        try {
        	
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
            id = rs.getInt("id");
        	title = rs.getString("title");
        	rent = rs.getString("rent");
        	contact = rs.getString("contact");
        	
        	
        	rentDate = rs.getString("rentDate");
        	
        	overDate = rs.getInt("overDate");
            
        	book = new Book(id,title,rent,contact,rentDate,overDate);
            }
        } catch (SQLException e) {
            System.out.println("getUserSearch() �삤瑜�:" + e.getMessage());
        } finally {
            dbClose();
        }
        	
        return book;
    }
 
}
