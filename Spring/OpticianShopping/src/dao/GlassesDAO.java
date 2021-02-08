package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Cart;
import vo.Glasses;
import vo.Member;
import vo.Order;

public class GlassesDAO {
	Connection con;
	private static GlassesDAO boardDAO;
	
	private GlassesDAO() {
		
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public static GlassesDAO getInstance() {
		if(boardDAO ==null) {
			boardDAO = new GlassesDAO();
		}
		
		return boardDAO;
	}
	
	
	
	public ArrayList<Glasses> selectGlassesList(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Glasses> glassesList = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM glasses");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				glassesList = new ArrayList<Glasses>();
				
				do {
					glassesList.add(new Glasses(
							rs.getInt("id"),
							rs.getString("kind"),
							rs.getInt("price"),
							rs.getString("image"),
							rs.getString("brand"),
							rs.getString("content"),
							rs.getInt("readcount")));
				}while(rs.next());
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return glassesList;
	}
	
	//종류로 검색
	public ArrayList<Glasses> selectGlassesList(String kind){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Glasses> glassesList = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM glasses where kind like '%' || ? || '%'");
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				glassesList = new ArrayList<Glasses>();
				
				do {
					glassesList.add(new Glasses(
							rs.getInt("id"),
							rs.getString("kind"),
							rs.getInt("price"),
							rs.getString("image"),
							rs.getString("brand"),
							rs.getString("content"),
							rs.getInt("readcount")));
				}while(rs.next());
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return glassesList;
	}
	
	//최대가격
		public ArrayList<Glasses> selectGlassesList(int endPrice){
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<Glasses> glassesList = null;
			try {
				pstmt = con.prepareStatement("SELECT * FROM glasses where price <= ?");
				pstmt.setInt(1, endPrice);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					glassesList = new ArrayList<Glasses>();
					
					do {
						glassesList.add(new Glasses(
								rs.getInt("id"),
								rs.getString("kind"),
								rs.getInt("price"),
								rs.getString("image"),
								rs.getString("brand"),
								rs.getString("content"),
								rs.getInt("readcount")));
					}while(rs.next());
					
				}
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return glassesList;
		}
	
	
	public Glasses selectGlasses(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Glasses glasses = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM glasses WHERE id =?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				glasses = new Glasses(
						rs.getInt("id"),
						rs.getString("kind"),
						rs.getInt("price"),
						rs.getString("image"),
						rs.getString("brand"),
						rs.getString("content"),
						rs.getInt("readcount"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return glasses;
	}
	
	
	
	public int updateReadCount(int id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";
		
		try {
			sql = "UPDATE glasses SET readcount = readcount + 1 WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			updateCount = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateCount;
	}
	
	public int insertGlasses(Glasses glasses) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "INSERT INTO glasses VALUES(glasses_seq.nextval,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, glasses.getKind());
			pstmt.setInt(2, glasses.getPrice());
			pstmt.setString(3, glasses.getImage());
			pstmt.setString(4, glasses.getBrand());
			pstmt.setString(5, glasses.getContent());
			pstmt.setInt(6, glasses.getReadcount());
			insertCount = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	public int updateGlasses(Glasses glasses) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";

		
		try {
			sql = " UPDATE glasses SET KIND = ?, PRICE=?, IMAGE = ?, BRAND=?, CONTENT=? WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, glasses.getKind());
			pstmt.setInt(2, glasses.getPrice());
			pstmt.setString(3, glasses.getImage());
			pstmt.setString(4, glasses.getBrand());
			pstmt.setString(5, glasses.getContent());
			pstmt.setInt(6, glasses.getId());
			updateCount = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	public int deleteGlasses(int id) {
		PreparedStatement pstmt = null;
	
		int deleteCount = 0;
		
		try {
			pstmt = con.prepareStatement("DELETE glasses WHERE id =?");
			pstmt.setInt(1, id);
			deleteCount = pstmt.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
	public int checkMember(String id, String password) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = con.prepareStatement("SELECT count(id) as id FROM MEMBER WHERE id = ? AND password=?");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			result = rs.getInt("id");
			}
		
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
	
	public Member selectMember(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM MEMBER WHERE id =?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member(
						rs.getString("id"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("contact"),
						rs.getString("addr"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return member;
	}
	
	public int addMember(Member member) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "INSERT INTO member VALUES(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getContact());
			pstmt.setString(5, member.getAddr());
			insertCount = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	public int updateMember(Member member) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";

		
		try {
			sql = " UPDATE MEMBER SET password =?, name = ?, contact =?, addr =? WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getContact());
			pstmt.setString(4, member.getAddr());
			pstmt.setString(5, member.getId());
			updateCount = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	public int deleteMember(String id) {
		PreparedStatement pstmt = null;
	
		int deleteCount = 0;
		
		try {
			pstmt = con.prepareStatement("DELETE MEMBER WHERE id =?");
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
	public int addOrder(Member member) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "INSERT INTO orderDetail VALUES(orderDetail_seq.nextval,SYSDATE,?,?,'배송 준비')";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getAddr());
			insertCount = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	public ArrayList<Order> getOrder(String customer) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM orderDetail WHERE customer =? ORDER BY orderDate");
			pstmt.setString(1, customer);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Order order = new Order(
						rs.getInt("id"),
						rs.getDate("orderDate"),
						rs.getString("customer"),
						rs.getString("addr"),
						rs.getString("status"));
				
				orderList.add(order);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return orderList;
	}
	
	public ArrayList<Order> getOrderAdmin() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM orderDetail ORDER BY status DESC , orderDate");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Order order = new Order(
						rs.getInt("id"),
						rs.getDate("orderDate"),
						rs.getString("customer"),
						rs.getString("addr"),
						rs.getString("status"));
				
				orderList.add(order);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return orderList;
	}
	
	
	
	public int getCurrentOrderId(String customer) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int orderId = 0;
		
		try {
			pstmt = con.prepareStatement("SELECT max(id) AS id FROM orderDetail WHERE customer = ?");
			pstmt.setString(1, customer);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				orderId = rs.getInt("id");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return orderId;
	}
	
	public int addOrderedItem(int orderId, int itemId, int qty) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "INSERT INTO orderedItem VALUES(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderId);
			pstmt.setInt(2, itemId);
			pstmt.setInt(3, qty);
			insertCount = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	public int deleteOrder(int id) {
		PreparedStatement pstmt = null;
	
		int deleteCount = 0;
		
		try {
			pstmt = con.prepareStatement("DELETE orderDetail WHERE id =?");
			pstmt.setInt(1, id);
			deleteCount = pstmt.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
	public ArrayList<Cart> orderDetailPage(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		
		try {
			pstmt = con.prepareStatement("SELECT o.customer, i.id, i.image, i.kind, i.price, a.qty FROM orderDetail o, glasses i, orderedItem a WHERE o.id = a.id AND a.ITEMID = i.ID AND o.ID = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setImage(rs.getString("image"));
				cart.setKind(rs.getString("kind"));
				cart.setPrice(rs.getInt("price"));
				cart.setQty(rs.getInt("qty"));
				cart.setCustomerId(rs.getString("customer"));
				cartList.add(cart);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return cartList;
	}
	
	public int updateOrderStatus(int orderId) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";

		
		try {
			sql = " UPDATE orderDetail SET status = '배송 완료' WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderId);
			updateCount = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return updateCount;
	}

}
