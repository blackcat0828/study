package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Glasses;

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
			pstmt = con.prepareStatement("SELECT count(id) as id FROM MEMBER WHERE id = ? AND password = ?");
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

}
